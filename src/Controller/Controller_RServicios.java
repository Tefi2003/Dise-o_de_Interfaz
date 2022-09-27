/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Servicios;
import Modelo.ServiciosBD;
import Vista.RServicios;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author User
 */
public class Controller_RServicios {
     private RServicios vista;
    private ServiciosBD modelo;
    ListSelectionModel listapersonamodel;

    public Controller_RServicios(RServicios vista, ServiciosBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
         this.vista.setVisible(true);
        iniciarcontrol();
        carga_tabla();
        
    }
    
    
    public void pruebakey(){
      
    
           
      
    KeyListener escuchateclado =new KeyListener() {
         
        @Override
        public void keyTyped(KeyEvent e) {
            
             
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
          
        }

        @Override
        public void keyReleased(KeyEvent e) {
             
                 
            
            String x= vista.getTxtnombre().getText();
            System.out.println(x);
              //aqui se  coloca la tabla de la busqueda
              tabla_busqueda(x);
               
        }

       
    };
    
    vista.getTxtnombre().addKeyListener(escuchateclado);
  
    }
    
    public void ingresar_servicio(){
        String servicio,precio;
        servicio=vista.getTxtnombre().getText();
        precio=vista.getTxtprecio().getText();
        modelo.setServ_servicio(servicio);
        Double preciod=Double.parseDouble(precio);
        modelo.setServ_precio(preciod);
        if (modelo.ingresar_servicio()) {
            JOptionPane.showMessageDialog(vista, "SE HA INGRESADO EL SERVICIO CORRECTAMENTE");
            carga_tabla();
            vista.getTxtnombre().setText("");
            vista.getTxtprecio().setText("");
        }else{
            JOptionPane.showMessageDialog(vista, "HA OCURRIDO UN ERROR(el precio debe ser numerico)");
        }
        
        
    }

    
public void carga_tabla(){
        //empieza tabla
         List<Servicios> todos_usuarios=modelo.getServicios();
        
         String matriz[][]=new String[todos_usuarios.size()][3];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             
             String precio=todos_usuarios.get(i).getServ_precio().toString();
            matriz[i][0]=todos_usuarios.get(i).getServ_codigo();
            matriz[i][1]=todos_usuarios.get(i).getServ_servicio();
            matriz[i][2]=precio;
        }
        
        vista.getTblservicio().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Codigo", "Servicio", "Precio"
    }
));
    }



public void tabla_busqueda(String nombre){
        //empieza tabla
         List<Servicios> todos_usuarios=modelo.servicio_like(nombre);
        
         String matriz[][]=new String[todos_usuarios.size()][3];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             
             String precio=todos_usuarios.get(i).getServ_precio().toString();
            matriz[i][0]=todos_usuarios.get(i).getServ_codigo();
            matriz[i][1]=todos_usuarios.get(i).getServ_servicio();
            matriz[i][2]=precio;
        }
        
        vista.getTblservicio().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Codigo", "Servicio", "Precio"
    }
));
    }
    public void limpiar(){
         vista.getTxtnombre().setText("");
            vista.getTxtprecio().setText("");
            vista.getTxtcodigo().setText("");
    }
     public void eliminar(){
        if (vista.getTblservicio().getSelectedRow()>=0) {
            String cod_=vista.getTblservicio().getValueAt(vista.getTblservicio().getSelectedRow(), 0).toString();
            int cod_servicio=Integer.parseInt(cod_);
            if (modelo.deleteServicios(cod_servicio)) {
                JOptionPane.showMessageDialog(vista, "ELIMINADO EL SERVICIO ");
                carga_tabla();
                vista.getTxtnombre().setText("");
            vista.getTxtprecio().setText("");
            vista.getTxtcodigo().setText("");
            }else{
                JOptionPane.showMessageDialog(vista, "HA OCURRIDO UN ERROR AL ELIMINAR ESTE SERVICIO");
                
            }
         }else{
            JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN ELEMENTO PARA ELIMINAR EN LA TABLA");
        }
    }



    public void iniciarcontrol(){
        pruebakey();
        vista.getBtnBuscar().addActionListener(l->limpiar());
        vista.getBtnCancelar().addActionListener(l->salir());
        vista.getTxtcodigo().setEditable(false);
        vista.getBtnRegistrar().addActionListener(l->ingresar_servicio());
        vista.getBtnEliminar().addActionListener(l->eliminar());
        //clicl en tabla
          vista.getTblservicio().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listapersonamodel=this.vista.getTblservicio().getSelectionModel();
    listapersonamodel.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                personaSeleccionada();
            }
        }
    });
        //click en tabla
        vista.getBtnModificar().addActionListener(l->modificar());
    }
    
    
    public void personaSeleccionada(){
         if (this.vista.getTblservicio().getSelectedRow()!=-1) {
             String seleccionado=vista.getTblservicio().getValueAt(vista.getTblservicio().getSelectedRow(), 0).toString();
             int selec=Integer.parseInt(seleccionado);
             List<Servicios> lista =modelo.obtener_servicio(selec);
             vista.getTxtcodigo().setText(lista.get(0).getServ_codigo().toString());
             vista.getTxtnombre().setText(lista.get(0).getServ_servicio().toString());
             vista.getTxtprecio().setText(lista.get(0).getServ_precio().toString());
         }
    }
    
    
    public void modificar(){
        if (vista.getTblservicio().getSelectedRow()>=0) {
        String seleccionado=vista.getTblservicio().getValueAt(vista.getTblservicio().getSelectedRow(), 0).toString();
        String codigo,name,precio;
        
        codigo=vista.getTxtcodigo().getText();
        name=vista.getTxtnombre().getText();
        precio=vista.getTxtprecio().getText();
        int cod=Integer.parseInt(seleccionado);
        double preciox=Double.parseDouble(precio);
        modelo.setServ_codigo(codigo);
        modelo.setServ_precio(preciox);
        modelo.setServ_servicio(name);
                if (modelo.editar_servicio(cod)) {
                JOptionPane.showMessageDialog(vista, "SE HA MODIFICADO CORRECTAMENTE");
                carga_tabla();
                vista.getTxtcodigo().setText("");
                vista.getTxtnombre().setText("");
                vista.getTxtprecio().setText("");
            }
        }else{
            JOptionPane.showMessageDialog(vista, "Debe seleccionar a una persona antes de modificar");
        }
    }
    
     public void salir(){
       vista.setVisible(false);
       
       
   } 
    
}

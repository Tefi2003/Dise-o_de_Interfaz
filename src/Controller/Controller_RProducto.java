/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ProductoBD;
import Modelo.Producto;
import Vista.RProducto;
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
public class Controller_RProducto {
    private RProducto vista;
    private ProductoBD modelo;
    ListSelectionModel listapersonamodel;

    public Controller_RProducto(RProducto vista, ProductoBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
        iniciarcontrol();
        carga_tabla();
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public void iniciarcontrol(){
        pruebakey();
        vista.getBtnBuscar().addActionListener(l->limpiar());
        vista.getBtnCancelar().addActionListener(l->salir());
        vista.getTxtcodigo().setEditable(false);
        vista.getBtnRegistrar().addActionListener(l->ingresar_servicio());
        vista.getBtnEliminar().addActionListener(l->eliminar());
        //clicl en tabla
        vista.getTblcliente().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listapersonamodel=this.vista.getTblcliente().getSelectionModel();
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
    
////////////////////////////////////////////////////////////////////////////////
    
    public void carga_tabla(){
        //empieza tabla
         List<Producto> todos_usuarios=modelo.getProducto();
        
         String matriz[][]=new String[todos_usuarios.size()][4];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             
             String precio=todos_usuarios.get(i).getPro_precio().toString();
            matriz[i][0]=todos_usuarios.get(i).getPro_codigo();
            matriz[i][1]=todos_usuarios.get(i).getPro_nombre();
            matriz[i][2]=precio;
            matriz[i][3]=todos_usuarios.get(i).getPro_marca();
        }
        
        vista.getTblcliente().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Codigo", "Nombre", "Precio", "Marca"
    }
));
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public void limpiar(){
         vista.getTxtnombre().setText("");
         vista.getTxtprecio().setText("");
         vista.getTxtcodigo().setText("");
         vista.getTxtmarca().setText("");
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public void salir(){
       vista.setVisible(false);
    } 
    
////////////////////////////////////////////////////////////////////////////////
    
    public void personaSeleccionada(){
         if (this.vista.getTblcliente().getSelectedRow()!=-1) {
             String seleccionado=vista.getTblcliente().getValueAt(vista.getTblcliente().getSelectedRow(), 0).toString();
             int selec=Integer.parseInt(seleccionado);
             List<Producto> lista =modelo.obtener_servicio(selec);
             vista.getTxtcodigo().setText(lista.get(0).getPro_codigo().toString());
             vista.getTxtnombre().setText(lista.get(0).getPro_nombre().toString());
             vista.getTxtprecio().setText(lista.get(0).getPro_precio().toString());
             vista.getTxtmarca().setText(lista.get(0).getPro_marca().toString());
         }
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public void ingresar_servicio() {
        String nombre, precio, marca;
        nombre = vista.getTxtnombre().getText();
        precio = vista.getTxtprecio().getText();
        marca = vista.getTxtmarca().getText();

        modelo.setPro_nombre(nombre);
        Double preciod = Double.parseDouble(precio);
        modelo.setPro_precio(preciod);
        modelo.setPro_marca(marca);
        if (modelo.ingresar_servicio()) {
            JOptionPane.showMessageDialog(vista, "SE HA INGRESADO EL PRODUCTO CORRECTAMENTE");
            carga_tabla();
            vista.getTxtnombre().setText("");
            vista.getTxtprecio().setText("");
            vista.getTxtmarca().setText("");
        } else {
            JOptionPane.showMessageDialog(vista, "HA OCURRIDO UN ERROR(el precio debe ser numerico)");
        }
    }

////////////////////////////////////////////////////////////////////////////////
    
    public void eliminar(){
        if (vista.getTblcliente().getSelectedRow()>=0) {
            String cod_=vista.getTblcliente().getValueAt(vista.getTblcliente().getSelectedRow(), 0).toString();
            int cod_servicio=Integer.parseInt(cod_);
            if (modelo.deleteServicios(cod_servicio)) {
                JOptionPane.showMessageDialog(vista, "Se elimino el producto correctamente");
                carga_tabla();
                vista.getTxtnombre().setText("");
            vista.getTxtprecio().setText("");
            vista.getTxtcodigo().setText("");
                vista.getTxtmarca().setText("");
            }else{
                JOptionPane.showMessageDialog(vista, "HA OCURRIDO UN ERROR AL ELIMINAR ESTE Producto");
                
            }
         }else{
            JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN ELEMENTO EN LA TABLA PARA ELIMINAR");
        }
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public void modificar(){
        if (vista.getTblcliente().getSelectedRow()>=0) {
        String seleccionado=vista.getTblcliente().getValueAt(vista.getTblcliente().getSelectedRow(), 0).toString();
        String codigo,name,precio,marca;
        
        codigo=vista.getTxtcodigo().getText();
        name=vista.getTxtnombre().getText();
        precio=vista.getTxtprecio().getText();
        marca=vista.getTxtnombre().getText();
        
        int cod=Integer.parseInt(seleccionado);
        double preciox=Double.parseDouble(precio);
        modelo.setPro_codigo(codigo);
        modelo.setPro_precio(preciox);
        modelo.setPro_nombre(name);
        modelo.setPro_marca(marca);
        
                if (modelo.editar_servicio(cod)) {
                JOptionPane.showMessageDialog(vista, "SE HA MODIFICADO CORRECTAMENTE");
                carga_tabla();
                vista.getTxtcodigo().setText("");
                vista.getTxtnombre().setText("");
                vista.getTxtprecio().setText("");
                vista.getTxtmarca().setText("");
            }
        }else{
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un producto antes de modificar");
        }
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public void tabla_busqueda(String nombre){
        //empieza tabla
         List<Producto> todos_usuarios=modelo.servicio_like(nombre);
        
         String matriz[][]=new String[todos_usuarios.size()][4];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             
             String precio=todos_usuarios.get(i).getPro_precio().toString();
            matriz[i][0]=todos_usuarios.get(i).getPro_codigo();
            matriz[i][1]=todos_usuarios.get(i).getPro_nombre();
            matriz[i][2]=precio;
            matriz[i][3]=todos_usuarios.get(i).getPro_marca();
        }
        
        vista.getTblcliente().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Codigo", "Nombre", "Precio", "Marca"
    }
));
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public void pruebakey() {

        KeyListener escuchateclado = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                String x = vista.getTxtnombre().getText();
                System.out.println(x);
                //aqui se  coloca la tabla de la busqueda
                tabla_busqueda(x);

            }
        };
        vista.getTxtnombre().addKeyListener(escuchateclado);
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
}
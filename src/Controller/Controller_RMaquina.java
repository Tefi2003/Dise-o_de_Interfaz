/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.MaquinaBD;
import Modelo.Maquina;
import Vista.RMaquina;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author User
 */
public class Controller_RMaquina {
    private RMaquina vista;
    private MaquinaBD modelo;
    ListSelectionModel listamaquinamodel;
    public Controller_RMaquina(RMaquina vista, MaquinaBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
        iniciarcontrol();
        carga_tabla();
     
    }
    
    
    
   public void iniciarcontrol(){
       vista.getBoxMaqui().setEnabled(false);
       vista.getBtnBuscar().addActionListener(l->borrar());
       vista.getBtnCancelar().addActionListener(l->salir());
       vista.getTxtcodigomaqui().setEditable(false);
       
       
        vista.getTblmaquina().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listamaquinamodel=this.vista.getTblmaquina().getSelectionModel();
        listamaquinamodel.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                personaSeleccionada();
            }
        }
    });
        
        vista.getBtnModificar().addActionListener(l->modificar());
   } 
   
   public void salir(){
       vista.setVisible(false);
   }
   public void borrar(){
       vista.getTxtcodigomaqui().setText("");
               vista.getTxtpreciomaqui().setText("");
   }
   
     public void personaSeleccionada(){
    if (this.vista.getTblmaquina().getSelectedRow()!=-1) {
         String c_seleccionado=vista.getTblmaquina().getValueAt(vista.getTblmaquina().getSelectedRow(), 0).toString();
        
       
       //ir poniendo lo de la busqueda en los txt
        List<Maquina> lista_user_seleccionado=modelo.buscarCodigo( c_seleccionado);
        int cod_antes=lista_user_seleccionado.get(0).getMaq_codigo();
        String cod_despues=String.valueOf(cod_antes);
        vista.getTxtcodigomaqui().setText(cod_despues);
        vista.getTxtpreciomaqui().setText(lista_user_seleccionado.get(0).getMaq_precio().toString());
        String tamaño=lista_user_seleccionado.get(0).getMaq_tamaño();
        
        switch(tamaño){
            case "Grande": 
                vista.getBoxMaqui().setSelectedIndex(0);
                break;
            case"Mediana":
                vista.getBoxMaqui().setSelectedIndex(1);
                break;
            case"Pequeña":
                vista.getBoxMaqui().setSelectedIndex(2);
                break;
        }
        
         
    }
     
    }
     
     
     
      public void modificar(){
          
          if (vista.getTxtcodigomaqui().equals("")||vista.getTxtpreciomaqui().equals("")) {
            JOptionPane.showMessageDialog(vista, "SELECCIONE EN LA TABLA ANTES DE MODIFICAR");
          }else{
        if (vista.getTblmaquina().getSelectedRow()>=0) {
        String codigo,precio,tamaño;
        codigo=vista.getTxtcodigomaqui().getText();
        precio=vista.getTxtpreciomaqui().getText();
        tamaño=vista.getBoxMaqui().getSelectedItem().toString();
        
        
        int cod=Integer.parseInt(codigo);
        double preciox=Double.parseDouble(precio);
        modelo.setMaq_codigo(cod);
        modelo.setMaq_precio(preciox);
        modelo.setMaq_tamaño(tamaño);
        
                if (modelo.editar_maquina(cod)) {
                JOptionPane.showMessageDialog(vista, "SE HA MODIFICADO CORRECTAMENTE");
                carga_tabla();
                vista.getTxtcodigomaqui().setText("");
                
                vista.getTxtpreciomaqui().setText("");
            
        }else{
            JOptionPane.showMessageDialog(vista, "Existen problemas al modificar esta maquina");
        }
    }else{
          JOptionPane.showMessageDialog(vista, "Debe seleccionar a una maquina antes de modificar");  
        }
        }
         }
   
   
   
   
   
         
         
    
    
    public void carga_tabla(){
        //empieza tabla
         List<Maquina> todos_usuarios=modelo.todas_maquinas();
        
         String matriz[][]=new String[todos_usuarios.size()][3];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             int codigo=todos_usuarios.get(i).getMaq_codigo();
             String codigo_tabla=String.valueOf(codigo);
            String precio=todos_usuarios.get(i).getMaq_precio().toString();
            matriz[i][0]=codigo_tabla;
            matriz[i][1]=todos_usuarios.get(i).getMaq_tamaño();
            matriz[i][2]=precio;
        }
        
        vista.getTblmaquina().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        "Codigo", "Tamaño", "Precio"
    }
));
    }
    
    
    
    
    
    
}

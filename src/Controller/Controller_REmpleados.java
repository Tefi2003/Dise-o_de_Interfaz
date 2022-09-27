/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Persona;
import Modelo.PersonaBD;
import Modelo.Usuario;
import Modelo.UsuarioBD;
import Vista.REmpleados;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
/**
 *
 * @author User
 */
public class Controller_REmpleados {
    private REmpleados vista;
    private UsuarioBD modelo;
ListSelectionModel listapersonamodel;

    public Controller_REmpleados(REmpleados vista, UsuarioBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
        
        iniciarcontrol();
        carga_tabla();
         
        
        
    }
     public void iniciarcontrol(){
         
            pruebakey();
         valida_cedula();
         valida_telefono();  
          valida_correo();
            
         
         vista.getBtnSalir().addActionListener(l->salir());
         vista.getBtnBuscar().addActionListener(l->limpiar());
         vista.getBtnRegistrar().addActionListener(l->registrar());
         vista.getBtnEliminar().addActionListener(l->eliminar());
         vista.getBtnModificar().addActionListener(l->modificar());
         //prueba
         vista.getTblrempleado().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listapersonamodel=this.vista.getTblrempleado().getSelectionModel();
    listapersonamodel.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                personaSeleccionada();
            }
        }
    });
         //prueba
         
     }
    
     //VALIDACIONES //VALIDACIONES //VALIDACIONES //VALIDACIONES //VALIDACIONES //VALIDACIONES 
     public void valida_cedula(){
         Validaciones v=new Validaciones();
         vista.getTxtcedula().addFocusListener(new FocusListener() {
    public void focusLost(FocusEvent arg0) {
       
        
         boolean resultado=v.validarCedula(vista.getTxtcedula().getText());
        if (resultado==false) {
            JOptionPane.showMessageDialog(null, "CEDULA INVALIDA");
            vista.getTxtcedula().setText("");
        }
    }
    public void focusGained(FocusEvent arg0) {
        // TODO Auto-generated method stub
    }
});
     }
     
     public void valida_telefono(){
         Validaciones v=new Validaciones();
         vista.getTxttelefono().addFocusListener(new FocusListener() {
    public void focusLost(FocusEvent arg0) {
       
        
         boolean resultado=v.validarCelu(vista.getTxttelefono().getText());
        if (resultado==false) {
            JOptionPane.showMessageDialog(null, "TELEFONO INVALIDO");
            vista.getTxttelefono().setText("");
        }
    }
    public void focusGained(FocusEvent arg0) {
        // TODO Auto-generated method stub
    }
});
     }
     
     public void valida_correo(){
         Validaciones v=new Validaciones();
         vista.getTxtcorreo().addFocusListener(new FocusListener() {
    public void focusLost(FocusEvent arg0) {
       
        
         boolean resultado=v.validarEmail(vista.getTxtcorreo().getText());
        if (resultado==false) {
            JOptionPane.showMessageDialog(null, "CORRREO INVALIDO");
            vista.getTxtcorreo().setText("");
        }
    }
    public void focusGained(FocusEvent arg0) {
        // TODO Auto-generated method stub
    }
});
     }
     //VALIDACIONES //VALIDACIONES //VALIDACIONES //VALIDACIONES //VALIDACIONES //VALIDACIONES //VALIDACIONES 
     
     
    //empieza like 
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
             
                 
            
            String x= vista.getTxtcedula().getText();
            System.out.println(x);
              //aqui se  coloca la tabla de la busqueda
              tabla_busqueda(x);
               
        }

       
    };
    
    vista.getTxtcedula().addKeyListener(escuchateclado);
  
    }
        
//final like
     public void personaSeleccionada(){
    if (this.vista.getTblrempleado().getSelectedRow()!=-1) {
        String u_seleccionado=vista.getTblrempleado().getValueAt(vista.getTblrempleado().getSelectedRow(), 1).toString();
        String c_seleccionado=vista.getTblrempleado().getValueAt(vista.getTblrempleado().getSelectedRow(), 0).toString();
       //ir poniendo lo de la busqueda en los txt
        List<Usuario> lista_user_seleccionado=modelo.buscar_para_modificar(u_seleccionado, c_seleccionado);
         vista.getTxtapellido().setText(lista_user_seleccionado.get(0).getPer_apellido().toString());
         vista.getTxtcedula().setText(lista_user_seleccionado.get(0).getPer_cedula().toString());
         vista.getTxtclave().setText(lista_user_seleccionado.get(0).getClave().toString());
         vista.getTxtcorreo().setText(lista_user_seleccionado.get(0).getPer_correo().toString());
         vista.getTxtdireccion().setText(lista_user_seleccionado.get(0).getPer_direccion().toString());
         vista.getTxtnombre().setText(lista_user_seleccionado.get(0).getPer_nombre().toString());
         vista.getTxtrepiteclave().setText(lista_user_seleccionado.get(0).getClave().toString());
         vista.getTxttelefono().setText(lista_user_seleccionado.get(0).getPer_telefono().toString());
         vista.getTxtusuario().setText(lista_user_seleccionado.get(0).getUsuario().toString());
         if (lista_user_seleccionado.get(0).getRol().equals("Administrador")) {
            vista.getCombo_rol().setSelectedIndex(0);
        }else{
             vista.getCombo_rol().setSelectedIndex(1);
         }
    }
     
    }
     
     
    public void salir(){
        vista.setVisible(false);
    }
    public void eliminar(){
        if (vista.getTblrempleado().getSelectedRow()>=0) {
            String user_eliminado=vista.getTblrempleado().getValueAt(vista.getTblrempleado().getSelectedRow(), 1).toString();
            if (modelo.eliminar_usuario(user_eliminado)) {
               PersonaBD pb=new PersonaBD();
              
                if (pb.borrar_porcedula(vista.getTxtcedula().getText())) {
                    JOptionPane.showMessageDialog(vista, "ELIMINADO EL USUARIO "+user_eliminado);
                carga_tabla();
                 vista.getTxtcedula().setText("");
                vista.getTxtnombre().setText("");
                vista.getTxtapellido().setText("");
                vista.getTxtclave().setText("");
                vista.getTxtcorreo().setText("");
                vista.getTxtdireccion().setText("");
                vista.getTxtrepiteclave().setText("");
                vista.getTxttelefono().setText("");
                vista.getTxtusuario().setText(""); 
                }else{
                    JOptionPane.showMessageDialog(vista, "SE BORRO USUARIO PERO NO PERSONA");
                }
               
            }else{
                JOptionPane.showMessageDialog(vista, "HA OCURRIDO UN ERROR AL ELIMINAR ESTE USUARIO");
                
            }
         }else{
            JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN ELEMENTO PARA ELIMINAR EN LA TABLA");
        }
    }
    
    
    
    
    public void modificar(){
        if (vista.getTblrempleado().getSelectedRow()>=0) {
            String u_seleccionado=vista.getTblrempleado().getValueAt(vista.getTblrempleado().getSelectedRow(), 1).toString();
            String c_seleccionado=vista.getTblrempleado().getValueAt(vista.getTblrempleado().getSelectedRow(), 0).toString();
            
             String cedula,nombre,apellido,usuario,clave,rep_clave,telefono,direccion,correo;
             cedula= vista.getTxtcedula().getText();
                   nombre=  vista.getTxtnombre().getText();
                   apellido= vista.getTxtapellido().getText();
                   usuario= vista.getTxtusuario().getText();
                    clave= vista.getTxtclave().getText();
                    telefono= vista.getTxttelefono().getText();
                    direccion= vista.getTxtdireccion().getText();
                    correo= vista.getTxtcorreo().getText();
                     rep_clave=vista.getTxtrepiteclave().getText();
                     
                     modelo.setPer_cedula(cedula);
        modelo.setPer_nombre(nombre);
        modelo.setPer_apellido(apellido);
        modelo.setPer_correo(correo);
        modelo.setPer_direccion(direccion);
        modelo.setPer_telefono(telefono);
        modelo.setUsuario(usuario);
            modelo.setClave(clave);
            
            String rol=vista.getCombo_rol().getSelectedItem().toString();
            
            modelo.setRol(rol);
            
            if (modelo.modificar_usuario1(u_seleccionado)&&modelo.modificar_usuario2(c_seleccionado)) {
                JOptionPane.showMessageDialog(vista, "DATOS MODIFICADOS CORRECTAMENTE");
                vista.getTxtcedula().setText("");
                vista.getTxtnombre().setText("");
                vista.getTxtapellido().setText("");
                vista.getTxtclave().setText("");
                vista.getTxtcorreo().setText("");
                vista.getTxtdireccion().setText("");
                vista.getTxtrepiteclave().setText("");
                vista.getTxttelefono().setText("");
                vista.getTxtusuario().setText("");
                carga_tabla();
            }
            
        }else{
            JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN ELEMENTO PARA MODIFICAR");
        }
    }
    
    
    
    
    
    
    public void registrar(){
         String cedula,nombre,apellido,usuario,clave,rep_clave,telefono,direccion,correo;
                   cedula= vista.getTxtcedula().getText();
                   nombre=  vista.getTxtnombre().getText();
                   apellido= vista.getTxtapellido().getText();
                   usuario= vista.getTxtusuario().getText();
                    clave= vista.getTxtclave().getText();
                    telefono= vista.getTxttelefono().getText();
                    direccion= vista.getTxtdireccion().getText();
                    correo= vista.getTxtcorreo().getText();
                     rep_clave=vista.getTxtrepiteclave().getText();
                    
                     PersonaBD p=new PersonaBD();
                     if (cedula.isEmpty()||nombre.isEmpty()||apellido.isEmpty()||usuario.isEmpty()||clave.isEmpty()||rep_clave.isEmpty()||telefono.isEmpty()||direccion.isEmpty()||correo.isEmpty()) {
        JOptionPane.showMessageDialog(vista, "EXISTEN CAMPOS VACIOS O LA CLAVE NO COINCIDE");
    }else{
          //VALIDACIONES
          
          
          //VALIDACIONES
                         
                         
        modelo.setPer_cedula(cedula);
        modelo.setPer_nombre(nombre);
        modelo.setPer_apellido(apellido);
        modelo.setPer_correo(correo);
        modelo.setPer_direccion(direccion);
        modelo.setPer_telefono(telefono);
        if (modelo.insertar_usuario1()) {
            //mensaje
            List<Persona> id_persona =p.hallar_id_persona(cedula);
            int id_per=id_persona.get(0).getPer_codigoper();
            modelo.setUsuario(usuario);
            modelo.setClave(clave);
            
            String rol=vista.getCombo_rol().getSelectedItem().toString();
            
            modelo.setRol(rol);
            if (modelo.insertar_usuario2(id_per)) {
                //mensaje 
                JOptionPane.showMessageDialog(vista, "Usuario creado correctamente");
                vista.getTxtcedula().setText("");
                vista.getTxtnombre().setText("");
                vista.getTxtapellido().setText("");
                vista.getTxtclave().setText("");
                vista.getTxtcorreo().setText("");
                vista.getTxtdireccion().setText("");
                vista.getTxtrepiteclave().setText("");
                vista.getTxttelefono().setText("");
                vista.getTxtusuario().setText("");
                carga_tabla();
            }
        }
    }
                  
                     }
    
    
    
    
    public void tabla_busqueda(String parametro){
        //empieza tabla
         List<Usuario> todos_usuarios=modelo.buscarUsuario_like(parametro);
        
         String matriz[][]=new String[todos_usuarios.size()][4];
         for (int i = 0; i < todos_usuarios.size(); i++) {
            matriz[i][0]=todos_usuarios.get(i).getPer_cedula();
            matriz[i][1]=todos_usuarios.get(i).getUsuario();
            matriz[i][2]=todos_usuarios.get(i).getPer_nombre();
            matriz[i][3]=todos_usuarios.get(i).getRol();
        }
        
        vista.getTblrempleado().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Cédula", "Usuario", "Nombre", "Rol"
    }
));
    }
    
    public void carga_tabla(){
        //empieza tabla
         List<Usuario> todos_usuarios=modelo.tabla_usuarios();
        
         String matriz[][]=new String[todos_usuarios.size()][4];
         for (int i = 0; i < todos_usuarios.size(); i++) {
            matriz[i][0]=todos_usuarios.get(i).getPer_cedula();
            matriz[i][1]=todos_usuarios.get(i).getUsuario();
            matriz[i][2]=todos_usuarios.get(i).getPer_nombre();
            matriz[i][3]=todos_usuarios.get(i).getRol();
        }
        
        vista.getTblrempleado().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Cédula", "Usuario", "Nombre", "Rol"
    }
));
    }
    //fin tabla

    private void limpiar() {
         vista.getTxtcedula().setText("");
                vista.getTxtnombre().setText("");
                vista.getTxtapellido().setText("");
                vista.getTxtclave().setText("");
                vista.getTxtcorreo().setText("");
                vista.getTxtdireccion().setText("");
                vista.getTxtrepiteclave().setText("");
                vista.getTxttelefono().setText("");
                vista.getTxtusuario().setText("");
                carga_tabla();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Cliente;
import Modelo.ClienteBD;
import Modelo.Persona;
import Modelo.PersonaBD;
import Vista.RCliente;
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
public class Controller_RCliente {
    private RCliente vista;
    private ClienteBD modelo;
    ListSelectionModel listaclientemodel;
    
    public Controller_RCliente(RCliente vista, ClienteBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
        iniciarcontrol();
        carga_tabla();
    }
    
    public void  iniciarcontrol(){
        pruebakey();
        vista.getBtnSalir().addActionListener(l->salir());
        vista.getBtnModificar().addActionListener(l->modificar());
        vista.getBtnRegistrar().addActionListener(l->registrar());
        vista.getBtnEliminar().addActionListener(l->eliminar());
        vista.getBtnBuscar().addActionListener(l->limpiar());
        
        vista.getTblcliente().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaclientemodel=this.vista.getTblcliente().getSelectionModel();
        listaclientemodel.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                personaSeleccionada();
            }
        }
    });
        
    }
    
    
////////////////////////////////////////////////////////////////////////////////
    
    public void personaSeleccionada() {
        if (this.vista.getTblcliente().getSelectedRow()!=-1) {
            String u_seleccionado = vista.getTblcliente().getValueAt(vista.getTblcliente().getSelectedRow(), 1).toString();
            String c_seleccionado = vista.getTblcliente().getValueAt(vista.getTblcliente().getSelectedRow(), 0).toString();
            //ir poniendo lo de la busqueda en los txt
            List<Cliente> lista_user_seleccionado = modelo.buscar_para_modificar( c_seleccionado);
            vista.getTxtapellido().setText(lista_user_seleccionado.get(0).getPer_apellido().toString());
            vista.getTxtcedula().setText(lista_user_seleccionado.get(0).getPer_cedula().toString());
            vista.getTxtcorreo().setText(lista_user_seleccionado.get(0).getPer_correo().toString());
            vista.getTxtdireccion().setText(lista_user_seleccionado.get(0).getPer_direccion().toString());
            vista.getTxtnombre().setText(lista_user_seleccionado.get(0).getPer_nombre().toString());
            vista.getTxttelefono().setText(lista_user_seleccionado.get(0).getPer_telefono().toString());
            vista.getTxtGenero().setText(lista_user_seleccionado.get(0).getCli_genero().toString());
        }
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public void modificar() {
        if (vista.getTblcliente().getSelectedRow() >= 0) {
            String u_seleccionado = vista.getTblcliente().getValueAt(vista.getTblcliente().getSelectedRow(), 1).toString();
            String c_seleccionado = vista.getTblcliente().getValueAt(vista.getTblcliente().getSelectedRow(), 0).toString();

            String cedula, nombre, apellido, genero, telefono, direccion, correo;
            cedula = vista.getTxtcedula().getText();
            nombre = vista.getTxtnombre().getText();
            apellido = vista.getTxtapellido().getText();
            genero = vista.getTxtGenero().getText();
            telefono = vista.getTxttelefono().getText();
            direccion = vista.getTxtdireccion().getText();
            correo = vista.getTxtcorreo().getText();

            modelo.setPer_cedula(cedula);
            modelo.setPer_nombre(nombre);
            modelo.setPer_apellido(apellido);
            modelo.setPer_correo(correo);
            modelo.setPer_direccion(direccion);
            modelo.setPer_telefono(telefono);
            modelo.setCli_genero(genero);

//          modelo.modificar_cliente1(u_seleccionado)&&
            if (modelo.modificar_cliente2(c_seleccionado)) {
                JOptionPane.showMessageDialog(vista, "DATOS MODIFICADOS CORRECTAMENTE");
                vista.getTxtcedula().setText("");
                vista.getTxtnombre().setText("");
                vista.getTxtapellido().setText("");
                vista.getTxtGenero().setText("");
                vista.getTxtcorreo().setText("");
                vista.getTxtdireccion().setText("");
                vista.getTxttelefono().setText("");
                carga_tabla();
            }

        } else {
            JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN ELEMENTO PARA MODIFICAR");
        }
    }
    
////////////////////////////////////////////////////////////////////////////////    
    
    public void registrar() {
        String cedula, nombre, apellido, genero, telefono, direccion, correo;
        
        cedula = vista.getTxtcedula().getText();
        nombre = vista.getTxtnombre().getText();
        apellido = vista.getTxtapellido().getText();
        genero = vista.getTxtGenero().getText();
        telefono = vista.getTxttelefono().getText();
        direccion = vista.getTxtdireccion().getText();
        correo = vista.getTxtcorreo().getText();
            
        PersonaBD p = new PersonaBD();
        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || genero.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "EXISTEN CAMPOS VACIOS O LA CLAVE NO COINCIDE");
        } else {
            modelo.setPer_cedula(cedula);
            modelo.setPer_nombre(nombre);
            modelo.setPer_apellido(apellido);
            modelo.setPer_correo(correo);
            modelo.setPer_direccion(direccion);
            modelo.setPer_telefono(telefono);
            if (modelo.insertar_cliente1()) {
                //mensaje
                List<Persona> id_persona = p.hallar_id_persona(cedula);
                int id_per = id_persona.get(0).getPer_codigoper();
                modelo.setPer_cedula(cedula);
                
                if (modelo.insertar_cliente2(id_per)) {
                    //mensaje 
                JOptionPane.showMessageDialog(vista, "Cliente creado correctamente");
                vista.getTxtcedula().setText("");
                vista.getTxtnombre().setText("");
                vista.getTxtapellido().setText("");
                vista.getTxtGenero().setText("");
                vista.getTxtcorreo().setText("");
                vista.getTxtdireccion().setText("");
                vista.getTxttelefono().setText("");
                    carga_tabla();
                }
            }
        }
    }
    
////////////////////////////////////////////////////////////////////////////////    
   
    
    
    public void salir(){
        vista.setVisible(false);
    }
    
    
    public void carga_tabla(){
        //empieza tabla
         List<Cliente> todos_cliente=modelo.tabla_cliente();
        
         String matriz[][]=new String[todos_cliente.size()][6];
         for (int i = 0; i < todos_cliente.size(); i++) {
            matriz[i][0]=todos_cliente.get(i).getPer_cedula();
            matriz[i][1]=todos_cliente.get(i).getPer_nombre();
            matriz[i][2]=todos_cliente.get(i).getPer_apellido();
            matriz[i][3]=todos_cliente.get(i).getCli_genero();
            matriz[i][4]=todos_cliente.get(i).getPer_telefono();
            int cod_cli=todos_cliente.get(i).getCli_codigocli();
            String cod_clif=String.valueOf(cod_cli);
            matriz[i][5]=cod_clif;
        }
        
        vista.getTblcliente().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Cédula", "Nombre", "Apellido", "Genero","Telefono","Codigo_cliente"
    }
));
    }
    
////////////////////////////////////////////////////////////////////////////////////    
    
     private void limpiar() {
         vista.getTxtcedula().setText("");
                vista.getTxtnombre().setText("");
                vista.getTxtapellido().setText("");
                vista.getTxtGenero().setText("");
                vista.getTxtcorreo().setText("");
                vista.getTxtdireccion().setText("");
                vista.getTxttelefono().setText("");
                carga_tabla();
    }
     
////////////////////////////////////////////////////////////////////////////////    
     
    public void eliminar(){
        if (vista.getTblcliente().getSelectedRow()>=0) {
            String cedula_selec=vista.getTblcliente().getValueAt(vista.getTblcliente().getSelectedRow(), 0).toString();
            String cod_selec=vista.getTblcliente().getValueAt(vista.getTblcliente().getSelectedRow(), 5).toString();
            PersonaBD pbd=new PersonaBD();
            if (modelo.eliminar_cliente(cod_selec)&&pbd.borrar_porcedula(cedula_selec)) {
                JOptionPane.showMessageDialog(vista, "ELIMINADO EL CLIENTE ");
                limpiar();
                
            }else{
                JOptionPane.showMessageDialog(vista, "HA OCURRIDO UN ERROR AL ELIMINAR ESTE CLIENTE");                
            }
         }else{
            JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN ELEMENTO PARA ELIMINAR EN LA TABLA");
        }
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

                String x = vista.getTxtcedula().getText();
                System.out.println(x);
                //aqui se  coloca la tabla de la busqueda
                tabla_busqueda(x);

            }

        };

        vista.getTxtcedula().addKeyListener(escuchateclado);

    }
    
////////////////////////////////////////////////////////////////////////////////    
    
     public void tabla_busqueda(String parametro) {
        //empieza tabla
        List<Cliente> todos_usuarios = modelo.buscarUsuario_like(parametro);

        String matriz[][] = new String[todos_usuarios.size()][6];
        for (int i = 0; i < todos_usuarios.size(); i++) {
            matriz[i][0] = todos_usuarios.get(i).getPer_cedula();
            matriz[i][1] = todos_usuarios.get(i).getPer_nombre();
            matriz[i][2]=todos_usuarios.get(i).getPer_apellido();
            matriz[i][3] = todos_usuarios.get(i).getCli_genero();
            matriz[i][4]=todos_usuarios.get(i).getPer_telefono();
            int cod_cli=todos_usuarios.get(i).getCli_codigocli();
            String cod_clif=String.valueOf(cod_cli);
            matriz[i][5]=cod_clif;
            
        }

        vista.getTblcliente().setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Cédula", "Nombre", "Apellido", "Genero","Telefono","Codigo_cliente"
                }
        ));
    }
}

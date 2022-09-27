/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Persona;
import Modelo.PersonaBD;
import Modelo.Usuario;
import Modelo.UsuarioBD;
import Vista.Login;
import Vista.RGerente;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Controller_RGerente {
    private RGerente vista;
    private UsuarioBD modelo;

    public Controller_RGerente(RGerente vista, UsuarioBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
        iniciarcontrol();
    }
    public void iniciarcontrol(){
        vista.getBtnRegistrarse().addActionListener(l->registro_gerente());
        vista.getBtnCancelar().addActionListener(l->atras());
    }
    
    public void atras(){
        
        vista.setVisible(false);
        
    }
public void registro_gerente(){
    String cedula,nombre,apellido,usuario,clave,rep_clave,telefono,direccion,correo;
                   cedula= vista.getTxtcedula().getText();
                   nombre=  vista.getTxtnombre().getText();
                   apellido= vista.getTxtapellido().getText();
                   usuario= vista.getTxtusuario().getText();
                    clave= vista.getTxtclave().getText();
                    telefono= vista.getTxttelefono().getText();
                    direccion= vista.getTxtdireccion().getText();
                    correo= vista.getTxtcorreo().getText();
                     rep_clave=vista.getTxtrepclave().getText();
    
    if (cedula.isEmpty()||nombre.isEmpty()||apellido.isEmpty()||usuario.isEmpty()||clave.isEmpty()||rep_clave.isEmpty()||telefono.isEmpty()||direccion.isEmpty()||correo.isEmpty()) {
        JOptionPane.showMessageDialog(vista, "EXISTEN CAMPOS VACIOS O LA CLAVE NO COINCIDE");
    }else{
        
        PersonaBD p=new PersonaBD();
        modelo.setPer_cedula(cedula);
        modelo.setPer_nombre(nombre);
        modelo.setPer_apellido(apellido);
        modelo.setPer_correo(correo);
        modelo.setPer_direccion(direccion);
        modelo.setPer_telefono(telefono);
        if (modelo.insertar_usuario1()) {
            JOptionPane.showMessageDialog(vista, "PERSONA CREADA");
            List<Persona> id_persona =p.hallar_id_persona(cedula);
            int id_per=id_persona.get(0).getPer_codigoper();
            modelo.setUsuario(usuario);
            modelo.setClave(clave);
            modelo.setRol("Administrador");
            if (modelo.insertar_usuario2(id_per)) {
                JOptionPane.showMessageDialog(vista, "USUARIO CREADO");
            }
        }
    }
}


}

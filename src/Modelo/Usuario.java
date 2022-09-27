/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Usuario;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Usuario extends Persona{
    private  String rol, clave,usuario;
    private int us_codigous;
public Usuario(){
    
}

    public Usuario(String rol, String clave, String usuario, int us_codigous) {
        this.rol = rol;
        this.clave = clave;
        this.usuario = usuario;
        this.us_codigous = us_codigous;
    }

    public Usuario(String rol, String clave, String usuario, int us_codigous, String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_direccion, String per_correo, int per_codigoper) {
        super(per_cedula, per_nombre, per_apellido, per_telefono, per_direccion, per_correo, per_codigoper);
        this.rol = rol;
        this.clave = clave;
        this.usuario = usuario;
        this.us_codigous = us_codigous;
    }

    public int getUs_codigous() {
        return us_codigous;
    }

    public void setUs_codigous(int us_codigous) {
        this.us_codigous = us_codigous;
    }
   

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


   

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "rol=" + rol + ", clave=" + clave + '}';
    }
   
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PersonaBD extends Persona{

    public PersonaBD() {
    }

    public PersonaBD(String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_direccion, String per_correo, int per_codigoper) {
        super(per_cedula, per_nombre, per_apellido, per_telefono, per_direccion, per_correo, per_codigoper);
    }

    

    
    Conexion cx = new Conexion();

    public boolean setPersona() {
        String sql;
        sql = "INSERT INTO persona (per_cedula,per_nombre,per_apellido,per_telefono,per_direccion,per_correo) "
                + "VALUES('" + getPer_cedula() + "'"
                + ",'" + getPer_nombre() + "'"
                + ",'" + getPer_apellido() + "'"
                + ",'" + getPer_telefono() + "'"
                + ",'" + getPer_direccion() + "'"
                + ",'" + getPer_correo() + "')";

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
    
////////////////////////////////////////////////////////////////////////////////    

    public List<Persona> buscarDatosPersonas(String cadena) {
        List<Persona> listapersona = new ArrayList<>();

        String sql = "select * from persona";

        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Persona pers = new Persona();
                
                
                pers.setPer_cedula(rs.getString("per_cedula"));
                pers.setPer_nombre(rs.getString("per_nombre"));
                pers.setPer_apellido(rs.getString("per_apellido"));
                pers.setPer_telefono(rs.getString("per_telefono"));
                pers.setPer_direccion(rs.getString("per_direccion"));
                pers.setPer_correo(rs.getString("per_correo"));
                listapersona.add(pers);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listapersona;
    }
    //////////////////////////////////////////////////
    public List<Persona> hallar_id_persona(String cedula) {
        List<Persona> listapersona = new ArrayList<>();

        String sql = "select * from persona where per_cedula='"+cedula+"'";

        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Persona pers = new Persona();
                
                
                pers.setPer_codigoper(rs.getInt("per_codigoper"));
                
                listapersona.add(pers);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listapersona;
    }
////////////////////////////////////////////////////////////////////////////////    

    public List<Persona> getPersonas() {

        List<Persona> listaPersonas = new ArrayList();
        String sql = "select * from persona";
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Persona per = new Persona();
               
                per.setPer_cedula(rs.getString("per_cedula"));
                per.setPer_nombre(rs.getString("per_nombre"));
                per.setPer_apellido(rs.getString("per_apellido"));
                per.setPer_telefono(rs.getString("per_telefono"));
                per.setPer_direccion(rs.getString("per_direccion"));
                per.setPer_correo(rs.getString("per_correo"));

                listaPersonas.add(per);
            }
            return listaPersonas;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaPersonas;
    }

    public boolean deletePersona(int id) {
        String sql = "DELETE FROM persona where per_codigoper='" + id + "'";
        return cx.accion(sql);
    }
    public boolean borrar_porcedula(String cedula ) {
        String sql = "DELETE FROM persona where per_cedula='" + cedula + "'";
        return cx.accion(sql);
    }
    
    
    
    
    public List<Persona> tabla_persona() {
        List<Persona> listapersona = new ArrayList<Persona>();
        
        String sql = "select p.per_cedula,p.per_nombre, p.per_apellido, p.per_telefono, p.per_direccion, p.per_correo from persona p ";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Persona perso=new Persona();
                perso.setPer_cedula(rs.getString("PER_CEDULA"));
                perso.setPer_nombre(rs.getString("PER_NOMBRE"));
                perso.setPer_apellido(rs.getString("PER_APELLIDO"));
                perso.setPer_telefono(rs.getString("PER_TELEFONO"));
                perso.setPer_direccion(rs.getString("PER_DIRECCION"));
                perso.setPer_correo(rs.getString("PER_CORREO"));
                listapersona.add(perso);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listapersona;
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author pc
 */
public class ServiciosBD extends Servicios {

    public ServiciosBD() {
    }

    public ServiciosBD(String serv_codigo, String serv_servicio, Double serv_precio) {
        super(serv_codigo, serv_servicio, serv_precio);
    }
    
     Conexion cx = new Conexion();

     public boolean editar_servicio(int codigo_serv) {
        String sql;
        sql = "update servicios set serv_precio="+getServ_precio()+", serv_nombre='"+getServ_servicio()+"' where serv_codigoser="+codigo_serv
                ;

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
     
     
     
    public boolean ingresar_servicio() {
        String sql;
        sql = "INSERT INTO servicios (serv_nombre, serv_precio) "
                + "VALUES("
                + "'" + getServ_servicio() + "'"
                + "," + getServ_precio()+ ")";

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
    
////////////////////////////////////////////////////////////////////////////////    
 public List<Servicios> obtener_servicio(int cod_servi) {

        List<Servicios> listaServicios = new ArrayList();
        String sql = "select * from servicios where serv_codigoser="+cod_servi;
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
               ServiciosBD serv = new ServiciosBD();
                
                serv.setServ_codigo(rs.getString("serv_codigoser"));
                serv.setServ_servicio(rs.getString("serv_nombre"));
                
//                double precio = Double.parseDouble(rs.getString("pro_precio"));
                serv.setServ_precio(rs.getDouble("serv_precio"));
                
               
                listaServicios.add(serv);
            }
            return listaServicios;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaServicios;
    }
   
    
////////////////////////////////////////////////////////////////////////////////    

    public List<Servicios> getServicios() {

        List<Servicios> listaServicios = new ArrayList();
        String sql = "select * from servicios";
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
               ServiciosBD serv = new ServiciosBD();
                
                serv.setServ_codigo(rs.getString("serv_codigoser"));
                serv.setServ_servicio(rs.getString("serv_nombre"));
                
//                double precio = Double.parseDouble(rs.getString("pro_precio"));
                serv.setServ_precio(rs.getDouble("serv_precio"));
                
               
                listaServicios.add(serv);
            }
            return listaServicios;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaServicios;
    }

    //
    public List<Servicios> servicio_like(String nombre) {

        List<Servicios> listaServicios = new ArrayList();
        String sql = "select * from servicios where serv_nombre like '"+nombre+"%'";
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
               ServiciosBD serv = new ServiciosBD();
                
                serv.setServ_codigo(rs.getString("serv_codigoser"));
                serv.setServ_servicio(rs.getString("serv_nombre"));
                
//                double precio = Double.parseDouble(rs.getString("pro_precio"));
                serv.setServ_precio(rs.getDouble("serv_precio"));
                
               
                listaServicios.add(serv);
            }
            return listaServicios;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaServicios;
    }
    //
    
    
    
    public boolean deleteServicios(int cod) {
        String sql = "DELETE FROM servicios where serv_codigoser='" + cod + "'";
        return cx.accion(sql);
    }
    
}

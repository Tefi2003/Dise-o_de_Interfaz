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
public class ProductoBD extends Producto {
    
    
    
    public ProductoBD() {
    }

    public ProductoBD(String pro_codigo, String pro_nombre, Double pro_precio, String pro_marca) {
        super(pro_codigo, pro_nombre, pro_precio, pro_marca);
    }
  

    
    Conexion cx = new Conexion();
    
    

     public List<Producto> getProducto() {

        List<Producto> listaServicios = new ArrayList();
        String sql = "select * from producto";
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
               ProductoBD serv = new ProductoBD();
                
                serv.setPro_codigo(rs.getString("pro_codigopro"));
                serv.setPro_nombre(rs.getString("pro_nombre"));
                serv.setPro_precio(rs.getDouble("pro_precio"));
                serv.setPro_marca(rs.getString("pro_marca"));
               
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
     
/////////////////////////////////////////////////////////////////////////////////

 public List<Producto> obtener_servicio(int cod_servi) {

        List<Producto> listaServicios = new ArrayList();
        String sql = "select * from producto where pro_codigopro="+cod_servi;
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
               ProductoBD serv = new ProductoBD();
                
                serv.setPro_codigo(rs.getString("pro_codigopro"));
                serv.setPro_nombre(rs.getString("pro_nombre"));
                serv.setPro_precio(rs.getDouble("pro_precio"));
                serv.setPro_marca(rs.getString("pro_marca"));               
               
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
 
  public boolean ingresar_servicio() {
        String sql;
        sql = "INSERT INTO producto (pro_nombre, pro_precio, pro_marca) "
                + "VALUES("
                + "'" + getPro_nombre()+ "'"
                + "," + getPro_precio()+ ","
                + "'" + getPro_marca()+ "')";

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
    }
 
////////////////////////////////////////////////////////////////////////////////
  
  public boolean deleteServicios(int cod) {
        String sql = "DELETE FROM producto where pro_codigopro='" + cod + "'";
        return cx.accion(sql);
    }
  
////////////////////////////////////////////////////////////////////////////////
  
  public boolean editar_servicio(int codigo_serv) {
        String sql;
        sql = "update producto set pro_precio="+getPro_precio()+", pro_nombre='"+getPro_nombre()+"', pro_marca='"+getPro_marca()+"' where pro_codigopro="+codigo_serv;     
        return cx.accion(sql);  //EJECUTAMOS EL INSERT      
    }
  
////////////////////////////////////////////////////////////////////////////////
  
  public List<Producto> servicio_like(String nombre) {

        List<Producto> listaServicios = new ArrayList();
        String sql = "select * from producto where pro_nombre like '"+nombre+"%'";
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
               ProductoBD serv = new ProductoBD();
                
                serv.setPro_codigo(rs.getString("pro_codigopro"));
                serv.setPro_nombre(rs.getString("pro_nombre"));
                serv.setPro_precio(rs.getDouble("pro_precio"));
                serv.setPro_marca(rs.getString("pro_marca"));
               
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
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tefip
 */
public class Producto {
    
    private String pro_codigo;
    private String pro_nombre;
    private Double pro_precio;
    private String pro_marca;
    Conexion con=new Conexion();

    public Producto() {
    }

    public Producto(String pro_codigo, String pro_nombre, Double pro_precio, String pro_marca) {
        this.pro_codigo = pro_codigo;
        this.pro_nombre = pro_nombre;
        this.pro_precio = pro_precio;
        this.pro_marca = pro_marca;
    }

    public String getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(String pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public Double getPro_precio() {
        return pro_precio;
    }

    public void setPro_precio(Double pro_precio) {
        this.pro_precio = pro_precio;
    }

    public String getPro_marca() {
        return pro_marca;
    }

    public void setPro_marca(String pro_marca) {
        this.pro_marca = pro_marca;
    }
    java.sql.Statement st;
    ResultSet rs;
    
     public void insertar_producto(String codigo, String nombre, double precio, String marca) {
        try {
             Connection conexion=con.conectar();
            st = conexion.createStatement();
            String sql = "insert into producto(codigo,nombre,precio, marca) values('" + codigo + "','" + nombre + "','" + precio + "','" + marca + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "EL PRODUCTO SE GUARDO CORRECTAMENTE", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "UPS! Algo sucedio y no se guardo el registro", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public List<Producto> mostrarDatos_producto(){
     try{   
         ArrayList<Producto>lista=new ArrayList<Producto>();
          Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql= "SELECT * FROM producto";
          rs= st.executeQuery(sql);
          
         while(rs.next())
         {
             Producto producto =new Producto();
             producto.setPro_codigo(rs.getString("codigo"));
             producto.setPro_nombre(rs.getString("nombre"));
             producto.setPro_precio(rs.getDouble("precio"));
             producto.setPro_marca(rs.getString("marca"));
             lista.add(producto);
         }
            st.close();
            conexion.close();
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
    }
    public void eliminar_producto(String codigo){
       try{
         Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql="delete from producto where codigo='"+codigo+"';";
         st.execute(sql);
         st.close();
         conexion.close();
           JOptionPane.showMessageDialog(null, "Producto eliminado correctamente", "ELIMINADO ", JOptionPane.INFORMATION_MESSAGE); 
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "No se ha encontrado producto a eliminar", "Error ", JOptionPane.ERROR_MESSAGE); 
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se ha encontrado producto a eliminar ...", "Error ", JOptionPane.ERROR_MESSAGE); 
       }
   }
    
    public List<Producto> busqueda_producto(String codigo){
        try{
            Connection conexion=con.conectar();
           ArrayList<Producto>lista=new ArrayList<Producto>();
         st=conexion.createStatement();
         String sql="select * from producto where codigo='"+codigo+"';";
       rs= st.executeQuery(sql);
       while(rs.next()){
            Producto producto=new Producto();
                         
             producto.setPro_codigo(rs.getString("codigo"));
             producto.setPro_nombre(rs.getString("nombre"));
             producto.setPro_precio(rs.getDouble("precio"));
             producto.setPro_marca(rs.getString("marca"));
             lista.add(producto);             
       }
       st.close();
       conexion.close();
       return lista;
       
       }catch(SQLException ex){
         Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
           
   }
     public void actualizar_producto(String codigo, String nombre, double precio, String marca){
       try{
          Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql="update clientes set marca='"+marca+"',precio='"+precio+"',nombre='"+nombre+"' where codigo='"+codigo+"';";
       st.executeUpdate(sql);
       st.close();
       conexion.close();
       JOptionPane.showMessageDialog(null, "El producto se actualizo", "exito ", JOptionPane.INFORMATION_MESSAGE);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Error ", JOptionPane.ERROR_MESSAGE);
       }
   }
    
    
    public List<Producto> buscarCodigo(String criterio){
        try{
             Connection conexion=con.conectar();
            ArrayList<Producto> lista = new ArrayList<Producto>();
             Conexion conecta= new Conexion();
            String sql = "SELECT * FROM producto WHERE codigo = '" + criterio + "';";
            ResultSet rs  = conecta.consulta(sql);
            while(rs.next()){
                Producto producto = new Producto();
                producto.setPro_codigo(rs.getString("codigo"));
                producto.setPro_nombre(rs.getString("nombre"));
                producto.setPro_precio(rs.getDouble("precio"));
                producto.setPro_marca(rs.getString("marca"));
                lista.add(producto); 
              
            }
        rs.close();
        return lista;
        }catch(SQLException ex){
           Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    } 
    
     public List<Producto> buscar(String criterio){
        try{
             Connection conexion=con.conectar();
            ArrayList<Producto> lista = new ArrayList<Producto>();
            Conexion conecta= new Conexion();
            String sql = "SELECT * FROM producto WHERE UPPER (nombre) like UPPER('%"+ criterio +"%') or UPPER (marca) like UPPER('%"+ criterio +"%')";
            ResultSet rs  = conecta.consulta(sql);
            while(rs.next()){
                Producto producto = new Producto();
                producto.setPro_codigo(rs.getString("codigo"));
                producto.setPro_nombre(rs.getString("nombre"));
                producto.setPro_precio(rs.getDouble("precio"));
                producto.setPro_marca(rs.getString("marca"));
                lista.add(producto); 
              
            }
        rs.close();
            return lista;
        }catch(SQLException ex){
           Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    } 
}

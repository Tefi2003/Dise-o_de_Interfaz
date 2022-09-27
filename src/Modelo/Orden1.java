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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wilo
 */
public class Orden1 {
    private String estado,cedula,servicios,maquinas,productos,fecha;
    private double precio_total,peso;
    private int num_orden;
 Conexion con=new Conexion();
 public Orden1() {
    }

    public Orden1(String estado, String cedula, String servicios, String maquinas, String productos, String fecha, double precio_total, double peso, int num_orden) {
        this.estado = estado;
        this.cedula = cedula;
        this.servicios = servicios;
        this.maquinas = maquinas;
        this.productos = productos;
        this.fecha = fecha;
        this.precio_total = precio_total;
        this.peso = peso;
        this.num_orden = num_orden;
    }
 
    
    public int getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(int num_orden) {
        this.num_orden = num_orden;
    }
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(String maquinas) {
        this.maquinas = maquinas;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    
    
   

   
        java.sql.Statement st;
    ResultSet rs;
    
     public void insertar_orden(int num_orden, String estado, String cedula, String servicios, String maquinas, String productos, String fecha, double precio_total, double peso) {
        try {
            Connection conexion=con.conectar();
            st = conexion.createStatement();
            String sql = "insert into ordenes(num_orden,estado,cedula, servicios,maquinas,productos,fecha,precio_total,peso) values('" +num_orden+ "','" +estado+ "','" + cedula + "','" + servicios + "','"+maquinas+"','"+productos+"','"+fecha+"','"+precio_total+"','"+peso+"');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "Orden generada correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "UPS! Algo sucedio y no se guardo el registro", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Orden1> mostrarDatos_orden(){
     try{   
         ArrayList<Orden1>lista=new ArrayList<Orden1>();
         Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql= "SELECT * FROM ordenes";
          rs= st.executeQuery(sql);
          
         while(rs.next())
         {
             Orden1 or =new Orden1();
             or.setCedula(rs.getString("cedula"));
             or.setEstado(rs.getString("estado"));
             or.setFecha(rs.getString("fecha"));
             or.setMaquinas(rs.getString("maquinas"));
             or.setNum_orden(rs.getInt("num_orden"));
             or.setPeso(rs.getDouble("peso"));
             or.setPrecio_total(rs.getDouble("precio_total"));
             or.setProductos(rs.getString("productos"));
             or.setServicios(rs.getString("servicios"));
             lista.add(or);
             
         }
            st.close();
            conexion.close();
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
    }
    
    
    public List<Orden1> orden_por_cedula(String cedula){
     try{   
         ArrayList<Orden1>lista=new ArrayList<Orden1>();
         Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql= "SELECT * FROM ordenes where cedula='"+cedula+"';";
          rs= st.executeQuery(sql);
          
         while(rs.next())
         {
             Orden1 or =new Orden1();
             or.setCedula(rs.getString("cedula"));
             or.setEstado(rs.getString("estado"));
             or.setFecha(rs.getString("fecha"));
             or.setMaquinas(rs.getString("maquinas"));
             or.setNum_orden(rs.getInt("num_orden"));
             or.setPeso(rs.getDouble("peso"));
             or.setPrecio_total(rs.getDouble("precio_total"));
             or.setProductos(rs.getString("productos"));
             or.setServicios(rs.getString("servicios"));
             lista.add(or);
             
         }
            st.close();
            conexion.close();
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
    }
    
    
    
     public void actualizar_estado(int num_orden){
       try{
           Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql="update ordenes set estado='ENTREGADO' where num_orden='"+num_orden+"';";
       st.executeUpdate(sql);
       st.close();
       conexion.close();
       
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Error ", JOptionPane.ERROR_MESSAGE);
       }
   }
    
    
}

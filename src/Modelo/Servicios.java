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
public class Servicios {
    
    private String serv_codigo;
    private String serv_servicio;
    private Double serv_precio;
Conexion con=new Conexion();
    
    public Servicios() {
    }
     
    public Servicios(String serv_codigo, String serv_servicio, Double serv_precio) {
        this.serv_codigo = serv_codigo;
        this.serv_servicio = serv_servicio;
        this.serv_precio = serv_precio;
    }

    public String getServ_codigo() {
        return serv_codigo;
    }

    public void setServ_codigo(String serv_codigo) {
        this.serv_codigo = serv_codigo;
    }

    public String getServ_servicio() {
        return serv_servicio;
    }

    public void setServ_servicio(String serv_servicio) {
        this.serv_servicio = serv_servicio;
    }

    public Double getServ_precio() {
        return serv_precio;
    }

    public void setServ_precio(Double serv_precio) {
        this.serv_precio = serv_precio;
    }
    
    
java.sql.Statement st;
ResultSet rs;
    
     public void insertar_servicio(String codigo, String servicio, Double precio) {
        try {
            Connection conexion = con.conectar();
            st = conexion.createStatement();
            String sql = "insert into servicios(codigo,servicio,precio) values('" + codigo + "','" + servicio + "','" + precio +"');";

            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "EL REGISTRO SE GUARDO CORRECTAMENTE", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "UPS! Algo sucedio y no se guardo el registro", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
     public List<Servicios> mostrarDatos_servicio(){
     try{   
         ArrayList<Servicios>lista=new ArrayList<Servicios>();
         Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql= "SELECT * FROM servicios";
          rs= st.executeQuery(sql);
          
         while(rs.next()){
             //
             Servicios servicio=new Servicios();
             
             servicio.setServ_codigo(rs.getString("codigo"));
             servicio.setServ_servicio(rs.getString("servicio"));
             servicio.setServ_precio(rs.getDouble("precio"));
             
             
             lista.add(servicio);
                }
             st.close();
            conexion.close();
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
    }
     
     
     
    public void eliminar_servicio(String codigo){
       try{
       Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql="delete from servicios where codigo='"+codigo+"';";
         st.execute(sql);
         st.close();
         conexion.close();
           JOptionPane.showMessageDialog(null, "Servicio eliminado correctamente", "ELIMINADO ", JOptionPane.INFORMATION_MESSAGE); 
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "No se ha encontrado servicio a eliminar", "Error ", JOptionPane.ERROR_MESSAGE); 
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se ha encontrado servicio a eliminar ...", "Error ", JOptionPane.ERROR_MESSAGE); 
       }
   }
    
    public List<Servicios> busqueda_servicio(String codigo){
        try{
           Connection conexion=con.conectar();
            ArrayList<Servicios>lista=new ArrayList<Servicios>();
         st=conexion.createStatement();
         String sql="select * from servicios where codigo='"+codigo+"';";
       rs= st.executeQuery(sql);
       while(rs.next()){
            Servicios servicio=new Servicios();
             
             servicio.setServ_codigo(rs.getString("codigo"));
             servicio.setServ_servicio(rs.getString("servicio"));
             servicio.setServ_precio(rs.getDouble("precio"));
             
             
             lista.add(servicio);
       }
       st.close();
       conexion.close();
       return lista;
       
       }catch(SQLException ex){
         Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
           
   }
     public void actualizar_servicio(String codigo, String servicio, Double precio){
       try{
           Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql="update servicios set servicio='"+serv_servicio+"',precio='"+serv_precio+"';";
       st.executeUpdate(sql);
       st.close();
       conexion.close();
       JOptionPane.showMessageDialog(null, "El registro se actualizo", "exito ", JOptionPane.INFORMATION_MESSAGE);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Error ", JOptionPane.ERROR_MESSAGE);
       }
   }
    
    
    public List<Servicios> buscarCodigo(String criterio){
        try{
            ArrayList<Servicios> lista = new ArrayList<Servicios>();
             Conexion conecta= new Conexion();
            String sql = "SELECT * FROM servicios WHERE codigo = '" + criterio + "';";
            
            ResultSet rs  = conecta.consulta(sql);
            while(rs.next()){
                Servicios servicio = new Servicios();
                servicio.setServ_codigo(rs.getString("codigo"));
                servicio.setServ_servicio(rs.getString("servicio"));
                servicio.setServ_precio(rs.getDouble("precio"));
                lista.add(servicio);
              
            }
        rs.close();
        return lista;
        }catch(SQLException ex){
           Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    } 
    
     public List<Servicios> buscar(String criterio){
        try{
            ArrayList<Servicios> lista = new ArrayList<Servicios>();
            Conexion conecta= new Conexion();
            String sql = "SELECT * FROM servicios WHERE UPPER (servicio) like UPPER('%"+ criterio +"%')";
            ResultSet rs  = conecta.consulta(sql);
            while(rs.next()){
                Servicios servicio = new Servicios();
                servicio.setServ_codigo(rs.getString("codigo"));
                servicio.setServ_servicio(rs.getString("servicio"));
                servicio.setServ_precio(rs.getDouble("precio"));
                lista.add(servicio);
              
            }
        rs.close();
            return lista;
        }catch(SQLException ex){
           Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    } 
     
      
    
}

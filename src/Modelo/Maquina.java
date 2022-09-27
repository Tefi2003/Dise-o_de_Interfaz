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
public class Maquina{
    
    private int maq_codigo;
    private String maq_tamaño;
    private Double maq_precio;
   
    Conexion con=new Conexion();
    ///CONST

    public Maquina() {
    }

    public Maquina(int maq_codigo, String maq_tamaño, Double maq_precio) {
        this.maq_codigo = maq_codigo;
        this.maq_tamaño = maq_tamaño;
        this.maq_precio = maq_precio;
    }

    public int getMaq_codigo() {
        return maq_codigo;
    }

    public void setMaq_codigo(int maq_codigo) {
        this.maq_codigo = maq_codigo;
    }

   
    public String getMaq_tamaño() {
        return maq_tamaño;
    }

    public void setMaq_tamaño(String maq_tamaño) {
        this.maq_tamaño = maq_tamaño;
    }

    public Double getMaq_precio() {
        return maq_precio;
    }

    public void setMaq_precio(Double maq_precio) {
        this.maq_precio = maq_precio;
    }

    java.sql.Statement st;
    ResultSet rs;

    public void insertar_maquina(String maq_codigomaq, String maq_tamaño, double maq_precio) {
        try {
            Connection conexion = con.conectar();
            st = conexion.createStatement();
            String sql = "insert into maquina(maq_codigomaq,maq_tamaño, maq_precio) values('" + maq_codigomaq + "','" + maq_tamaño+ "','" + maq_precio + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "LA MAQUINA SE REGISTRO CORRECTAMENTE", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "UPS! Algo sucedio y no se guardo el registro", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public List<Maquina> mostrarDatos_maquina(){
     try{   
         ArrayList<Maquina>lista=new ArrayList<Maquina>();
         Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql= "SELECT * FROM maquina";
          rs= st.executeQuery(sql);
          
         while(rs.next())
         {
             Maquina maquina =new Maquina();
            
             maquina.setMaq_codigo(rs.getInt("maq_codigomaq"));
             maquina.setMaq_tamaño(rs.getString("maq_tamaño"));
             maquina.setMaq_precio(rs.getDouble("maq_precio"));
             
             lista.add(maquina);
         }
            st.close();
            conexion.close();
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Maquina.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
    }
    
     public void eliminar_maquina(String maq_codigo){
       try{
       Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql="delete from maquina where maq_codigomaq='"+maq_codigo+"';";
         st.execute(sql);
         st.close();
         conexion.close();
           JOptionPane.showMessageDialog(null, "Maquina eliminado correctamente", "ELIMINADO ", JOptionPane.INFORMATION_MESSAGE); 
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "No se ha encontrado maquina a eliminar", "Error ", JOptionPane.ERROR_MESSAGE); 
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se ha encontrado maquina a eliminar ...", "Error ", JOptionPane.ERROR_MESSAGE); 
       }
   }
     
      public List<Maquina> busqueda_maquina(String maq_codigo){
        try{
           Connection conexion=con.conectar();
           ArrayList<Maquina>lista=new ArrayList<Maquina>();
         st=conexion.createStatement();
         String sql="select * from maquina where maq_codigomaq='"+maq_codigo+"';";
         rs= st.executeQuery(sql);
       while(rs.next()){
            Maquina maquina =new Maquina();
            
             maquina.setMaq_codigo(rs.getInt("maq_codigomaq "));
            maquina.setMaq_tamaño(rs.getString("maq_tamaño"));
             maquina.setMaq_precio(rs.getDouble("maq_precio"));
             
             lista.add(maquina);          
       }
       st.close();
       conexion.close();
         return lista;
       }catch(SQLException ex){
         Logger.getLogger(Maquina.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
           
   }
      
  
   
   public void actualizar_maquina(String maq_codigo, String maq_tamaño, double maq_precio){
       try{
         Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql="update maquina set maq_precio='"+maq_precio+"',maq_tamaño='"+maq_tamaño+"' where maq_codigomaq='"+maq_codigo+"';";
       st.executeUpdate(sql);
       st.close();
       conexion.close();
       JOptionPane.showMessageDialog(null, "El registro se actualizo", "exito ", JOptionPane.INFORMATION_MESSAGE);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Error ", JOptionPane.ERROR_MESSAGE);
       }
   }
}

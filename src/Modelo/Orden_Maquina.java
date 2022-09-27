/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author DELL
 */
public class Orden_Maquina {
    private int id_ordenmaquina;
    private int OMnum_orden;
    private String OMcod_maquina;
    Conexion con=new Conexion();

    public Orden_Maquina() {
    }

    public Orden_Maquina(int id_ordenmaquina, int OMnum_orden, String OMcod_maquina) {
        this.id_ordenmaquina = id_ordenmaquina;
        this.OMnum_orden = OMnum_orden;
        this.OMcod_maquina = OMcod_maquina;
    }

    public int getId_ordenmaquina() {
        return id_ordenmaquina;
    }

    public void setId_ordenmaquina(int id_ordenmaquina) {
        this.id_ordenmaquina = id_ordenmaquina;
    }

    public int getOMnum_orden() {
        return OMnum_orden;
    }

    public void setOMnum_orden(int OMnum_orden) {
        this.OMnum_orden = OMnum_orden;
    }

    public String getOMcod_maquina() {
        return OMcod_maquina;
    }

    public void setOMcod_maquina(String OMcod_maquina) {
        this.OMcod_maquina = OMcod_maquina;
    }
    
    
    
    
    java.sql.Statement st;
    ResultSet rs;
    
     public void insertar_ORDEN_MAQUINA(int id_ordenmaquina, int OMnum_orden, String OMcod_maquina) {
        try {
            Connection conexion=con.conectar();
            st = conexion.createStatement();
            String sql = "insert into orden_maquina(id_ordenmaquina,OMnum_orden,OMcod_maquina) values('" +id_ordenmaquina+ "','" +OMnum_orden+ "','" +OMcod_maquina+ "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "¡Relacion ORDEN-MAQUINA establecida exitosamente!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "UPS! Algo sucedio y no se guardo la relacion", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Orden_Maquina> mostrarDatos_ordenmaquina(){
     try{   
         ArrayList<Orden_Maquina>lista=new ArrayList<Orden_Maquina>();
         Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql= "SELECT * FROM orden_maquina";
          rs= st.executeQuery(sql);
         while(rs.next())
         {
             Orden_Maquina or=new Orden_Maquina();
             or.setId_ordenmaquina(rs.getInt("id_ordenmaquina"));
             or.setOMnum_orden(rs.getInt("OMnum_orden"));
             or.setOMcod_maquina(rs.getString("OMcod_maquina"));
             lista.add(or);
         }
            st.close();
            conexion.close();
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Orden_Maquina.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
    }
    
    
    public List<Orden_Maquina> ordenmaq_por_num_orden(String OMnum_orden){
     try{   
         ArrayList<Orden_Maquina>lista=new ArrayList<Orden_Maquina>();
        Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql= "SELECT * FROM orden_maquina where OMnum_orden='"+OMnum_orden+"';";
          rs= st.executeQuery(sql);
          
         while(rs.next())
         {
             Orden_Maquina or=new Orden_Maquina();
             or.setId_ordenmaquina(rs.getInt("id_ordenmaquina"));
             or.setOMnum_orden(rs.getInt("OMnum_orden"));
             or.setOMcod_maquina(rs.getString("OMcod_maquina"));
             lista.add(or);
         }
            st.close();
            conexion.close();
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Orden_Maquina.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
    }
    public List<Orden_Maquina> ordenmap_por_codmaq(String OMcod_maquina){
     try{   
         ArrayList<Orden_Maquina>lista=new ArrayList<Orden_Maquina>();
         Connection conexion=con.conectar();
         st=conexion.createStatement();
         String sql= "SELECT * FROM orden where OMcod_maquina='"+OMcod_maquina+"';";
          rs= st.executeQuery(sql);
          
         while(rs.next())
         {
             Orden_Maquina or=new Orden_Maquina();
             or.setId_ordenmaquina(rs.getInt("id_ordenmaquina"));
             or.setOMnum_orden(rs.getInt("OMnum_orden"));
             or.setOMcod_maquina(rs.getString("OMcod_maquina"));
             lista.add(or);
             
         }
            st.close();
            conexion.close();
       return lista;
     }
     catch(SQLException ex)
     {
         Logger.getLogger(Orden_Maquina.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
    }
    public int id_incrementableOM()
    {
        int id=1;
        java.sql.Statement st;
        ResultSet rs;
        try
        {
            Connection conexion=con.conectar();
            st=conexion.createStatement();
            String sql= "select max (id_ordenmaquina) from orden_maquina";
            rs= st.executeQuery(sql);
            while(rs.next())
            {
                id=rs.getInt(1)+1;
            }
        st.close();
        conexion.close();
        }
        catch(Exception ex)
        {
            Logger.getLogger(Orden_Maquina.class.getName()).log(Level.SEVERE,null,ex);
        }
        return id;
    }
}

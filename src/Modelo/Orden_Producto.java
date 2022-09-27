/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Orden_Producto {
    private int id_ordenproducto;
    private int OPnum_orden;
    private String OPcod_producto;
     Conexion con=new Conexion();
    public Orden_Producto() {
    }

    public Orden_Producto(int id_ordenproducto, int OPnum_orden, String OPcod_producto) {
        this.id_ordenproducto = id_ordenproducto;
        this.OPnum_orden = OPnum_orden;
        this.OPcod_producto = OPcod_producto;
    }

    public int getId_ordenproducto() {
        return id_ordenproducto;
    }

    public void setId_ordenproducto(int id_ordenproducto) {
        this.id_ordenproducto = id_ordenproducto;
    }

    public int getOPnum_orden() {
        return OPnum_orden;
    }

    public void setOPnum_orden(int OPnum_orden) {
        this.OPnum_orden = OPnum_orden;
    }

    public String getOPcod_producto() {
        return OPcod_producto;
    }

    public void setOPcod_producto(String OPcod_producto) {
        this.OPcod_producto = OPcod_producto;
    }
    
    
    java.sql.Statement st;
    ResultSet rs;
    
     public void insertar_ORDEN_PRODUCTO(int id_ordenproducto, int OPnum_orden, String OPcod_producto) {
        try {
            Connection conexion=con.conectar();
            st = conexion.createStatement();
            String sql = "insert into orden_producto(id_ordenproducto,OPnum_orden,OPcod_producto) values('" +id_ordenproducto+ "','" +OPnum_orden+ "','" +OPcod_producto+ "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "¡Relacion ORDEN-PRODUCTO establecida exitosamente!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "UPS! Algo sucedio y no se guardo la relacion ORDEN-PRODUCTO", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int id_incrementableOP()
    {
        int id=1;
        java.sql.Statement st;
        ResultSet rs;
        try
        {
            Connection conexion=con.conectar();
            st=conexion.createStatement();
            String sql= "select max (id_ordenproducto) from orden_producto";
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
            Logger.getLogger(Orden_Producto.class.getName()).log(Level.SEVERE,null,ex);
        }
        return id;
    }
    
}

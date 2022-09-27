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
public class Orden_Servicio {
    private int id_ordenservicio;
    private int OSnum_orden;
    private String OScod_servicio;
    Conexion con=new Conexion();
    public Orden_Servicio() {
    }

    public Orden_Servicio(int id_ordenservicio, int OSnum_orden, String OScod_servicio) {
        this.id_ordenservicio = id_ordenservicio;
        this.OSnum_orden = OSnum_orden;
        this.OScod_servicio = OScod_servicio;
    }

    public int getId_ordenservicio() {
        return id_ordenservicio;
    }

    public void setId_ordenservicio(int id_ordenservicio) {
        this.id_ordenservicio = id_ordenservicio;
    }

    public int getOSnum_orden() {
        return OSnum_orden;
    }

    public void setOSnum_orden(int OSnum_orden) {
        this.OSnum_orden = OSnum_orden;
    }

    public String getOScod_servicio() {
        return OScod_servicio;
    }

    public void setOScod_servicio(String OScod_servicio) {
        this.OScod_servicio = OScod_servicio;
    }
    
    
    
    java.sql.Statement st;
    ResultSet rs;
    public void insertar_ORDEN_SERVICIO(int id_ordenservicio, int OSnum_orden, String OScod_servicio) {
        try {
            Connection conexion=con.conectar();
            st = conexion.createStatement();
            String sql = "insert into orden_servicio(id_ordenservicio,OSnum_orden,OScod_servicio) values('" +id_ordenservicio+ "','" +OSnum_orden+ "','" +OScod_servicio+ "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "¡Relacion ORDEN-SERVICIO establecida exitosamente!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "UPS! Algo sucedio y no se guardo la relacion ORDEN-SERVICIO", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    public int id_incrementableOS()
    {
        int id=1;
        java.sql.Statement st;
        ResultSet rs;
        try
        {
            Connection conexion=con.conectar();
            st=conexion.createStatement();
            String sql= "select max (id_ordenservicio) from orden_servicio";
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
            Logger.getLogger(Orden_Servicio.class.getName()).log(Level.SEVERE,null,ex);
        }
        return id;
    }
    
}

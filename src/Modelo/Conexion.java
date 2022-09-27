/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tefip
 */
public class Conexion {
     String cadenaConexion = "jdbc:oracle:thin:@localhost:1521:XE";
    String usuario = "Lava"; 
    String password = "1234";  
    Connection con;

    public Conexion() {
          try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(cadenaConexion, usuario, password);
            System.out.println("conectado");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    

    public Connection conectar() {
        try {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(cadenaConexion, usuario, password);
            System.out.println("conectado");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return con;
    }
    
    public ResultSet consulta(String sql) {   //SELECTS
         try {
            Statement st = con.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean accion(String sql) {   //INSERT,UPDATE,DELETE

        boolean correcto;
        try {

            Statement st = con.createStatement();
            st.execute(sql);
            st.close();  //CIERRO CONEXION SOLO EN CASO DE ACCION
            correcto = true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            correcto = false;
        }
        return correcto;
    }
}

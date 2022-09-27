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

/**
 *
 * @author pc
 */
public class MaquinaBD extends Maquina {

    public MaquinaBD() {
    }

    public MaquinaBD(int maq_codigo, String maq_tamaño, Double maq_precio) {
        super(maq_codigo, maq_tamaño, maq_precio);
    }

    

    
    
    Conexion cx = new Conexion();

    public boolean setMaquina() {
        String sql;
        sql = "INSERT INTO maquina ( maq_tamaño,  maq_precio) "
                + "VALUES('"+
                 getMaq_tamaño() + "'"
                + ",'" + getMaq_precio() + "')";

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
 ///////////////////////////////////////////////////////////////////////////////
    public List<Maquina> obtener_maquina(int cod_maqui) {

        List<Maquina> listaMaquina = new ArrayList();
        String sql = "select * from maquina where MAQ_CODIGOMAQ="+cod_maqui;
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
               MaquinaBD serv = new MaquinaBD();
                
                serv.setMaq_codigo(rs.getInt("MAQ_CODIGOMAQ"));
                serv.setMaq_tamaño(rs.getString("MAQ_TAMAÑO"));
                
//                double precio = Double.parseDouble(rs.getString("pro_precio"));
                serv.setMaq_precio(rs.getDouble("MAQ_PRECIO"));
                
               
                listaMaquina.add(serv);
            }
            return listaMaquina;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaMaquina;
    }
    
    /////////////////////////////////////////////////////////////////////
    public boolean editar_maquina(int codigo_serv) {
        String sql;
        sql = "update maquina set MAQ_TAMAÑO='"+getMaq_tamaño()+"', MAQ_PRECIO="+getMaq_precio()+" where MAQ_CODIGOMAQ="+codigo_serv
                ;

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
     
////////////////////////////////////////////////////////////////////////////////    

    public List<Maquina> buscarDatosMaquina(String cadena) {
        List<Maquina> listaMaquina = new ArrayList<>();

        String sql = "select * from maquina WHERE ";
        //sql+=" UPPER(per_cod) like UPPER('%"+cadena+"%')OR";
        sql += " UPPER(maq_codigomaq) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(maq_tamaño) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(maq_precio) like UPPER('%" + cadena + "%')";

        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Maquina maq = new Maquina();
                
                maq.setMaq_codigo(rs.getInt("maq_codigomaq"));
                maq.setMaq_tamaño(rs.getString("maq_tamaño"));
                
//                double precio = Double.parseDouble(rs.getString("pro_precio"));
                maq.setMaq_precio(rs.getDouble("maq_precio"));
                
               
                listaMaquina.add(maq);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaMaquina;
    }
    
////////////////////////////////////////////////////////////////////////////////    
 public List<Maquina> buscarCodigo(String criterio){
        try{
            Connection conexion=con.conectar();
            ArrayList<Maquina> lista = new ArrayList<Maquina>();
             Conexion conecta= new Conexion();
            String sql = "SELECT * FROM maquina WHERE maq_codigomaq = '" + criterio + "'";
            ResultSet rs  = conecta.consulta(sql);
            while(rs.next()){
                Maquina maquina =new Maquina();
            
             maquina.setMaq_codigo(rs.getInt("maq_codigomaq"));
             maquina.setMaq_tamaño(rs.getString("maq_tamaño"));
             maquina.setMaq_precio(rs.getDouble("maq_precio"));
             
             lista.add(maquina);
              
            }
        rs.close();
        return lista;
        }catch(SQLException ex){
           Logger.getLogger(Maquina.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    } 
   public List<Maquina> todas_maquinas  () {
        List<Maquina> listamaquina = new ArrayList<Maquina>();
        
        String sql = "select * from maquina";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Maquina maq=new Maquina();
                maq.setMaq_codigo(rs.getInt("MAQ_CODIGOMAQ"));
                maq.setMaq_tamaño(rs.getString("MAQ_TAMAÑO"));
                maq.setMaq_precio(rs.getDouble("MAQ_PRECIO"));
                listamaquina.add(maq);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listamaquina;
    }

    public boolean deleteMaquina(int id) {
        String sql = "DELETE FROM producto where maq_codigo='" + id + "'";
        return cx.accion(sql);
    }
    
      
      
        public List<Maquina> tabla_maquina() {
        List<Maquina> listamaquina = new ArrayList<Maquina>();
        
        String sql = "select maq_tamaño, maq_precio from maquina";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Maquina maq=new Maquina();
                maq.setMaq_tamaño(rs.getString("MAQ_TAMAÑO"));
                maq.setMaq_precio(rs.getDouble("MAQ_PRECIO"));
                listamaquina.add(maq);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listamaquina;
    }
    
}

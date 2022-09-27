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
 * @author pc
 */
public class OrdenBD extends Orden {

    public OrdenBD() {
    }

    public OrdenBD(String cli_genero, int cli_codigocli, String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_direccion, String per_correo, int per_codigoper) {
        super(cli_genero, cli_codigocli, per_cedula, per_nombre, per_apellido, per_telefono, per_direccion, per_correo, per_codigoper);
    }

    
   

   

    

    
    
    Conexion cx = new Conexion();

    public boolean setOrden(String fecha) {
        String sql;
        sql = "INSERT INTO orden (or_precio,or_fecha,or_peso, or_estado, or_codigocli,  or_descripcion_maq,or_descripcion_pro,  or_descripcion_ser) "
                + "VALUES(" + getOr_precio()+ ""
                + ",'" + fecha + "'"
                + "," + getOr_peso() + ""
                + ",'" + getOr_estado() + "'"
                + "," + getOr_codigocli() + ""
                + ",'" + getOr_descripcion_maq() + "'"
                + ",'" + getOr_descripcion_pro() + "'"
                + ",'" + getOr_descripcion_ser() + "')";

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
    
////////////////////////////////////////////////////////////////////////////////    

    public List<Orden> buscarDatosOrden(String cadena) {
        List<Orden> listaOrden = new ArrayList<>();

        String sql = "select * from orden WHERE ";
        //sql+=" UPPER(per_cod) like UPPER('%"+cadena+"%')OR";
        sql += " UPPER(or_precio) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(or_fecha) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(or_peso) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(or_estado) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(or_descripcion_cli) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(or_descripcion_maq) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(or_descripcion_pro) like UPPER('%" + cadena + "%') OR";
        sql += " UPPER(or_descripcion_ser) like UPPER('%" + cadena + "%')";

        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Orden maq = new Orden();
                
//                maq.setOr_precio(rs.getDouble("or_precio"));
//                maq.setOr_fecha(rs.getString("or_fecha"));
//                maq.setOr_precio(rs.getDouble("or_peso"));
//                maq.setOr_fecha(rs.getString("or_estado"));
//                maq.setOr_precio(rs.getInt("or_codigocli"));
//                maq.setOr_fecha(rs.getString("or_descripcion_maq"));
//                maq.setOr_precio(rs.getInt("or_descripcion_pro"));
//                maq.setOr_fecha(rs.getString("or_descripcion_ser"));
                
                
//               
                
               
                listaOrden.add(maq);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaOrden;
    }
    
////////////////////////////////////////////////////////////////////////////////    

    public List<Orden> getOrden() {

        List<Orden> listaOrden = new ArrayList();
        String sql = "select * from orden";
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
               Orden maq = new Orden();
                
//               maq.setOr_precio(rs.getDouble("or_precio"));
//                maq.setOr_fecha(rs.getString("or_fecha"));
//                maq.setOr_precio(rs.getDouble("or_peso"));
//                maq.setOr_fecha(rs.getString("or_estado"));
//                maq.setOr_precio(rs.getInt("or_codigocli"));
//                maq.setOr_fecha(rs.getString("or_descripcion_maq"));
//                maq.setOr_precio(rs.getInt("or_descripcion_pro"));
//                maq.setOr_fecha(rs.getString("or_descripcion_ser"));
               
                listaOrden.add(maq);
            }
            return listaOrden;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();//cierro conexion BD
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaOrden;
    }
    
    public boolean actualizar_estado(String num_orden){
     
        try{
           
         String sql="update orden set or_estado='ENTREGADO' where OR_CODIGOORDEN="+num_orden;
          return cx.accion(sql);
       
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudo actualizar", "Error ", JOptionPane.ERROR_MESSAGE);
           return false;
       }
     
   }
    
    public List<Orden> Ver(String num_orden){
     
          List<Orden> listaOrden = new ArrayList<Orden>();

        String sql = "SELECT OR_DESCRIPCION_SER,OR_DESCRIPCION_MAQ,OR_DESCRIPCION_PRO FROM ORDEN where OR_CODIGOORDEN="+num_orden;
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Orden orde=new Orden();
//               
                
                orde.setOr_codigoorden(rs.getInt("OR_CODIGOORDEN"));
                orde.setPer_cedula(rs.getString("PER_CEDULA"));
                orde.setPer_nombre(rs.getString("PER_NOMBRE"));
                orde.setPer_apellido(rs.getString("PER_APELLIDO"));
                orde.setOr_fecha(rs.getDate("OR_FECHA"));
                orde.setOr_estado(rs.getString("OR_ESTADO"));                
                orde.setOr_descripcion_ser(rs.getString("OR_DESCRIPCION_SER"));
                orde.setOr_descripcion_maq(rs.getString("OR_DESCRIPCION_MAQ"));
                orde.setOr_descripcion_pro(rs.getString("OR_DESCRIPCION_PRO"));                
                orde.setOr_peso(rs.getDouble("OR_PESO"));
                orde.setOr_precio(rs.getDouble("OR_PRECIO"));
                
                listaOrden.add(orde);
//              
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaOrden;
     
   }

    public List<Orden> ver_pendientes(){
     try{   
         ArrayList<Orden>lista=new ArrayList<Orden>();

         String sql= "select O.OR_CODIGOORDEN, PE.PER_CEDULA,pe.per_nombre, pe.per_apellido, O.OR_FECHA, O.OR_ESTADO,O.OR_DESCRIPCION_SER,O.OR_DESCRIPCION_MAQ,O.OR_DESCRIPCION_PRO, O.OR_PESO, O.OR_PRECIO \n" +
"FROM ORDEN O, PERSONA PE, CLIENTE C \n" +
"WHERE  PE.PER_CODIGOPER=C.CLI_CODIGOPER AND O.OR_CODIGOCLI=C.CLI_CODIGOCLI and UPPER(or_estado) = UPPER('pendiente')";
         ResultSet rs = cx.consulta(sql);
          
          
         while(rs.next())
         {
             Orden orde=new Orden();
               
                
                orde.setOr_codigoorden(rs.getInt("OR_CODIGOORDEN"));
                orde.setPer_cedula(rs.getString("PER_CEDULA"));
                orde.setPer_nombre(rs.getString("PER_NOMBRE"));
                orde.setPer_apellido(rs.getString("PER_APELLIDO"));
                orde.setOr_fecha(rs.getDate("OR_FECHA"));
                orde.setOr_estado(rs.getString("OR_ESTADO"));                
                orde.setOr_descripcion_ser(rs.getString("OR_DESCRIPCION_SER"));
                orde.setOr_descripcion_maq(rs.getString("OR_DESCRIPCION_MAQ"));
                orde.setOr_descripcion_pro(rs.getString("OR_DESCRIPCION_PRO"));                
                orde.setOr_peso(rs.getDouble("OR_PESO"));
                orde.setOr_precio(rs.getDouble("OR_PRECIO"));
                
                lista.add(orde);
         }
            rs.close();
           
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
     
    }
    
    public boolean deleteOrden(String id) {
        String sql = "DELETE FROM orden where or_codigoorden =" +id;
        return cx.accion(sql);
    }
     
         public List<Orden> listado_por_fecha(String fecha){
     try{   
         ArrayList<Orden>lista=new ArrayList<Orden>();
         
         String sql= "select * from orden where OR_FECHA='"+fecha+"';";
          ResultSet rs = cx.consulta(sql);
          
         while(rs.next())
         {
//             Orden maq =new Orden();
//              maq.setOr_precio(rs.getDouble("or_precio"));
//                maq.setOr_fecha(rs.getString("or_fecha"));
//                maq.setOr_precio(rs.getDouble("or_peso"));
//                maq.setOr_fecha(rs.getString("or_estado"));
//                maq.setOr_precio(rs.getInt("or_codigocli"));
//                maq.setOr_fecha(rs.getString("or_descripcion_maq"));
//                maq.setOr_precio(rs.getInt("or_descripcion_pro"));
//                maq.setOr_fecha(rs.getString("or_descripcion_ser"));
//               
//                lista.add(maq);
             
         }
            rs.close();
            
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,null,ex);
         JOptionPane.showMessageDialog(null, "xxx");  
         return null;
     }
    
    
  
         }    
         
         
         public List<Orden> orden_por_cedula(){
     try{   
         ArrayList<Orden>lista=new ArrayList<Orden>();
         ArrayList<Persona>listaPer=new ArrayList<Persona>();
         ArrayList<Maquina>listaM=new ArrayList<Maquina>();
         ArrayList<Producto>listaPro=new ArrayList<Producto>();
         ArrayList<Servicios>listaSer=new ArrayList<Servicios>();
         
         String sql= "select O.OR_CODIGOORDEN, P.PER_CEDULA, O.OR_FECHA, O.OR_ESTADO, S.SERV_NOMBRE, M.MAQ_TAMAÑO, PR.PRO_NOMBRE,O.OR_PESO FROM ORDEN O, PERSONA P,\n" +
         "SERVICIOS S, MAQUINA M, PRODUCTO PR, CLIENTE C WHERE P.PER_CODIGOPER=C.CLI_CODIGOPER AND O.OR_CODIGOMAQ=M.MAQ_CODIGOMAQ AND O.OR_CODIGOPRO=PR.PRO_CODIGOPRO AND O.OR_CODIGOSER=S.SERV_CODIGOSER";
          ResultSet rs = cx.consulta(sql);
          
         while(rs.next())
         {
            Orden maq =new Orden();
            Persona per= new Persona();
            Servicios serv= new Servicios();
            Maquina maqui=new Maquina();
            Producto pro = new Producto();
                per.setPer_cedula(rs.getString("PER_CEDULA"));
                maq.setOr_fecha(rs.getDate("or_fecha"));
                maq.setOr_estado(rs.getString("or_estado"));
                serv.setServ_servicio(rs.getString("SERV_NOMBRE"));
                maqui.setMaq_tamaño(rs.getString("MAQ_TAMAÑO"));
                pro.setPro_nombre(rs.getString("PRO_NOMBRE"));
                maq.setOr_peso(rs.getDouble("OR_PESO"));
              
                lista.add(maq);
                listaPer.add(per);
                listaM.add(maqui);
                listaPro.add(pro);
                listaSer.add(serv);
             
         }
            rs.close();
          
       return lista;
     }catch(SQLException ex){
         Logger.getLogger(Producto.class.getName()).log(Level.SEVERE,null,ex);
         return null;
     }
    }
   
         public List<Orden> tabla_orden() {
        List<Orden> listaOrden = new ArrayList<Orden>();

        String sql = "select O.OR_CODIGOORDEN, PE.PER_CEDULA,pe.per_nombre, pe.per_apellido, O.OR_FECHA, O.OR_ESTADO,O.OR_DESCRIPCION_SER,O.OR_DESCRIPCION_MAQ,O.OR_DESCRIPCION_PRO, O.OR_PESO, O.OR_PRECIO \n" +
"FROM ORDEN O, PERSONA PE, CLIENTE C \n" +
"WHERE  PE.PER_CODIGOPER=C.CLI_CODIGOPER AND O.OR_CODIGOCLI=C.CLI_CODIGOCLI";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Orden orde=new Orden();
//               
                
                orde.setOr_codigoorden(rs.getInt("OR_CODIGOORDEN"));
                orde.setPer_cedula(rs.getString("PER_CEDULA"));
                orde.setPer_nombre(rs.getString("PER_NOMBRE"));
                orde.setPer_apellido(rs.getString("PER_APELLIDO"));
                orde.setOr_fecha(rs.getDate("OR_FECHA"));
                orde.setOr_estado(rs.getString("OR_ESTADO"));                
                orde.setOr_descripcion_ser(rs.getString("OR_DESCRIPCION_SER"));
                orde.setOr_descripcion_maq(rs.getString("OR_DESCRIPCION_MAQ"));
                orde.setOr_descripcion_pro(rs.getString("OR_DESCRIPCION_PRO"));                
                orde.setOr_peso(rs.getDouble("OR_PESO"));
                orde.setOr_precio(rs.getDouble("OR_PRECIO"));
                
                listaOrden.add(orde);
//              
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaOrden;
//        
    }
         
         public List<Orden> buscarOrden_like(String parametro) {
        List<Orden> listaOrden = new ArrayList<Orden>();
         String parametrox;
         String sql;
           if (parametro.isEmpty()) {
               sql="select O.OR_CODIGOORDEN, PE.PER_CEDULA,pe.per_nombre, pe.per_apellido, O.OR_FECHA, O.OR_ESTADO,O.OR_DESCRIPCION_SER,O.OR_DESCRIPCION_MAQ,O.OR_DESCRIPCION_PRO, O.OR_PESO, O.OR_PRECIO \n" +
"FROM ORDEN O, PERSONA PE, CLIENTE C \n" +
"WHERE  PE.PER_CODIGOPER=C.CLI_CODIGOPER AND O.OR_CODIGOCLI=C.CLI_CODIGOCLI";
           }else{
              
               parametrox=parametro+"%";
           sql = "select O.OR_CODIGOORDEN, PE.PER_CEDULA,pe.per_nombre, pe.per_apellido, O.OR_FECHA, O.OR_ESTADO,O.OR_DESCRIPCION_SER,O.OR_DESCRIPCION_MAQ,O.OR_DESCRIPCION_PRO, O.OR_PESO, O.OR_PRECIO \n" +
"FROM ORDEN O, PERSONA PE, CLIENTE C \n" +
"WHERE PE.PER_CEDULA LIKE '"+parametrox+"' AND PE.PER_CODIGOPER=C.CLI_CODIGOPER AND O.OR_CODIGOCLI=C.CLI_CODIGOCLI";
           
//         sql = "select c.cli_codigocli,p.per_cedula,p.per_nombre,p.per_apellido,c.cli_genero,p.per_telefono from cliente c,persona p where \n" +
//"p.per_apellido like '"+parametrox+"' or p.per_cedula like '"+parametrox+"'and p.per_codigoper=c.cli_codigoper";
           System.out.println(sql);
           }
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Orden orde=new Orden();
//               
                
                orde.setOr_codigoorden(rs.getInt("OR_CODIGOORDEN"));
                orde.setPer_cedula(rs.getString("PER_CEDULA"));
                orde.setPer_nombre(rs.getString("PER_NOMBRE"));
                orde.setPer_apellido(rs.getString("PER_APELLIDO"));
                orde.setOr_fecha(rs.getDate("OR_FECHA"));
                orde.setOr_estado(rs.getString("OR_ESTADO"));                
                orde.setOr_descripcion_ser(rs.getString("OR_DESCRIPCION_SER"));
                orde.setOr_descripcion_maq(rs.getString("OR_DESCRIPCION_MAQ"));
                orde.setOr_descripcion_pro(rs.getString("OR_DESCRIPCION_PRO"));                
                orde.setOr_peso(rs.getDouble("OR_PESO"));
                orde.setOr_precio(rs.getDouble("OR_PRECIO"));
                
                listaOrden.add(orde);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaOrden;
    }
       
    
     //dsdsds
          public List<Orden> tabla_entre_fechas(String fecha_1 , String fecha_2) {
        List<Orden> listaOrden = new ArrayList<Orden>();

        String sql = "select O.OR_CODIGOORDEN, PE.PER_CEDULA,pe.per_nombre, pe.per_apellido, O.OR_FECHA, O.OR_ESTADO,O.OR_DESCRIPCION_SER,O.OR_DESCRIPCION_MAQ,O.OR_DESCRIPCION_PRO, O.OR_PESO, O.OR_PRECIO \n" +
"FROM ORDEN O, PERSONA PE, CLIENTE C\n" +
"WHERE  PE.PER_CODIGOPER=C.CLI_CODIGOPER AND O.OR_CODIGOCLI=C.CLI_CODIGOCLI and or_fecha between '"+fecha_1+"' and '"+fecha_2+"'";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Orden orde=new Orden();
//               
                
                orde.setOr_codigoorden(rs.getInt("OR_CODIGOORDEN"));
                orde.setPer_cedula(rs.getString("PER_CEDULA"));
                orde.setPer_nombre(rs.getString("PER_NOMBRE"));
                orde.setPer_apellido(rs.getString("PER_APELLIDO"));
                orde.setOr_fecha(rs.getDate("OR_FECHA"));
                orde.setOr_estado(rs.getString("OR_ESTADO"));                
                orde.setOr_descripcion_ser(rs.getString("OR_DESCRIPCION_SER"));
                orde.setOr_descripcion_maq(rs.getString("OR_DESCRIPCION_MAQ"));
                orde.setOr_descripcion_pro(rs.getString("OR_DESCRIPCION_PRO"));                
                orde.setOr_peso(rs.getDouble("OR_PESO"));
                orde.setOr_precio(rs.getDouble("OR_PRECIO"));
                
                listaOrden.add(orde);
//              
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaOrden;
//        
    }
         ///sdsdsd
         
         
          
          
          
          
          
          
           public List<Orden> precios_entre_fechas(String fecha_1 , String fecha_2) {
        List<Orden> listaOrden = new ArrayList<Orden>();

        String sql = "select O.OR_PRECIO \n" +
"FROM ORDEN O, PERSONA PE, CLIENTE C\n" +
"WHERE  PE.PER_CODIGOPER=C.CLI_CODIGOPER AND O.OR_CODIGOCLI=C.CLI_CODIGOCLI and or_fecha between '"+fecha_1+"' and '"+fecha_2+"'";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Orden orde=new Orden();
//              
                orde.setOr_precio(rs.getDouble("OR_PRECIO"));
                
                listaOrden.add(orde);
//              
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaOrden;
//        
    }
         
         
}//finalllllllllllllllllllllll


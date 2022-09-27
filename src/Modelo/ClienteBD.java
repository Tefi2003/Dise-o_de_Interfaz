/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tefip
 */
public class ClienteBD extends Cliente{

    public ClienteBD() {
    }

    public ClienteBD(String cli_genero, int cli_codigocli, String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_direccion, String per_correo, int per_codigoper) {
        super(cli_genero, cli_codigocli, per_cedula, per_nombre, per_apellido, per_telefono, per_direccion, per_correo, per_codigoper);
    }
    
    
    Conexion cx = new Conexion();
    
/////////////////////////////////////////////////////////////////////////////////
    
      public boolean insertar_cliente2(int codigo_per) {
        String sql;
        sql = "insert into cliente(cli_codigoper,cli_genero)"
                + "VALUES(" + codigo_per + ""
                + ",'" + getCli_genero() + "')";
        return cx.accion(sql);  //EJECUTAMOS EL INSERT
    }
      
    
      public boolean insertar_cliente1() {
        String sql;
        sql = "INSERT INTO persona (per_cedula,per_nombre,per_apellido,per_telefono,per_direccion,per_correo) "
                + "VALUES('" + getPer_cedula() + "'"
                + ",'" + getPer_nombre() + "'"
                + ",'" + getPer_apellido() + "'"
                + ",'" + getPer_telefono() + "'"
                + ",'" + getPer_direccion() + "'"
                + ",'" + getPer_correo() + "')";
                

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
      
/////////////////////////////////////////////////////////////////////////////////      
      
       public List<Cliente> buscarDatosCliente() {
        List<Cliente> listacliente = new ArrayList<Cliente>();
        
        String sql = "SELECT * FROM CLIENTE";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Cliente per=new Cliente();
                
                per.setCli_genero(rs.getString("CLI_GENERO"));
                listacliente.add(per);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listacliente;
    }
       
/////////////////////////////////////////////////////////////////////////////////           
       
       public List<Cliente> tabla_cliente() {
        List<Cliente> listacliente = new ArrayList<Cliente>();
        
        String sql = "select c.cli_codigocli,p.per_cedula, p.per_nombre,p.per_apellido, c.cli_genero ,p.per_telefono FROM persona p , cliente c where p.per_codigoper=c.cli_codigoper";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Cliente per=new Cliente();
                per.setCli_codigocli(rs.getInt("CLI_CODIGOCLI"));
                per.setPer_cedula(rs.getString("PER_CEDULA"));
                per.setPer_nombre(rs.getString("PER_NOMBRE"));
                per.setPer_apellido(rs.getString("PER_APELLIDO"));
                per.setCli_genero(rs.getString("CLI_GENERO"));
                per.setPer_telefono(rs.getString("PER_TELEFONO"));
                listacliente.add(per);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listacliente;
    }
       
/////////////////////////////////////////////////////////////////////////////////       
       
       public List<Cliente> buscar_para_modificar(String cedula) {
        List<Cliente> listacliente = new ArrayList<Cliente>();
        
        String sql = "select p.per_cedula,p.per_nombre,p.per_apellido,c.cli_genero, p.per_direccion,p.per_telefono,p.per_correo\n" 
                     +"from persona p , cliente c\n"
                     +"where p.per_codigoper=c.cli_codigoper and p.per_cedula='" + cedula + "'";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Cliente pers=new Cliente();
                pers.setPer_nombre(rs.getString("per_nombre"));
                pers.setPer_apellido(rs.getString("per_apellido"));
                pers.setPer_cedula(rs.getString("per_cedula"));
                pers.setCli_genero(rs.getString("cli_genero"));
                pers.setPer_correo(rs.getString("per_correo"));
                pers.setPer_direccion(rs.getString("per_direccion"));
                pers.setPer_telefono(rs.getString("per_telefono"));
                listacliente.add(pers);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listacliente;
    }
       
/////////////////////////////////////////////////////////////////////////////////       
       
     public boolean modificar_cliente1(String clie) {
        String sql;
//        sql = " update cliente set cli_genero='"+getCli_genero()+"'"; 
        sql = " UPDATE cliente set cli_genero='" + getCli_genero() + "' where cli_codigoper=(SELECT p.per_codigoper FROM cliente c, persona p WHERE c.cli_codigoper=p.per_codigoper AND p.per_cedula='"+getPer_cedula()+"')";

                
        System.out.println(sql);         
        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
      
      
      public boolean modificar_cliente2(String cedula) {
        String sql;
        sql = "update persona set per_nombre='" + getPer_nombre() + "'\n"
                + ", per_apellido='" + getPer_apellido() + "'\n"
                + ",per_telefono='" + getPer_telefono() + "'\n"
                + ",per_direccion='" + getPer_direccion() + "'\n"
                + ", per_correo='" + getPer_correo() + "'where per_cedula='" + getPer_cedula() + "'";

        System.out.println(sql);
        return cx.accion(sql);  //EJECUTAMOS EL INSERT
    }  
       
/////////////////////////////////////////////////////////////////////////////////       
      
        public boolean eliminar_cliente(String cod_cli) {
        String sql;
       
        sql="DELETE FROM cliente WHERE cli_codigocli="+cod_cli;  
                                                         
        
            
        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
       
/////////////////////////////////////////////////////////////////////////////////  
        
        public List<Cliente> buscarUsuario_like(String parametro) {
        List<Cliente> listausuarios = new ArrayList<Cliente>();
         String parametrox;
         String sql;
           if (parametro.isEmpty()) {
               sql="select c.cli_codigocli,p.per_cedula, p.per_nombre,p.per_apellido, c.cli_genero ,p.per_telefono FROM persona p , cliente c where p.per_codigoper=c.cli_codigoper";
           }else{
              
               parametrox=parametro+"%";
           
           
         sql = "select c.cli_codigocli,p.per_cedula,p.per_nombre,p.per_apellido,c.cli_genero,p.per_telefono from cliente c,persona p where \n" +
"p.per_apellido like '"+parametrox+"' or p.per_cedula like '"+parametrox+"'and p.per_codigoper=c.cli_codigoper";
           System.out.println(sql);
           }
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Cliente pers=new Cliente();
                 pers.setPer_cedula(rs.getString("PER_CEDULA"));
                pers.setPer_nombre(rs.getString("PER_NOMBRE"));
                pers.setPer_apellido(rs.getString("PER_APELLIDO"));
                pers.setCli_genero(rs.getString("CLI_GENERO"));
                pers.setPer_telefono(rs.getString("PER_TELEFONO"));
                pers.setCli_codigocli(rs.getInt("CLI_CODIGOCLI"));
                listausuarios.add(pers);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listausuarios;
    }
       
       //fin prueba metodo
          public List<Cliente> obtener_codigocliente(String cedula) {
        List<Cliente> listacliente = new ArrayList<Cliente>();
        
        String sql = "select c.cli_codigocli  from cliente c , persona p where p.per_cedula='"+cedula+"' and p.per_codigoper= c.cli_codigoper";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Cliente pers=new Cliente();
                pers.setCli_codigocli(rs.getInt("CLI_CODIGOCLI"));
               
                listacliente.add(pers);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listacliente;
    }
        
        
        
/////////////////////////////////////////////////////////////////////////////////  
}

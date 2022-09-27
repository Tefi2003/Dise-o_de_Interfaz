/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class UsuarioBD extends Usuario{

    public UsuarioBD() {
    }

    public UsuarioBD(String rol, String clave, String usuario, int us_codigous) {
        super(rol, clave, usuario, us_codigous);
    }

    public UsuarioBD(String rol, String clave, String usuario, int us_codigous, String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_direccion, String per_correo, int per_codigoper) {
        super(rol, clave, usuario, us_codigous, per_cedula, per_nombre, per_apellido, per_telefono, per_direccion, per_correo, per_codigoper);
    }

    
    
        Conexion cx = new Conexion();

      public boolean insertar_usuario2(int codigo_per) {
        String sql;
        sql = "insert into usuario(us_codigoper,us_rol,us_usuario,us_clave)"
                + "VALUES(" + codigo_per + ""
                + ",'" + getRol() + "'"
                + ",'" + getUsuario() + "'"
                + ",'" + getClave() + "')";
                

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
    
      
        public boolean eliminar_usuario(String user) {
        String sql;
        sql = "delete from usuario where us_usuario='"+user+"'";
                

        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
      
      
      
      
      public boolean insertar_usuario1() {
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
      
      
      public boolean modificar_usuario1(String user) {
        String sql;
        sql = " update usuario set us_rol='"+getRol()+"'\n" +
"                , us_clave='"+getClave()+"'\n" +
", us_usuario='"+getUsuario()+"' where us_usuario='"+user+"'" ;

                
          System.out.println(sql);         
        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
      public boolean modificar_usuario2(String cedula) {
        String sql;
        sql = "update persona set per_nombre='"+getPer_nombre()+"'\n" +
", per_apellido='"+getPer_apellido()+"'\n" +
",per_telefono='"+getPer_telefono()+"'\n" +
",per_direccion='"+getPer_direccion()+"'\n" +
", per_correo='"+getPer_correo()+"'where per_cedula='"+getPer_cedula()+"'";
                
          System.out.println(sql);         
        return cx.accion(sql);  //EJECUTAMOS EL INSERT
        
    }
      
      
      
       public List<Usuario> buscarDatosUsuarios() {
        List<Usuario> listausuarios = new ArrayList<Usuario>();
        
        String sql = "SELECT * FROM USUARIO";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Usuario pers=new Usuario();
                
                pers.setUsuario(rs.getString("US_USUARIO"));
                pers.setRol(rs.getString("US_ROL"));
                pers.setClave(rs.getString("US_CLAVE"));
                listausuarios.add(pers);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listausuarios;
    }
       
       
       
       //prueba metodo
       
       public List<Usuario> buscarUsuario_like(String parametro) {
        List<Usuario> listausuarios = new ArrayList<Usuario>();
         String parametrox;
         String sql;
           if (parametro.isEmpty()) {
               sql="select p.per_cedula,u.us_usuario,p.per_nombre,u.us_rol from persona p , usuario u where p.per_codigoper=u.us_codigoper";
           }else{
              
               parametrox=parametro+"%";
           
           
         sql = "select p.per_cedula,u.us_usuario,p.per_nombre,u.us_rol from usuario u,persona p where \n" +
"p.per_apellido like '"+parametrox+"' or p.per_cedula like '"+parametrox+"'and p.per_codigoper=u.us_codigoper";
           System.out.println(sql);
           }
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Usuario pers=new Usuario();
                
                pers.setPer_cedula(rs.getString("PER_CEDULA"));
                pers.setUsuario(rs.getString("US_USUARIO"));
                pers.setPer_nombre(rs.getString("PER_NOMBRE"));
                pers.setRol(rs.getString("US_ROL"));
                listausuarios.add(pers);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listausuarios;
    }
       
       //fin prueba metodo
       
       
       
       public List<Usuario> buscar_para_modificar(String user,String cedula) {
        List<Usuario> listausuarios = new ArrayList<Usuario>();
        
        String sql = "select p.per_cedula,u.us_usuario,p.per_nombre,p.per_apellido,u.us_clave,p.per_direccion,p.per_telefono\n" +
",p.per_correo,u.us_rol from persona p , usuario u where p.per_codigoper=u.us_codigoper and u.us_usuario='"+user+"' \n" +
"and p.per_cedula='"+cedula+"'";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Usuario pers=new Usuario();
                pers.setPer_nombre(rs.getString("per_nombre"));
                pers.setPer_apellido(rs.getString("per_apellido"));
                pers.setPer_cedula(rs.getString("per_cedula"));
                pers.setPer_correo(rs.getString("per_correo"));
                pers.setPer_direccion(rs.getString("per_direccion"));
                pers.setPer_telefono(rs.getString("per_telefono"));
                pers.setUsuario(rs.getString("US_USUARIO"));
                pers.setRol(rs.getString("US_ROL"));
                pers.setClave(rs.getString("US_CLAVE"));
                listausuarios.add(pers);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listausuarios;
    }
       
       
       
       
       public List<Usuario> tabla_usuarios() {
        List<Usuario> listausuarios = new ArrayList<Usuario>();
        
        String sql = "select p.per_cedula,u.us_usuario,p.per_nombre,u.us_rol from persona p , usuario u where p.per_codigoper=u.us_codigoper";
        
        ResultSet rs = cx.consulta(sql);
        try {
            while (rs.next()) {
                Usuario pers=new Usuario();
                pers.setPer_cedula(rs.getString("PER_CEDULA"));
                pers.setUsuario(rs.getString("US_USUARIO"));
                pers.setPer_nombre(rs.getString("PER_NOMBRE"));
                pers.setRol(rs.getString("US_ROL"));
                listausuarios.add(pers);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return listausuarios;
    }
       
}

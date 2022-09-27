/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ClienteBD;
import Modelo.Conexion;
import Modelo.MaquinaBD;
import Modelo.OrdenBD;
import Modelo.ProductoBD;
import Modelo.ServiciosBD;
import Modelo.Usuario;
import Modelo.UsuarioBD;
import Vista.LVerificacion;
import Vista.Login;
import Vista.Pantalla_Empleado;
import Vista.Pantalla_Gerente;
import Vista.RGerente;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Controller_login {
    private Login vista;
    private UsuarioBD modelo;

    public Controller_login(Login vista, UsuarioBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        iniciarcontrol();
    }
    
    public void iniciarcontrol(){
            vista.getBtnIniciar().addActionListener(l->login_control());
            vista.getBtnRegistrarse().addActionListener(l->registrarse());
            
    }
    
    public void registrarse(){
        
        LVerificacion lv=new LVerificacion();
        new Controller_LVerificacion(lv);
        
        
        
    }
    public void login_control(){
        Conexion cd=new Conexion();
        
        
        String usuario=vista.getTxtusuario().getText();
                String clave=vista.getTxtclave().getText();
                
              if ("".equals(usuario) || clave=="") {
                  JOptionPane.showMessageDialog(vista, "CAMPOS VACIOS");
        }else{
                  int x=0;
                   List<Usuario> lista_usuarios=modelo.buscarDatosUsuarios();
                   for (int i = 0; i < lista_usuarios.size(); i++) {
                       if (lista_usuarios.get(i).getUsuario().equals(usuario)&&lista_usuarios.get(i).getClave().equals(clave)) {
                           JOptionPane.showMessageDialog(vista, "SE ENCONTRO USUARIO , BIENVENIDO");
                           if (lista_usuarios.get(i).getRol().equals("Administrador")) {
                               x=1;
                               
                           }else{
                               x=2;
                               
                           }
                         
                           break;
                       }
                  }
                   if (x==1) {
                      vista.setVisible(false);
                      Pantalla_Gerente pg=new Pantalla_Gerente();
                      
                      new Controller_Admin(pg);
                      pg.setVisible(true);
                  }
                   if (x==2) {
                      vista.setVisible(false);
                      Pantalla_Empleado pe=new Pantalla_Empleado();
                      ServiciosBD servi =new ServiciosBD();
                      ClienteBD cliente=new ClienteBD();
                      MaquinaBD maquina=new MaquinaBD();
                      ProductoBD producto=new ProductoBD();
                      OrdenBD orden=new OrdenBD();
                      new Controller_Pantalla_Empleado(pe,servi,cliente,maquina,producto,orden);
                      pe.setVisible(true);
   
                  }if(x==0){
                       JOptionPane.showMessageDialog(vista, "USUARIO O CLAVE INCORRECTOS --- NO SE HAN ENCONTRADO DATOS");
                       vista.getTxtusuario().setText("");
                       vista.getTxtclave().setText("");
                   }
              }
              
  
    }
}

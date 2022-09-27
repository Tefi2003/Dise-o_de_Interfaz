/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.ClienteBD;
import Modelo.MaquinaBD;
import Modelo.OrdenBD;
import Modelo.Persona;
import Modelo.PersonaBD;
import Modelo.ProductoBD;
import Modelo.ServiciosBD;
import Modelo.UsuarioBD;
import Vista.Login;
import Vista.Pantalla_Gerente;
import Vista.RCliente;
import Vista.REmpleados;
import Vista.RGerente;
import Vista.RMaquina;
import Vista.RProducto;
import Vista.RServicios;
import Vista.VReportes;

/**
 *
 * @author User
 */
public class Controller_Admin {
    private Pantalla_Gerente vista;

    public Controller_Admin(Pantalla_Gerente vista) {
        this.vista = vista;
        this.vista.setVisible(true);
        iniciarcontrol();
    }

    
     public void iniciarcontrol(){
        ;
        vista.getBtnEmpleaods().addActionListener(l->abrir_empleados());
        vista.getBtnClientes().addActionListener(l->abrir_clientes());
        vista.getBtnMaquinas().addActionListener(l->abrir_maquinas());
        vista.getBtnProductos().addActionListener(l->abrir_productos());
        vista.getBtnReportes().addActionListener(l->abrir_reportes());
        vista.getBtnServicios().addActionListener(l->abrir_servicios());
        vista.getBtnCerrarSesion().addActionListener(l->salir());
    }
     
     public void salir(){
         vista.setVisible(false);
         Login lg=new Login();
         new Controller_login(lg,user);
         lg.setVisible(true);
     }
     UsuarioBD user=new UsuarioBD();
     PersonaBD people=new PersonaBD();
     ClienteBD clien=new ClienteBD();
     MaquinaBD maqbd=new MaquinaBD();
     ProductoBD produc=new ProductoBD();
     OrdenBD order=new OrdenBD();
     ServiciosBD services=new ServiciosBD();
     public void abrir_empleados(){
         REmpleados rp=new REmpleados();
         new Controller_REmpleados(rp,user);
         rp.setVisible(true);
     }
    public void abrir_clientes(){
         RCliente rc=new RCliente();
         new Controller_RCliente(rc,clien);
         rc.setVisible(true);
     }
    public void abrir_maquinas(){
        RMaquina rmaq=new RMaquina();
        new Controller_RMaquina(rmaq,maqbd);
        rmaq.setVisible(true);
     }
    public void abrir_productos(){
         RProducto rproc=new RProducto();
         new Controller_RProducto(rproc,produc);
         rproc.setVisible(true);
     }
    public void abrir_reportes(){
         VReportes repor=new VReportes();
         new Controller_VReportes(repor,order);
         repor.setVisible(true);
     }
    public void abrir_servicios(){
        RServicios servi=new RServicios();
        new Controller_RServicios(servi,services);
        servi.setVisible(true);
     }
    
    
    
}

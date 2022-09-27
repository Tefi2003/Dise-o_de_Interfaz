/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import EJECUTABLE.ManagerFactory;
import Vista.Reportes_Individuales;
import java.util.HashMap;
import Modelo.Conexion;
import javax.swing.WindowConstants;
/**
 *
 * @author tefip
 */
public class Controller_Reportes_Individules {
    
    private Reportes_Individuales vista;
    ManagerFactory manage;

    public Controller_Reportes_Individules(Reportes_Individuales vista, ManagerFactory manage) {
        this.vista = vista;
        this.manage = manage;
        iniciarcontrol();
    }

    
     public void iniciarcontrol(){
        vista.getBtnCerrarSesion1().addActionListener(l->salir());
        vista.getBtnProductos1().addActionListener(l->reporteProd());
        vista.getBtnServicios1().addActionListener(l->reporteServ());
        vista.getBtnMaquinas1().addActionListener(l->reporteMaq());
        vista.getBtnClientes1().addActionListener(l->reporteCli());
        vista.getBtnEmpleaods1().addActionListener(l->reporteUsu());
        vista.getBtnReportes1().addActionListener(l->reporteOrd());
    }
     
     
    public void salir(){
        vista.setVisible(false);
    }
    //
    
//    public void reporteProductos() {
//        JasperReport reportepro; //CREO EL OBJETO REPORTE
//        String path = "C:\\Users\\tefip\\Documents\\NetBeansProjects\\kkkk\\PV_Lavanderia\\src\\reportes";
//        try{
//            reportepro = (JasperReport) JRLoader.loadObjectFromFile(path); //CARGO EL REPORTE AL OBJETO
//            JasperPrint jprint = JasperFillManager.fillReport(path, null, con)
//                    JasperViewer viewer = new JasperViewer (jprint,false);
//                    viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        }
//    }
    
    public void reporteProd() {
        Resouces.imprimirReeporte(ManagerFactory.getConnection(manage.getEntityManagerFactory().createEntityManager()), "/reportes/Producto.jasper", new HashMap());
    }
    
    
    public void reporteServ() {
        Resouces.imprimirReeporte(ManagerFactory.getConnection(manage.getEntityManagerFactory().createEntityManager()), "/reportes/Servicio.jasper", new HashMap());
    }
    
    
    public void reporteMaq() {
        Resouces.imprimirReeporte(ManagerFactory.getConnection(manage.getEntityManagerFactory().createEntityManager()), "/reportes/Maquina.jasper", new HashMap());
    }
    
    
    public void reporteCli() {
        Resouces.imprimirReeporte(ManagerFactory.getConnection(manage.getEntityManagerFactory().createEntityManager()), "/reportes/Cliente.jasper", new HashMap());
    }
    
    
    public void reporteUsu() {
        Resouces.imprimirReeporte(ManagerFactory.getConnection(manage.getEntityManagerFactory().createEntityManager()), "/reportes/Usuario.jasper", new HashMap());
    }
    
    
    public void reporteOrd() {
        Resouces.imprimirReeporte(ManagerFactory.getConnection(manage.getEntityManagerFactory().createEntityManager()), "/reportes/Orden.jasper", new HashMap());
    }
    

}

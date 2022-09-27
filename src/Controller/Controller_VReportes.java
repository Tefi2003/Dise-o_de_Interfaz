/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import EJECUTABLE.ManagerFactory;
import Modelo.OrdenBD;
import Vista.Reporte_orden_dia;
import Vista.VReportes;
import Vista.Reportes_Individuales;

/**
 *
 * @author User
 */
public class Controller_VReportes {
      private VReportes vista;
    private OrdenBD modelo;

    public Controller_VReportes(VReportes vista, OrdenBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
        iniciarcontrol();
    }

    
    public void iniciarcontrol(){
        vista.getBtnAtras().addActionListener(l->salir());
        vista.getBtnOrdenTrabajo().addActionListener(l->ordenes_de_trabajo());
        vista.getBtnReporteMaterial().addActionListener(l->reportes());
    }
    
     public void salir(){
       vista.setVisible(false);
       
   } 
     
     public void ordenes_de_trabajo(){
     Reporte_orden_dia rod=new Reporte_orden_dia();
     OrdenBD obd=new OrdenBD();
     new Controller_Reporte_orden_dia(rod,obd);
     
         rod.setVisible(true);
         
     }
     
     
     public void reportes(){
     Reportes_Individuales rod=new Reportes_Individuales();
     ManagerFactory manage=new ManagerFactory();
     new Controller_Reportes_Individules(rod, manage);
         rod.setVisible(true);
         
     }
    
}

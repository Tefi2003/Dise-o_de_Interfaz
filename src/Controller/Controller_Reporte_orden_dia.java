/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Orden;
import Modelo.OrdenBD;
import Vista.Reporte_orden_dia;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Controller_Reporte_orden_dia {
    private Reporte_orden_dia vista ;
    private OrdenBD  modelo ;

    public Controller_Reporte_orden_dia(Reporte_orden_dia vista, OrdenBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setVisible(true);
        iniciarcontrol();
        carga_tabla();
    }
    
    public void iniciarcontrol(){
        vista.getBtnsalir().addActionListener(l->salir());
        vista.getBtnBuscar().addActionListener(l->buscar_orden_mediantefecha());
    }
    public void salir(){
        vista.setVisible(false);
    }
    
    public void buscar_orden_mediantefecha(){
        if (vista.getJfecha().getDate()==null||vista.getJfecha2().getDate()==null) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar las fechas antes de generar una busqueda");
        }else{
            //fecha11111111111111111111111111111111111111111111111111111111
             
            
            
              int año,mes,dia;
              año=vista.getJfecha().getCalendar().get(Calendar.YEAR);
              mes=vista.getJfecha().getCalendar().get(Calendar.MONTH)+1;
              if (mes>12) {
                  año=año+1;
                  mes=1;
                  dia=1;
              } dia=vista.getJfecha().getCalendar().get(Calendar.DAY_OF_MONTH);
              String fecha=dia+"/"+mes+"/"+año;
              System.out.println("fecha: "+fecha);
              //fecha22222222222222222222222222222222222222222222222222222222
               
              int año2,mes2,dia2;
              año2=vista.getJfecha2().getCalendar().get(Calendar.YEAR);
              mes2=vista.getJfecha2().getCalendar().get(Calendar.MONTH)+1;
              if (mes2>12) {
                  año2=año2+1;
                  mes2=1;
                  dia2=1;
              } dia2=vista.getJfecha2().getCalendar().get(Calendar.DAY_OF_MONTH);
              String fecha2=dia2+"/"+mes2+"/"+año2;
              System.out.println("fecha: "+fecha2);
              //////////////////////////////////////////////////////////
              tabla_busqueda(fecha, fecha2);
              
              //calculo de los precios
              Double precio_a_mostrar=0.0;
              List<Orden> listaprecios=modelo.precios_entre_fechas(fecha, fecha2);
              for (int i = 0; i < listaprecios.size(); i++) {
              precio_a_mostrar=precio_a_mostrar+listaprecios.get(i).getOr_precio();
            }
              
              vista.getLbltotal_dia().setText(precio_a_mostrar.toString());
        }
    
    }
    
    public void carga_tabla(){
        //empieza tabla
         List<Orden> todos_orden=modelo.tabla_orden();
        
         String matriz[][]=new String[todos_orden.size()][11];
         for (int i = 0; i < todos_orden.size(); i++) {
             Double precios = todos_orden.get(i).getOr_precio();
            String preci = precios.toString();
            
             Double peso = todos_orden.get(i).getOr_peso();
            String or_peso = peso.toString();
            
            Date fecha= todos_orden.get(i).getOr_fecha();
            String fechas=fecha.toString();
            
            int cod_cli=todos_orden.get(i).getOr_codigoorden();
            String cod_orden=String.valueOf(cod_cli);

            matriz[i][0]=cod_orden;
            matriz[i][1]=todos_orden.get(i).getPer_cedula();
            matriz[i][2]=todos_orden.get(i).getPer_nombre();
            matriz[i][3]=todos_orden.get(i).getPer_apellido();
            matriz[i][4]=fechas;
            matriz[i][5]=todos_orden.get(i).getOr_estado();
            matriz[i][6]=todos_orden.get(i).getOr_descripcion_ser();
            matriz[i][7]=todos_orden.get(i).getOr_descripcion_maq();
            matriz[i][8]=todos_orden.get(i).getOr_descripcion_pro();
            matriz[i][9]=or_peso;
            matriz[i][10]=preci;
        }
        
        vista.getTblordenes().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Nr Orden", "Cedula","Nombre", "Apellido", "Fecha", "Estado", "Servicios", "Maquinas", "Productos", "Peso", "Total"
            
    }
));   
    }
    
      public void tabla_busqueda(String fecha_1,String fecha_2) {
        //empieza tabla
        List<Orden> todos_orden = modelo.tabla_entre_fechas(fecha_1,fecha_2);

        String matriz[][] = new String[todos_orden.size()][11];
        for (int i = 0; i < todos_orden.size(); i++) {
            
            Double precios = todos_orden.get(i).getOr_precio();
            String preci = precios.toString();
            
             Double peso = todos_orden.get(i).getOr_peso();
            String or_peso = peso.toString();
            
            Date fecha= todos_orden.get(i).getOr_fecha();
            String fechass=fecha.toString();
            
            int cod_cli=todos_orden.get(i).getOr_codigoorden();
            String cod_ord=String.valueOf(cod_cli);
            
            matriz[i][0]=cod_ord;
            matriz[i][1]=todos_orden.get(i).getPer_cedula();
            matriz[i][2]=todos_orden.get(i).getPer_nombre();
            matriz[i][3]=todos_orden.get(i).getPer_apellido();
            matriz[i][4]=fechass;
            matriz[i][5]=todos_orden.get(i).getOr_estado();
            matriz[i][6]=todos_orden.get(i).getOr_descripcion_ser();
            matriz[i][7]=todos_orden.get(i).getOr_descripcion_maq();
            matriz[i][8]=todos_orden.get(i).getOr_descripcion_pro();
            matriz[i][9]=or_peso;
            matriz[i][10]=preci;
//            int cod_cli=todos_orden.get(i).getCli_codigocli();
//            String cod_clif=String.valueOf(cod_cli);
//            matriz[i][5]=cod_clif;
            
        }

        vista.getTblordenes().setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Nr Orden", "Cedula","Nombre", "Apellido", "Fecha", "Estado", "Servicios", "Maquinas", "Productos", "Peso", "Total"
                }
        ));
    }
    
}//finalllllllllllllllllllllllllllll

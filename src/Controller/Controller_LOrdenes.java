/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Orden;
import Modelo.OrdenBD;
import Vista.Listado_ordenes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author pc
 */
public class Controller_LOrdenes {
    private Listado_ordenes vista;
    private OrdenBD modelo;
    ListSelectionModel listaordenmodel;
    public Controller_LOrdenes(Listado_ordenes vista, OrdenBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        carga_tabla();
        iniciarcontrol();
    }
    public void iniciarcontrol(){
        pruebakey_cliente();
        
            vista.getBtnEntregar().addActionListener(l->modificar());
            vista.getBtnVerPendientes().addActionListener(l->ver_Pendientes());
            vista.getBtnVerTodo().addActionListener(l->ver_todo());
            vista.getBtnsalir().addActionListener(l->salir());
            vista.getBtnEliminar().addActionListener(l->eliminar());
            
            
            /////////////////////////////////////////////////////////////////
//            vista.getTblordenes().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//    listaordenmodel=this.vista.getTblordenes().getSelectionModel();
//    listaordenmodel.addListSelectionListener(new ListSelectionListener() {
//        @Override
//        public void valueChanged(ListSelectionEvent e) {
//            if (!e.getValueIsAdjusting()) {
//                personaSeleccionada();
//            }
//        }
//    });

    }
    public void salir(){
        vista.setVisible(false);
    }
    
    public void total_ordenes(){
        Listado_ordenes rg=new Listado_ordenes();
        
//        new Controller_RGerente(rg,modelo);
        rg.setVisible(true);
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
    //fin tabla
     public void ver_Pendientes(){
        //empieza tabla
         List<Orden> todos_orden=modelo.ver_pendientes();
        
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
    
     
     public void tabla_busqueda(String parametro) {
        //empieza tabla
        List<Orden> todos_orden = modelo.buscarOrden_like(parametro);

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
    
        //busca servicios
     public void pruebakey_cliente(){
      
    
           
      
    KeyListener escuchateclado =new KeyListener() {
         
        @Override
        public void keyTyped(KeyEvent e) {
            
             
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
          
        }

        @Override
        public void keyReleased(KeyEvent e) {
             
                 
            
            String x= vista.getTxtcedula().getText();
            System.out.println(x);
              //aqui se  coloca la tabla de la busqueda
              tabla_busqueda(x);
               
        }

       
    };
    
    vista.getTxtcedula().addKeyListener(escuchateclado);
  
    }
     public void modificar(){
        if (vista.getTblordenes().getSelectedRow()>=0) {
             
            
            String user_modificado=vista.getTblordenes().getValueAt(vista.getTblordenes().getSelectedRow(), 0).toString();
            if (modelo.actualizar_estado(user_modificado)) {
              JOptionPane.showMessageDialog(vista, "ORDEN MODIFICADA");
              carga_tabla();
//               
               
            }else{
                JOptionPane.showMessageDialog(vista, "HA OCURRIDO UN ERROR AL MODIFICAR LA ORDEN");
                
            }
         }else{
            JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN ELEMENTO PARA MODIFICAR LA ORDEN");
        }
    }
     
     public void eliminar(){
        if (vista.getTblordenes().getSelectedRow()>=0) {
             
            
            String user_eliminado=vista.getTblordenes().getValueAt(vista.getTblordenes().getSelectedRow(), 0).toString();
            if (modelo.deleteOrden(user_eliminado)) {
              JOptionPane.showMessageDialog(vista, "ORDEN ELIMINADA");
              carga_tabla();
//               
               
            }else{
                JOptionPane.showMessageDialog(vista, "HA OCURRIDO UN ERROR AL ELIMINAR LA ORDEN");
                
            }
         }else{
            JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN ELEMENTO PARA ELIMINAR LA ORDEN");
        }
    }
     public void ver_todo(){
         carga_tabla();
    }
     
//     public void personaSeleccionada(){
//    if (this.vista.getTblordenes().getSelectedRow()!=-1) {
////        String u_seleccionado=vista.getTblrempleado().getValueAt(vista.getTblrempleado().getSelectedRow(), 1).toString();
//        String c_seleccionado=vista.getTblordenes().getValueAt(vista.getTblordenes().getSelectedRow(), 0).toString();
//       //ir poniendo lo de la busqueda en los txt
//        List<Orden> lista_user_seleccionado=modelo.Ver(c_seleccionado);
//         vista.getjTextAreaServicio().setText(lista_user_seleccionado.get(0).getOr_descripcion_ser().toString());
//         vista.getjTextAreaMaquina().setText(lista_user_seleccionado.get(0).getOr_descripcion_maq().toString());
//         vista.getjTextAreaProducto().setText(lista_user_seleccionado.get(0).getOr_descripcion_pro().toString());
//         
//    }
//     
//    }
      
}

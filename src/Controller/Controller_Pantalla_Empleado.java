/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Cliente;
import Modelo.ClienteBD;
import Modelo.Maquina;
import Modelo.MaquinaBD;
import Modelo.OrdenBD;
import Modelo.Producto;
import Modelo.ProductoBD;
import Modelo.Servicios;
import Modelo.ServiciosBD;
import Modelo.UsuarioBD;
import Vista.Listado_ordenes;
import Vista.Login;
import Vista.Pantalla_Empleado;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Controller_Pantalla_Empleado {
    private Pantalla_Empleado vista;
    private ServiciosBD modelo_servicio;
    private ClienteBD modelo_cliente;
    private MaquinaBD modelo_maquina;
    private ProductoBD modelo_producto;
    private OrdenBD modelo_orden;
    Double PRECIO_TOTAL=0.0;
     List<Double> lista_servicios = new ArrayList<Double>();
     List<Double> lista_productos = new ArrayList<Double>();
     List<Double> lista_maquinas = new ArrayList<Double>();

    public Controller_Pantalla_Empleado(Pantalla_Empleado vista, ServiciosBD modelo_servicio, ClienteBD modelo_cliente, MaquinaBD modelo_maquina, ProductoBD modelo_producto, OrdenBD modelo_orden) {
        this.vista = vista;
        this.modelo_servicio = modelo_servicio;
        this.modelo_cliente = modelo_cliente;
        this.modelo_maquina = modelo_maquina;
        this.modelo_producto = modelo_producto;
        this.modelo_orden = modelo_orden;
        this.vista.setVisible(true);
        carga_tabla_servicios();
        carga_tabla_maquina();
        carga_tabla_cliente();
        carga_tabla_producto();
        iniciarcontrol();
    }

    

   

    

    
    
    public void iniciarcontrol(){
        vista.getBtnTotalOrdenes().addActionListener(l->ver_ordenes());
        vista.getArea_productos().setEditable(false);
        vista.getBtnGuardarOrden().addActionListener(l->guardar_orden());
        vista.getArea_servicios().setEditable(false);
        //serviciosss inicio
        pruebakey_servicios();
        pruebakey_cliente();
        pruebakey_producto();
        vista.getBtnCerrarSesion().addActionListener(l->salir());
        vista.getBtnaceptar_servicio().addActionListener(l->aceptar_servicio());
        vista.getBtnlimpiar_servicio().addActionListener(l->limpiar_servicio());
        vista.getBtncancelar_servicio().addActionListener(l->cancelar_servicio());
        //servicios final
        //cliente inicio
        vista.getLimpiar_cliente().addActionListener(l->limpiar_cliente());
        vista.getBtnAceptar_cliente().addActionListener(l->aceptar_cliente());
        vista.getBtncancelar_cliente().addActionListener(l->cancelar_cliente());
        //cliente final
        //maquina inicio
        vista.getBtncancelar_maquina().addActionListener(l->cancelar_maquina());
        vista.getAceptar_maquina().addActionListener(l->aceptar_maquina());
        //maquina final
        //producto inicio
        vista.getBtnaceptar_producto().addActionListener(l->aceptar_producto());
        vista.getBtncancelar_producto().addActionListener(l->cancelar_producto());
        //producto final
    }
   
    public void ver_ordenes(){
        Listado_ordenes lo=new Listado_ordenes();
        OrdenBD orbd=new OrdenBD();
        new Controller_LOrdenes(lo,orbd);
        lo.setVisible(true);
    }
     public void salir(){
         vista.setVisible(false);
         UsuarioBD user =new UsuarioBD();
         Login lg=new Login();
         new Controller_login(lg,user);
         lg.setVisible(true);
     }
    
    public void guardar_orden(){
      if (vista.getTxtcedula_detalle().equals("")||vista.getArea_servicios().equals("")||vista.getJfecha().getDate()==null||
              vista.getTxtpeso_detalle().equals("")||vista.getTxtmediana().getText().equals("0")&&vista.getTxtpequeña().getText().equals("0")&&vista.getTxtgrande().getText().equals("0")) {
          JOptionPane.showMessageDialog(null, "Falta ingreso de datos para generar orden");
     }else{
          
              Date fecha_f=null;
              int x=2;
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
              //dsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
              String servicios=vista.getArea_servicios().getText();
              String maquinas=("G : "+vista.getTxtgrande().getText()+"--- M : "+vista.getTxtmediana().getText()+"--- P : "+vista.getTxtpequeña().getText());
              String productos=vista.getArea_productos().getText();
              String psx=vista.getTxtpeso_detalle().getText();
              Double peso=Double.parseDouble(psx);
              String cedula=vista.getTxtcedula_detalle().getText();
              String totx=vista.getTxtTOTAL_ORDEN().getText().replaceAll("\\,", ".");
              
              
              
              Double precio_total=Double.parseDouble(totx);
              List<Cliente> lista_codcliente=modelo_cliente.obtener_codigocliente(cedula);
              int cod_cliente=lista_codcliente.get(0).getCli_codigocli();
              SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
              try {
               fecha_f=formato.parse(fecha);
              } catch (ParseException ex) {
              Logger.getLogger(Controller_Pantalla_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("algo malo linea 146");
          }
              
             
              modelo_orden.setOr_precio(precio_total);
             
              modelo_orden.setOr_peso(peso);
              modelo_orden.setOr_estado("PENDIENTE");
              modelo_orden.setOr_descripcion_maq(maquinas);
              modelo_orden.setOr_descripcion_pro(productos);
              modelo_orden.setOr_descripcion_ser(servicios);
               modelo_orden.setOr_codigocli(cod_cliente);
              //aqui falta setear la orden
              if (modelo_orden.setOrden(fecha)) {
              JOptionPane.showMessageDialog(vista, "ORDEN GENERADA");
              }else{
                  JOptionPane.showMessageDialog(vista, "UPS ALGO SUCEDIO Y SU ORDEN NO SE GUARDO CORRECTAMENTE");
              }
          
        }
    }
     
     
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS
     //INICIA//INICIA//INICIA//INICIA//INICIA//INICIA//INICIA//INICIA//INICIA//INICIA//INICIA//INICIA//INICIA//INICIA
     public void limpiar_servicio(){
         vista.getTxtservicio().setText("");
     }
     public void cancelar_servicio(){
         vista.getArea_servicios().setText("");
         double precio_servicios=0;
          String totalt=vista.getTxtTOTAL_ORDEN().getText().replaceAll("\\,", ".");
          
          
          
           double totald=Double.valueOf(totalt);
           
         for (int i = 0; i < lista_servicios.size(); i++) {
             precio_servicios=precio_servicios+lista_servicios.get(i).doubleValue();
         }
         System.out.println(""+precio_servicios);
        PRECIO_TOTAL=PRECIO_TOTAL-precio_servicios;
        
         totald=totald-precio_servicios;
         
         String xxx=String.format("%.2f", totald);
         
         
         vista.getTxtTOTAL_ORDEN().setText(xxx);
         lista_servicios.clear();
     }
     public void aceptar_servicio(){
         if (vista.getTblservicios().getSelectedRow()<0) {
             JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN SERVICIO PRIMERO");
         }else{
             String dato_guardado=vista.getArea_servicios().getText();
             String name_servicio=vista.getTblservicios().getValueAt(vista.getTblservicios().getSelectedRow(), 1).toString();
             vista.getArea_servicios().setText(dato_guardado+name_servicio+"\n");
             //////////////////
             String precio_pro=vista.getTblservicios().getValueAt(vista.getTblservicios().getSelectedRow(), 2).toString();
             
             double precio_array=Double.parseDouble(precio_pro);
             lista_servicios.add(precio_array);
             
             PRECIO_TOTAL=Double.parseDouble(precio_pro)+PRECIO_TOTAL;
             String imprimir=String.format("%.2f",PRECIO_TOTAL);
             vista.getTxtTOTAL_ORDEN().setText(imprimir);
             
            
                     
         }
            
     }
      
    public void carga_tabla_servicios(){
        //empieza tabla
         List<Servicios> todos_usuarios=modelo_servicio.getServicios();
        
         String matriz[][]=new String[todos_usuarios.size()][3];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             
             String precio=todos_usuarios.get(i).getServ_precio().toString();
            matriz[i][0]=todos_usuarios.get(i).getServ_codigo();
            matriz[i][1]=todos_usuarios.get(i).getServ_servicio();
            matriz[i][2]=precio;
        }
        
        vista.getTblservicios().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Codigo", "Servicio", "Precio"
    }
));
    }
     
     public void tabla_busqueda_servicios(String nombre){
        //empieza tabla
         List<Servicios> todos_usuarios=modelo_servicio.servicio_like(nombre);
        
         String matriz[][]=new String[todos_usuarios.size()][3];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             
             String precio=todos_usuarios.get(i).getServ_precio().toString();
            matriz[i][0]=todos_usuarios.get(i).getServ_codigo();
            matriz[i][1]=todos_usuarios.get(i).getServ_servicio();
            matriz[i][2]=precio;
        }
        
        vista.getTblservicios().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Codigo", "Servicio", "Precio"
    }
));
    }
     //busca servicios
     public void pruebakey_servicios(){
      
    
           
      
    KeyListener escuchateclado =new KeyListener() {
         
        @Override
        public void keyTyped(KeyEvent e) {
            
             
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
          
        }

        @Override
        public void keyReleased(KeyEvent e) {
             
                 
            
            String x= vista.getTxtservicio().getText();
            System.out.println(x);
              //aqui se  coloca la tabla de la busqueda
              tabla_busqueda_servicios(x);
               
        }

       
    };
    
    vista.getTxtservicio().addKeyListener(escuchateclado);
  
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS//SERVICIOS
     //FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL//FINAL
     
     //NOTHING
     
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO
     //CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO//CLIENTE INICIO
     public void limpiar_cliente(){
         vista.getTxtcliente().setText("");
     }
     public void cancelar_cliente(){
         vista.getTxtcliente_detalle().setText("");
         vista.getTxtcedula_detalle().setText("");
     }
     public void carga_tabla_cliente(){
        //empieza tabla
         List<Cliente> todos_cliente=modelo_cliente.tabla_cliente();
        
         String matriz[][]=new String[todos_cliente.size()][6];
         for (int i = 0; i < todos_cliente.size(); i++) {
            matriz[i][0]=todos_cliente.get(i).getPer_cedula();
            matriz[i][1]=todos_cliente.get(i).getPer_nombre();
            matriz[i][2]=todos_cliente.get(i).getPer_apellido();
            matriz[i][3]=todos_cliente.get(i).getCli_genero();
            matriz[i][4]=todos_cliente.get(i).getPer_telefono();
            int cod_cli=todos_cliente.get(i).getCli_codigocli();
            String cod_clif=String.valueOf(cod_cli);
            matriz[i][5]=cod_clif;
        }
        
        vista.getTabla_clientes().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Cédula", "Nombre", "Apellido", "Genero","Telefono","Codigo_cliente"
    }
));
    }
     public void tabla_busqueda(String parametro) {
        //empieza tabla
        List<Cliente> todos_usuarios = modelo_cliente.buscarUsuario_like(parametro);

        String matriz[][] = new String[todos_usuarios.size()][6];
        for (int i = 0; i < todos_usuarios.size(); i++) {
            matriz[i][0] = todos_usuarios.get(i).getPer_cedula();
            matriz[i][1] = todos_usuarios.get(i).getPer_nombre();
            matriz[i][2]=todos_usuarios.get(i).getPer_apellido();
            matriz[i][3] = todos_usuarios.get(i).getCli_genero();
            matriz[i][4]=todos_usuarios.get(i).getPer_telefono();
            int cod_cli=todos_usuarios.get(i).getCli_codigocli();
            String cod_clif=String.valueOf(cod_cli);
            matriz[i][5]=cod_clif;
            
        }

        vista.getTabla_clientes().setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Cédula", "Nombre", "Apellido", "Genero","Telefono","Codigo_cliente"
                }
        ));
    }
public void pruebakey_cliente() {

        KeyListener escuchateclado = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                String x = vista.getTxtcliente().getText();
                System.out.println(x);
                //aqui se  coloca la tabla de la busqueda
                tabla_busqueda(x);

            }

        };

        vista.getTxtcliente().addKeyListener(escuchateclado);

    }
    
    public void aceptar_cliente(){
        if (vista.getTabla_clientes().getSelectedRow()<0) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar un cliente antes de aceptar");
        }else{
        String cedula,apellido,nombre;
        cedula=vista.getTabla_clientes().getValueAt(vista.getTabla_clientes().getSelectedRow(), 0).toString();
        nombre=vista.getTabla_clientes().getValueAt(vista.getTabla_clientes().getSelectedRow(), 1).toString();
        apellido=vista.getTabla_clientes().getValueAt(vista.getTabla_clientes().getSelectedRow(), 2).toString();
        vista.getTxtcedula_detalle().setText(cedula);
        vista.getTxtcliente_detalle().setText(nombre+" "+apellido);
                }
    }
   
      
     
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL
     //CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL//CLIENTE FINAL
     
     //NOTHING
     
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //MAQUINAS INICIO////MAQUINAS INICIO////MAQUINAS INICIO////MAQUINAS INICIO////MAQUINAS INICIO////MAQUINAS INICIO//
    //MAQUINAS INICIO////MAQUINAS INICIO////MAQUINAS INICIO////MAQUINAS INICIO////MAQUINAS INICIO////MAQUINAS INICIO//
      public void cancelar_maquina(){
          vista.getTxtpequeña().setText("0");
          vista.getTxtmediana().setText("0");
          vista.getTxtgrande().setText("0");
          
          //dsasdasdasd
          double precio_maquinas=0;
          String totalt=vista.getTxtTOTAL_ORDEN().getText().replaceAll("\\,", ".");
          
          
          
           double totald=Double.valueOf(totalt);
           
         for (int i = 0; i < lista_maquinas.size(); i++) {
             precio_maquinas=precio_maquinas+lista_maquinas.get(i).doubleValue();
         }
        PRECIO_TOTAL=PRECIO_TOTAL-precio_maquinas;
        
         totald=totald-precio_maquinas;
         
         String xxx=String.format("%.2f", totald);
         
         
         vista.getTxtTOTAL_ORDEN().setText(xxx);
         lista_maquinas.clear();
          //sasdasdasda
          
      }
      public void carga_tabla_maquina(){
        //empieza tabla
         List<Maquina> todos_usuarios=modelo_maquina.todas_maquinas();
        
         String matriz[][]=new String[todos_usuarios.size()][3];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             int codigo=todos_usuarios.get(i).getMaq_codigo();
             String codigo_tabla=String.valueOf(codigo);
            String precio=todos_usuarios.get(i).getMaq_precio().toString();
            matriz[i][0]=codigo_tabla;
            matriz[i][1]=todos_usuarios.get(i).getMaq_tamaño();
            matriz[i][2]=precio;
        }
        
        vista.getTblmaquina().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        "Codigo", "Tamaño", "Precio"
    }
));
    }
      
      public void aceptar_maquina(){
          if (vista.getTblmaquina().getSelectedRow()<0) {
             JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UNA MAQUINA PRIMERO PRIMERO");
         }else{
              String pequeña,mediana,grande;
              pequeña=vista.getTxtpequeña().getText();
              mediana=vista.getTxtmediana().getText();
              grande=vista.getTxtgrande().getText();
              
              int pequeñac,medianac,grandec;
              pequeñac=Integer.parseInt(pequeña);
              medianac=Integer.parseInt(mediana);
              grandec=Integer.parseInt(grande);
              
              String tamaño=vista.getTblmaquina().getValueAt(vista.getTblmaquina().getSelectedRow(), 1).toString();
              
              switch(tamaño){
                  case"Pequeña":
                      pequeñac=pequeñac+1;
                      break;
                      case"Mediana":
                      medianac=medianac+1;    
                      break;
                      case"Grande":
                      grandec=grandec+1;    
                      break;
              }
              
              String pequeñaf,medianaf,grandef;
              pequeñaf=String.valueOf(pequeñac);
              medianaf=String.valueOf(medianac);
              grandef=String.valueOf(grandec);
              vista.getTxtpequeña().setText(pequeñaf);
                      vista.getTxtmediana().setText(medianaf);
                              vista.getTxtgrande().setText(grandef);
                              
                              
                              //////
                              String precio =vista.getTblmaquina().getValueAt(vista.getTblmaquina().getSelectedRow(),2).toString();
                              PRECIO_TOTAL=Double.parseDouble(precio)+PRECIO_TOTAL;
                              lista_maquinas.add(Double.parseDouble(precio));
                              String imprimir=String.format("%.2f", PRECIO_TOTAL);
                              vista.getTxtTOTAL_ORDEN().setText(imprimir);
          }
      }
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL
     //MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL//MAQUINA FINAL
     
      //nothing
      
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
      //PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO
      //PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO//PRODUCTO INICIO
      
      public void carga_tabla_producto(){
        //empieza tabla
         List<Producto> todos_usuarios=modelo_producto.getProducto();
        
         String matriz[][]=new String[todos_usuarios.size()][4];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             
             String precio=todos_usuarios.get(i).getPro_precio().toString();
            matriz[i][0]=todos_usuarios.get(i).getPro_codigo();
            matriz[i][1]=todos_usuarios.get(i).getPro_nombre();
            matriz[i][2]=precio;
            matriz[i][3]=todos_usuarios.get(i).getPro_marca();
        }
        
        vista.getTblproducto().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Codigo", "Nombre", "Precio", "Marca"
    }
));
    }
      
      
      
       public void pruebakey_producto() {

        KeyListener escuchateclado = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                String x = vista.getTxt_producto().getText();
                System.out.println(x);
                //aqui se  coloca la tabla de la busqueda
                tabla_busqueda_producto(x);
                

            }
        };
        vista.getTxt_producto().addKeyListener(escuchateclado);
    }
       public void tabla_busqueda_producto(String nombre){
        //empieza tabla
         List<Producto> todos_usuarios=modelo_producto.servicio_like(nombre);
        
         String matriz[][]=new String[todos_usuarios.size()][4];
         for (int i = 0; i < todos_usuarios.size(); i++) {
             
             String precio=todos_usuarios.get(i).getPro_precio().toString();
            matriz[i][0]=todos_usuarios.get(i).getPro_codigo();
            matriz[i][1]=todos_usuarios.get(i).getPro_nombre();
            matriz[i][2]=precio;
            matriz[i][3]=todos_usuarios.get(i).getPro_marca();
        }
        
        vista.getTblproducto().setModel(new javax.swing.table.DefaultTableModel(
        matriz,
    new String [] {
        
        
        "Codigo", "Nombre", "Precio", "Marca"
    }
));
    }
       
       public void aceptar_producto(){
          if (vista.getTblproducto().getSelectedRow()<0) {
             JOptionPane.showMessageDialog(vista, "DEBE SELECCIONAR UN SERVICIO PRIMERO");
         }else{
             String dato_guardado=vista.getArea_productos().getText();
             String name_producto=vista.getTblproducto().getValueAt(vista.getTblproducto().getSelectedRow(), 1).toString();
             vista.getArea_productos().setText(dato_guardado+name_producto+"\n");
             //////////////////
             String precio_pro=vista.getTblproducto().getValueAt(vista.getTblproducto().getSelectedRow(), 2).toString();
             
             double precio_array=Double.parseDouble(precio_pro);
             lista_productos.add(precio_array);
             
             PRECIO_TOTAL=Double.parseDouble(precio_pro)+PRECIO_TOTAL;
             String imprimir=String.format("%.2f",PRECIO_TOTAL);
             vista.getTxtTOTAL_ORDEN().setText(imprimir);
             
            
                     
         }   
       }
       public void cancelar_producto(){
        vista.getArea_productos().setText("");
         double precio_productos=0;
          String totalt=vista.getTxtTOTAL_ORDEN().getText().replaceAll("\\,", ".");
          
          
          
           double totald=Double.valueOf(totalt);
           
         for (int i = 0; i < lista_productos.size(); i++) {
             precio_productos=precio_productos+lista_productos.get(i).doubleValue();
         }
         System.out.println(""+precio_productos);
        PRECIO_TOTAL=PRECIO_TOTAL-precio_productos;
        
         totald=totald-precio_productos;
         
         String xxx=String.format("%.2f", totald);
         
         
         vista.getTxtTOTAL_ORDEN().setText(xxx);
         lista_productos.clear();    
       }
       //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL
      // PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL// PRODUCTO FINAL
}//final codigo

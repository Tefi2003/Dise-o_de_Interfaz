/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.TextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author tefip
 */
public class Pantalla_Empleado extends javax.swing.JFrame {

    /**
     * Creates new form Pantalla_Empleado
     */
    public Pantalla_Empleado() {
        initComponents();
    }

    public JButton getBtncancelar_cliente() {
        return btncancelar_cliente;
    }

    public void setBtncancelar_cliente(JButton btncancelar_cliente) {
        this.btncancelar_cliente = btncancelar_cliente;
    }

    public JTextField getTxtcedula_detalle() {
        return txtcedula_detalle;
    }

    public void setTxtcedula_detalle(JTextField txtcedula_detalle) {
        this.txtcedula_detalle = txtcedula_detalle;
    }

    public JTextField getTxtcliente_detalle() {
        return txtcliente_detalle;
    }

    public void setTxtcliente_detalle(JTextField txtcliente_detalle) {
        this.txtcliente_detalle = txtcliente_detalle;
    }

    public JButton getBtnAceptar_cliente() {
        return Aceptar_cliente;
    }

    public TextArea getArea_prueba() {
        return area_servicios;
    }

    public void setArea_prueba(TextArea area_prueba) {
        this.area_servicios = area_prueba;
    }

    public JTextField getTxtpeso_detalle() {
        return txtpeso_detalle;
    }

    public void setTxtpeso_detalle(JTextField txtpeso_detalle) {
        this.txtpeso_detalle = txtpeso_detalle;
    }
    
    public void setBtnAceptar_cliente(JButton btnAceptar_cliente) {
        this.Aceptar_cliente = btnAceptar_cliente;
    }

    public JButton getBtncancelar_maquina() {
        return btncancelar_maquina;
    }

    public JDateChooser getJfecha() {
        return jfecha;
    }

    public void setJfecha(JDateChooser jfecha) {
        this.jfecha = jfecha;
    }

    public void setBtncancelar_maquina(JButton btncancelar_maquina) {
        this.btncancelar_maquina = btncancelar_maquina;
    }

    public JTextField getTxtbuscar_cliente() {
        return txtcliente;
    }

    public void setTxtbuscar_cliente(JTextField txtbuscar_cliente) {
        this.txtcliente = txtbuscar_cliente;
    }

    
    
    public JButton getBtnAgregarCliente() {
        return btnAgregarCliente;
    }

    public void setBtnAgregarCliente(JButton btnAgregarCliente) {
        this.btnAgregarCliente = btnAgregarCliente;
    }

    public JButton getBtnAgregarOrden() {
        return btnAgregarOrden;
    }

    public void setBtnAgregarOrden(JButton btnAgregarOrden) {
        this.btnAgregarOrden = btnAgregarOrden;
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public void setBtnCerrarSesion(JButton btnCerrarSesion) {
        this.btnCerrarSesion = btnCerrarSesion;
    }

  
    public JButton getBtnGuardarOrden() {
        return btnGuardarOrden;
    }

    public void setBtnGuardarOrden(JButton btnGuardarOrden) {
        this.btnGuardarOrden = btnGuardarOrden;
    }

    

    public JButton getBtnOrdenes() {
        return btnOrdenes;
    }

    public void setBtnOrdenes(JButton btnOrdenes) {
        this.btnOrdenes = btnOrdenes;
    }

    public JButton getAceptar_cliente() {
        return Aceptar_cliente;
    }

    public void setAceptar_cliente(JButton Aceptar_cliente) {
        this.Aceptar_cliente = Aceptar_cliente;
    }

    public JButton getLimpiar_cliente() {
        return limpiar_cliente;
    }

    public void setLimpiar_cliente(JButton limpiar_cliente) {
        this.limpiar_cliente = limpiar_cliente;
    }

    public JButton getRegistro_cliente() {
        return registro_cliente;
    }

    public void setRegistro_cliente(JButton registro_cliente) {
        this.registro_cliente = registro_cliente;
    }

    public JTable getTabla_clientes() {
        return tabla_clientes;
    }

    public void setTabla_clientes(JTable tabla_clientes) {
        this.tabla_clientes = tabla_clientes;
    }

    public JTextField getTxtcliente() {
        return txtcliente;
    }

    public JButton getBtnaceptar_producto() {
        return btnaceptar_producto;
    }

    public void setBtnaceptar_producto(JButton btnaceptar_producto) {
        this.btnaceptar_producto = btnaceptar_producto;
    }

    public JButton getBtncancelar_producto() {
        return btncancelar_producto;
    }

    public void setBtncancelar_producto(JButton btncancelar_producto) {
        this.btncancelar_producto = btncancelar_producto;
    }

    public void setTxtcliente(JTextField txtcliente) {
        this.txtcliente = txtcliente;
    }

    public JTable getTblproducto() {
        return tblproducto;
    }

    public void setTblproducto(JTable tblproducto) {
        this.tblproducto = tblproducto;
    }

    public JTextField getTxt_producto() {
        return txt_producto;
    }

    public void setTxt_producto(JTextField txt_producto) {
        this.txt_producto = txt_producto;
    }

   

    public JButton getBtnTotalOrdenes() {
        return btnTotalOrdenes;
    }

    public void setBtnTotalOrdenes(JButton btnTotalOrdenes) {
        this.btnTotalOrdenes = btnTotalOrdenes;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlprincipal = new javax.swing.JPanel();
        pnlizquierdo = new javax.swing.JPanel();
        lblcodigo = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        xxx = new javax.swing.JLabel();
        fdg = new javax.swing.JLabel();
        lblapellido = new javax.swing.JLabel();
        lblcedula = new javax.swing.JLabel();
        foto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnTotalOrdenes = new javax.swing.JButton();
        pnlsecundario = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        pnlsuperior = new javax.swing.JPanel();
        lbltitulo = new javax.swing.JLabel();
        pnlmedio = new javax.swing.JPanel();
        lblcpanelc = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnAgregarCliente = new javax.swing.JButton();
        btnAgregarOrden = new javax.swing.JButton();
        btnOrdenes = new javax.swing.JButton();
        pnldetalledeorden = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        btnGuardarOrden = new javax.swing.JButton();
        area_servicios = new java.awt.TextArea();
        area_productos = new java.awt.TextArea();
        txtpeso_detalle = new javax.swing.JTextField();
        txtcedula_detalle = new javax.swing.JTextField();
        txtcliente_detalle = new javax.swing.JTextField();
        txtTOTAL_ORDEN = new javax.swing.JTextField();
        txtgrande = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtmediana = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtpequeña = new javax.swing.JTextField();
        jfecha = new com.toedter.calendar.JDateChooser();
        menu_cambiante = new javax.swing.JTabbedPane();
        panel_cliente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        lblnombre_cliente1 = new javax.swing.JLabel();
        lblcedula_cliente1 = new javax.swing.JLabel();
        lbltitulo1 = new javax.swing.JLabel();
        Aceptar_cliente = new javax.swing.JButton();
        limpiar_cliente = new javax.swing.JButton();
        registro_cliente = new javax.swing.JButton();
        btncancelar_cliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btncancelar_servicio = new javax.swing.JButton();
        lblcodigo1 = new javax.swing.JLabel();
        lblBCliente = new javax.swing.JLabel();
        txtservicio = new javax.swing.JTextField();
        btnlimpiar_servicio = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblservicios = new javax.swing.JTable();
        btnaceptar_servicio = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblcodigo2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblmaquina = new javax.swing.JTable();
        lblBCliente1 = new javax.swing.JLabel();
        aceptar_maquina = new javax.swing.JButton();
        btncancelar_maquina = new javax.swing.JButton();
        btnSiguiente1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        txt_producto = new javax.swing.JTextField();
        btncancelar_producto = new javax.swing.JButton();
        btnaceptar_producto = new javax.swing.JButton();
        lblcodigo3 = new javax.swing.JLabel();
        lblBCliente3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblproducto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlprincipal.setBackground(new java.awt.Color(240, 247, 250));
        pnlprincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlprincipal.setMinimumSize(new java.awt.Dimension(1000, 600));
        pnlprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlizquierdo.setBackground(new java.awt.Color(0, 147, 185));
        pnlizquierdo.setPreferredSize(new java.awt.Dimension(260, 460));

        lblcodigo.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        lblcodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblcodigo.setText("Cédula:");

        lblnombre.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(255, 255, 255));
        lblnombre.setText(".");

        xxx.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        xxx.setForeground(new java.awt.Color(255, 255, 255));
        xxx.setText("Nombre:");

        fdg.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        fdg.setForeground(new java.awt.Color(255, 255, 255));
        fdg.setText("Apellido:");

        lblapellido.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        lblapellido.setForeground(new java.awt.Color(255, 255, 255));
        lblapellido.setText(".");

        lblcedula.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        lblcedula.setForeground(new java.awt.Color(255, 255, 255));
        lblcedula.setText(".");

        foto.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        foto.setForeground(new java.awt.Color(255, 255, 255));
        foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        foto.setText("ICON");

        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Empleado");

        btnTotalOrdenes.setBackground(new java.awt.Color(44, 202, 251));
        btnTotalOrdenes.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnTotalOrdenes.setForeground(new java.awt.Color(255, 255, 255));
        btnTotalOrdenes.setText("TOTAL ORDENES");
        btnTotalOrdenes.setBorder(null);

        javax.swing.GroupLayout pnlizquierdoLayout = new javax.swing.GroupLayout(pnlizquierdo);
        pnlizquierdo.setLayout(pnlizquierdoLayout);
        pnlizquierdoLayout.setHorizontalGroup(
            pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlizquierdoLayout.createSequentialGroup()
                .addGroup(pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlizquierdoLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlizquierdoLayout.createSequentialGroup()
                                .addComponent(fdg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblapellido))
                            .addGroup(pnlizquierdoLayout.createSequentialGroup()
                                .addGroup(pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblcodigo)
                                    .addComponent(xxx))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblcedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(pnlizquierdoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTotalOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlizquierdoLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlizquierdoLayout.setVerticalGroup(
            pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlizquierdoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(foto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo)
                    .addComponent(lblcedula))
                .addGap(18, 18, 18)
                .addGroup(pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xxx)
                    .addComponent(lblnombre))
                .addGap(18, 18, 18)
                .addGroup(pnlizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fdg)
                    .addComponent(lblapellido))
                .addGap(56, 56, 56)
                .addComponent(btnTotalOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlprincipal.add(pnlizquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 530));

        pnlsecundario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        jLabel11.setText("Agregar detalles de la orden");
        pnlsecundario.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        pnlprincipal.add(pnlsecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 800, 40));

        pnlsuperior.setBackground(new java.awt.Color(0, 147, 185));

        lbltitulo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        lbltitulo.setForeground(new java.awt.Color(255, 255, 255));
        lbltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltitulo.setText("LAVANDERÍA");

        javax.swing.GroupLayout pnlsuperiorLayout = new javax.swing.GroupLayout(pnlsuperior);
        pnlsuperior.setLayout(pnlsuperiorLayout);
        pnlsuperiorLayout.setHorizontalGroup(
            pnlsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlsuperiorLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbltitulo)
                .addContainerGap(837, Short.MAX_VALUE))
        );
        pnlsuperiorLayout.setVerticalGroup(
            pnlsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbltitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        pnlprincipal.add(pnlsuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 60));

        pnlmedio.setBackground(new java.awt.Color(255, 255, 255));

        lblcpanelc.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 13)); // NOI18N
        lblcpanelc.setForeground(new java.awt.Color(51, 51, 51));
        lblcpanelc.setText("Panel de navegación");

        btnCerrarSesion.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 13)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(102, 102, 102));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setActionCommand("btnCerrarSesión");
        btnCerrarSesion.setBorder(null);

        javax.swing.GroupLayout pnlmedioLayout = new javax.swing.GroupLayout(pnlmedio);
        pnlmedio.setLayout(pnlmedioLayout);
        pnlmedioLayout.setHorizontalGroup(
            pnlmedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmedioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblcpanelc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 732, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlmedioLayout.setVerticalGroup(
            pnlmedioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmedioLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(lblcpanelc))
            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlprincipal.add(pnlmedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1010, 50));

        btnAgregarCliente.setBackground(new java.awt.Color(44, 202, 251));
        btnAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCliente.setText("Agregar Cliente");
        btnAgregarCliente.setBorder(null);
        pnlprincipal.add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 90, 30));

        btnAgregarOrden.setBackground(new java.awt.Color(44, 202, 251));
        btnAgregarOrden.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarOrden.setText("Agregar Orden");
        btnAgregarOrden.setBorder(null);
        pnlprincipal.add(btnAgregarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 650, 90, 30));

        btnOrdenes.setBackground(new java.awt.Color(44, 202, 251));
        btnOrdenes.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenes.setText("Ordenes");
        btnOrdenes.setBorder(null);
        pnlprincipal.add(btnOrdenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 90, 30));

        pnldetalledeorden.setBackground(new java.awt.Color(255, 255, 255));
        pnldetalledeorden.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Cliente:");
        pnldetalledeorden.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 118, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Cédula:");
        pnldetalledeorden.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 78, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Servicios:");
        pnldetalledeorden.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 158, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Máquinas:");
        pnldetalledeorden.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 343, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Peso:");
        pnldetalledeorden.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Productos:");
        pnldetalledeorden.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Fecha:");
        pnldetalledeorden.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        lblRegistrar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 22)); // NOI18N
        lblRegistrar.setForeground(new java.awt.Color(0, 51, 102));
        lblRegistrar.setText("Detalles de la Orden");
        pnldetalledeorden.add(lblRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 20, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 51, 102));
        pnldetalledeorden.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 56, 262, 10));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("TOTAL:$");
        pnldetalledeorden.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 636, -1, -1));

        btnGuardarOrden.setBackground(new java.awt.Color(76, 226, 114));
        btnGuardarOrden.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnGuardarOrden.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarOrden.setText("Guardar Orden");
        btnGuardarOrden.setActionCommand("btnGuardarOrden");
        btnGuardarOrden.setBorder(null);
        pnldetalledeorden.add(btnGuardarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 631, 110, 33));
        pnldetalledeorden.add(area_servicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 158, 222, 105));
        pnldetalledeorden.add(area_productos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 238, 111));

        txtpeso_detalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpeso_detalleActionPerformed(evt);
            }
        });
        pnldetalledeorden.add(txtpeso_detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 160, -1));
        pnldetalledeorden.add(txtcedula_detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 78, 143, -1));
        pnldetalledeorden.add(txtcliente_detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 118, 143, -1));

        txtTOTAL_ORDEN.setText("0.0");
        txtTOTAL_ORDEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTOTAL_ORDENActionPerformed(evt);
            }
        });
        pnldetalledeorden.add(txtTOTAL_ORDEN, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 636, 51, -1));

        txtgrande.setText("0");
        pnldetalledeorden.add(txtgrande, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 60, -1));

        jLabel16.setText("G:");
        pnldetalledeorden.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        jLabel17.setText("M:");
        pnldetalledeorden.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        txtmediana.setText("0");
        txtmediana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmedianaActionPerformed(evt);
            }
        });
        pnldetalledeorden.add(txtmediana, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 60, -1));

        jLabel18.setText("P:");
        pnldetalledeorden.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, -1, -1));

        txtpequeña.setText("0");
        pnldetalledeorden.add(txtpequeña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 60, -1));
        pnldetalledeorden.add(jfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 160, -1));

        pnlprincipal.add(pnldetalledeorden, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 370, 720));

        menu_cambiante.setBackground(new java.awt.Color(255, 255, 255));

        tabla_clientes.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N
        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Teléfono"
            }
        ));
        tabla_clientes.setRowHeight(25);
        tabla_clientes.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tabla_clientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_clientes);

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        jLabel14.setText("Buscar  un cliente");

        txtcliente.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N

        lblnombre_cliente1.setText(".");

        lblcedula_cliente1.setText(".");

        lbltitulo1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbltitulo1.setForeground(new java.awt.Color(51, 51, 51));
        lbltitulo1.setText("Seleccione un cliente para la orden");

        Aceptar_cliente.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        Aceptar_cliente.setForeground(new java.awt.Color(102, 102, 102));
        Aceptar_cliente.setText("Aceptar");
        Aceptar_cliente.setBorder(null);

        limpiar_cliente.setBackground(new java.awt.Color(0, 147, 185));
        limpiar_cliente.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        limpiar_cliente.setForeground(new java.awt.Color(255, 255, 255));
        limpiar_cliente.setText("LIMPIAR");
        limpiar_cliente.setBorder(null);

        registro_cliente.setBackground(new java.awt.Color(0, 147, 185));
        registro_cliente.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        registro_cliente.setForeground(new java.awt.Color(255, 255, 255));
        registro_cliente.setText("Registrar");
        registro_cliente.setBorder(null);

        btncancelar_cliente.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btncancelar_cliente.setForeground(new java.awt.Color(102, 102, 102));
        btncancelar_cliente.setText("CANCELAR");
        btncancelar_cliente.setBorder(null);

        javax.swing.GroupLayout panel_clienteLayout = new javax.swing.GroupLayout(panel_cliente);
        panel_cliente.setLayout(panel_clienteLayout);
        panel_clienteLayout.setHorizontalGroup(
            panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_clienteLayout.createSequentialGroup()
                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_clienteLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lbltitulo1))
                    .addGroup(panel_clienteLayout.createSequentialGroup()
                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panel_clienteLayout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblcedula_cliente1)
                                    .addComponent(lblnombre_cliente1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(62, 62, 62)
                                .addComponent(limpiar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(registro_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_clienteLayout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(panel_clienteLayout.createSequentialGroup()
                                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Aceptar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(panel_clienteLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btncancelar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        panel_clienteLayout.setVerticalGroup(
            panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_clienteLayout.createSequentialGroup()
                .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_clienteLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbltitulo1)
                        .addGap(25, 25, 25)
                        .addComponent(lblnombre_cliente1)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblcedula_cliente1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_clienteLayout.createSequentialGroup()
                        .addContainerGap(91, Short.MAX_VALUE)
                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(limpiar_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registro_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addGroup(panel_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Aceptar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                        .addGap(31, 31, 31)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        menu_cambiante.addTab("CLIENTE", panel_cliente);

        btncancelar_servicio.setBackground(new java.awt.Color(0, 147, 185));
        btncancelar_servicio.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btncancelar_servicio.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar_servicio.setText("Cancelar");
        btncancelar_servicio.setBorder(null);

        lblcodigo1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 13)); // NOI18N
        lblcodigo1.setText("Nombre del servicio:");

        lblBCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lblBCliente.setText("Registrar servicio: ");

        txtservicio.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 13)); // NOI18N

        btnlimpiar_servicio.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnlimpiar_servicio.setForeground(new java.awt.Color(102, 102, 102));
        btnlimpiar_servicio.setText("LIMPIAR");
        btnlimpiar_servicio.setBorder(null);
        btnlimpiar_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiar_servicioActionPerformed(evt);
            }
        });

        tblservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Servicio", "Precio"
            }
        ));
        tblservicios.setRowHeight(25);
        tblservicios.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblservicios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblservicios);

        btnaceptar_servicio.setBackground(new java.awt.Color(0, 147, 185));
        btnaceptar_servicio.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnaceptar_servicio.setForeground(new java.awt.Color(255, 255, 255));
        btnaceptar_servicio.setText("Aceptar");
        btnaceptar_servicio.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBCliente)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(lblcodigo1)
                            .addGap(18, 18, 18)
                            .addComponent(txtservicio, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnlimpiar_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(188, 188, 188)
                            .addComponent(btncancelar_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnaceptar_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(200, 200, 200)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblBCliente)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtservicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcodigo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncancelar_servicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnaceptar_servicio, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        menu_cambiante.addTab("SERVICIOS", jPanel2);

        lblcodigo2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 13)); // NOI18N
        lblcodigo2.setForeground(new java.awt.Color(51, 51, 51));
        lblcodigo2.setText("Ingrese tamaño:");

        tblmaquina.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        tblmaquina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Tamaño", "Precio"
            }
        ));
        tblmaquina.setRowHeight(25);
        tblmaquina.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblmaquina);

        lblBCliente1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lblBCliente1.setForeground(new java.awt.Color(51, 51, 51));
        lblBCliente1.setText("Registrar máquina");

        aceptar_maquina.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        aceptar_maquina.setForeground(new java.awt.Color(102, 102, 102));
        aceptar_maquina.setText("Aceptar");
        aceptar_maquina.setBorder(null);

        btncancelar_maquina.setBackground(new java.awt.Color(0, 147, 185));
        btncancelar_maquina.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btncancelar_maquina.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar_maquina.setText("Cancelar");
        btncancelar_maquina.setBorder(null);

        btnSiguiente1.setBackground(new java.awt.Color(0, 147, 185));
        btnSiguiente1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnSiguiente1.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente1.setText("Siguiente");
        btnSiguiente1.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btncancelar_maquina, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lblcodigo2)
                                    .addGap(18, 18, 18)
                                    .addComponent(aceptar_maquina, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBCliente1)))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBCliente1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo2)
                    .addComponent(aceptar_maquina, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSiguiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar_maquina, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        menu_cambiante.addTab("MAQUINA", jPanel3);

        txt_producto.setFont(new java.awt.Font("Microsoft YaHei", 0, 13)); // NOI18N

        btncancelar_producto.setBackground(new java.awt.Color(0, 147, 185));
        btncancelar_producto.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btncancelar_producto.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar_producto.setText("Cancelar");
        btncancelar_producto.setBorder(null);

        btnaceptar_producto.setBackground(new java.awt.Color(0, 147, 185));
        btnaceptar_producto.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        btnaceptar_producto.setForeground(new java.awt.Color(255, 255, 255));
        btnaceptar_producto.setText("Aceptar");
        btnaceptar_producto.setBorder(null);

        lblcodigo3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 13)); // NOI18N
        lblcodigo3.setText("Nombre del producto:");

        lblBCliente3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lblBCliente3.setText("Registrar producto");

        tblproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Producto", "Precio"
            }
        ));
        tblproducto.setRowHeight(25);
        tblproducto.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tblproducto.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblproducto);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(lblcodigo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btncancelar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnaceptar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblBCliente3)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBCliente3)
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcodigo3)
                    .addComponent(txt_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnaceptar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        menu_cambiante.addTab("PRODUCTOS", jPanel5);

        pnlprincipal.add(menu_cambiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 800, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpeso_detalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpeso_detalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpeso_detalleActionPerformed

    private void txtmedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmedianaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmedianaActionPerformed

    private void btnlimpiar_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiar_servicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlimpiar_servicioActionPerformed

    private void txtTOTAL_ORDENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTOTAL_ORDENActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTOTAL_ORDENActionPerformed

    public JButton getAceptar_maquina() {
        return aceptar_maquina;
    }

    public void setAceptar_maquina(JButton aceptar_maquina) {
        this.aceptar_maquina = aceptar_maquina;
    }

    public  JTextField getTxtservicio() {
        return txtservicio;
    }

    public JTextField getTxtTOTAL_ORDEN() {
        return txtTOTAL_ORDEN;
    }

    public void setTxtTOTAL_ORDEN(JTextField txtTOTAL_ORDEN) {
        this.txtTOTAL_ORDEN = txtTOTAL_ORDEN;
    }

    public JTextField getTxtgrande() {
        return txtgrande;
    }

    public void setTxtgrande(JTextField txtgrande) {
        this.txtgrande = txtgrande;
    }

    public JTextField getTxtmediana() {
        return txtmediana;
    }

    public void setTxtmediana(JTextField txtmediana) {
        this.txtmediana = txtmediana;
    }

    public JTextField getTxtpequeña() {
        return txtpequeña;
    }

    public void setTxtpequeña(JTextField txtpequeña) {
        this.txtpequeña = txtpequeña;
    }

 
    public TextArea getArea_productos() {
        return area_productos;
    }

    public void setArea_productos(TextArea area_productos) {
        this.area_productos = area_productos;
    }

    public TextArea getArea_servicios() {
        return area_servicios;
    }

    public void setArea_servicios(TextArea area_servicios) {
        this.area_servicios = area_servicios;
    }

    public JButton getBtnaceptar_servicio() {
        return btnaceptar_servicio;
    }

    public void setBtnaceptar_servicio(JButton btnaceptar_servicio) {
        this.btnaceptar_servicio = btnaceptar_servicio;
    }

    public JButton getBtncancelar_servicio() {
        return btncancelar_servicio;
    }

    public void setBtncancelar_servicio(JButton btncancelar_servicio) {
        this.btncancelar_servicio = btncancelar_servicio;
    }

    public JButton getBtnlimpiar_servicio() {
        return btnlimpiar_servicio;
    }

    public void setBtnlimpiar_servicio(JButton btnlimpiar_servicio) {
        this.btnlimpiar_servicio = btnlimpiar_servicio;
    }

    public JTable getTblmaquina() {
        return tblmaquina;
    }

    public void setTblmaquina(JTable tblmaquina) {
        this.tblmaquina = tblmaquina;
    }

   

    
    public JTable getTblservicios() {
        return tblservicios;
    }

    public void setTblservicios(JTable tblservicios) {
        this.tblservicios = tblservicios;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar_cliente;
    private javax.swing.JButton aceptar_maquina;
    private java.awt.TextArea area_productos;
    private java.awt.TextArea area_servicios;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnAgregarOrden;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnGuardarOrden;
    private javax.swing.JButton btnOrdenes;
    private javax.swing.JButton btnSiguiente1;
    private javax.swing.JButton btnTotalOrdenes;
    private javax.swing.JButton btnaceptar_producto;
    private javax.swing.JButton btnaceptar_servicio;
    private javax.swing.JButton btncancelar_cliente;
    private javax.swing.JButton btncancelar_maquina;
    private javax.swing.JButton btncancelar_producto;
    private javax.swing.JButton btncancelar_servicio;
    private javax.swing.JButton btnlimpiar_servicio;
    private javax.swing.JLabel fdg;
    private javax.swing.JLabel foto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jfecha;
    private javax.swing.JLabel lblBCliente;
    private javax.swing.JLabel lblBCliente1;
    private javax.swing.JLabel lblBCliente3;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblapellido;
    private javax.swing.JLabel lblcedula;
    private javax.swing.JLabel lblcedula_cliente1;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lblcodigo1;
    private javax.swing.JLabel lblcodigo2;
    private javax.swing.JLabel lblcodigo3;
    private javax.swing.JLabel lblcpanelc;
    private javax.swing.JLabel lblnombre;
    private javax.swing.JLabel lblnombre_cliente1;
    private javax.swing.JLabel lbltitulo;
    private javax.swing.JLabel lbltitulo1;
    private javax.swing.JButton limpiar_cliente;
    private javax.swing.JTabbedPane menu_cambiante;
    private javax.swing.JPanel panel_cliente;
    private javax.swing.JPanel pnldetalledeorden;
    private javax.swing.JPanel pnlizquierdo;
    private javax.swing.JPanel pnlmedio;
    private javax.swing.JPanel pnlprincipal;
    private javax.swing.JPanel pnlsecundario;
    private javax.swing.JPanel pnlsuperior;
    private javax.swing.JButton registro_cliente;
    private javax.swing.JTable tabla_clientes;
    private javax.swing.JTable tblmaquina;
    private javax.swing.JTable tblproducto;
    private javax.swing.JTable tblservicios;
    private javax.swing.JTextField txtTOTAL_ORDEN;
    private javax.swing.JTextField txt_producto;
    private javax.swing.JTextField txtcedula_detalle;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtcliente_detalle;
    private javax.swing.JTextField txtgrande;
    private javax.swing.JTextField txtmediana;
    private javax.swing.JTextField txtpequeña;
    private javax.swing.JTextField txtpeso_detalle;
    private javax.swing.JTextField txtservicio;
    private javax.swing.JLabel xxx;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.PersonaBD;
import Vista.Ag_cliente_orden;

/**
 *
 * @author tefip
 */
public class Controller_Ag_cliente_orden {

    private Ag_cliente_orden vista;
    private PersonaBD modelo;

    public Controller_Ag_cliente_orden(Ag_cliente_orden vista, PersonaBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
        iniciarcontrol();
    }
    
    
////////////////////////////////////////////////////////////////////////////////    
    

    public void iniciarcontrol() {
        vista.getBtnAceptar().addActionListener(l -> aceptar());
        vista.getBtnBuscar().addActionListener(l -> buscar());
        vista.getBtnRegistrar().addActionListener(l -> registrar());
    }

    public void aceptar() {
        vista.setVisible(false);
    }
    
    public void buscar() {
        vista.setVisible(false);
    }
    
    public void registrar() {
        vista.setVisible(false);
    }
}


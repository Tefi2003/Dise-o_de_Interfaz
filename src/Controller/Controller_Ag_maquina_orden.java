/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Modelo.MaquinaBD;
import Vista.Ag_maquina_orden;
/**
 *
 * @author tefip
 */
public class Controller_Ag_maquina_orden {
    
    private Ag_maquina_orden vista;
    private MaquinaBD modelo;

    public Controller_Ag_maquina_orden(Ag_maquina_orden vista, MaquinaBD modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
        iniciarcontrol();
    }
    
    
////////////////////////////////////////////////////////////////////////////////    
    

    public void iniciarcontrol() {
        vista.getBtnAceptar().addActionListener(l -> aceptar());
        vista.getBtnCancelar().addActionListener(l -> cancelar());
        vista.getBtnSiguiente().addActionListener(l -> siguiente());
    }

    public void cancelar() {
        vista.setVisible(false);
    }
    
    public void siguiente() {
        vista.setVisible(false);
    }
    
    public void aceptar() {
        vista.setVisible(false);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.UsuarioBD;
import Vista.LVerificacion;
import Vista.RGerente;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Controller_LVerificacion {
    private LVerificacion vista;

    public Controller_LVerificacion(LVerificacion vista) {
        this.vista = vista;
        vista.setVisible(true);
        iniciarcontrol();
    }
  public void  iniciarcontrol(){
      vista.getBtnIngresar().addActionListener(l->entrar());
      vista.getBtncancelar().addActionListener(l->cancelar());
  }
   
  public void entrar(){
      if (vista.getTxtpassword3().getText().equals("1234")) {
           RGerente rg=new RGerente();
        UsuarioBD modelo =new UsuarioBD();
        new Controller_RGerente(rg,modelo);
        rg.setVisible(true);
        vista.setVisible(false);
          
      }else{
          JOptionPane.showMessageDialog(vista, "CONTRASEÑA INCORRECTA");
      }
    
  }
  public void cancelar(){
      vista.setVisible(false);
  }
}

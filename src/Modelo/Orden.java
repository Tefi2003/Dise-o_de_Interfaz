/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wilo
 */
public class Orden extends Cliente{
    private int or_codigoorden;
    private double or_precio;
    private Date or_fecha;
    private double or_peso;
    private String or_estado;
    private int or_codigocli;
    private String or_descripcion_maq;
    private String or_descripcion_pro;
    private String or_descripcion_ser;

    public Orden() {
    }

    public Orden(String cli_genero, int cli_codigocli, String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_direccion, String per_correo, int per_codigoper) {
        super(cli_genero, cli_codigocli, per_cedula, per_nombre, per_apellido, per_telefono, per_direccion, per_correo, per_codigoper);
    }

    public int getOr_codigoorden() {
        return or_codigoorden;
    }

    public void setOr_codigoorden(int or_codigoorden) {
        this.or_codigoorden = or_codigoorden;
    }

   

    public double getOr_precio() {
        return or_precio;
    }

    public void setOr_precio(double or_precio) {
        this.or_precio = or_precio;
    }

    public Date getOr_fecha() {
        return or_fecha;
    }

    public void setOr_fecha(Date or_fecha) {
        this.or_fecha = or_fecha;
    }

    public double getOr_peso() {
        return or_peso;
    }

    public void setOr_peso(double or_peso) {
        this.or_peso = or_peso;
    }

    public String getOr_estado() {
        return or_estado;
    }

    public void setOr_estado(String or_estado) {
        this.or_estado = or_estado;
    }

    public int getOr_codigocli() {
        return or_codigocli;
    }

    public void setOr_codigocli(int or_codigocli) {
        this.or_codigocli = or_codigocli;
    }

    public String getOr_descripcion_maq() {
        return or_descripcion_maq;
    }

    public void setOr_descripcion_maq(String or_descripcion_maq) {
        this.or_descripcion_maq = or_descripcion_maq;
    }

    public String getOr_descripcion_pro() {
        return or_descripcion_pro;
    }

    public void setOr_descripcion_pro(String or_descripcion_pro) {
        this.or_descripcion_pro = or_descripcion_pro;
    }

    public String getOr_descripcion_ser() {
        return or_descripcion_ser;
    }

    public void setOr_descripcion_ser(String or_descripcion_ser) {
        this.or_descripcion_ser = or_descripcion_ser;
    }

    
    
   
      
}

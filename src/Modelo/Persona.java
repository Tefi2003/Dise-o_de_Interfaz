/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Persona {
    private String per_cedula;
    private String per_nombre;
    private String per_apellido;
    private String per_telefono;
    private String per_direccion;
    private String per_correo;
    private int per_codigoper;

    public Persona() {
    }

    public Persona(String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_direccion, String per_correo, int per_codigoper) {
        this.per_cedula = per_cedula;
        this.per_nombre = per_nombre;
        this.per_apellido = per_apellido;
        this.per_telefono = per_telefono;
        this.per_direccion = per_direccion;
        this.per_correo = per_correo;
        this.per_codigoper = per_codigoper;
    }

    public int getPer_codigoper() {
        return per_codigoper;
    }

    public void setPer_codigoper(int per_codigoper) {
        this.per_codigoper = per_codigoper;
    }

    
    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_nombre() {
        return per_nombre;
    }

    public void setPer_nombre(String per_nombre) {
        this.per_nombre = per_nombre;
    }

    public String getPer_apellido() {
        return per_apellido;
    }

    public void setPer_apellido(String per_apellido) {
        this.per_apellido = per_apellido;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }

    public String getPer_correo() {
        return per_correo;
    }

    public void setPer_correo(String per_correo) {
        this.per_correo = per_correo;
    }

    @Override
    public String toString() {
        return "Persona{" + "per_cedula=" + per_cedula + ", per_nombre=" + per_nombre + ", per_apellido=" + per_apellido + ", per_telefono=" + per_telefono + ", per_direccion=" + per_direccion + ", per_correo=" + per_correo + '}';
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author tefip
 */
public class Cliente extends Persona{

    private String cli_genero;
    private int cli_codigocli;

    
    public Cliente() {
    }
    
    public Cliente(String cli_genero, int cli_codigocli, String per_cedula, String per_nombre, String per_apellido, String per_telefono, String per_direccion, String per_correo, int per_codigoper) {
        super(per_cedula, per_nombre, per_apellido, per_telefono, per_direccion, per_correo, per_codigoper);
        this.cli_genero = cli_genero;
        this.cli_codigocli = cli_codigocli;
    }
    
    

    public String getCli_genero() {
        return cli_genero;
    }

    public void setCli_genero(String cli_genero) {
        this.cli_genero = cli_genero;
    }

    public int getCli_codigocli() {
        return cli_codigocli;
    }

    public void setCli_codigocli(int cli_codigocli) {
        this.cli_codigocli = cli_codigocli;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cli_genero=" + cli_genero + ", cli_codigocli=" + cli_codigocli + '}';
    }
    
    
    
    
    
}

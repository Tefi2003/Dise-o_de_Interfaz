/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_JDBC;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tefip
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsUsuario", query = "SELECT u FROM Usuario u WHERE u.usUsuario = :usUsuario"),
    @NamedQuery(name = "Usuario.findByUsRol", query = "SELECT u FROM Usuario u WHERE u.usRol = :usRol"),
    @NamedQuery(name = "Usuario.findByUsClave", query = "SELECT u FROM Usuario u WHERE u.usClave = :usClave"),
    @NamedQuery(name = "Usuario.findByUsCodigous", query = "SELECT u FROM Usuario u WHERE u.usCodigous = :usCodigous")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "US_USUARIO")
    private String usUsuario;
    @Basic(optional = false)
    @Column(name = "US_ROL")
    private String usRol;
    @Basic(optional = false)
    @Column(name = "US_CLAVE")
    private String usClave;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "US_CODIGOUS")
    private BigDecimal usCodigous;
    @JoinColumn(name = "US_CODIGOPER", referencedColumnName = "PER_CODIGOPER")
    @ManyToOne(optional = false)
    private Persona usCodigoper;

    public Usuario() {
    }

    public Usuario(BigDecimal usCodigous) {
        this.usCodigous = usCodigous;
    }

    public Usuario(BigDecimal usCodigous, String usUsuario, String usRol, String usClave) {
        this.usCodigous = usCodigous;
        this.usUsuario = usUsuario;
        this.usRol = usRol;
        this.usClave = usClave;
    }

    public String getUsUsuario() {
        return usUsuario;
    }

    public void setUsUsuario(String usUsuario) {
        this.usUsuario = usUsuario;
    }

    public String getUsRol() {
        return usRol;
    }

    public void setUsRol(String usRol) {
        this.usRol = usRol;
    }

    public String getUsClave() {
        return usClave;
    }

    public void setUsClave(String usClave) {
        this.usClave = usClave;
    }

    public BigDecimal getUsCodigous() {
        return usCodigous;
    }

    public void setUsCodigous(BigDecimal usCodigous) {
        this.usCodigous = usCodigous;
    }

    public Persona getUsCodigoper() {
        return usCodigoper;
    }

    public void setUsCodigoper(Persona usCodigoper) {
        this.usCodigoper = usCodigoper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usCodigous != null ? usCodigous.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usCodigous == null && other.usCodigous != null) || (this.usCodigous != null && !this.usCodigous.equals(other.usCodigous))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo_JDBC.Usuario[ usCodigous=" + usCodigous + " ]";
    }
    
}

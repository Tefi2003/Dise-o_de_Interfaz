/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_JDBC;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tefip
 */
@Entity
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPerCodigoper", query = "SELECT p FROM Persona p WHERE p.perCodigoper = :perCodigoper"),
    @NamedQuery(name = "Persona.findByPerCedula", query = "SELECT p FROM Persona p WHERE p.perCedula = :perCedula"),
    @NamedQuery(name = "Persona.findByPerNombre", query = "SELECT p FROM Persona p WHERE p.perNombre = :perNombre"),
    @NamedQuery(name = "Persona.findByPerApellido", query = "SELECT p FROM Persona p WHERE p.perApellido = :perApellido"),
    @NamedQuery(name = "Persona.findByPerTelefono", query = "SELECT p FROM Persona p WHERE p.perTelefono = :perTelefono"),
    @NamedQuery(name = "Persona.findByPerDireccion", query = "SELECT p FROM Persona p WHERE p.perDireccion = :perDireccion"),
    @NamedQuery(name = "Persona.findByPerCorreo", query = "SELECT p FROM Persona p WHERE p.perCorreo = :perCorreo")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PER_CODIGOPER")
    private BigDecimal perCodigoper;
    @Basic(optional = false)
    @Column(name = "PER_CEDULA")
    private String perCedula;
    @Basic(optional = false)
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    @Basic(optional = false)
    @Column(name = "PER_APELLIDO")
    private String perApellido;
    @Basic(optional = false)
    @Column(name = "PER_TELEFONO")
    private String perTelefono;
    @Basic(optional = false)
    @Column(name = "PER_DIRECCION")
    private String perDireccion;
    @Basic(optional = false)
    @Column(name = "PER_CORREO")
    private String perCorreo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliCodigoper")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usCodigoper")
    private Collection<Usuario> usuarioCollection;

    public Persona() {
    }

    public Persona(BigDecimal perCodigoper) {
        this.perCodigoper = perCodigoper;
    }

    public Persona(BigDecimal perCodigoper, String perCedula, String perNombre, String perApellido, String perTelefono, String perDireccion, String perCorreo) {
        this.perCodigoper = perCodigoper;
        this.perCedula = perCedula;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perTelefono = perTelefono;
        this.perDireccion = perDireccion;
        this.perCorreo = perCorreo;
    }

    public BigDecimal getPerCodigoper() {
        return perCodigoper;
    }

    public void setPerCodigoper(BigDecimal perCodigoper) {
        this.perCodigoper = perCodigoper;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerCorreo() {
        return perCorreo;
    }

    public void setPerCorreo(String perCorreo) {
        this.perCorreo = perCorreo;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perCodigoper != null ? perCodigoper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.perCodigoper == null && other.perCodigoper != null) || (this.perCodigoper != null && !this.perCodigoper.equals(other.perCodigoper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo_JDBC.Persona[ perCodigoper=" + perCodigoper + " ]";
    }
    
}

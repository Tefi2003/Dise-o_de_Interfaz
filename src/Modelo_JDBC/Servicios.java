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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tefip
 */
@Entity
@Table(name = "SERVICIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s"),
    @NamedQuery(name = "Servicios.findByServCodigoser", query = "SELECT s FROM Servicios s WHERE s.servCodigoser = :servCodigoser"),
    @NamedQuery(name = "Servicios.findByServPrecio", query = "SELECT s FROM Servicios s WHERE s.servPrecio = :servPrecio"),
    @NamedQuery(name = "Servicios.findByServNombre", query = "SELECT s FROM Servicios s WHERE s.servNombre = :servNombre")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SERV_CODIGOSER")
    private BigDecimal servCodigoser;
    @Basic(optional = false)
    @Column(name = "SERV_PRECIO")
    private BigDecimal servPrecio;
    @Basic(optional = false)
    @Column(name = "SERV_NOMBRE")
    private String servNombre;

    public Servicios() {
    }

    public Servicios(BigDecimal servCodigoser) {
        this.servCodigoser = servCodigoser;
    }

    public Servicios(BigDecimal servCodigoser, BigDecimal servPrecio, String servNombre) {
        this.servCodigoser = servCodigoser;
        this.servPrecio = servPrecio;
        this.servNombre = servNombre;
    }

    public BigDecimal getServCodigoser() {
        return servCodigoser;
    }

    public void setServCodigoser(BigDecimal servCodigoser) {
        this.servCodigoser = servCodigoser;
    }

    public BigDecimal getServPrecio() {
        return servPrecio;
    }

    public void setServPrecio(BigDecimal servPrecio) {
        this.servPrecio = servPrecio;
    }

    public String getServNombre() {
        return servNombre;
    }

    public void setServNombre(String servNombre) {
        this.servNombre = servNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servCodigoser != null ? servCodigoser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.servCodigoser == null && other.servCodigoser != null) || (this.servCodigoser != null && !this.servCodigoser.equals(other.servCodigoser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo_JDBC.Servicios[ servCodigoser=" + servCodigoser + " ]";
    }
    
}

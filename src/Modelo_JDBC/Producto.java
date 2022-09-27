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
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByProCodigopro", query = "SELECT p FROM Producto p WHERE p.proCodigopro = :proCodigopro"),
    @NamedQuery(name = "Producto.findByProNombre", query = "SELECT p FROM Producto p WHERE p.proNombre = :proNombre"),
    @NamedQuery(name = "Producto.findByProPrecio", query = "SELECT p FROM Producto p WHERE p.proPrecio = :proPrecio"),
    @NamedQuery(name = "Producto.findByProMarca", query = "SELECT p FROM Producto p WHERE p.proMarca = :proMarca")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRO_CODIGOPRO")
    private BigDecimal proCodigopro;
    @Basic(optional = false)
    @Column(name = "PRO_NOMBRE")
    private String proNombre;
    @Basic(optional = false)
    @Column(name = "PRO_PRECIO")
    private BigDecimal proPrecio;
    @Basic(optional = false)
    @Column(name = "PRO_MARCA")
    private String proMarca;

    public Producto() {
    }

    public Producto(BigDecimal proCodigopro) {
        this.proCodigopro = proCodigopro;
    }

    public Producto(BigDecimal proCodigopro, String proNombre, BigDecimal proPrecio, String proMarca) {
        this.proCodigopro = proCodigopro;
        this.proNombre = proNombre;
        this.proPrecio = proPrecio;
        this.proMarca = proMarca;
    }

    public BigDecimal getProCodigopro() {
        return proCodigopro;
    }

    public void setProCodigopro(BigDecimal proCodigopro) {
        this.proCodigopro = proCodigopro;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public BigDecimal getProPrecio() {
        return proPrecio;
    }

    public void setProPrecio(BigDecimal proPrecio) {
        this.proPrecio = proPrecio;
    }

    public String getProMarca() {
        return proMarca;
    }

    public void setProMarca(String proMarca) {
        this.proMarca = proMarca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proCodigopro != null ? proCodigopro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.proCodigopro == null && other.proCodigopro != null) || (this.proCodigopro != null && !this.proCodigopro.equals(other.proCodigopro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo_JDBC.Producto[ proCodigopro=" + proCodigopro + " ]";
    }
    
}

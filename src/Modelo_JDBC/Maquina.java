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
@Table(name = "MAQUINA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maquina.findAll", query = "SELECT m FROM Maquina m"),
    @NamedQuery(name = "Maquina.findByMaqCodigomaq", query = "SELECT m FROM Maquina m WHERE m.maqCodigomaq = :maqCodigomaq"),
    @NamedQuery(name = "Maquina.findByMaqTama\u00f1o", query = "SELECT m FROM Maquina m WHERE m.maqTama\u00f1o = :maqTama\u00f1o"),
    @NamedQuery(name = "Maquina.findByMaqPrecio", query = "SELECT m FROM Maquina m WHERE m.maqPrecio = :maqPrecio")})
public class Maquina implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MAQ_CODIGOMAQ")
    private BigDecimal maqCodigomaq;
    @Basic(optional = false)
    @Column(name = "MAQ_TAMA\u00d1O")
    private String maqTamaño;
    @Basic(optional = false)
    @Column(name = "MAQ_PRECIO")
    private BigDecimal maqPrecio;

    public Maquina() {
    }

    public Maquina(BigDecimal maqCodigomaq) {
        this.maqCodigomaq = maqCodigomaq;
    }

    public Maquina(BigDecimal maqCodigomaq, String maqTamaño, BigDecimal maqPrecio) {
        this.maqCodigomaq = maqCodigomaq;
        this.maqTamaño = maqTamaño;
        this.maqPrecio = maqPrecio;
    }

    public BigDecimal getMaqCodigomaq() {
        return maqCodigomaq;
    }

    public void setMaqCodigomaq(BigDecimal maqCodigomaq) {
        this.maqCodigomaq = maqCodigomaq;
    }

    public String getMaqTamaño() {
        return maqTamaño;
    }

    public void setMaqTamaño(String maqTamaño) {
        this.maqTamaño = maqTamaño;
    }

    public BigDecimal getMaqPrecio() {
        return maqPrecio;
    }

    public void setMaqPrecio(BigDecimal maqPrecio) {
        this.maqPrecio = maqPrecio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maqCodigomaq != null ? maqCodigomaq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquina)) {
            return false;
        }
        Maquina other = (Maquina) object;
        if ((this.maqCodigomaq == null && other.maqCodigomaq != null) || (this.maqCodigomaq != null && !this.maqCodigomaq.equals(other.maqCodigomaq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo_JDBC.Maquina[ maqCodigomaq=" + maqCodigomaq + " ]";
    }
    
}

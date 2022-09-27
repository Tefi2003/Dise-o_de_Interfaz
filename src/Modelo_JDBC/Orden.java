/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_JDBC;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tefip
 */
@Entity
@Table(name = "ORDEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o"),
    @NamedQuery(name = "Orden.findByOrCodigoorden", query = "SELECT o FROM Orden o WHERE o.orCodigoorden = :orCodigoorden"),
    @NamedQuery(name = "Orden.findByOrPrecio", query = "SELECT o FROM Orden o WHERE o.orPrecio = :orPrecio"),
    @NamedQuery(name = "Orden.findByOrFecha", query = "SELECT o FROM Orden o WHERE o.orFecha = :orFecha"),
    @NamedQuery(name = "Orden.findByOrPeso", query = "SELECT o FROM Orden o WHERE o.orPeso = :orPeso"),
    @NamedQuery(name = "Orden.findByOrEstado", query = "SELECT o FROM Orden o WHERE o.orEstado = :orEstado"),
    @NamedQuery(name = "Orden.findByOrDescripcionMaq", query = "SELECT o FROM Orden o WHERE o.orDescripcionMaq = :orDescripcionMaq"),
    @NamedQuery(name = "Orden.findByOrDescripcionPro", query = "SELECT o FROM Orden o WHERE o.orDescripcionPro = :orDescripcionPro"),
    @NamedQuery(name = "Orden.findByOrDescripcionSer", query = "SELECT o FROM Orden o WHERE o.orDescripcionSer = :orDescripcionSer")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "OR_CODIGOORDEN")
    private BigDecimal orCodigoorden;
    @Basic(optional = false)
    @Column(name = "OR_PRECIO")
    private BigDecimal orPrecio;
    @Basic(optional = false)
    @Column(name = "OR_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orFecha;
    @Basic(optional = false)
    @Column(name = "OR_PESO")
    private BigDecimal orPeso;
    @Basic(optional = false)
    @Column(name = "OR_ESTADO")
    private String orEstado;
    @Basic(optional = false)
    @Column(name = "OR_DESCRIPCION_MAQ")
    private String orDescripcionMaq;
    @Basic(optional = false)
    @Column(name = "OR_DESCRIPCION_PRO")
    private String orDescripcionPro;
    @Basic(optional = false)
    @Column(name = "OR_DESCRIPCION_SER")
    private String orDescripcionSer;
    @JoinColumn(name = "OR_CODIGOCLI", referencedColumnName = "CLI_CODIGOCLI")
    @ManyToOne(optional = false)
    private Cliente orCodigocli;

    public Orden() {
    }

    public Orden(BigDecimal orCodigoorden) {
        this.orCodigoorden = orCodigoorden;
    }

    public Orden(BigDecimal orCodigoorden, BigDecimal orPrecio, Date orFecha, BigDecimal orPeso, String orEstado, String orDescripcionMaq, String orDescripcionPro, String orDescripcionSer) {
        this.orCodigoorden = orCodigoorden;
        this.orPrecio = orPrecio;
        this.orFecha = orFecha;
        this.orPeso = orPeso;
        this.orEstado = orEstado;
        this.orDescripcionMaq = orDescripcionMaq;
        this.orDescripcionPro = orDescripcionPro;
        this.orDescripcionSer = orDescripcionSer;
    }

    public BigDecimal getOrCodigoorden() {
        return orCodigoorden;
    }

    public void setOrCodigoorden(BigDecimal orCodigoorden) {
        this.orCodigoorden = orCodigoorden;
    }

    public BigDecimal getOrPrecio() {
        return orPrecio;
    }

    public void setOrPrecio(BigDecimal orPrecio) {
        this.orPrecio = orPrecio;
    }

    public Date getOrFecha() {
        return orFecha;
    }

    public void setOrFecha(Date orFecha) {
        this.orFecha = orFecha;
    }

    public BigDecimal getOrPeso() {
        return orPeso;
    }

    public void setOrPeso(BigDecimal orPeso) {
        this.orPeso = orPeso;
    }

    public String getOrEstado() {
        return orEstado;
    }

    public void setOrEstado(String orEstado) {
        this.orEstado = orEstado;
    }

    public String getOrDescripcionMaq() {
        return orDescripcionMaq;
    }

    public void setOrDescripcionMaq(String orDescripcionMaq) {
        this.orDescripcionMaq = orDescripcionMaq;
    }

    public String getOrDescripcionPro() {
        return orDescripcionPro;
    }

    public void setOrDescripcionPro(String orDescripcionPro) {
        this.orDescripcionPro = orDescripcionPro;
    }

    public String getOrDescripcionSer() {
        return orDescripcionSer;
    }

    public void setOrDescripcionSer(String orDescripcionSer) {
        this.orDescripcionSer = orDescripcionSer;
    }

    public Cliente getOrCodigocli() {
        return orCodigocli;
    }

    public void setOrCodigocli(Cliente orCodigocli) {
        this.orCodigocli = orCodigocli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orCodigoorden != null ? orCodigoorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.orCodigoorden == null && other.orCodigoorden != null) || (this.orCodigoorden != null && !this.orCodigoorden.equals(other.orCodigoorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo_JDBC.Orden[ orCodigoorden=" + orCodigoorden + " ]";
    }
    
}

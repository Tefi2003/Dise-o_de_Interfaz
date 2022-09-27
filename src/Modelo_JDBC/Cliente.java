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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCliGenero", query = "SELECT c FROM Cliente c WHERE c.cliGenero = :cliGenero"),
    @NamedQuery(name = "Cliente.findByCliCodigocli", query = "SELECT c FROM Cliente c WHERE c.cliCodigocli = :cliCodigocli")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CLI_GENERO")
    private String cliGenero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CLI_CODIGOCLI")
    private BigDecimal cliCodigocli;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orCodigocli")
    private Collection<Orden> ordenCollection;
    @JoinColumn(name = "CLI_CODIGOPER", referencedColumnName = "PER_CODIGOPER")
    @ManyToOne(optional = false)
    private Persona cliCodigoper;

    public Cliente() {
    }

    public Cliente(BigDecimal cliCodigocli) {
        this.cliCodigocli = cliCodigocli;
    }

    public Cliente(BigDecimal cliCodigocli, String cliGenero) {
        this.cliCodigocli = cliCodigocli;
        this.cliGenero = cliGenero;
    }

    public String getCliGenero() {
        return cliGenero;
    }

    public void setCliGenero(String cliGenero) {
        this.cliGenero = cliGenero;
    }

    public BigDecimal getCliCodigocli() {
        return cliCodigocli;
    }

    public void setCliCodigocli(BigDecimal cliCodigocli) {
        this.cliCodigocli = cliCodigocli;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    public Persona getCliCodigoper() {
        return cliCodigoper;
    }

    public void setCliCodigoper(Persona cliCodigoper) {
        this.cliCodigoper = cliCodigoper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cliCodigocli != null ? cliCodigocli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cliCodigocli == null && other.cliCodigocli != null) || (this.cliCodigocli != null && !this.cliCodigocli.equals(other.cliCodigocli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo_JDBC.Cliente[ cliCodigocli=" + cliCodigocli + " ]";
    }
    
}

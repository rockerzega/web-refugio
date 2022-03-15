/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Marcelo
 */
@Entity
@Table(name = "donador-refugio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DonadorRefugio.findAll", query = "SELECT d FROM DonadorRefugio d")
    , @NamedQuery(name = "DonadorRefugio.findById", query = "SELECT d FROM DonadorRefugio d WHERE d.id = :id")
    , @NamedQuery(name = "DonadorRefugio.findByFecSusc", query = "SELECT d FROM DonadorRefugio d WHERE d.fecSusc = :fecSusc")})
public class DonadorRefugio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fec_susc")
    @Temporal(TemporalType.DATE)
    private Date fecSusc;
    @JoinColumn(name = "donador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Donador donador;
    @JoinColumn(name = "refugio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Refugio refugio;

    public DonadorRefugio() {
    }

    public DonadorRefugio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecSusc() {
        return fecSusc;
    }

    public void setFecSusc(Date fecSusc) {
        this.fecSusc = fecSusc;
    }

    public Donador getDonador() {
        return donador;
    }

    public void setDonador(Donador donador) {
        this.donador = donador;
    }

    public Refugio getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonadorRefugio)) {
            return false;
        }
        DonadorRefugio other = (DonadorRefugio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DonadorRefugio[ id=" + id + " ]";
    }
    
}

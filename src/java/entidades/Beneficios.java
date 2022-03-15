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
@Table(name = "beneficios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beneficios.findAll", query = "SELECT b FROM Beneficios b")
    , @NamedQuery(name = "Beneficios.findById", query = "SELECT b FROM Beneficios b WHERE b.id = :id")
    , @NamedQuery(name = "Beneficios.findByFecEmi", query = "SELECT b FROM Beneficios b WHERE b.fecEmi = :fecEmi")
    , @NamedQuery(name = "Beneficios.findByFecRea", query = "SELECT b FROM Beneficios b WHERE b.fecRea = :fecRea")})
public class Beneficios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fec_emi")
    @Temporal(TemporalType.DATE)
    private Date fecEmi;
    @Column(name = "fec_rea")
    @Temporal(TemporalType.DATE)
    private Date fecRea;
    @JoinColumn(name = "beneficio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AdmBeneficio beneficio;
    @JoinColumn(name = "donador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Donador donador;
    @JoinColumn(name = "refugio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Refugio refugio;

    public Beneficios() {
    }

    public Beneficios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecEmi() {
        return fecEmi;
    }

    public void setFecEmi(Date fecEmi) {
        this.fecEmi = fecEmi;
    }

    public Date getFecRea() {
        return fecRea;
    }

    public void setFecRea(Date fecRea) {
        this.fecRea = fecRea;
    }

    public AdmBeneficio getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(AdmBeneficio beneficio) {
        this.beneficio = beneficio;
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
        if (!(object instanceof Beneficios)) {
            return false;
        }
        Beneficios other = (Beneficios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Beneficios[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(name = "refugio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refugio.findAll", query = "SELECT r FROM Refugio r")
    , @NamedQuery(name = "Refugio.findById", query = "SELECT r FROM Refugio r WHERE r.id = :id")
    , @NamedQuery(name = "Refugio.findByHAtencion", query = "SELECT r FROM Refugio r WHERE r.hAtencion = :hAtencion")})
public class Refugio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id")
    private String id;
    @Size(max = 50)
    @Column(name = "h_atencion")
    private String hAtencion;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "refugio")
    private Collection<Donaciones> donacionesCollection; */
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "refugio")
    private Collection<DonadorRefugio> donadorRefugioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "refugio")
    private Collection<Beneficios> beneficiosCollection;*/

    public Refugio() {
    }

    public Refugio(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHAtencion() {
        return hAtencion;
    }

    public void setHAtencion(String hAtencion) {
        this.hAtencion = hAtencion;
    }

    /*@XmlTransient
    public Collection<Donaciones> getDonacionesCollection() {
        return donacionesCollection;
    }

    public void setDonacionesCollection(Collection<Donaciones> donacionesCollection) {
        this.donacionesCollection = donacionesCollection;
    }*/

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /*@XmlTransient
    public Collection<DonadorRefugio> getDonadorRefugioCollection() {
        return donadorRefugioCollection;
    }

    public void setDonadorRefugioCollection(Collection<DonadorRefugio> donadorRefugioCollection) {
        this.donadorRefugioCollection = donadorRefugioCollection;
    }

    @XmlTransient
    public Collection<Beneficios> getBeneficiosCollection() {
        return beneficiosCollection;
    }

    public void setBeneficiosCollection(Collection<Beneficios> beneficiosCollection) {
        this.beneficiosCollection = beneficiosCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Refugio)) {
            return false;
        }
        Refugio other = (Refugio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Refugio[ id=" + id + " ]";
    }
    
}

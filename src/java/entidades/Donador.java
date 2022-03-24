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
@Table(name = "donador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Donador.findAll", query = "SELECT d FROM Donador d")
    , @NamedQuery(name = "Donador.findById", query = "SELECT d FROM Donador d WHERE d.id = :id")
    , @NamedQuery(name = "Donador.findByApellido", query = "SELECT d FROM Donador d WHERE d.apellido = :apellido")
    , @NamedQuery(name = "Donador.findByPuntos", query = "SELECT d FROM Donador d WHERE d.puntos = :puntos")})
public class Donador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "id")
    private String id;
    @Size(max = 50)
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "puntos")
    private Integer puntos;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "donador")
    private Collection<Donaciones> donacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donador")
    private Collection<DonadorRefugio> donadorRefugioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donador")
    private Collection<Beneficios> beneficiosCollection;*/

    public Donador() {
    }

    public Donador(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /*@XmlTransient
    public Collection<Beneficios> getBeneficiosCollection() {
        return beneficiosCollection;
    }

    public void setBeneficiosCollection(Collection<Beneficios> beneficiosCollection) {
        this.beneficiosCollection = beneficiosCollection;
    }

    @XmlTransient
    public Collection<Donaciones> getDonacionesCollection() {
        return donacionesCollection;
    }

    public void setDonacionesCollection(Collection<Donaciones> donacionesCollection) {
        this.donacionesCollection = donacionesCollection;
    }

    @XmlTransient
    public Collection<DonadorRefugio> getDonadorRefugioCollection() {
        return donadorRefugioCollection;
    }

    public void setDonadorRefugioCollection(Collection<DonadorRefugio> donadorRefugioCollection) {
        this.donadorRefugioCollection = donadorRefugioCollection;
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
        if (!(object instanceof Donador)) {
            return false;
        }
        Donador other = (Donador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Donador[ id=" + id + " ]";
    }
    
}

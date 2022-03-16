
package entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="menu")
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="codigo")
    private Integer codigo;
    
    @Size(max = 50)
    @Column(name="nombre")
    private String nombre;
    
    @Size(max = 1)
    @Column(name="tipo")
    private String tipo;
    
    @Size(max = 3)
    @Column(name="tipo_usr")
    private String tipoUsr;
    
    @ManyToOne
    @JoinColumn(name = "codigo_smenu")
    private Menu submenu;
    
    @Column(name="estado")
    private boolean estado;
    
    @Size(max = 100)
    @Column(name="url")
    private String url;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoUsr() {
        return tipoUsr;
    }

    public void setTipoUsr(String tipoUsr) {
        this.tipoUsr = tipoUsr;
    }

    public Menu getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Menu submenu) {
        this.submenu = submenu;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Menu{" + "codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", estado=" + estado + '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}

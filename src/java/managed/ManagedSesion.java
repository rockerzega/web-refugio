
package managed;

import ejb.UsuarioFacadeLocal;
import entidades.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "managedSesion")
@SessionScoped
public class ManagedSesion implements Serializable {
    @EJB
    private UsuarioFacadeLocal manUser;
    private Usuario usuario;
    
    @PostConstruct
    private void iniciar () {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String inciarSesion () {
        Usuario u;
        String ruta = null;
        try {
            u = manUser.userAndPass(usuario.getUsuario(), usuario.getPass());
            if (u != null) {
                FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Información", "Bienvenido al sistema")
            );
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Administrador", u);
                ruta = "/pages/protegido/principal?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Precaución", "Usuario no reconocido")
            );
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.toString())
            );
        }
        return ruta;
    }
    
}

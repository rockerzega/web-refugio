package managed;

import entidades.Usuario;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class controlSesion implements Serializable {
    private Usuario user;
    
    public void verificarSesion () {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            user = (Usuario) context.getExternalContext().getSessionMap().get("Administrador");
            if (user == null) {
                context.getExternalContext().redirect("./../principal.xhtml");
            }
        } catch (Exception ex) {
            // mensaje
        }
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}

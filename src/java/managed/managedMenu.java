
package managed;

import ejb.MenuFacadeLocal;
import entidades.Menu;
import entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
//Solo activar cuando se use el sessionscoped
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@Named
@SessionScoped
public class managedMenu implements Serializable {
    @EJB
    private MenuFacadeLocal manMenu;
    private List<Menu> listaMenu;
    private MenuModel model;
    
    @PostConstruct
    private void inicio () {
        listarMenus();
        model = new DefaultMenuModel();
        construirMenu();
    }
    
    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    public void listarMenus () {
        try {
            listaMenu = manMenu.findAll();
        } catch (Exception ex) {
            //
        }
    }
    
    public void construirMenu () {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Administrador");
        for (Menu m: listaMenu) {
            if (m.getTipo().equals("S") && user.getId().startsWith(m.getTipoUsr())) {
               DefaultSubMenu firstSubMenu = new DefaultSubMenu(m.getNombre());
               for (Menu i : listaMenu) {
                   Menu subMenu = i.getSubmenu();
                   if(subMenu != null) {
                       if(subMenu.getCodigo() == m.getCodigo()) {
                           DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                           item.setUrl(i.getUrl());
                           firstSubMenu.addElement(item);
                       }
                   }
               }
               model.addElement(firstSubMenu);
            } else {
                if(m.getSubmenu() == null && user.getId().startsWith(m.getTipoUsr())){    
                    DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                    item.setUrl(m.getUrl());
                    model.addElement(item);
                }
            }
        }
    }

    public void cerrarSesion () {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}

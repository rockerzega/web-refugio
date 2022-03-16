/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import ejb.AdmBeneficioFacadeLocal;
import ejb.AdmDonacionFacadeLocal;
import ejb.AdministradorFacadeLocal;
import entidades.AdmBeneficio;
import entidades.AdmDonacion;
import entidades.Administrador;
import entidades.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Marcelo
 */
@Named(value = "jSFManagedAdm")
@ViewScoped
public class JSFManagedAdm implements Serializable{

    @EJB
    private AdmBeneficioFacadeLocal manAdmBeneficio;
    private AdmBeneficio admBeneficio;
    private List<AdmBeneficio> listaAdmBen;
    
    @EJB
    private AdmDonacionFacadeLocal manAdmDonacion;
    private AdmDonacion admDonacion;
    private List<AdmDonacion> listaAdmDon;
    
    @EJB
    private AdministradorFacadeLocal manAdministrador;
    private Administrador administrador;
    private List<Administrador> listaAdministrador;
    private Usuario usuario;
    
    /**
     * Creates a new instance of JSFManagedAdm
     */
    public JSFManagedAdm() {
    }
    
    // Opreacion post construccion e inicializacion
    
    @PostConstruct
    private void inicio () {
        admBeneficio = new AdmBeneficio();
        admDonacion = new AdmDonacion();
        administrador = new Administrador();
        usuario = new Usuario();
        listarAdministradores();
        listarAdmDonaciones();
        listarAdmBeneficios();
        incrementoAdm();
    }

    // Get y set de atributos
    public AdmBeneficio getAdmBeneficio() {
        return admBeneficio;
    }

    public void setAdmBeneficio(AdmBeneficio admBeneficio) {
        this.admBeneficio = admBeneficio;
    }

    public List<AdmBeneficio> getListaAdmBen() {
        return listaAdmBen;
    }

    public void setListaAdmBen(List<AdmBeneficio> listaAdmBen) {
        this.listaAdmBen = listaAdmBen;
    }

    public AdmDonacion getAdmDonacion() {
        return admDonacion;
    }

    public void setAdmDonacion(AdmDonacion admDonacion) {
        this.admDonacion = admDonacion;
    }

    public List<AdmDonacion> getListaAdmDon() {
        return listaAdmDon;
    }

    public void setListaAdmDon(List<AdmDonacion> listaAdmDon) {
        this.listaAdmDon = listaAdmDon;
    }
    
    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Administrador> getListaAdministrador() {
        return listaAdministrador;
    }

    public void setListaAdministrador(List<Administrador> listaAdministrador) {
        this.listaAdministrador = listaAdministrador;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    // Operaciones CRUD
    public void crearAdmBen () {
        manAdmBeneficio.create(admBeneficio);
        admBeneficio = new AdmBeneficio();
        listarAdmBeneficios();
    }

    public void crearAdmDon () {
        manAdmDonacion.create(admDonacion);
        admDonacion = new AdmDonacion();
        listarAdmDonaciones();
    }
    
    public void crearAdministrador () {
        try {
            usuario.setId(administrador.getId());
            administrador.setUsuario(usuario);
            manAdministrador.create(administrador);
            administrador = new Administrador();
            usuario = new Usuario();
            listarAdministradores();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró exitosamente")
            );
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Se ha presentado un error")
            );
        }
    }
    // Operaciones listas
    public void listarAdmBeneficios () {
        setListaAdmBen(manAdmBeneficio.findAll());
    } 
    
    public void listarAdmDonaciones () {
        setListaAdmDon(manAdmDonacion.findAll());
    }

    public void listarAdministradores () {
        setListaAdministrador(manAdministrador.findAll());
    }
    
    public void incrementoAdm () {
        Administrador temp = listaAdministrador.get(listaAdministrador.size()-1);
        String aux = String.valueOf(Integer.valueOf(temp.getId().substring(3))+1);
        String cero = "";
        for (int i = 0; i < 12 - aux.length(); i++) {
            cero += "0";
        }
        administrador.setId("ADM"+cero+aux);
        administrador.setActivo(Boolean.TRUE);
    }

}

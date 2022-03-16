/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import ejb.AdmBeneficioFacadeLocal;
import ejb.AdmDonacionFacadeLocal;
import ejb.AdministradorFacadeLocal;
import ejb.DonadorFacadeLocal;
import ejb.RefugioFacadeLocal;
import entidades.AdmBeneficio;
import entidades.AdmDonacion;
import entidades.Administrador;
import entidades.Donador;
import entidades.Refugio;
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
    
    @EJB
    private RefugioFacadeLocal manRefugio;
    private Refugio refugio;
    private List<Refugio> listaRefugios;
    
    @EJB
    private DonadorFacadeLocal manDonador;
    private Donador donador;
    private List<Donador> listaDonadores;
    
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
        refugio = new Refugio();
        donador = new Donador();
        listarAdministradores();
        listarAdmDonaciones();
        listarAdmBeneficios();
        listarRefugios();
        listarDonadores();
        incrementoAdm();
        incrementoRef();
        incrementoDon();
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
    
    public Refugio getRefugio() {
        return refugio;
    }

    public void setRefugio(Refugio refugio) {
        this.refugio = refugio;
    }

    public List<Refugio> getListaRefugios() {
        return listaRefugios;
    }

    public void setListaRefugios(List<Refugio> listaRefugios) {
        this.listaRefugios = listaRefugios;
    }
    
    public Donador getDonador() {
        return donador;
    }

    public void setDonador(Donador donador) {
        this.donador = donador;
    }

    public List<Donador> getListaDonadores() {
        return listaDonadores;
    }

    public void setListaDonadores(List<Donador> listaDonadores) {
        this.listaDonadores = listaDonadores;
    }
    
    // Operaciones CRUD
    public void crearAdmBen () {
        try {
            manAdmBeneficio.create(admBeneficio);
            admBeneficio = new AdmBeneficio();
            listarAdmBeneficios();
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

    public void crearAdmDon () {
        try {
            manAdmDonacion.create(admDonacion);
            admDonacion = new AdmDonacion();
            listarAdmDonaciones(); 
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
    
    public void crearRefugio () {
        try {
            usuario.setId(refugio.getId());
            refugio.setUsuario(usuario);
            manRefugio.create(refugio);
            refugio = new Refugio();
            usuario = new Usuario();
            listarRefugios();
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
    
    public void crearDonador () {
        try {
            usuario.setId(donador.getId());
            donador.setUsuario(usuario);
            manDonador.create(donador);
            donador = new Donador();
            usuario = new Usuario();
            listarDonadores();
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
    
    public void listarRefugios () {
        setListaRefugios(manRefugio.findAll());
    }
    
    public void listarDonadores () {
        setListaDonadores(manDonador.findAll());
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
    
    public void incrementoRef () {
        Refugio temp = listaRefugios.get(listaRefugios.size()-1);
        String aux = String.valueOf(Integer.valueOf(temp.getId().substring(3))+1);
        String cero = "";
        for (int i = 0; i < 12 - aux.length(); i++) {
            cero += "0";
        }
        refugio.setId("REF"+cero+aux);
    }
    
    public void incrementoDon () {
        Donador temp = listaDonadores.get(listaDonadores.size()-1);
        String aux = String.valueOf(Integer.valueOf(temp.getId().substring(3))+1);
        String cero = "";
        for (int i = 0; i < 12 - aux.length(); i++) {
            cero += "0";
        }
        donador.setId("DON"+cero+aux);
        donador.setPuntos(0);
    }

}

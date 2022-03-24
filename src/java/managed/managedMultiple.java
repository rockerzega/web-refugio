/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed;

import ejb.DonadorRefugioFacadeLocal;
import ejb.ImagenesFacadeLocal;
import ejb.RefugioFacadeLocal;
import entidades.DonadorRefugio;
import entidades.Imagenes;
import entidades.Refugio;
import entidades.Usuario;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Marcelo
 */
@Named(value = "managedMultiple")
@ManagedBean
@SessionScoped
public class managedMultiple implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String message;
    private UploadedFile file;
    private String rutaImagen;
    
    @EJB
    private DonadorRefugioFacadeLocal manDonRef;
    private DonadorRefugio donRef;
    private List<DonadorRefugio> lista;
    
    @EJB
    private ImagenesFacadeLocal manImages;
    private Imagenes imagen;
    
    @EJB
    private RefugioFacadeLocal manRefugio;
    
    public managedMultiple() {
    }
    
    @PostConstruct
    public void inicio () {
        donRef = new DonadorRefugio();
        imagen = new Imagenes();
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String cargarImagenTemporal (byte[] imgByte, String fileName) {
        String rutaImg = null;
        ServletContext servletContext = (ServletContext) FacesContext
                .getCurrentInstance().getExternalContext().getContext();
        String ruta = servletContext.getRealPath("") + File.separatorChar
                + "resources" + File.separatorChar+ "img" +File.separatorChar
                +"tmp" + File.separatorChar + fileName;
        File f = null;
        InputStream imgtemp = null;
        try {
            f = new File(ruta);
            imgtemp = new ByteArrayInputStream(imgByte);
            FileOutputStream out = new FileOutputStream(f.getAbsolutePath());
            int c = 0;
            while ((c = imgtemp.read()) >= 0) {
                out.write(c);
            }
            out.flush();
            out.close();
            rutaImg = "../../resources/img/tmp" + fileName;
        } catch (IOException ex){
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage())
            );
        }
        return rutaImg;
    }
    
    public void subirImagen() {
        try {
            String ms = "Error";
            if (file != null) {
                ms="Bien";
            }
            Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Administrador");
            // imagen.setImg(event.getFile().getContents());
            // imagen.setRefugio(user.getId());
            // imagen.setNombre(event.getFile().getFileName());
            // rutaImagen = cargarImagenTemporal(imagen.getImg(), event.getFile().getFileName());
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", ms)
            );
            //manImages.create(imagen);
            //imagen = new Imagenes();
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getClass().getName())
            );
        }
    }
    
    public void saveMessage() {
        Usuario user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Administrador");
        Refugio refugio = (Refugio) manRefugio.find(user.getId());
        //lista = manDonRef.obtenerDonadores(user.getId());
        FacesContext context = FacesContext.getCurrentInstance();
 
        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + String.valueOf(lista.size())) );
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
    }
    
    /// Methodos diferenciados
//    public void listarDonRef () {
//        try {
//            System.out.println("Imprimite porfa");
//            user = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Administrador");
//        // setListaDonRef(manDonRef.findAll());
//        FacesContext.getCurrentInstance().addMessage(
//                    null,
//                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", user.getNombre())
//            );
//        listaDonRef = manDonRef.obtenerDonadores(user.getId());
//        } catch (Exception ex) {
//        FacesContext.getCurrentInstance().addMessage(
//                    null,
//                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage())
//            );
//        }
//    }

    public DonadorRefugio getDonRef() {
        return donRef;
    }

    public void setDonRef(DonadorRefugio donRef) {
        this.donRef = donRef;
    }

    public List<DonadorRefugio> getLista() {
        return lista;
    }

    public void setLista(List<DonadorRefugio> lista) {
        this.lista = lista;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Imagenes getImagen() {
        return imagen;
    }

    public void setImagen(Imagenes imagen) {
        this.imagen = imagen;
    }

   
    
}


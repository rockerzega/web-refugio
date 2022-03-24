/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marcelo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "refugioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario userAndPass(String nombre, String pass) {
        Usuario user = null;
        System.out.println(nombre);
        try {
            user =(Usuario) em.createNamedQuery("Usuario.findByUsuarioandPass")
                          .setParameter("usuario", nombre)
                          .setParameter("pass", pass)
                          .getSingleResult();
            System.out.println(user);
        } catch (Exception ex) {
            throw (ex);
        }
      return user;
   }
}

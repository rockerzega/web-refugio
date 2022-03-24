/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.DonadorRefugio;
import entidades.Refugio;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marcelo
 */
@Stateless
public class DonadorRefugioFacade extends AbstractFacade<DonadorRefugio> implements DonadorRefugioFacadeLocal {

    @PersistenceContext(unitName = "refugioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DonadorRefugioFacade() {
        super(DonadorRefugio.class);
    }
    
    @Override
    public List<DonadorRefugio> obtenerDonadores (String refugio) {
        List<DonadorRefugio> lista = null;
        try {
            lista = (List<DonadorRefugio>) em.createQuery("SELECT d FROM DonadorRefugio d WHERE d.refugio = :refugio")
                          .setParameter("refugio", refugio)
                          .getResultList();
            System.out.println("Salida");
        } catch (Exception ex) {
            throw (ex);
        }
        return lista;
    }
    
}

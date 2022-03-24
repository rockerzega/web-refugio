/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Refugio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marcelo
 */
@Stateless
public class RefugioFacade extends AbstractFacade<Refugio> implements RefugioFacadeLocal {

    @PersistenceContext(unitName = "refugioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RefugioFacade() {
        super(Refugio.class);
    }
    
}

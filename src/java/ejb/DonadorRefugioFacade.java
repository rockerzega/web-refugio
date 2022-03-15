/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.DonadorRefugio;
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
    
}

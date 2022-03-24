/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Refugio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo
 */
@Local
public interface RefugioFacadeLocal {

    void create(Refugio refugio);

    void edit(Refugio refugio);

    void remove(Refugio refugio);

    Refugio find(Object id);

    List<Refugio> findAll();

    List<Refugio> findRange(int[] range);

    int count();
    
}

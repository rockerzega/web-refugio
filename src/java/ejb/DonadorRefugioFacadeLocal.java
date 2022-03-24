/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.DonadorRefugio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo
 */
@Local
public interface DonadorRefugioFacadeLocal {

    void create(DonadorRefugio donadorRefugio);

    void edit(DonadorRefugio donadorRefugio);

    void remove(DonadorRefugio donadorRefugio);

    DonadorRefugio find(Object id);

    List<DonadorRefugio> findAll();

    List<DonadorRefugio> findRange(int[] range);

    int count();
    
    public List<DonadorRefugio> obtenerDonadores (String refugio);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.AdmDonacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo
 */
@Local
public interface AdmDonacionFacadeLocal {

    void create(AdmDonacion admDonacion);

    void edit(AdmDonacion admDonacion);

    void remove(AdmDonacion admDonacion);

    AdmDonacion find(Object id);

    List<AdmDonacion> findAll();

    List<AdmDonacion> findRange(int[] range);

    int count();
    
}

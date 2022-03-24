/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.AdmBeneficio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo
 */
@Local
public interface AdmBeneficioFacadeLocal {

    void create(AdmBeneficio admBeneficio);

    void edit(AdmBeneficio admBeneficio);

    void remove(AdmBeneficio admBeneficio);

    AdmBeneficio find(Object id);

    List<AdmBeneficio> findAll();

    List<AdmBeneficio> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Beneficios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo
 */
@Local
public interface BeneficiosFacadeLocal {

    void create(Beneficios beneficios);

    void edit(Beneficios beneficios);

    void remove(Beneficios beneficios);

    Beneficios find(Object id);

    List<Beneficios> findAll();

    List<Beneficios> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Donaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo
 */
@Local
public interface DonacionesFacadeLocal {

    void create(Donaciones donaciones);

    void edit(Donaciones donaciones);

    void remove(Donaciones donaciones);

    Donaciones find(Object id);

    List<Donaciones> findAll();

    List<Donaciones> findRange(int[] range);

    int count();
    
}

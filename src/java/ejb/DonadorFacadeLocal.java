/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.Donador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marcelo
 */
@Local
public interface DonadorFacadeLocal {

    void create(Donador donador);

    void edit(Donador donador);

    void remove(Donador donador);

    Donador find(Object id);

    List<Donador> findAll();

    List<Donador> findRange(int[] range);

    int count();
    
}

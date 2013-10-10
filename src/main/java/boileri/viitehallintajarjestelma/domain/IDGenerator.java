/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

import java.util.List;

/**
 *
 * @author alpa
 */
public class IDGenerator {

    List<Viite> list;

    public IDGenerator(List<Viite> l) {
        list = l;
    }

    public void generateId(Viite v) {
        
    }

    public boolean validateId(String id) {
        for (Viite v : list) {
            if (v.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }
}

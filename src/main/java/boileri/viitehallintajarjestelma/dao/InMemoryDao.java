/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boileri.viitehallintajarjestelma.dao;

import boileri.viitehallintajarjestelma.domain.Viite;
import java.util.ArrayList;
import java.util.List;


public class InMemoryDao implements ViiteDao {
    
    private List<Viite> viitteet;

    public InMemoryDao() {
        viitteet = new ArrayList<Viite>();        
    }

    @Override
    public List<Viite> haeKaikki() {
        return viitteet;
    }

    @Override
    public boolean tallennaViite(Viite viite) {
        if(viite == null){
            return false;
        }
        viitteet.add(viite);
        return true;
    }

    @Override
    public boolean poistaViite(String id) {
        for (Viite poistettava : viitteet) {
            if (poistettava.getId().equals(id)) {
                viitteet.remove(poistettava);
                return true;
            }
        }
        return false;
    }
    
    
    
}

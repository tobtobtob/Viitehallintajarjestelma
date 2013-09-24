/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boileri.viitehallintajarjestelma.Dao;

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
    public void tallennaViite(Viite viite) {
        viitteet.add(viite);
    }

    @Override
    public void poistaViite(Viite viite) {
        viitteet.remove(viite);
    }
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.dao;

import boileri.viitehallintajarjestelma.domain.Viite;
import boileri.viitehallintajarjestelma.komennot.IDGeneroija;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDao implements ViiteDao {

    private List<Viite> viitteet;
    IDGeneroija gen;

    public InMemoryDao() {

        viitteet = new ArrayList<Viite>();
        gen = new IDGeneroija(this);
    }

    @Override
    public List<Viite> haeKaikki() {
        return viitteet;
    }

    @Override
    public boolean tallennaViite(Viite viite) {
        if (viite == null) {
            return false;
        }
        viite.setId(gen.generoiId(viite));
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

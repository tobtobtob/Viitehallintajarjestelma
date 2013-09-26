
package boileri.viitehallintajarjestelma.dao;

import boileri.viitehallintajarjestelma.domain.Viite;
import java.util.List;

public interface ViiteDao {
    
    public List<Viite> haeKaikki();
    
    public boolean tallennaViite(Viite viite);
    
    public void poistaViite(Viite viite);
}

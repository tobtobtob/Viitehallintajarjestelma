
package boileri.viitehallintajarjestelma.dao;

import boileri.viitehallintajarjestelma.domain.Viite;
import java.util.List;

public interface ViiteDao {
    
    public List<Viite> haeKaikki();
    
    public void tallennaViite(Viite viite);
    
    public void poistaViite(Viite viite);
}

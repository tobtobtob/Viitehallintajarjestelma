/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.dao;

import boileri.viitehallintajarjestelma.domain.Viite;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author topi
 */
public class InMemoryDaoTest {
    private InMemoryDao dao;
    public InMemoryDaoTest() {
    }
    
    @Before
    public void setUp() {
        dao = new InMemoryDao();
    }
    
    @Test
    public void palauttaaTyhjanArraynJosEiViitteita(){
        List<Viite> viitteet = dao.haeKaikki();
        assertEquals(0, viitteet.size());
    }
    
     @Test
     public void palauttaaFalseJosTallennetaanTyhjaaViitetta(){
         assertEquals(false, dao.tallennaViite(null));
     }
     @Test 
     public void palauttaaTrueJosAsiallinenViite(){
        
         Viite v = luoViite();
         assertEquals(true, dao.tallennaViite(v));
     }
     @Test
     public void poistoToimii(){
         Viite v = luoViite();
         dao.tallennaViite(v);
         assertEquals(1, dao.haeKaikki().size());
         dao.poistaViite(v.getId());
         assertEquals(0, dao.haeKaikki().size());
     }

    private Viite luoViite() {
        List<String> testi = new ArrayList<String>();
        testi.add("A");
        testi.add("T");
        testi.add("B");
        testi.add("Y");
        Viite v = Viite.luoViite("inproceedings");
        return v;
    }
}

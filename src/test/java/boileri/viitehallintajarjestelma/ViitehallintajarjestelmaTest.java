package boileri.viitehallintajarjestelma;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author topi
 */
public class ViitehallintajarjestelmaTest {
    
    public ViitehallintajarjestelmaTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testimetodiJenkinsille(){
        assertEquals(9, Viitehallintajarjestelma.testiMetodi(7));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

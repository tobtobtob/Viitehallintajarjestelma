package boileri.viitehallintajarjestelma;


import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


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
    
}

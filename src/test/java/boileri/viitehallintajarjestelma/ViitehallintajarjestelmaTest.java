package boileri.viitehallintajarjestelma;


import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ViitehallintajarjestelmaTest {
    
    Viitehallintajarjestelma viitejar;
    public ViitehallintajarjestelmaTest() {
    }
    
    @Before
    public void setUp() {
        viitejar = new Viitehallintajarjestelma(System.in);
    }
    
    @Test
    public void testi(){
        assertEquals(true, true);
    }
    
}

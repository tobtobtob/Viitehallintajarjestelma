/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import boileri.viitehallintajarjestelma.BibTexKirjoittaja;
import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;
import boileri.viitehallintajarjestelma.domain.Viite;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BibTexKirjoittajaTest {
    
    FileWriter fw;
    BibTexKirjoittaja gen;
    Viite viite;
    
    public BibTexKirjoittajaTest() {
    }
    
    @Before
    public void setUp() {
        fw = mock(FileWriter.class);
        viite = mock(Viite.class);
        gen = new BibTexKirjoittaja(fw);
    }
    @Test
    public void kirjoittaaYhdenViitteenOikein(){
        List<Viite> viitteet = new ArrayList<Viite>();
        viitteet.add(viite);
        when(viite.toBibTex()).thenReturn("@testiviite{839\nauthor = {testimies},\n}");
        gen.writeBibTex(viitteet, "testi");
    }
    
}

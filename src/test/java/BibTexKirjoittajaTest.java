/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import boileri.viitehallintajarjestelma.BibTexKirjoittaja;
import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;
import boileri.viitehallintajarjestelma.domain.Viite;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BibTexKirjoittajaTest {
    
    FileWriter fw;
    BibTexKirjoittaja gen;
    Viite viite, viite2;
    
    public BibTexKirjoittajaTest() {
    }
    
    @Before
    public void setUp() {
        fw = mock(FileWriter.class);
        viite = mock(Viite.class);
        viite2 = mock(Viite.class);
        gen = new BibTexKirjoittaja(fw);
    }
    @Test
    public void kirjoittaaYhdenViitteenOikein() throws IOException{
        List<Viite> viitteet = new ArrayList<Viite>();
        viitteet.add(viite);
        when(viite.toBibTex()).thenReturn("@testiviite{839\nauthor = {testimies},\n}\n");
        gen.writeBibTex(viitteet, "testi");
        verify(fw).write("@testiviite{839\nauthor = {testimies},\n}\n");
    }
    @Test
    public void kirjoittaaUseammanViitteenOikein() throws IOException{
        List<Viite> viitteet = new ArrayList<Viite>();
        viitteet.add(viite);
        viitteet.add(viite2);
        when(viite.toBibTex()).thenReturn("@testiviite{839\nauthor = {testimies},\n}\n");
        when(viite2.toBibTex()).thenReturn("@toinen{879\nauthor = {testimies},\n}\n");
        gen.writeBibTex(viitteet, "nakki");
        verify(fw).write("@testiviite{839\nauthor = {testimies},\n}\n");
        verify(fw).write("@toinen{879\nauthor = {testimies},\n}\n");
    }
    
}

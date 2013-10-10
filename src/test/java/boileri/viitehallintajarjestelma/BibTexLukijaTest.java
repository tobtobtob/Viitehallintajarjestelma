package boileri.viitehallintajarjestelma;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import boileri.viitehallintajarjestelma.BibTexLukija;
import boileri.viitehallintajarjestelma.domain.Viite;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author topi
 */
public class BibTexLukijaTest {
    
    BibTexLukija bib;
    Scanner s;
    
    public BibTexLukijaTest() {
    }
    
    @Before
    public void setUp() {
        bib = new BibTexLukija();
        
    }
    
    @Test
    public void oikeaKenttaLoytyy(){
        String kentta = bib.getKentta("booktitle = {Rikos ja rangaistus},");
        assertEquals(kentta, "booktitle");
    }
    @Test
    public void oikeaArvoLoytyy(){
        String arvo = bib.getArvo("booktitle = {Rikos ja rangaistus},");
        assertEquals(arvo, "Rikos ja rangaistus");
    }
    @Test
    public void loytaaTyypinOikein(){
        String tyyppi = bib.getTyyppiJaID("@inproceedings{testiID,")[0];
        assertEquals("inproceedings", tyyppi);
    }
    @Test
    public void loytaaOikeanIDn(){
        String id = bib.getTyyppiJaID("@inproceedings{testiID,")[1];
        assertEquals("testiID", id);
    }
    @Test
    public void loytaaKivastiYhdenViitteen(){
        s = new Scanner("@book{BA04,\n"+
"author = {Beck, Kent and Andres, Cynthia},\n"+
"title = {Extreme Programming Explained: Embrace Change (2nd Edition)},\n"+
"year = {2004},\n"+
"publisher = {Addison-Wesley Professional},\n"+
"})");
        List<Viite> viitteet = bib.lueViitteet(s);
        String viite = viitteet.get(0).toString();
        assertEquals("id: BA04\nauthor: Beck, Kent and Andres, Cynthia\n"
                + "title: Extreme Programming Explained: Embrace Change (2nd Edition)\n"
                +"year: 2004\n"
        + "publisher: Addison-Wesley Professional\n", viite);                
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import boileri.viitehallintajarjestelma.BibTexLukija;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author topi
 */
public class BibTexLukijaTest {
    
    BibTexLukija bib;
    
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

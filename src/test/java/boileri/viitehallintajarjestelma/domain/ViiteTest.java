package boileri.viitehallintajarjestelma.domain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Outt
 */
public class ViiteTest {

    public ViiteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getPakollisetTest() {
        List<String> actual = new InProceedingsViite().getKentat();
        List<String> expected = new ArrayList<String>() {
        };
        expected.add("author");
        expected.add("title");
        expected.add("booktitle");
        expected.add("year");
        assertEquals(actual, expected);
    }

    @Test
    public void luoViiteTest() {

        List<String> otsikot = new ArrayList<String>();
        otsikot.add("A");
        otsikot.add("T");
        otsikot.add("B");
        otsikot.add("Y");
        Viite x = Viite.luoViite("inproceedings");
        x.setSisalto(otsikot);
        x.setId("0.o");
        String expected = "id: 0.o\nauthor: A\ntitle: T\nbooktitle: B\nyear: Y\n";
        assertEquals(x.toString(), expected);
    }

    @Test
    public void luoViiteNullTest() {
        List<String> otsikot = new ArrayList<String>();
        otsikot.add("A");
        otsikot.add("T");
        otsikot.add("B");
        otsikot.add("Y");
        Viite x = Viite.luoViite("porkkana");
        assertNull(x);
    }
//
//    @Test
//    public void luoViiteNullTest2() {
//        List<String> otsikot = new ArrayList<String>();
//        otsikot.add("A");
//        otsikot.add("T");
//        otsikot.add("");
//        otsikot.add("Y");
//        Viite x = Viite.luoViite("inproceedings");
//        assertNull(x);
//    }

//    @Test
//    public void getPakollisetNullTest() {
//        List<String> actual = Viite.getKentat("kurpitsa");
//        List<String> expected = null;
//        assertEquals(actual, expected);
//    }

    //@Test
    public void generateIdTestOikeaID() {
        List<String> otsikot = new ArrayList<String>();
        otsikot.add("Ass");
        otsikot.add("Tar");
        otsikot.add("Sima");
        otsikot.add("2010");
        Viite x = Viite.luoViite("inproceedings");

        assertEquals("ATS20", x.getId());
    }

    //@Test
    public void generateIdNullJosHuonoSyote() {
        List<String> otsikot = new ArrayList<String>();
        otsikot.add("Ass");
        otsikot.add("Tar");
        otsikot.add("Sima");
        otsikot.add("2");
        Viite x = Viite.luoViite("inproceedings");
        x.setSisalto(otsikot);

        assertEquals("NULL", x.getId());
    }

    @Test
    public void toStringTest() {
    }
}
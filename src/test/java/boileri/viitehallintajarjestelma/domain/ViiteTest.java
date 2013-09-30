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
        List<String> actual = Viite.getPakollisetKentat("inproceedings");
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
        Viite x = Viite.luoViite(otsikot, "inproceedings");
        String expected = "author: A\ntitle: T\nbooktitle: B\nyear: Y\n";
        assertEquals(x.toString(), expected);
    }

    @Test
    public void luoViiteNullTest() {
        List<String> otsikot = new ArrayList<String>();
        otsikot.add("A");
        otsikot.add("T");
        otsikot.add("B");
        otsikot.add("Y");
        Viite x = Viite.luoViite(otsikot, "porkkana");
        assertNull(x);
    }

    @Test
    public void luoViiteNullTest2() {
        List<String> otsikot = new ArrayList<String>();
        otsikot.add("A");
        otsikot.add("T");
        otsikot.add("");
        otsikot.add("Y");
        Viite x = Viite.luoViite(otsikot, "inproceedings");
        assertNull(x);
    }

    @Test
    public void getPakollisetNullTest() {
        List<String> actual = Viite.getPakollisetKentat("kurpitsa");
        List<String> expected = null;
        assertEquals(actual, expected);
    }

    @Test
    public void toStringTest() {
    }
}
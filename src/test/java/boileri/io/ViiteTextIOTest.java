/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.io;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.InputStream;

/**
 * @author alpa
 */
public class ViiteTextIOTest {

    ViiteTextIO io;

    @Before
    public void setUp() {
        io = new ViiteTextIO(System.in);
    }

    @Test
    public void printTulostaaOikein() {
        System.setIn(null);
    }

    @Test
    public void readIntPalauttaaOikeanLuvun() {
        
    }

    @Test
    public void readIntPalauttaaMiinusYksiKunNegLuku() {
    }

    @Test
    public void readIntePalauttaaMiinusYksiKunEiLuku() {
    }

    @Test
    public void readStringPalauttaaOikeinRivin() {
    }
}
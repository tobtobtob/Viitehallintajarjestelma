/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.io;

import java.io.ByteArrayOutputStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;

/**
 * @author alpa
 */
public class ViiteTextIOTest {

    ViiteTextIO io;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outputErr = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        io = new ViiteTextIO(System.in);
    }

    // printin testin alustus
    @Before
    public void setOutputStreams() {
        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(outputErr));
    }

    // printin testin alustuksen nollaus
    @After
    public void cleanOutputStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void printTulostaaOikein() {
        io.print("testi ja toinen");
        assertEquals("testi ja toinen\n", output.toString());
    }

    @Test
    public void printToimiiLinebreakina() {
        io.print("");
        assertEquals("\n", output.toString());
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author alpa
 */
public class ViiteTextIOTest {

    ViiteIO io;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outputErr = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        io = new ViiteTextIO(System.in);
    }

    // Outputin alustus testia varten
    @Before
    public void setOutputStreams() {
        System.setOut(new PrintStream(output));
        System.setErr(new PrintStream(outputErr));
    }

    // Testienjälkeinen outputin nollaus
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
        io = setNewInputStream("12");
        assertEquals(12, io.readInt());
    }

    @Test
    public void readIntPalauttaaMiinusYksiKunNegLuku() {

        io = setNewInputStream("-5");
        assertEquals(-1, io.readInt());
    }

    @Test
    public void readIntePalauttaaMiinusYksiKunEiLuku() {
        io = setNewInputStream("matias");
        assertEquals(-1, io.readInt());
    }

    @Test
    public void readStringPalauttaaOikeinRivin() {
        io = setNewInputStream("iso ja pieni");
        assertEquals("iso ja pieni", io.readLine());
    }

    public ViiteTextIO setNewInputStream(String s) {
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        return new ViiteTextIO(in);
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.io;

import java.io.ByteArrayInputStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.InputStream;
import java.util.Scanner;

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
        String syote = "testi";
        InputStream inStream = System.in;
        try {
            System.setIn(new ByteArrayInputStream(syote.getBytes()));
            Scanner scanner = new Scanner(System.in);
            String testiSyote = scanner.nextLine();

            io.print(testiSyote);
        } finally {
            System.setIn(inStream);
        }
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
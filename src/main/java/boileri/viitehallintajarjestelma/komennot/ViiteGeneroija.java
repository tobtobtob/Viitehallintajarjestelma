/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.komennot;

import boileri.viitehallintajarjestelma.BibTexKirjoittaja;
import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;

/**
 *
 * @author alpa
 */
public class ViiteGeneroija implements Runnable {

    private final Viitehallintajarjestelma jarjestelma;

    public ViiteGeneroija(final Viitehallintajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        jarjestelma.io.print("Anna tiedoston nimi:");
        String tiedostonimi = jarjestelma.io.readLine();
        BibTexKirjoittaja bib = new BibTexKirjoittaja();
        if (bib.writeBibTex(jarjestelma.dao.haeKaikki(), tiedostonimi)) {
            jarjestelma.io.print("tiedoston generointi onnistui");
        } else {
            jarjestelma.io.print("tiedoston generointi epäonnistui");
        }
    }
}

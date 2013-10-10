/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.komennot;

import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;

/**
 *
 * @author alpa
 */
public class ViitteenPoistaja implements Runnable {

    private final Viitehallintajarjestelma jarjestelma;

    public ViitteenPoistaja(final Viitehallintajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        jarjestelma.io.print("Anna viitteen id:");
        String id = jarjestelma.io.readLine();
        boolean poisto = jarjestelma.dao.poistaViite(id);
        if (poisto == false) {
            jarjestelma.io.print("Virheellinen tai olematon id");
        } else {
            jarjestelma.io.print("Viite poistettu");
        }
    }
}

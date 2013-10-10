/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.komennot;

import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;
import boileri.viitehallintajarjestelma.domain.Viite;

/**
 *
 * @author alpa
 */
public class ViiteListaaja implements Runnable {

    private final Viitehallintajarjestelma jarjestelma;

    public ViiteListaaja(final Viitehallintajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }

    @Override
    public void run() {
        for (Viite viite : jarjestelma.dao.haeKaikki()) {
            System.out.println(viite);
        }
    }
}

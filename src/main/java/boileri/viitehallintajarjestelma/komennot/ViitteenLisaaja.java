/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.komennot;

import boileri.io.ViiteIO;
import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;
import boileri.viitehallintajarjestelma.dao.ViiteDao;
import boileri.viitehallintajarjestelma.domain.ArticleViite;
import boileri.viitehallintajarjestelma.domain.BookViite;
import boileri.viitehallintajarjestelma.domain.InProceedingsViite;
import boileri.viitehallintajarjestelma.domain.Viite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author alpa
 */
public class ViitteenLisaaja implements Runnable {

    private final Viitehallintajarjestelma jarjestelma;
    HashMap<String, Viite> maaritellyt;

    public ViitteenLisaaja(final Viitehallintajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
        maaritellyt = new HashMap<String, Viite>();
        alustaMaaritellyt();
    }

    public final void alustaMaaritellyt() {
        maaritellyt.put("inproceedings", new InProceedingsViite());
        maaritellyt.put("article", new ArticleViite());
        maaritellyt.put("book", new BookViite());
    }

    @Override
    public void run() {
        ViiteIO io = jarjestelma.io;
        ViiteDao dao = jarjestelma.dao;

        io.print("Anna viitteen tyyppi:");
        String tyyppi = io.readLine();

        if (!maaritellyt.containsKey(tyyppi)) {
            for (String object : maaritellyt.keySet()) {
                io.print(object);
            }
            io.print("Virheellinen tyyppi");
            return;
        }
        List<String> kentat = maaritellyt.get(tyyppi).getKentat();
        List<String> syotetytKentat = new ArrayList<String>();
        for (String kentta : kentat) {
            io.print("syötä kenttä \"" + kentta + "\":");
            syotetytKentat.add(io.readLine());
        }
        Viite uusi = Viite.luoViite(tyyppi);
        uusi.setSisalto(syotetytKentat);
        if (dao.tallennaViite(uusi)) {
            io.print("Viite tallennettu!");
        } else {
            io.print("Tallennus epäonnistui");
        }
    }
}

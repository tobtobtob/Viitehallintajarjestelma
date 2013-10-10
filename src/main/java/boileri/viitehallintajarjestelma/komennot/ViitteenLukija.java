/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boileri.viitehallintajarjestelma.komennot;

import boileri.io.ViiteIO;
import boileri.viitehallintajarjestelma.BibTexLukija;
import boileri.viitehallintajarjestelma.Viitehallintajarjestelma;
import boileri.viitehallintajarjestelma.dao.ViiteDao;
import boileri.viitehallintajarjestelma.domain.Viite;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ViitteenLukija implements Runnable {
    
    private final Viitehallintajarjestelma jarjestelma;

    public ViitteenLukija(Viitehallintajarjestelma jarjestelma) {
        this.jarjestelma = jarjestelma;
    }
    
    
    @Override
    public void run() {
        ViiteDao dao = jarjestelma.dao;
        ViiteIO io = jarjestelma.io;
        BibTexLukija bib = new BibTexLukija();
        io.print("Anna tiedoston nimi:");
        String tiedostonNimi = io.readLine();
        try {
            List<Viite> viitteet = bib.lueViitteet(tiedostonNimi, new Scanner(new File(tiedostonNimi)));
            for (Viite viite : viitteet) {
                dao.tallennaViite(viite);
            }
            io.print("viitteet tallennettu");
            
        } catch (FileNotFoundException ex) {
            io.print("joku meni vikaan");
        }
        
    }

}

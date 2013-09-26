package boileri.viitehallintajarjestelma;

/**
 * Hello world!
 *
 */
import boileri.io.ViiteIO;
import boileri.io.ViiteTextIO;
import boileri.viitehallintajarjestelma.dao.InMemoryDao;
import boileri.viitehallintajarjestelma.dao.ViiteDao;
import boileri.viitehallintajarjestelma.domain.Viite;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
//import boileri.viitehallintajarjestelma.domain.PerusViite;
//import boileri.viitehallintajarjestelma.Dao.InMemoryDao;
//import java.util.ArrayList;

public class Viitehallintajarjestelma {

    public ViiteIO io;
    public ViiteDao dao;

    public Viitehallintajarjestelma(InputStream d) {
        io = new ViiteTextIO(d);
        dao = new InMemoryDao();
    }

    public static void main(String[] args) {

//        Testailua...        
//        ArrayList<String> b =new ArrayList();
//        b.add("a");
//        b.add("b");
//        b.add("c");
//        b.add("d");
//        PerusViite x = new PerusViite(b);
//        InMemoryDao y = new InMemoryDao();
//        y.tallennaViite(x);
//        System.out.println(x);
        Viitehallintajarjestelma viitejar = new Viitehallintajarjestelma(System.in);
        viitejar.run();
    }

    public void run() {
        String command;
        while (true) {
            io.print("Syötä komento:");
            io.print("Tyhjä syöte sammuttaa ohjelman\n");
            command = io.readLine(">");
            
            if (command.equals("listaa")){
                listaaViitteet();
            }
            else if (command.equals("uusi")){
                uusiViite();
            }
            else if (command.isEmpty()) {
                io.print("Sammutetaan ohjelma..");
                break;
            } else {
                io.print("Tunnistamaton komento.\n");
            }
        }
    }
    public void uusiViite(){
        
        io.print("Anna viitteen tyyppi:");
        String tyyppi = io.readLine(">");
        List<String> kentat = Viite.getPakollisetKentat(tyyppi);
        if(kentat == null){
            io.print("Virheellinen tyyppi");
            return;
        }
        List<String> syotetytKentat = new ArrayList<String>();
        for (String kentta : kentat) {
            io.print("syötä kenttä \""+kentta+"\":");
            syotetytKentat.add(io.readLine(">"));
        }
        Viite uusi = Viite.luoViite(syotetytKentat, tyyppi);
        if(dao.tallennaViite(uusi)){
            io.print("Viite tallennettu!");
        }
        else{
            io.print("Tallennus epäonnistui");
        }
    }
    public void listaaViitteet(){
        
    }

}

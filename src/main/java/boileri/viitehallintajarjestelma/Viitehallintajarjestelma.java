package boileri.viitehallintajarjestelma;

/**
 * Hello world!
 *
 */
import boileri.io.ViiteIO;
import boileri.io.ViiteTextIO;
//import boileri.viitehallintajarjestelma.domain.PerusViite;
//import boileri.viitehallintajarjestelma.Dao.InMemoryDao;
//import java.util.ArrayList;

public class Viitehallintajarjestelma {

    public ViiteIO io;

    public Viitehallintajarjestelma(ViiteIO i) {
        io = i;
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
        Viitehallintajarjestelma viitejar = new Viitehallintajarjestelma(new ViiteTextIO());
        viitejar.run();
    }

    public void run() {
        String command;
        while (true) {
            command = io.readLine(">");

            // Kun käyttäjä antaa tyhjän syötteen
            if (command.isEmpty()) {
                io.print("Sammutetaan ohjelma..");
                break;
            }
        }
    }

    public static int testiMetodi(int numero) {
        return numero + 2;
    }
}

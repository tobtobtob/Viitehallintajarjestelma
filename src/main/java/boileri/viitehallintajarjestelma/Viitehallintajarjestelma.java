package boileri.viitehallintajarjestelma;

/**
 * Hello world!
 *
 */
import boileri.io.ViiteIO;
import boileri.io.ViiteTextIO;
import java.io.InputStream;
//import boileri.viitehallintajarjestelma.domain.PerusViite;
//import boileri.viitehallintajarjestelma.Dao.InMemoryDao;
//import java.util.ArrayList;

public class Viitehallintajarjestelma {

    public ViiteIO io;

    public Viitehallintajarjestelma(InputStream d) {
        io = new ViiteTextIO(d);
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

            // Kun käyttäjä antaa tyhjän syötteen
            if (command.isEmpty()) {
                io.print("Sammutetaan ohjelma..");
                break;
            } else {
                io.print("Tunnistamaton komento.\n");
            }
        }
    }

    public static int testiMetodi(int numero) {
        return numero + 2;
    }
}

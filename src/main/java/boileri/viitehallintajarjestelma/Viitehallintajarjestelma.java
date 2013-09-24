package boileri.viitehallintajarjestelma;

/**
 * Hello world!
 *
 */
import boileri.io.ViiteIO;
import boileri.io.ViiteTextIO;

public class Viitehallintajarjestelma {

    public ViiteIO io;

    public Viitehallintajarjestelma(ViiteIO i) {
        io = i;
    }

    public static void main(String[] args) {
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

package boileri.viitehallintajarjestelma;

/**
 * Hello world!
 *
 */
import boileri.io.ViiteIO;
import boileri.io.ViiteTextIO;
import boileri.viitehallintajarjestelma.dao.InMemoryDao;
import boileri.viitehallintajarjestelma.dao.ViiteDao;
import boileri.viitehallintajarjestelma.komennot.ViiteGeneroija;
import boileri.viitehallintajarjestelma.komennot.ViiteListaaja;
import boileri.viitehallintajarjestelma.komennot.ViitteenLisaaja;
import boileri.viitehallintajarjestelma.komennot.ViitteenLukija;
import boileri.viitehallintajarjestelma.komennot.ViitteenPoistaja;
import java.io.InputStream;
import java.util.HashMap;

public class Viitehallintajarjestelma {

    public ViiteIO io;
    public ViiteDao dao;
    public HashMap<String, Runnable> cmd;

    public Viitehallintajarjestelma(InputStream d) {
        this.cmd = new HashMap<String, Runnable>();
        io = new ViiteTextIO(d);
        dao = new InMemoryDao();

        luoKomentoLista();

    }

    public Viitehallintajarjestelma(ViiteIO io) {
        this.io = io;
        dao = new InMemoryDao();
    }

    private void luoKomentoLista() {
        cmd.put("listaa", new ViiteListaaja(this));
        cmd.put("uusi", new ViitteenLisaaja(this));
        cmd.put("generoi", new ViiteGeneroija(this));
        cmd.put("poista", new ViitteenPoistaja(this));
        cmd.put("lue", new ViitteenLukija(this));
    }

    public static void main(String[] args) {

        Viitehallintajarjestelma viitejar = new Viitehallintajarjestelma(System.in);
        viitejar.run();
    }

    public void run() {
        String command;
        while (true) {
            io.print("Syötä komento:\n" + "Tyhjä syöte sammuttaa ohjelman\n");
            io.print(" listaa\n uusi\n generoi\n poista\n lue");

            command = io.readLine();

            if (command.isEmpty()) {
                io.print("Sammutetaan ohjelma..");
                break;
            }
            try {
                cmd.get(command).run();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Tunnistamaton komento");
            }
        }
    }
}

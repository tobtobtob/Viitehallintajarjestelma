package boileri.io;

/**
 * @author Outt+alpa+ohtumateriaali
 */
import java.util.ArrayList;

public class ViiteStubIO implements ViiteIO {

    private String[] lines;
    private int i;
    private ArrayList<String> prints;

    // Tällä syötetään komennot testeissä
    public ViiteStubIO(String... values) {
        this.lines = values;
        prints = new ArrayList<String>();
    }

    // Tallentaa annetun syötteen tarkistusta varten
    @Override
    public void print(String toPrint) {
        prints.add(toPrint);
    }

    // Kuuntelee input-syötettä ja tallentaa sen
    @Override
    public int readInt() {
        return Integer.parseInt(lines[i++]);
    }

    // Palauttaa seuraavan konstruktorissa syötetyn arvon
    @Override
    public String readLine() {
        if (i < lines.length) {
            return lines[i++];
        }
        return "";
    }

    // Tänne tallennetaan ohjelman tulostukset tarkastusta varten
    public ArrayList<String> getPrints() {
        return prints;
    }
}

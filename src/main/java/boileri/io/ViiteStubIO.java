package boileri.io;

/**
 * @author Outt+alpa+ohtumateriaali
 */

import java.util.ArrayList;


public class ViiteStubIO implements ViiteIO {

    private String[] lines;
    private int i;
    private ArrayList<String> prints;

    public ViiteStubIO(String... values) {
        this.lines = values;
        prints = new ArrayList<String>();
    }
    
    // Tulostaa annetun syötteen

    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
        prints.add(toPrint);
    }

    // Kuuntelee input-syötettä ja palauttaa annetun kokonaisluvun
    // Palauttaa -1 jos virheellinen (ei int) syöte
    @Override
    public int readInt() {
        return Integer.parseInt(lines[i++]);
    }

    // Kuuntelee input-syötettä ja palauttaa annetun merkkijonon
    @Override
    public String readLine() {
        if (i < lines.length) {
            return lines[i++];
        }
        return "";
    }

    public ArrayList<String> getPrints() {
        return prints;
    }
}

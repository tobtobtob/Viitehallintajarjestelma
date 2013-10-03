package boileri.io;

/**
 * @author alpa
 */
import java.io.InputStream;
import java.util.Scanner;

public class ViiteTextIO implements ViiteIO {

    private Scanner scanner;

    public ViiteTextIO(InputStream d) {
        scanner = new Scanner(d);
    }

    // Tulostaa annetun syötteen
    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    // Kuuntelee input-syötettä ja palauttaa annetun kokonaisluvun
    // Palauttaa -1 jos virheellinen (ei int) syöte
    @Override
    public int readInt() {
        try {
            int i = Integer.parseInt(scanner.nextLine());
            if (i < 0) {
                return -1;
            }
            return i;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Kuuntelee input-syötettä ja palauttaa annetun merkkijonon
    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}

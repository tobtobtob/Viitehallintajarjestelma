/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.io;

/**
 * @author alpa
 */
import java.util.Scanner;

public class ViiteTextIO implements ViiteIO {

    private Scanner scanner = new Scanner(System.in);

    // Tulostaa annetun syötteen
    @Override
    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    // Kuuntelee näppäimistöä ja palauttaa annetun kokonaisluvun
    @Override
    public int readInt(String prompt) {
        System.out.print(prompt + " ");
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

    // Kuuntelee näppäimistöä ja palauttaa annetun merkkijonon
    @Override
    public String readLine(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
}

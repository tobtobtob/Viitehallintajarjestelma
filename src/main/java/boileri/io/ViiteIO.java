/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.io;

/**
 *
 * @author alpa
 *
 * Rajapinta Input / Output - laitteille
 */
public interface ViiteIO {

    void print(String toPrint);

    int readInt(String prompt);

    String readLine(String prompt);
}

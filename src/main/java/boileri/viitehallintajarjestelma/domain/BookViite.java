/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

/**
 *
 * @author alpa
 */
public class BookViite extends Viite {

    public BookViite() {

        super.tyyppi = "book";

        kentat.add("author");
        kentat.add("title");
        kentat.add("year");
        kentat.add("publisher");
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alpa
 */
public class BookViite extends Viite {

    public BookViite(List<String> sisalto) {
        super.tyyppi = "book";

        //id tulis antaa konstruktorissa

        super.kentat.add("author");
        super.kentat.add("title");
        super.kentat.add("year");
        super.kentat.add("publisher");
        this.sisalto = sisalto;
    }

    public List<String> getKentat() {
        return super.kentat;
    }
}

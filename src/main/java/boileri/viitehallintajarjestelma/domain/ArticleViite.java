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
public class ArticleViite extends Viite {

    public ArticleViite(List<String> sisalto) {
        super.tyyppi = "article";

        //id tulis antaa konstruktorissa

        super.kentat.add("author");
        super.kentat.add("title");
        super.kentat.add("journal");
        super.kentat.add("year");
        super.kentat.add("volume");
        super.kentat.add("pages");
        this.sisalto = sisalto;
    }

    public List<String> getKentat() {
        return super.kentat;
    }
}

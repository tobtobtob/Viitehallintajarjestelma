/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

/**
 *
 * @author alpa
 */
public class ArticleViite extends Viite {

    public ArticleViite() {
        super.tyyppi = "article";

        kentat.add("author");
        kentat.add("title");
        kentat.add("journal");
        kentat.add("year");
        kentat.add("volume");
        kentat.add("pages");
    }

    @Override
    public void generateId() {
        id = "hih";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

/**
 *
 * @author Outt
 */
public class InProceedingsViite extends Viite {

    public InProceedingsViite() {
        super.tyyppi = "inproceedings";

        kentat.add("author");
        kentat.add("title");
        kentat.add("booktitle");
        kentat.add("year");
    }

    @Override
    public void generateId() {
         id = "huh";
    }

  }

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Outt
 */

public class InProceedingsViite extends Viite{


    public InProceedingsViite(List<String> sisalto) {
        super.tyyppi = "inproceedings";
        
        //id tulis antaa konstruktorissa
        super.id = "testiID";
        super.kentat = new ArrayList<String>();
        super.kentat.add("author");
        super.kentat.add("title");
        super.kentat.add("booktitle");
        super.kentat.add("year");
        this.sisalto = sisalto; 
    }
    
    public List<String> getKentat() {
        return super.kentat;
    }
}

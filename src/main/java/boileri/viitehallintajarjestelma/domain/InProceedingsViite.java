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

//    private List<String> kentat = new ArrayList(4);
//    private List<String> sisalto;
//    {
//        kentat.add("Author: ");
//        kentat.add("Title: ");
//        kentat.add("Book title: ");
//        kentat.add("Year: ");
//  }

    public InProceedingsViite(List<String> sisalto) {
        
        super.kentat = new ArrayList<String>();
        super.kentat.add("Author: ");
        super.kentat.add("Title: ");
        super.kentat.add("Book title: ");
        super.kentat.add("Year: ");
        this.sisalto = sisalto;  
    }
    
    public List<String> getKentat() {
        return super.kentat;
    }
}

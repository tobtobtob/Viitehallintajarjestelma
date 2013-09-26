/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

import java.util.ArrayList;

/**
 *
 * @author Outt
 */

public class InProceedingsViite extends Viite{

    private ArrayList<String> kentat = new ArrayList(4);
    private ArrayList<String> sisalto;
    {
        kentat.add("Author: ");
        kentat.add("Title: ");
        kentat.add("Book title: ");
        kentat.add("Year: ");
  }

    public InProceedingsViite(ArrayList<String> sisalto) {
        this.sisalto = sisalto;  
    }
    
    public ArrayList<String> getKentat() {
        return kentat;
    }
}

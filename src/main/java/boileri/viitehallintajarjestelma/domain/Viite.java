/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boileri.viitehallintajarjestelma.domain;

import java.util.List;


public class Viite {
    
    public static List<String> getPakollisetKentat(String tyyppi){
        if(tyyppi.equals("inproceedings")){
            return new InProceedingsViite(null).getKentat();
        }
        return null;
    }
   
   public static Viite luoViite(List<String> pakolliset, String tyyppi){
       if(tyyppi.equals("inproceedings")){
           return new InProceedingsViite(pakolliset);
       }
       return null;
   }
}

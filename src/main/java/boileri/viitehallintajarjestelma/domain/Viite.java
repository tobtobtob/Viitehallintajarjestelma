/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boileri.viitehallintajarjestelma.domain;

import java.util.List;


public class Viite {
    
    protected String id;
    protected String tyyppi;
    protected List<String> kentat;
    protected List<String> sisalto;
    
    public static List<String> getPakollisetKentat(String tyyppi){
        if(tyyppi.equals("inproceedings")){
            return new InProceedingsViite(null).getKentat();
        }
        return null;
    }
   
   public static Viite luoViite(List<String> pakolliset, String tyyppi){
       
       for (String string : pakolliset) {
           if(string.equals("")){
               return null;
           }
       }
       if(tyyppi.equals("inproceedings")){
           return new InProceedingsViite(pakolliset);
       }
       return null;
   }
    @Override
   public String toString(){
       String ret = "";
       for(int i = 0; i<kentat.size();i++){
           ret += kentat.get(i)+": "+sisalto.get(i)+"\n";
       }
       return ret;
   }
   public String toBibTex(){
       String ret = "@"+this.tyyppi+"{"+this.id+",\n";       
       for(int i = 0; i<kentat.size();i++){
           ret += kentat.get(i)+" = {"+sisalto.get(i)+"},\n";
       }
       ret += "}\n";
       return ret;
   }
}

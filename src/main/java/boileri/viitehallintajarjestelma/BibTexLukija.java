/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package boileri.viitehallintajarjestelma;

import boileri.viitehallintajarjestelma.domain.Viite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class BibTexLukija {
    Scanner s;
    
    public List<Viite> lueViitteet(String tiedostoNimi, Scanner s){
        List<Viite> viitteet = new ArrayList();
        this.s = s;
        String rivi;
        HashMap<String, String> arvot;
        
        while(s.hasNextLine()){
            arvot = new HashMap<String, String>();
            String[] temp = getTyyppiJaID(s.nextLine());
            arvot.put("id", temp[1]);
            arvot.put("tyyppi", temp[0]);
            rivi = s.nextLine();
            
            while(eiTurhaRivi(rivi)){
                arvot.put(getKentta(rivi), getArvo(rivi));
                rivi = s.nextLine();
            }
            viitteet.add(luoViite(arvot));
        }
        
        return viitteet;
    }
    public String[] getTyyppiJaID(String rivi){
        rivi = rivi.replaceAll(" ", "");
        String tyyppi = "";
        String ID = "";
        int alku = 0;
        for (int i = 1; i < rivi.length(); i++) {
            if(rivi.charAt(i) == '{'){
                alku = i;
                break;
            }
            tyyppi += rivi.charAt(i);
        }
        for (int i = alku+1; i < rivi.length(); i++) {
            if(rivi.charAt(i) == ','){                
                break;
            }
            ID += rivi.charAt(i);
        }
        String[] ret = {tyyppi, ID};
        return ret;
        
    }
    public String getKentta(String rivi){
        rivi = rivi.replaceAll(" ", "");
        String kentta = "";
        for (int i = 0; i < rivi.length(); i++) {
            if(rivi.charAt(i) == '='){
                break;
            }
            kentta += rivi.charAt(i);
        }
        
        return kentta;
    }
    public String getArvo(String rivi){
        String arvo = "";
        int alku = 0;
        for (int i = 0; i < rivi.length(); i++) {
            if(rivi.charAt(i) == '{'){
                alku = i;
                break;
            }
        }
        for (int i = alku+1; i < rivi.length(); i++) {
            if(rivi.charAt(i) =='}'){
                break;
            }
            arvo += rivi.charAt(i);
                
        }
        return arvo;
    }

    private boolean eiTurhaRivi(String rivi) {
        
        for (int i = 0; i < rivi.length(); i++) {
            if(rivi.charAt(i) == '{'){
                return true;
            }
            if(rivi.charAt(i) == '}'){
                return false;
            }
        }
        return false;
    }

    private Viite luoViite(HashMap<String, String> arvot) {
        List<String> kentat = Viite.getPakollisetKentat(arvot.get("tyyppi"));
        List<String> sisalto = new ArrayList<String>();
        
        for (String kentta : kentat) {
            sisalto.add(arvot.get(kentta));
        }
        return Viite.luoViite(sisalto, arvot.get("tyyppi"));
        
    }
}

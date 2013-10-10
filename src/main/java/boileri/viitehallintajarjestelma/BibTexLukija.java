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

    public List<Viite> lueViitteet( Scanner s) {
        List<Viite> viitteet = new ArrayList();
        this.s = s;
        String rivi;
        HashMap<String, String> arvot;

        while (s.hasNextLine()) {
            rivi =s.nextLine();
            while(s.hasNextLine() && !eiTurhaRivi(rivi)){
                rivi = s.nextLine();
            }
            if(!s.hasNextLine()){
                break;
            }
            arvot = new HashMap<String, String>();
            String[] temp = getTyyppiJaID(rivi);
            arvot.put("id", temp[1]);
            arvot.put("tyyppi", temp[0]);
            rivi = s.nextLine();

            while (eiTurhaRivi(rivi)) {
                arvot.put(getKentta(rivi), getArvo(rivi));
                rivi = s.nextLine();
            }
            Viite uusi = luoViite(arvot);
            uusi.setId(arvot.get("id"));
            viitteet.add(uusi);
        }

        return viitteet;
    }

    public String[] getTyyppiJaID(String rivi) {
        rivi = rivi.replaceAll(" ", "");
        String tyyppi = "";
        String ID = "";
        int alku = 0;
        for (int i = 1; i < rivi.length(); i++) {
            if (rivi.charAt(i) == '{') {
                alku = i;
                break;
            }
            tyyppi += rivi.charAt(i);
        }
        for (int i = alku + 1; i < rivi.length(); i++) {
            if (rivi.charAt(i) == ',') {
                break;
            }
            ID += rivi.charAt(i);
        }
        String[] ret = {tyyppi, ID};
        return ret;

    }

    public String getKentta(String rivi) {
        rivi = rivi.replaceAll(" ", "");
        String kentta = "";
        for (int i = 0; i < rivi.length(); i++) {
            if (rivi.charAt(i) == '=') {
                break;
            }
            kentta += rivi.charAt(i);
        }

        return kentta;
    }

    public String getArvo(String rivi) {
        String arvo = "";
        int alku = 0;
        for (int i = 0; i < rivi.length(); i++) {
            if (rivi.charAt(i) == '{') {
                alku = i;
                break;
            }
        }
        for (int i = alku + 1; i < rivi.length(); i++) {
            if (rivi.charAt(i) == '}') {
                break;
            }
            arvo += rivi.charAt(i);

        }
        return arvo;
    }

    private boolean eiTurhaRivi(String rivi) {

        for (int i = 0; i < rivi.length(); i++) {
            if (rivi.charAt(i) == '{') {
                return true;
            }
            if (rivi.charAt(i) == '}') {
                return false;
            }
        }
        return false;
    }

    private Viite luoViite(HashMap<String, String> arvot) {
        List<String> sisalto = new ArrayList<String>();
        Viite viite = Viite.luoViite(arvot.get("tyyppi"));
        List<String> kentat = viite.getKentat();

        for (String kentta : kentat) {
            sisalto.add(arvot.get(kentta));
        }
        viite.setSisalto(sisalto);
        return viite;

    }
}

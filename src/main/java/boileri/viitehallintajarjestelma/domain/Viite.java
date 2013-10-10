/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

import java.util.ArrayList;
import java.util.List;

public class Viite {

    protected String id;
    protected String tyyppi;
    protected final List<String> kentat;
    protected List<String> sisalto;

    public Viite() {
        kentat = new ArrayList<String>();
        sisalto = new ArrayList<String>();
    }

    public static Viite luoViite(String tyyppi) {

        if (tyyppi.equals("inproceedings")) {
            Viite viite = new InProceedingsViite();
            return viite;
        }
        if (tyyppi.equals("article")) {
            Viite viite = new ArticleViite();
            return viite;
        }
        if (tyyppi.equals("book")) {
            Viite viite = new BookViite();
            return viite;
        }
        return null;
    }

    @Override
    public String toString() {
        String ret = "";

        for (int i = 0; i < kentat.size(); i++) {
            ret += kentat.get(i) + ": " + sisalto.get(i) + "\n";
        }

        return ret;
    }

    public String toBibTex() {
        String ret = "@" + this.tyyppi + "{" + this.id + ",\n";
        for (int i = 0; i < kentat.size(); i++) {
            ret += kentat.get(i) + " = {" + sisalto.get(i) + "},\n";
        }
        ret += "}\n";
        return ret;
    }

    public void setId(String newId) {
        this.id = newId;
    }

    public void setSisalto(List<String> l) {
        sisalto.clear();
        sisalto.addAll(l);
    }

    public String getId() {
        return id;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public List<String> getSisalto() {
        return sisalto;
    }

    public final List<String> getKentat() {
        return kentat;
    }
}

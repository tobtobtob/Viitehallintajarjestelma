/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Viite {

    protected String id;
    protected String tyyppi;
    protected final List<String> kentat;
    protected List<String> sisalto;
    IDGenerator gen;

    public Viite() {
        kentat = new ArrayList<String>();
        sisalto = new ArrayList<String>();
    }

    public static Viite luoViite(String tyyppi) {

        if (tyyppi.equals("inproceedings")) {
            Viite viite = new InProceedingsViite();
            viite.generateId();
            return viite;
        }
        if (tyyppi.equals("article")) {
            Viite viite = new ArticleViite();
            viite.generateId();
            return viite;
        }
        if (tyyppi.equals("book")) {
            Viite viite = new BookViite();
            viite.generateId();
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

    // ottaa viitteen sisallon 3 ensimmaisen indeksin ensimmaiset merkit
    // ja neljannen indeksin kaksi ensimmaista merkkia ja runttaa ne yhteen
    // asettaa id:si "NULL", jos jokin merkkijonoista liian lyhyt
    public abstract void generateId();
     
    

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

    public final List<String> getKentat() {
        return kentat;
    }
}

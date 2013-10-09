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
    }

    public static List<String> getPakollisetKentat(String tyyppi) {
        if (tyyppi.equals("inproceedings")) {
            return new InProceedingsViite(null).getKentat();
        }
        if (tyyppi.equals("article")) {
            return new ArticleViite(null).getKentat();
        }
        if (tyyppi.equals("book")) {
            return new BookViite(null).getKentat();
        }
        return null;
    }

    public static Viite luoViite(List<String> pakolliset, String tyyppi) {

        for (String string : pakolliset) {
            if (string.equals("")) {
                return null;
            }
        }
        if (tyyppi.equals("inproceedings")) {
            Viite viite = new InProceedingsViite(pakolliset);
            viite.generateId();
            return viite;
        }
        if (tyyppi.equals("article")) {
            Viite viite = new ArticleViite(pakolliset);
            viite.generateId();
            return viite;
        }
        if (tyyppi.equals("book")) {
            Viite viite = new BookViite(pakolliset);
            viite.generateId();
            return viite;
        }
        return null;
    }

    @Override
    public String toString() {
        String ret = "";
        try {
            for (int i = 0; i < kentat.size(); i++) {
                ret += kentat.get(i) + ": " + sisalto.get(i) + "\n";
            }
        } catch (IndexOutOfBoundsException e) {
            return "IndexOutOfBoundsException";
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
    public void generateId() {
        try {
            this.id = sisalto.get(0).substring(0, 1) + sisalto.get(1).substring(0, 1)
                    + sisalto.get(2).substring(0, 1) + sisalto.get(3).substring(0, 2);
        } catch (StringIndexOutOfBoundsException e) {
            this.id = "NULL";
        }
    }

    public String getId() {
        return id;
    }
}

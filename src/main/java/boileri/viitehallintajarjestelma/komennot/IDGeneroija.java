/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boileri.viitehallintajarjestelma.komennot;

import boileri.viitehallintajarjestelma.dao.ViiteDao;
import boileri.viitehallintajarjestelma.domain.Viite;
import java.util.ArrayList;
import java.util.List;

/**
 * vastaa viitteen ID-generoinnista ja niiden uniikkiudesta
 */
public class IDGeneroija {

    ViiteDao dao;
    List<Viite> viitteet;

    public IDGeneroija(ViiteDao dao) {
        this.dao = dao;
        viitteet = new ArrayList<Viite>(this.dao.haeKaikki());

    }

    /*
     * Luo uniikin ID:n ottamalla ensimmaisen ja toisen sisaltoindeksin
     * ensimmaisen merkin ja niin monta kolmannen indeksin merkkia kuin uniikkiuteen
     * tarvitaan.
     */
    public String generoiId(Viite v) {
        viitteet = dao.haeKaikki();
        String ID = "";
        String etumerkit, valimerkit, loppumerkit;
        List<String> sisalto = v.getSisalto();
        int indexCounter = 0;
        while (true) {
            if (sisalto.get(0).isEmpty()) {
                etumerkit = "N" + Integer.toString(indexCounter);
            } else {
                etumerkit = sisalto.get(0).substring(0, 1);
            }
            if (sisalto.get(1).isEmpty()) {
                valimerkit = "N" + Integer.toString(indexCounter);
            } else {
                valimerkit = sisalto.get(1).substring(0, 1);
            }
            if (sisalto.get(3).isEmpty() || sisalto.get(3).length() > indexCounter) {
                loppumerkit = "0" + Integer.toString(indexCounter);
            } else {
                loppumerkit = sisalto.get(3).substring(0, indexCounter);
            }
            ID = etumerkit + valimerkit + loppumerkit;
            if (IDKay(ID)) {
                break;
            }
            indexCounter++;
        }
        return ID;
    }

    /*
     * Palauttaa
     */
    public boolean IDKay(String ID) {
        if (ID.equals("")) {
            return false;
        } else if (viitteet.isEmpty()) {
            return true;
        }
        for (Viite v : viitteet) {
            if (ID.equals(v.getId())) {
                return false;
            }
        }
        return true;
    }
}

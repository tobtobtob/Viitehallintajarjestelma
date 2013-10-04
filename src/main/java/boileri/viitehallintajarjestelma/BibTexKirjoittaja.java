package boileri.viitehallintajarjestelma;


import boileri.viitehallintajarjestelma.domain.Viite;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class BibTexKirjoittaja {
    
    FileWriter fw;
    String tiedostonimi;
    
   
    public boolean writeBibTex(List<Viite> viitteet, String tiedostonimi){
        
        this.tiedostonimi = tiedostonimi;
        if(tiedostonimi.equals("")){
            tiedostonimi = "uusi.bib";
        } else{
            tiedostonimi += ".bib";
        }
        try {
            if(fw == null){
                fw = new FileWriter(new File(tiedostonimi));
            }
            for (Viite viite : viitteet) {
                String temp = viite.toBibTex();
                temp = temp.replaceAll("ä", "\"{a}");
                temp = temp.replaceAll("ö", "\"{o}");
                fw.write(temp);
            }
            fw.close();
        } catch (IOException ex) {
            return false;
        }      
        return true;
    }

    public BibTexKirjoittaja() {
    }
    
    //Toinen konstruktori vain testausta varten. 
    public BibTexKirjoittaja(FileWriter fw){
        this.fw = fw;
    }
    
}


import boileri.viitehallintajarjestelma.domain.Viite;
import java.io.FileWriter;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class BibTexGeneraattori {
    
    FileWriter fw;
    String tiedostonimi;
    
    public boolean writeBibTex(List<Viite> viitteet, String tiedostonimi){
        
        this.tiedostonimi = tiedostonimi;
        if(tiedostonimi.equals("")){
            tiedostonimi = "uusi.bib";
        } else{
            tiedostonimi += ".bib";
        }
        
        
        
        return true;
    }
}

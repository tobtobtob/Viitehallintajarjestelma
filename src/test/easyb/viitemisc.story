import boileri.*
import boileri.io.*
import boileri.viitehallintajarjestelma.*
import boileri.viitehallintajarjestelma.dao.*
import boileri.viitehallintajarjestelma.domain.*
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// @author Outt

description 'kayttaja voi listata ja poistaa viitteita'


scenario "kayttaja voi listata viitteet", {
    given 'komento listaa valittu', {
    
          io = new ViiteStubIO("uusi","inproceedings","A","B","C","D","listaa")
          app = new Viitehallintajarjestelma(io)
    
 
    }
    when 'viitteita on olemassa', {
          app.run()
    }
    then 'viitteet tulostuvat', {
          io.getPrints().shouldHave("author: A\ntitle: B\nbooktitle: C\nyear: D")
    }

}



scenario "kayttaja voi poistaa viitteen", {
    given 'komento poista valittu', {
    

          io = new ViiteStubIO("uusi","inproceedings","A","B","C","D","poista","AB")
          app = new Viitehallintajarjestelma(io)
    
 
    }
    when 'viite poistetaan', {
          app.run()
    }
    
    then 'viite on poistettu', {
          io.getPrints().shouldHave("Viite poistettu")
    }

}

scenario "väärä id poiston yhteydessä ilmoittaa asiasta", {
    given 'komento poista valittu', {
    
          io = new ViiteStubIO("poista","ABCDD")
          app = new Viitehallintajarjestelma(io)
    
 
    }
    when 'viite poistetaan', {
          app.run()
    }
    
    then 'viite on poistettu', {
          io.getPrints().shouldHave("Virheellinen tai olematon id")
    }

}
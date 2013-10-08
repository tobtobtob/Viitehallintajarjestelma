import boileri.*
import boileri.io.*
import boileri.viitehallintajarjestelma.*
import boileri.viitehallintajarjestelma.dao.*
import boileri.viitehallintajarjestelma.domain.*
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;

// @author Outt

description 'User can create a new Viite and feel very yay about it and do other stuff as well woohoo'



scenario "kayttaja voi luoda uuden viitteen", {
    given 'komento uusi valittu', {
    
          io = new ViiteStubIO("uusi","inproceedings","A","B","C","D")
          app = new Viitehallintajarjestelma(io)
    
 
    }
    when 'viitteen tiedot syotetty', {
          app.run()
    }
    
    then 'new viite is alive, ALIVE!', {
          io.getPrints().shouldHave("Viite tallennettu!")
    }

}

scenario "kayttaja voi listata viitteet", {
    given 'komento listaa valittu'
    when 'viitteita on olemassa'
    then 'viitteet tulostuvat'

}

scenario "kayttaja voi poistaa viitteen, {
    given 'komento poista valittu'
    when 'viite on olemassa'
    then 'viite poistetaan'

}

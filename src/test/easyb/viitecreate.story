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

description 'käyttäjä voi luoda uuden viitteen olemassaolevalla viitetyypillä'



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

scenario "kayttaja ei voi luoda olematonta viitetta", {
    given 'komento uusi valittu', {
    
          io = new ViiteStubIO("uusi","failviite")
          app = new Viitehallintajarjestelma(io)
    
    }
    when 'vaara viite annettu', {
          app.run()
    }
    
    then 'new viite is not alive, ALIVE!', {
          io.getPrints().shouldHave("Virheellinen tyyppi")
    }

}

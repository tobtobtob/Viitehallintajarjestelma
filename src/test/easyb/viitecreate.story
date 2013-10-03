import boileri.*
import boileri.io.*
import boileri.viitehallintajarjestelma.*
import boileri.viitehallintajarjestelma.dao.*
import boileri.viitehallintajarjestelma.domain.*
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;


description 'User can create a new Viite and feel very yay about it'



scenario "user can create a new viite", {
    given 'command uusi selected', {
    
    io = new ViiteStubIO("uusi","inproceedings","A","B","C","D")
    app = new Viitehallintajarjestelma(io)
    
 
}
    when 'viite data is given', {
    app.run()
}
    
    then 'new viite is alive', {
          io.getPrints().shouldHave("Viite tallennettu!")
}

}


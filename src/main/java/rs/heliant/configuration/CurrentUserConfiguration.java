package rs.heliant.configuration;

import org.springframework.context.annotation.Configuration;
import rs.heliant.entity.KorisnikDO;
import rs.heliant.repository.KorisnikRepository;

@Configuration
public class CurrentUserConfiguration {

    private KorisnikRepository repository;

    public CurrentUserConfiguration(KorisnikRepository repository) {
        this.repository = repository;
    }

    private static KorisnikDO loggedUser;

    public KorisnikDO getLoggedUser(){
        return loggedUser;
    }

    public void setLoggedUser(String username){
        loggedUser = repository.findAll().stream().filter(e->e.getKorisnickoIme().equals(username)).toList().get(0);
    }
}

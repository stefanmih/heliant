package rs.heliant.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.heliant.entity.KorisnikDO;
import rs.heliant.repository.KorisnikRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final KorisnikRepository repository;

    public JwtUserDetailsService(KorisnikRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<KorisnikDO> listKorisnik = repository.findAll().stream().filter(e->e.getKorisnickoIme().equals(username)).toList();
        if (!listKorisnik.isEmpty()) {
            return new User(username, listKorisnik.get(0).getLozinka(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
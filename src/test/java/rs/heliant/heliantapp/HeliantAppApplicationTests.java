package rs.heliant.heliantapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import rs.heliant.repository.FormularRepository;

@SpringBootTest
class HeliantAppApplicationTests {

    @Autowired
    private FormularRepository repository;
    @Test
    void contextLoads() {
        System.out.println(new BCryptPasswordEncoder().encode("stefan"));
    }

}

package rs.heliant.heliantapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
public class HeliantAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeliantAppApplication.class, args);
    }

}

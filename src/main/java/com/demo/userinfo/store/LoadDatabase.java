package com.demo.userinfo.store;

import com.demo.userinfo.models.Address;
import com.demo.userinfo.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            logger.info("Preloading: " + repository.save(
                    new User(1L, "Phillip Rivers", "chargers01", "philip@chargers.com",
                            new Address("123 San Diego Lane", "San Diego", "92131"),
                            "858-555-5555")));
            logger.info("Preloading: " + repository.save(
                    new User(2L, "Shaq Oneil", "lakers01", "shaq@lakers.com",
                            new Address("123 Los Angeles Lane", "Los Angeles", "90001"),
                            "202-555-5555")));
        };
    }
}

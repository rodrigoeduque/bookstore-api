package br.com.rodrigoeduque.bookstore.config;

import br.com.rodrigoeduque.bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    private DBService dbService;

    @Autowired
    public DevConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instanciaBaseDados() {
        if (strategy.equals("create")) {
            dbService.instanciarBaseDados();
        }
        return false;
    }

}

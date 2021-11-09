package br.com.rodrigoeduque.bookstore.config;

import br.com.rodrigoeduque.bookstore.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TesteConfig {

    private DBService dbService;

    @Autowired
    public TesteConfig(DBService dbService) {
        this.dbService = dbService;
    }

    @Bean
    public void instanciaBaseDados() {
        dbService.instanciarBaseDados();
    }
}

package br.com.rodrigoeduque.bookstore;

import br.com.rodrigoeduque.bookstore.domain.Categoria;
import br.com.rodrigoeduque.bookstore.domain.Livro;
import br.com.rodrigoeduque.bookstore.repository.CategoriaRepository;
import br.com.rodrigoeduque.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    LivroRepository livroRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Categoria categoria = new Categoria("Tecnologia da Informação", "Livros técnicos");
        Livro livro = new Livro("Código Limpo", "Martin", "Habilidades Práticas do Agile Software", categoria);
        Livro livro2 = new Livro("Comecando a Programar em Java", "Burd", "Java para Leigos", categoria);

        categoria.getLivros().addAll(Arrays.asList(livro, livro2));

        categoriaRepository.save(categoria);
        livroRepository.save(livro);
        livroRepository.save(livro2);
    }
}

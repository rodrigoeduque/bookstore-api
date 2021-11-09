package br.com.rodrigoeduque.bookstore.services;

import br.com.rodrigoeduque.bookstore.domain.Categoria;
import br.com.rodrigoeduque.bookstore.domain.Livro;
import br.com.rodrigoeduque.bookstore.repository.CategoriaRepository;
import br.com.rodrigoeduque.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    LivroRepository livroRepository;

    public void instanciarBaseDados() {
        Categoria categoria = new Categoria("Tecnologia da Informação", "Livros técnicos");
        Categoria categoria2 = new Categoria("Quadrinhos", "apsjhhansdmansdkah");

        Livro livro = new Livro("Código Limpo", "Martin", "Habilidades Práticas do Agile Software", categoria);
        Livro livro2 = new Livro("Comecando a Programar em Java", "Burd", "Java para Leigos", categoria);
        Livro livro3 = new Livro("Guerra Civil/Guerras Secretas", "Novo Seculo", "Box Marvel", categoria2);

        categoria.getLivros().addAll(Arrays.asList(livro, livro2));
        categoria2.getLivros().addAll(Arrays.asList(livro3));

        categoriaRepository.saveAll(Arrays.asList(categoria, categoria2));
        livroRepository.saveAll(Arrays.asList(livro, livro2, livro3));

    }
}

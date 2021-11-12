package br.com.rodrigoeduque.bookstore.services;

import br.com.rodrigoeduque.bookstore.domain.Livro;
import br.com.rodrigoeduque.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

  private LivroRepository repository;

  @Autowired
  public LivroService(LivroRepository repository) {
    this.repository = repository;
  }

  public Livro findById(Integer id) {
    Optional<Livro> obj = repository.findById(id);
    return obj.orElse(null);
  }
}

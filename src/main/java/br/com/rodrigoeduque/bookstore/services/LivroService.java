package br.com.rodrigoeduque.bookstore.services;

import br.com.rodrigoeduque.bookstore.domain.Livro;
import br.com.rodrigoeduque.bookstore.repository.LivroRepository;
import br.com.rodrigoeduque.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! ID : " + id + ", TIPO : " + Livro.class.getName()));
  }

  public List<Livro> findAll() {
    List<Livro> list = repository.findAll();
    return list;
  }
}

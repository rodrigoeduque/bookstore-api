package br.com.rodrigoeduque.bookstore.services;

import br.com.rodrigoeduque.bookstore.domain.Categoria;
import br.com.rodrigoeduque.bookstore.dtos.categorias.CategoriaDTO;
import br.com.rodrigoeduque.bookstore.repository.CategoriaRepository;
import br.com.rodrigoeduque.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

  private CategoriaRepository categoriaRepository;

  @Autowired
  public CategoriaService(CategoriaRepository categoriaRepository) {
    this.categoriaRepository = categoriaRepository;
  }

  public Categoria findById(Integer id) {
    Optional<Categoria> obj = categoriaRepository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada! ID : " + id + ", TIPO : " + Categoria.class.getName()));
  }

  public List<Categoria> findAll() {
    List<Categoria> obj = categoriaRepository.findAll();
    return obj;
  }

  public Categoria create(Categoria obj) {
    return categoriaRepository.save(obj);
  }
}

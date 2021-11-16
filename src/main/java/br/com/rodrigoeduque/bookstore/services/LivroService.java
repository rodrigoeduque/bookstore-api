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
  private CategoriaService categoriaService;

  @Autowired
  public LivroService(LivroRepository repository, CategoriaService categoriaService) {
    this.repository = repository;
    this.categoriaService = categoriaService;
  }

  public Livro findById(Integer id) {
    Optional<Livro> obj = repository.findById(id);
    return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado! ID : " + id + ", TIPO : " + Livro.class.getName()));
  }

  public List<Livro> findAll() {
    List<Livro> list = repository.findAll();
    return list;
  }

  public List<Livro> findAllByCategoria(Integer id_cat) {
    categoriaService.findById(id_cat);
    List<Livro> allByCategoria = repository.findAllByCategoria(id_cat);
    return allByCategoria;
  }


  public Livro update(Integer id, Livro obj) {
    Livro newObj = findById(id);
    updateData(newObj, obj);
    return repository.save(newObj);

  }

  private void updateData(Livro newObj, Livro obj) {
    newObj.setCategoria(obj.getCategoria());
    newObj.setDescricao(obj.getDescricao());
    newObj.setTitulo(obj.getTitulo());
    newObj.setAutor(obj.getAutor());
  }
}

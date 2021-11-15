package br.com.rodrigoeduque.bookstore.controller;

import br.com.rodrigoeduque.bookstore.domain.Livro;
import br.com.rodrigoeduque.bookstore.dtos.livros.LivroDTO;
import br.com.rodrigoeduque.bookstore.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

  private LivroService service;

  @Autowired
  public LivroController(LivroService service) {
    this.service = service;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Livro> findById(@PathVariable Integer id) {
    Livro obj = service.findById(id);

    return ResponseEntity.ok().body(obj);
  }

  @GetMapping
  public ResponseEntity<List<LivroDTO>> findAll() {
    List<Livro> livros = service.findAll();
    List<LivroDTO> livroDTOS = livros.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
    return ResponseEntity.ok().body(livroDTOS);
  }
}

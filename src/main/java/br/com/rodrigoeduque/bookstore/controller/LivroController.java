package br.com.rodrigoeduque.bookstore.controller;

import br.com.rodrigoeduque.bookstore.domain.Livro;
import br.com.rodrigoeduque.bookstore.dtos.livros.LivroDTO;
import br.com.rodrigoeduque.bookstore.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
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

  @GetMapping("/categoria")
  public ResponseEntity<List<LivroDTO>> findAllByCategory(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
    List<Livro> list = service.findAllByCategoria(id_cat);
    List<LivroDTO> listDto = list.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<LivroDTO> update(@Valid @PathVariable Integer id, @RequestBody Livro obj) {
    Livro newObj = service.update(id, obj);
    LivroDTO livroDTO = new LivroDTO(newObj);
    return ResponseEntity.ok().body(livroDTO);
  }

  @PatchMapping(value = "/{id}")
  public ResponseEntity<Livro> updateParcial(@Valid @PathVariable Integer id, @RequestBody Livro obj) {
    Livro newObj = service.update(id, obj);
    return ResponseEntity.ok().body(newObj);
  }

  @PostMapping
  public ResponseEntity<?> create(@Valid @RequestBody Livro livro) {
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
    Livro obj = service.create(livro);
    return ResponseEntity.created(uri).body(obj);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}

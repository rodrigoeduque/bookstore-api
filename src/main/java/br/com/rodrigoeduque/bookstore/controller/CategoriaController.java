package br.com.rodrigoeduque.bookstore.controller;

import br.com.rodrigoeduque.bookstore.domain.Categoria;
import br.com.rodrigoeduque.bookstore.dtos.categorias.CategoriaDTO;
import br.com.rodrigoeduque.bookstore.services.CategoriaService;
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
@RequestMapping("/categorias")
public class CategoriaController {

  private CategoriaService service;

  @Autowired
  public CategoriaController(CategoriaService categoriaService) {
    this.service = categoriaService;
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
    Categoria obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  @GetMapping
  public ResponseEntity<List<CategoriaDTO>> findAll() {
    List<Categoria> list = service.findAll();
    List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }

  @PostMapping
  public ResponseEntity<CategoriaDTO> create(@Valid @RequestBody CategoriaDTO obj) {
    Categoria categoria = new Categoria(obj.getNome(), obj.getDescricao());
    service.create(categoria);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
    return ResponseEntity.created(uri).body(obj);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CategoriaDTO> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
    Categoria newObj = service.update(id, categoriaDTO);
    return ResponseEntity.ok().body(new CategoriaDTO(newObj));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}

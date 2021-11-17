package br.com.rodrigoeduque.bookstore.dtos.livros;

import br.com.rodrigoeduque.bookstore.domain.Livro;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class LivroDTO {

  private Integer id;
  @NotEmpty
  @Size(min = 3, max = 100)
  private String titulo;
  @NotEmpty
  @Size(min = 3, max = 50)
  private String autor;


  public LivroDTO() {
  }

  public LivroDTO(Livro livro) {
    this.id = livro.getId();
    this.titulo = livro.getTitulo();
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}

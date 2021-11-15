package br.com.rodrigoeduque.bookstore.dtos.livros;

import br.com.rodrigoeduque.bookstore.domain.Livro;

public class LivroDTO {

  private Integer id;
  private String titulo;
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

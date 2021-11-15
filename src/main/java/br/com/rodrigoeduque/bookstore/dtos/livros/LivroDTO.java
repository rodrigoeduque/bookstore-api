package br.com.rodrigoeduque.bookstore.dtos.livros;

import br.com.rodrigoeduque.bookstore.domain.Livro;

public class LivroDTO {

  private String titulo;
  private String autor;
  private String descricao;
  private String categoria;

  public LivroDTO() {
  }

  public LivroDTO(Livro livro) {
    this.titulo = livro.getTitulo();
    this.autor = livro.getAutor();
    this.descricao = livro.getAutor();
    this.categoria = livro.getCategoria().getNome();
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}

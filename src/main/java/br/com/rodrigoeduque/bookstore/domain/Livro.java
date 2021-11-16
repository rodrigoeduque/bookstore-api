package br.com.rodrigoeduque.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Livro {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Integer id;
  @NotEmpty
  @Size(min = 3, max = 100)
  private String titulo;
  @NotEmpty
  @Size(min = 3, max = 50)
  private String autor;
  @NotEmpty
  @Size(min = 10, max = 300)
  private String descricao;

  @JsonIgnore
  @NotNull
  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private Categoria categoria;

  public Livro() {
  }

  public Livro(String titulo, String autor, String descricao, Categoria categoria) {
    this.titulo = titulo;
    this.autor = autor;
    this.descricao = descricao;
    this.categoria = categoria;
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

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Livro livro = (Livro) o;
    return id.equals(livro.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

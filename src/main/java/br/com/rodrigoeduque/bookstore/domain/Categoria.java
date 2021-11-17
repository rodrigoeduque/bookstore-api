package br.com.rodrigoeduque.bookstore.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Integer id;
  private String nome;
  private String descricao;

  @OneToMany(mappedBy = "categoria")
  private List<Livro> livros = new ArrayList<>();

  public Categoria() {
  }

  public Categoria(String nome, String descricao) {
    this.nome = nome;
    this.descricao = descricao;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public List<Livro> getLivros() {
    return livros;
  }

  public void setLivros(List<Livro> livros) {
    this.livros = livros;
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
    Categoria categoria = (Categoria) o;
    return id.equals(categoria.id) && nome.equals(categoria.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome);
  }
}

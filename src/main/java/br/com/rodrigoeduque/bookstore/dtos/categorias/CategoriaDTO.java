package br.com.rodrigoeduque.bookstore.dtos.categorias;

import br.com.rodrigoeduque.bookstore.domain.Categoria;

public class CategoriaDTO {

  private String nome;
  private String descricao;

  public CategoriaDTO() {

  }

  public CategoriaDTO(Categoria categoria) {
    this.nome = categoria.getNome();
    this.descricao = categoria.getDescricao();
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

  public CategoriaDTO toModel(Categoria categoria) {
    return new CategoriaDTO(categoria);
  }
}

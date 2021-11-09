package br.com.rodrigoeduque.bookstore.repository;

import br.com.rodrigoeduque.bookstore.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}

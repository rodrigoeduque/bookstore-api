package br.com.rodrigoeduque.bookstore.services;

import br.com.rodrigoeduque.bookstore.domain.Categoria;
import br.com.rodrigoeduque.bookstore.domain.Livro;
import br.com.rodrigoeduque.bookstore.repository.CategoriaRepository;
import br.com.rodrigoeduque.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
  @Autowired
  CategoriaRepository categoriaRepository;
  @Autowired
  LivroRepository livroRepository;

  public void instanciarBaseDados() {
    Categoria categoria = new Categoria("Administração", "Administração Geral");
    Categoria categoria2 = new Categoria("Direito", "Direito Civil");
    Categoria categoria3 = new Categoria("Informática","Linguagem");

    Livro livro = new Livro("O Poder do Hábito - Por Que Fazemos o Que Fazemos na Vida e Nos Negócios", "Duhigg,Charles", "Este livro é um verdadeiro e profundo estudo dos hábitos. Porém, além de mostrar como eles funcionam, o autor Charles Duhigg também consegue explicar como eles podem ser transformados.", categoria);
    Livro livro2 = new Livro("O Jeito Harvard de Ser Feliz - o Curso Mais Concorrido de Uma Das Melhores Universidades do Mundo", "Achor,Shawn", "De repente, você percebe que há algo de errado com aquela pessoa de quem você tanto gosta, ou até mesmo se dá conta de que pode haver algo errado com você", categoria);
    Livro livro3 = new Livro("O Jeito Disney de Encantar Os Clientes", "Disney Institute", "Um delicado poema que conta, com simplicidade, a força e a importância das palavras", categoria);
    Livro livro4 = new Livro("Customer Success", "Steinman,Dan,Mehta,Nick,Murphy,Lincoln", "De onde virá a receita do seu negócio no futuro? Sua empresa ainda é daquelas que têm que “matar um leão por dia” para fechar o mês? Já ouviu falar em receita recorrente? ", categoria);

    Livro livro5 = new Livro("Vade Mecum Compacto - 23ª Edição - 2021", "Diversos", "ypsolon haushuahl nnnbasj, nnasnansn", categoria2);
    Livro livro6 = new Livro("Direito Processual Civil Esquematizado", "Gonçalves, Marcus Vinicius Rios", "Indicada para alunos de graduação e candidatos a concursos públicos, a Coleção Esquematizado® oferece uma obra completa de Direito Processual Civil", categoria2);
    Livro livro7 = new Livro("Direito Tributário - Série Concursos Públicos", "Periandro,Fábio", "O propósito deste trabalho é colaborar, facilitar o ingresso do candidato no cargo público almejado sem repetir aspectos de abordagem da graduação, estabelecendo uma linha de raciocínio que se coaduna com a linguagem exigida pelas bancas examinadoras.", categoria2);

    Livro livro8 = new Livro("Java - Como Programar - 10ª Ed. 2016", "Deitel", "Milhões de alunos e profissionais aprenderam programação e desenvolvimento de software com os livros Deitel", categoria3);
    Livro livro9 = new Livro("Construindo Chatbots Com Python", "Sumit Raj", "Construa seu próprio chatbot usando Python e ferramentas open source", categoria3);


    categoria.getLivros().addAll(Arrays.asList(livro, livro2, livro3,livro4));
    categoria2.getLivros().addAll(Arrays.asList(livro5,livro6,livro7));
    categoria3.getLivros().addAll(Arrays.asList(livro8,livro9));

    categoriaRepository.saveAll(Arrays.asList(categoria, categoria2,categoria3));
    livroRepository.saveAll(Arrays.asList(livro, livro2, livro3,livro4,livro5,livro6,livro7,livro8,livro9));

  }
}

package com.firstwo.firstexample.services;

import java.util.List;
import java.util.Optional;

import com.firstwo.firstexample.model.Produto;
import com.firstwo.firstexample.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  @Autowired
  private ProdutoRepository produtoRepository;

  public List<Produto> obterTodos() {
    return produtoRepository.obterTodos();
  }

  /**
   * Metodo que retorna o produto encontrado pelo seu Id.
   * 
   * @param id do produto que sera localizado
   * @return retorna um produto caso seja encontrado
   */
  public Optional<Produto> obterPorId(Integer id) {
    return produtoRepository.obterPorId(id);
  }

  /**
   * Metodo para adicionar produto na lista
   * 
   * @param produto que será adicionado.
   * @return o produto que foi adicionado na lista
   */
  public Produto adicionar(Produto produto) {
    return produtoRepository.adicionar(produto);
  }

  /**
   * metodo para deletar o produto por id
   * 
   * @param id do produto a ser deletado
   */
  public void deletar(Integer id) {
    produtoRepository.deletar(id);
  }

  /**
   * metodo para atualizar o produto na lista
   * 
   * @param produto que sera atualizado
   * @return o produto apos atualizar a lista
   */
  public Produto atualizar(Integer id, Produto produto) {
    produto.setId(id);

    return produtoRepository.atualizar(produto);
  }
}

package com.firstwo.firstexample.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.firstwo.firstexample.model.Produto;

@Repository
public class ProdutoRepository {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retornar uma lista de produtos
     * 
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Metodo que retorna o produto encontrado pelo seu Id.
     * 
     * @param id do produto que sera localizado
     * @return retorna um produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Metodo para adicionar produto na lista
     * 
     * @param produto que será adicionado.
     * @return o produto que foi adicionado na lista
     */
    public Produto adicionar(Produto produto) {

        ultimoId++;

        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * metodo para deletar o produto por id
     * 
     * @param id do produto a ser deletado
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * metodo para atualizar o produto na lista
     * 
     * @param produto que sera atualizado
     * @return o produto apos atualizar a lista
     */
    public Produto atualizar(Produto produto) {

        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()) {
            throw new InputMismatchException("nao encontrado");
        }

        deletar(produto.getId());

        produtos.add(produto);

        return produto;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.beta.gerenciadordeprodutos.services.produto;

import br.senac.tads.pi3.beta.gerenciadordeprodutos.exceptions.DataSourceException;
import br.senac.tads.pi3.beta.gerenciadordeprodutos.exceptions.ProdutoException;
import br.senac.tads.pi3.beta.gerenciadordeprodutos.model.Produto;
import br.senac.tads.pi3.beta.gerenciadordeprodutos.model.ValidadorProduto;
import br.senac.tads.pi3.beta.gerenciadordeprodutos.repository.contracts.IRepositorio;
import br.senac.tads.pi3.beta.gerenciadordeprodutos.repository.produto.RepositorioProduto;
import java.util.ArrayList;

/**
 *
 * @author Bruna
 */
public class ServicoProduto {
    static IRepositorio repositorio = new RepositorioProduto();
    public static void cadastrarProduto(Produto produto)
            throws ProdutoException {

        //Chama o validador para verificar o cliente
        ValidadorProduto.validar(produto);

        try {
            //Realiza a chamada de inserção na fonte de dados
            repositorio.inserir(produto);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            //throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static void atualizarProduto(Produto produto)
            throws ProdutoException, DataSourceException {
        
        //Chama o validador para verificar o cliente
        ValidadorProduto.validar(produto);

        try {
            //Realiza a chamada de atualização na fonte de dados
            repositorio.atualizar(produto);
            return;
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Realiza a pesquisa de um cliente por nome na fonte de dados
    public static ArrayList<Produto> procurarPeloNome(String nome)
            throws ProdutoException, DataSourceException {
        try {
            //Verifica se um parâmetro de pesquisa não foi informado.
            //Caso afirmativo, realiza uma listagem simples do mock.
            //Caso contrário, realiza uma pesquisa com o parâmetro
            return (ArrayList<Produto>)repositorio.buscarPorNome(nome);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Obtem o cliente com ID informado do mock
    public static Produto buscarIdProduto(Integer id)
            throws ProdutoException, DataSourceException {
        try {
            //Retorna o cliente obtido com o DAO
            return (Produto)repositorio.pegar(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }

    //Exclui o cliente com ID informado do mock
    public static void excluirProduto(Integer id)
            throws ProdutoException, DataSourceException {
        try {
            //Solicita ao DAO a exclusão do cliente informado
            repositorio.deletar(id);
        } catch (Exception e) {
            //Imprime qualquer erro técnico no console e devolve
            //uma exceção e uma mensagem amigável a camada de visão
            e.printStackTrace();
            throw new DataSourceException("Erro na fonte de dados", e);
        }
    }
    
    public static ArrayList<Produto> listar (){
        try {
            return (ArrayList<Produto>) repositorio.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

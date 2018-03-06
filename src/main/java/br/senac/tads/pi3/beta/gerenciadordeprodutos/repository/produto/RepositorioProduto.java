/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.beta.gerenciadordeprodutos.repository.produto;

import br.senac.tads.pi3.beta.gerenciadordeprodutos.connection.ConnectionUtils;
import br.senac.tads.pi3.beta.gerenciadordeprodutos.model.Produto;
import br.senac.tads.pi3.beta.gerenciadordeprodutos.repository.contracts.IRepositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Beto
 */
public class RepositorioProduto implements IRepositorio {

    private Connection connection;

    @Override
    public void inserir(Object entity) throws SQLException {

        try {
            connection = ConnectionUtils.obterConexao();
            Produto produto = (Produto) entity;
            String sql = "INSERT INTO Produto(Nome, Descricao, Preco_Compra, Preco_Venda, Quantidade, Dt_Cadastro) VALUES(?,?,?,?,?,CURRENT_DATE)";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setFloat(3, produto.getPrecoCompra());
            pst.setFloat(4, produto.getPrecoVenda());
            pst.setInt(5, produto.getQuantidade());

            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Produto> listar() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try {
            connection = ConnectionUtils.obterConexao();
            String sql = "SELECT * FROM Produto";

            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("Id"));
                produto.setNome(rs.getString("Nome"));
                produto.setDescricao(rs.getString("Descricao"));
                produto.setPrecoCompra(rs.getFloat("Preco_Compra"));
                produto.setPrecoVenda(rs.getFloat("Preco_Venda"));
                produto.setQuantidade(rs.getInt("Quantidade"));
                produtos.add(produto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }

    @Override
    public Object pegar(Integer id) throws SQLException {
        try {
            connection = ConnectionUtils.obterConexao();
            String sql = "SELECT * FROM Produto WHERE Id = ?";

            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("Id"));
                produto.setNome(rs.getString("Nome"));
                produto.setDescricao(rs.getString("Descricao"));
                produto.setPrecoCompra(rs.getFloat("preco_Compra"));
                produto.setPrecoVenda(rs.getFloat("preco_Venda"));
                produto.setQuantidade(rs.getInt("Quantidade"));
                return produto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void atualizar(Object entity) throws SQLException {
        try {
            connection = ConnectionUtils.obterConexao();
            Produto produto = (Produto) entity;
            String sql = "UPDATE Produto SET nome=?, Descricao=?, preco_Compra=?, preco_Venda=?, Quantidade=? WHERE id=?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setFloat(3, produto.getPrecoCompra());
            pst.setFloat(4, produto.getPrecoVenda());
            pst.setInt(5, produto.getQuantidade());
            pst.setInt(6, produto.getId());

            pst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(Integer id) throws SQLException {

        try {
            connection = ConnectionUtils.obterConexao();
            String sql = "DELETE FROM Produto WHERE id=?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object buscarPorNome(String nome) throws SQLException {
        ArrayList<Produto> produtos = new ArrayList();

        try {
            connection = ConnectionUtils.obterConexao();
            String sql = "SELECT * FROM Produto WHERE LOWER(nome) LIKE ?";

            PreparedStatement pst = connection.prepareStatement(sql);

            pst.setString(1, nome.toLowerCase() + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("Id"));
                produto.setNome(rs.getString("Nome"));
                produto.setDescricao(rs.getString("Descricao"));
                produto.setPrecoCompra(rs.getFloat("preco_Compra"));
                produto.setPrecoVenda(rs.getInt("preco_Venda"));
                produto.setQuantidade(rs.getInt("Quantidade"));
                produtos.add(produto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }
}

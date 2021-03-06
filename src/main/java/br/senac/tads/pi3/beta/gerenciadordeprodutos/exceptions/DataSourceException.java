/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.beta.gerenciadordeprodutos.exceptions;

/**
 *
 * @author Beto
 */
//Indica uma exceção direta com a fonte de dados
public class DataSourceException extends Exception {

    //Construtor que permite informar uma mensagem de erro
    public DataSourceException(String message) {
        super(message);
    }

    //Construtor que permite informar uma mensagem de erro e uma exception base
    public DataSourceException(String message, Throwable cause) {
        super(message, cause);
    }

    //Construtor que permite informar uma exception base
    public DataSourceException(Throwable cause) {
        super(cause);
    }
}


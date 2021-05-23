package com.trepudox.mercadinho.exception.produto;

public class ProdutoNotFoundException extends Exception {

    public ProdutoNotFoundException() {
        super("Esse produto não existe!");
    }

    public ProdutoNotFoundException(String msg) {
        super(msg);
    }

    public ProdutoNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

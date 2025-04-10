package com.StockManager.Exceptions;

public class ProdutNotFoudException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public ProdutNotFoudException(String msg) {
		super(msg);
	}
}

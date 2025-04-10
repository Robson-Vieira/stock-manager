package com.StockManager.Exceptions;

public class MovementNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MovementNotFound(String msg) {
		super(msg);
	}
}

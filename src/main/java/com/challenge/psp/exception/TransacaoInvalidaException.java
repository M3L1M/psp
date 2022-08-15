package com.challenge.psp.exception;

public class TransacaoInvalidaException extends RuntimeException {
	public TransacaoInvalidaException(String mensagem) {
		super(mensagem);
	}
}

package com.challenge.psp.service;

import java.util.List;

import com.challenge.psp.model.entity.Transacao;

public interface TransacaoService {
	List<Transacao> listarTransacao();
	Transacao processarTransacao(Transacao transacao); 
	void validarTransacao(Transacao transacao);
}

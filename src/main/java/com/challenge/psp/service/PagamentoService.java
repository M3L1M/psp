package com.challenge.psp.service;

import java.util.List;

import com.challenge.psp.model.entity.Pagamento;
import com.challenge.psp.model.entity.Transacao;

public interface PagamentoService {
	
	List<Pagamento> listarPagamento();
	Pagamento efetuarPagamento(Transacao transacao);
	Pagamento validarPagamento(Transacao transacao);
}

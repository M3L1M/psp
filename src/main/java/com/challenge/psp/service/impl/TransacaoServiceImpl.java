package com.challenge.psp.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.challenge.psp.exception.TransacaoInvalidaException;
import com.challenge.psp.model.entity.Transacao;
import com.challenge.psp.model.enums.MetodoPagamento;
import com.challenge.psp.model.enums.Status;
import com.challenge.psp.model.repository.TransacaoRepository;
import com.challenge.psp.service.TransacaoService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class TransacaoServiceImpl implements TransacaoService {
	
	private TransacaoRepository repository;
	
	@Override
	public List<Transacao> listarTransacao() {
		List<Transacao> listar=repository.findAll();
		
		return listar;
	}

	@Override
	@Transactional
	public Transacao processarTransacao(Transacao transacao) {
		validarTransacao(transacao);
		return repository.save(transacao);
	}

	@Override
	public void validarTransacao(Transacao transacao) {
		
		if(transacao.getValorTransacao()==null && transacao.getValorTransacao().compareTo(BigDecimal.ZERO)<0) {
			throw new TransacaoInvalidaException("Valor da transacao invalido");
		}
		
		if(transacao.getDescricaoTransacao().trim().equals("") && transacao.getDescricaoTransacao() == null) {
			throw new TransacaoInvalidaException("Descricao invalida");
		}
		
		String metodoPagamento=transacao.getMetodoPagamento().name();
		
		if(metodoPagamento==null && metodoPagamento.trim().equals("")) {
			throw new TransacaoInvalidaException("Metodo de pagamento não informado");
		}
		if(transacao.getNumeroCartao().trim().equals("") && transacao.getNumeroCartao() == null) {
			throw new TransacaoInvalidaException("Numero do cartão não informado");
		}
		
		if(transacao.getPortadorCartao().trim().equals("") && transacao.getPortadorCartao() == null) {
			throw new TransacaoInvalidaException("Nome do portador não informado");
		}
		
		if(transacao.getValidadeCartao() == null) {
			throw new TransacaoInvalidaException("Validade do cartão não informado");
		}
		
		
		if(transacao.getCvv() == null) {
			throw new TransacaoInvalidaException("Codigode verificação do cartão (CVV)");
		}
		
		
		Double taxa=transacao.getValorTransacao().doubleValue();
		if(transacao.getMetodoPagamento()==MetodoPagamento.DEBITO) {
			taxa=taxa-(taxa*0.03);
		}
		
		if(transacao.getMetodoPagamento()==MetodoPagamento.CREDITO) {
			taxa=taxa-(taxa*0.05);
		}
		transacao.setValorTransacao(BigDecimal.valueOf(taxa));
		
	}

	@Override
	public BigDecimal pago() {
		BigDecimal receita=repository.obterPago();
		
		return receita;
	}

	@Override
	public BigDecimal aReceber() {
		BigDecimal receita=repository.obterAReceber();
		return receita;
	}

}

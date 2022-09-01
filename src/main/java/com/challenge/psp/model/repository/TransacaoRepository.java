package com.challenge.psp.model.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.challenge.psp.model.entity.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

	@Query(value="SELECT SUM(t.valorTransacao) FROM Transacao t WHERE t.metodoPagamento='DEBITO'")
	BigDecimal obterPago();
	
	@Query(value="SELECT SUM(t.valorTransacao) FROM Transacao t WHERE t.metodoPagamento='CREDITO'")
	BigDecimal obterAReceber();

}

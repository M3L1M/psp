package com.challenge.psp.model.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import com.challenge.psp.model.enums.MetodoPagamento;


@Entity
@Table(name = "transacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "valor_transacao")
	private BigDecimal valorTransacao;
	
	@Column(name = "descricao_transacao")
	private String descricaoTransacao;
	
	@Column(name = "metodo_pagamento")
	@Enumerated(EnumType.STRING)
	private MetodoPagamento metodoPagamento;
	
	@Column(name = "numero_cartao")
	private String numeroCartao;
	
	@Column(name = "portador_cartao")
	private String portadorCartao;
	 
	@Column(name = "validade_cartao")
	private Date validadeCartao;
	
	@Column(name = "cvv")
	private Integer cvv;
	
	@JoinColumn(name = "id_pagamento")
	@OneToOne(fetch = FetchType.LAZY)
	private Pagamento idPagamento;
	
	
}

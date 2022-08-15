package com.challenge.psp.api.dto;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.challenge.psp.model.entity.Transacao;
import com.challenge.psp.model.enums.MetodoPagamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransacaoDTO {
	private Integer id;
	private BigDecimal valorTransacao;
	private String descricaoTransacao;
	private MetodoPagamento metodoPagamento;
	private String numeroCartao;
	private String portadorCartao;
	private Date validadeCartao;
	private Integer cvv;
}

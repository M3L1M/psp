package com.challenge.psp.api.dto;

import java.time.LocalDate;

import com.challenge.psp.model.entity.Pagamento;
import com.challenge.psp.model.entity.Transacao;
import com.challenge.psp.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagamentoDTO {
	private Integer id;
	private Transacao idTransacao;
	private Status status;
	private LocalDate dataPagamento;
}

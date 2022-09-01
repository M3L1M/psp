package com.challenge.psp.api.resource;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.psp.api.dto.TransacaoDTO;
import com.challenge.psp.exception.TransacaoInvalidaException;
import com.challenge.psp.model.entity.Pagamento;
import com.challenge.psp.model.entity.Transacao;
import com.challenge.psp.service.PagamentoService;
import com.challenge.psp.service.TransacaoService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/transacao")
@AllArgsConstructor
public class TransacaoResource {
	
	private TransacaoService service;
	private PagamentoService pagamentoService;
	
	@GetMapping
	public ResponseEntity listarTransacoes() {
		List<Transacao> listar=service.listarTransacao();
		
		return new ResponseEntity(listar,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity salvarTransacao(@RequestBody TransacaoDTO dto) {
		Transacao transacao=Transacao.builder()
				.valorTransacao(dto.getValorTransacao())
				.descricaoTransacao(dto.getDescricaoTransacao())
				.metodoPagamento(dto.getMetodoPagamento())
				.numeroCartao(dto.getNumeroCartao())
				.portadorCartao(dto.getPortadorCartao())
				.validadeCartao(dto.getValidadeCartao())
				.cvv(dto.getCvv()).build();
		
		try {
			Pagamento salvarPagamento=pagamentoService.efetuarPagamento(transacao);
			
			transacao.setIdPagamento(salvarPagamento);
			Transacao salvarTransacao=service.processarTransacao(transacao);
			
			return new ResponseEntity(salvarTransacao,HttpStatus.CREATED);
		}catch (TransacaoInvalidaException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/pago")
	public ResponseEntity obterPago() {
		BigDecimal pago=service.pago();
		
		return ResponseEntity.ok(pago);
	}
	
	@GetMapping("/receber")
	public ResponseEntity obterAReceber() {
		BigDecimal receber=service.aReceber();
		
		return ResponseEntity.ok(receber);
	}
	
	
	
	
}

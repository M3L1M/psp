package com.challenge.psp.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.challenge.psp.model.entity.Pagamento;
import com.challenge.psp.model.entity.Transacao;
import com.challenge.psp.model.enums.MetodoPagamento;
import com.challenge.psp.model.enums.Status;
import com.challenge.psp.model.repository.PagamentoRepository;
import com.challenge.psp.service.PagamentoService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PagamentoServiceImpl implements PagamentoService {

	private PagamentoRepository repository;
	
	@Override
	public List<Pagamento> listarPagamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Pagamento efetuarPagamento(Transacao transacao) {
		Pagamento pagamento=validarPagamento(transacao);
		return repository.save(pagamento);
	}

	@Override
	public Pagamento validarPagamento(Transacao transacao) {
		Pagamento pagamento=new Pagamento();
		
		if(transacao.getMetodoPagamento()==MetodoPagamento.DEBITO) {
			pagamento.setStatus(Status.PAGO);
			pagamento.setDataPagamento(LocalDate.now());
		}
		
		if(transacao.getMetodoPagamento()==MetodoPagamento.CREDITO) {
			pagamento.setStatus(Status.A_RECEBER);
			LocalDate data=LocalDate.now();
			
			int dia=data.getDayOfYear()+30;
			data=data.withDayOfYear(dia);
			
			pagamento.setDataPagamento(data);
			
		}
		
		return pagamento;
		
	}

}

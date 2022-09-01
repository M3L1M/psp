package com.challenge.psp.model.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.challenge.psp.model.entity.Pagamento;
import com.challenge.psp.model.enums.Status;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

	

}

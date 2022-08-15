package com.challenge.psp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.psp.model.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}

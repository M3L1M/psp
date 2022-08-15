package com.challenge.psp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.psp.model.entity.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}

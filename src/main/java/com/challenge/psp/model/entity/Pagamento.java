package com.challenge.psp.model.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.challenge.psp.model.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "data_pagamento")
	private LocalDate dataPagamento;
}

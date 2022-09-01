package com.challenge.psp.model.repository;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.challenge.psp.model.entity.Pagamento;
import com.challenge.psp.model.enums.Status;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class PagamentoRepositoryTest {
	@Autowired
	PagamentoRepository repository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void salvarUmPagamento() {
		Pagamento pagamento=criarPagamentoDebito();
		pagamento=repository.save(pagamento);
		assertThat(pagamento.getId()).isNotNull();
	}

	
	public static Pagamento criarPagamentoDebito() {
		return Pagamento.builder().dataPagamento(LocalDate.now()).status(Status.PAGO).build();
	}
}

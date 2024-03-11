package b_exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import b_exercicio_conta_bancaria.Banco;
import b_exercicio_conta_bancaria.ContaBancaria;
import b_exercicio_conta_bancaria.ContaCorrente;
import b_exercicio_conta_bancaria.ContaEspecial;
import b_exercicio_conta_bancaria.ContaPoupanca;

class BancoTest {
	List<ContaBancaria> contas;
	Banco banco;
	
	@BeforeEach
	void inicializaTest() {
		contas = new ArrayList<>();
		ContaBancaria contaBancaria = new ContaBancaria(1, 4000);
		ContaCorrente contaCorrente = new ContaCorrente(2, 5000);
		ContaEspecial contaEspecial = new ContaEspecial(3, 6000, 5000);
		ContaPoupanca contaPoupanca = new ContaPoupanca(4, 7000);
		contas.add(contaBancaria);
		contas.add(contaCorrente);
		contas.add(contaEspecial);
		contas.add(contaPoupanca);
	}
	
	@Test
	void bancoTest() {
		banco = new Banco(contas);
		assertEquals(banco.getContas().size(), 4);
	}

}

package b_exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import b_exercicio_conta_bancaria.ContaBancaria;
import b_exercicio_conta_bancaria.ContaCorrente;
import b_exercicio_conta_bancaria.ContaEspecial;
import b_exercicio_conta_bancaria.ContaPoupanca;

class ContaBancariaTest {

	ContaBancaria contaCorrente;
	ContaBancaria contaEspecial;
	ContaBancaria contaPoupanca;
	
	@BeforeEach
	public void inicializaConta() {
		contaCorrente = new ContaCorrente(1, 5000);
		contaEspecial = new ContaEspecial(2, 6000, 8000);
		contaPoupanca = new ContaPoupanca(3, 4000);
	}
	
	@Test
	void contaCorrenteDepositoTest() {
		contaCorrente.deposito(500);
		assertEquals(5500, contaCorrente.getSaldo());
	}
	@Test
	void contaCorrenteSaqueTest() {
			contaCorrente.saque(5000);
			assertEquals(0, contaCorrente.getSaldo());
	}
	@Test
	void contaCorrenteTransferenciaTest() {
		ContaBancaria contaTeste = new ContaBancaria(4, 1000);
		contaCorrente.transferencia(contaTeste, 500);
		assertEquals(contaTeste.getSaldo(), 1500);
	}
	@Test
	void contaEspecialDepositoTest() {
		contaEspecial.deposito(500);
		assertEquals(6500, contaEspecial.getSaldo());
	}
	@Test
	void contaEspecialSaqueTest() {
		contaEspecial.saque(14000);
		assertEquals(-8000, contaEspecial.getSaldo());
	}
	@Test
	void contaEspecialTransferenciaTest() {
		ContaBancaria contaTeste = new ContaBancaria(5, 1000);
		contaEspecial.transferencia(contaTeste, 500);
		assertEquals(contaTeste.getSaldo(), 1500);
	}
	@Test
	void contaPoupancaDepositoTest() {
		contaPoupanca.deposito(500);
		assertEquals(4500, contaPoupanca.getSaldo());
	}
	
}

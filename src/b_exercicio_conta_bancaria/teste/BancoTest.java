package b_exercicio_conta_bancaria.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import b_exercicio_conta_bancaria.Banco;
import b_exercicio_conta_bancaria.ContaBancaria;
import b_exercicio_conta_bancaria.ContaCorrente;
import b_exercicio_conta_bancaria.ContaEspecial;
import b_exercicio_conta_bancaria.ContaPoupanca;

class BancoTest {
	
	private Banco banco = new Banco();
	
	@BeforeEach
	void criaConta() {
		banco.adicionarConta(new ContaCorrente(1, 100));
		banco.adicionarConta(new ContaEspecial(2, 100, 500));
		banco.adicionarConta(new ContaPoupanca(3, 100));
	}
	
	@Test
	void depositoTest() {
		List<ContaBancaria> contas = banco.getContas();
		contas.get(0).deposito(100);
		contas.get(1).deposito(100);
		contas.get(2).deposito(100);
	}
	@Test
	void saqueContaCorrenteOkTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(0).saque(50));
		assertEquals(50, contas.get(0).getSaldo());
	}
	@Test
	void saqueContaCorrenteFailTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertFalse(contas.get(0).saque(150));
		assertEquals(100, contas.get(0).getSaldo());
	}
	@Test
	void saqueContaEspecialOkTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(1).saque(50));
		assertEquals(50, contas.get(1).getSaldo());
	}
	@Test
	void saqueContaEspecialOkLimiteTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(1).saque(600));
		assertEquals(-500, contas.get(1).getSaldo());
	}
	@Test
	void saqueContaEspecialFailTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertFalse(contas.get(1).saque(1500));
		assertEquals(100, contas.get(1).getSaldo());
	}
	@Test
	void saqueContaPoupancaOkTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(2).saque(50));
		assertEquals(50, contas.get(2).getSaldo());
	}
	@Test
	void saqueContaPoupancaFailSaldoTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertFalse(contas.get(2).saque(150));
		assertEquals(100, contas.get(2).getSaldo());
	}
	@Test
	void saqueContaPoupancaFailLimiteTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(2).saque(5));
		assertTrue(contas.get(2).saque(5));
		assertTrue(contas.get(2).saque(5));
		assertTrue(contas.get(2).saque(5));
		assertTrue(contas.get(2).saque(5));
		assertFalse(contas.get(2).saque(5));
		assertEquals(75, contas.get(2).getSaldo());
	}
	@Test
	void transferenciaOkTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertTrue(contas.get(0).transferencia(contas.get(1), 100));
		assertEquals(0, contas.get(0).getSaldo());
		assertEquals(200, contas.get(1).getSaldo());
	}
	@Test
	void transferenciaFailSaldoTest() {
		List<ContaBancaria> contas = banco.getContas();
		assertFalse(contas.get(0).transferencia(contas.get(1), 150));
		assertEquals(100, contas.get(0).getSaldo());
		assertEquals(100, contas.get(1).getSaldo());
	}
	
}

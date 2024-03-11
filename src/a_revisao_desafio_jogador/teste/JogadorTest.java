package a_revisao_desafio_jogador.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import a_revisao_desafio_jogador.Jogador;

class JogadorTest {

	Jogador j1;
	Jogador j2;
	
	@BeforeEach
	public void inicializaJogadores() {
		j1 = new Jogador();
		j2 = new Jogador("A", 5, 3);
	}
	
	@Test
	public void construtorVazioTest() {
		assertEquals(999, j1.getCamisa());
		assertEquals(-1, j1.getGols());
		assertEquals("", j1.getNome());
		assertEquals("Jogador [nome = , camisa = 999, gol = -1]", j1.toString());
	}
	@Test
	public void construtorParametros() {
		assertEquals(5, j2.getCamisa());
		assertEquals(3, j2.getGols());
		assertEquals("A", j2.getNome());
		assertEquals("Jogador [nome = A, camisa = 5, gol = 3]", j2.toString());
	}
	

}

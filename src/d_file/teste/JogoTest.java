package d_file.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import d_file.Arquivo;
import d_file.Pergunta;
import d_file.Resposta;

class JogoTest {
	
	private Arquivo jogo = new Arquivo();
	
	@Test
	void carregaArquivoTest() {
		jogo.lerArquivo();
		assertEquals(50, jogo.getPerguntas().size());
		Pergunta quarta = jogo.getPerguntas().get(3);
		assertEquals("O Monte Everest é a montanha mais alta do mundo", quarta.getTitulo());
		assertEquals(true, quarta.isRespostaCorreta());
	}
	@Test
	void fazCorrecaoTest() {
		Pergunta pergunta = new Pergunta("ABCD é EFGH, Falso");
		Resposta r = new Resposta(pergunta, false);
		assertEquals("acerto", r.correcao());
	}
	@Test
	void fazCorrecaoErroTest() {
		Pergunta pergunta = new Pergunta("ABCD é EFGH, Falso");
		Resposta r = new Resposta(pergunta, true);
		assertEquals("erro", r.correcao());
	}

	@Test
	void calculaPontuacaoTest() {
		assertEquals(2, jogo.calculaPontuacao(respostasControladas()));
	}
	
	@Test
	void gravarRespostasTest() {
		ArrayList<Resposta> respostas = respostasControladas();
		jogo.gravaResultado(respostas);
		String conteudoArq = jogo.lerRespostas();
		assertEquals("1,A,acerto\n" + "2,B,acerto\n" + "3,C,erro\n" + "4,D,erro\n", conteudoArq);
	}
	
	private ArrayList<Resposta> respostasControladas(){
		ArrayList<Resposta> respostas = new ArrayList<>();
		Pergunta pa = new Pergunta("A", false);
		Pergunta pb = new Pergunta("B", false);
		Pergunta pc = new Pergunta("C", true);
		Pergunta pd = new Pergunta("D", true);
		respostas.add(new Resposta(pa, false));
		respostas.add(new Resposta(pb, false));
		respostas.add(new Resposta(pc, false));
		respostas.add(new Resposta(pd, false));
		return respostas;
	}
	@Test
	void sorteiaRodada() {
		jogo.lerArquivo();
		Pergunta primeira = jogo.getPerguntas().get(0);
		Pergunta segunda = jogo.getPerguntas().get(1);
		assertEquals("A Grande Muralha da China pode ser vista do espaço", primeira.getTitulo());
		assertEquals("A água ferve a uma temperatura mais alta em altitudes mais elevadas", segunda.getTitulo());
		ArrayList<Pergunta> sorteadas = jogo.sorteiaRodada(10);
		primeira = sorteadas.get(0);
		segunda = sorteadas.get(1);
		assertNotEquals("A Grande Muralha da China pode ser vista do espaço", primeira.getTitulo());
		assertNotEquals("A água ferve a uma temperatura mais alta em altitudes mais elevadas", segunda.getTitulo());
		assertEquals(10, sorteadas.size());
	}
}

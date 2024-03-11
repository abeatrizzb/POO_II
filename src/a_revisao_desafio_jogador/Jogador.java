package a_revisao_desafio_jogador;

public class Jogador {

	private String nome;
	private int camisa;
	private int gols;
	
	public Jogador() {
		setNome("");
		setCamisa(999);
		setGols(-1);
	}
	
	public Jogador(String nome, int camisa, int gol) {
		this.nome = nome;
		this.camisa = camisa;
		this.gols = gol;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCamisa() {
		return camisa;
	}
	public void setCamisa(int camisa) {
		this.camisa = camisa;
	}
	public int getGols() {
		return gols;
	}
	public void setGols(int gol) {
		this.gols = gol;
	}

	@Override
	public String toString() {
		return "Jogador [nome = " + nome + ", camisa = " + camisa + ", gol = " + gols + "]";
	}
}

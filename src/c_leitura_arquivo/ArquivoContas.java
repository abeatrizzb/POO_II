package c_leitura_arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import b_exercicio_conta_bancaria.ContaBancaria;
import b_exercicio_conta_bancaria.ContaCorrente;
import b_exercicio_conta_bancaria.ContaEspecial;
import b_exercicio_conta_bancaria.ContaPoupanca;

public class ArquivoContas {

	public static void main(String[] args) {

		ArrayList<ContaBancaria> contas = new ArrayList<ContaBancaria>();
		try {
			FileReader fr = new FileReader("contas.txt"); // aponta o arquivo
			BufferedReader br = new BufferedReader(fr); // le o arquivo linha por linha
			String linha = ""; // "segura" cada linha de texto
			while ((linha = br.readLine()) != null) { // nesse loop irá ler e colocar o que foi lido na variável
														// enquanto não estiver nulo
				String v[] = linha.split(","); // armazena cada parte da frase em um array (split: divide a frase toda
												// vez que houver ,)
				int nr = Integer.parseInt(v[1]); // transforma a string na posição 1 (numero da conta) em um int
				double saldo = Double.parseDouble(v[2]); // transforma a string na p2 (saldo) em um double
				if (v[0].equals("0")) { // se na posição 0 listar "0" adiciona uma nova conta corrente adicionando num e
										// saldo
					contas.add(new ContaCorrente(nr, saldo)); // adiciona na lista
				}
				if (v[0].equals("1")) { // se na posição 0 listar "1" adiciona uma nova conta poupança adicionando num e
										// saldo
					contas.add(new ContaPoupanca(nr, saldo));
				}
				if (v[0].equals("2")) { // se na posição 0 listar "2" adiciona uma nova conta especial adicionando num,
										// saldo e limite
					double limite = Double.parseDouble(v[3]); // transforma a string na p3 (limite) em um double
					contas.add(new ContaEspecial(nr, saldo, limite));
				}
			}
			br.close(); // lembrar de fechar buffer e file reader
			fr.close();

			for (ContaBancaria c : contas) { // percorre o arrarlist e imprime o toString no console
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package c_leitura_arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import b_exercicio_conta_bancaria.ContaBancaria;
import b_exercicio_conta_bancaria.ContaCorrente;
import b_exercicio_conta_bancaria.ContaPoupanca;

public class ArquivoContas {

	public static void main(String[] args) {
		ArrayList<ContaBancaria> contas = new ArrayList<>();
		try {
			FileReader fr = new FileReader("contas.txt"); //apontador de arquivo
			BufferedReader br = new BufferedReader(fr); //coloca o arquivo em buffer para realizar a leitura linha por linha
			String linha = "";
			while((linha = br.readLine()) != null) {
				String v[] = linha.split(" ,");
				int nr = Integer.parseInt(v[1]);
				double saldo = Double.parseDouble(v[2]);
				ContaCorrente c = new ContaCorrente(Integer.parseInt(v[1]), Double.parseDouble(v[2]));
				System.out.println(c);
				if(v[0].equals("0")) {
					contas.add(new ContaCorrente(nr, saldo));
				}
				if(v[0].equals("1")) {
					contas.add(new ContaPoupanca(nr, saldo));
				}
			}
			
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

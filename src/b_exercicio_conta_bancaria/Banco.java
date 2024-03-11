package b_exercicio_conta_bancaria;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private List<ContaBancaria> contas;

	public Banco() {
		contas = new ArrayList<>();
	}

	public Banco(List<ContaBancaria> contas) {
		this.contas = contas;
	}


	public void adicionarConta(ContaBancaria conta) {
		contas.add(conta);
	}

	public List<ContaBancaria> getContas() {
		return contas;
	}

}

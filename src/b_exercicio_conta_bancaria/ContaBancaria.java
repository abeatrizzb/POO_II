package b_exercicio_conta_bancaria;

public class ContaBancaria {

	protected int numeroConta;
	protected double saldo;

	public ContaBancaria() {
		setNumeroConta(0);
		setSaldo(0);
	}

	public ContaBancaria(int numeroConta, double saldo) {
		setNumeroConta(numeroConta);
		setSaldo(saldo);
	}

	public void deposito(double valor) {
		setSaldo(getSaldo() + valor);
	}

	public boolean saque(double valor) {
		if (valor <= getSaldo()) {
			setSaldo(getSaldo() - valor);
			return true;
		}
		return false;
	}

	public boolean transferencia(ContaBancaria destino, double valor) {
		if (valor <= getSaldo()) {
			setSaldo(getSaldo() - valor);
			destino.deposito(valor);
			return true;
		}
		return false;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldoDisponivel) {
		this.saldo = saldoDisponivel;
	}

}

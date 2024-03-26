package b_exercicio_conta_bancaria;

public class ContaEspecial extends ContaBancaria {

	private double limite;

	public ContaEspecial() {
		super();
		setLimite(0);
	}
	
	public ContaEspecial(int numeroConta, double saldo, double limite) {
		super(numeroConta, saldo);
		setLimite(limite);
	}

	@Override
	public boolean saque(double valor) {
		if (valor <= getSaldo() + getLimite()) {
			setSaldo(getSaldo() - valor);
			return true;
		}
		return false;
	}
	public double getLimite() {
		return limite;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
	@Override
	public String toString() {
		return super.toString()+" - Limite: R$ "+getLimite();
	}
}

package Enum;

public enum Cargo {
	DESENVOLVIMENTO (0.10),
	COMERCIAL (0.15),
	JURIDICO (0.10),
	FINANCEIRO(0.05);
	
	private double porcentagem;
	
	private Cargo(double porcentagem) {
		this.porcentagem = porcentagem;
	}
	
	public double getPorcentagem() {
		return porcentagem;
	}
}

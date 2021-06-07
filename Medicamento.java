package Farmacia;

public class Medicamento extends Produto {

	private static final long serialVersionUID = 1L;

	public String precisaPrescricao() {
		return "Prescrição médica necessária";
	}
	public Medicamento(String nome, int dose, String laboratorio, int valor) {
		super(nome, dose, laboratorio, valor);
		this.categoria = "Saúde";

	}
}

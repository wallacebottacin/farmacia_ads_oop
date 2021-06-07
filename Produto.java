package Farmacia;

import java.io.Serializable;

public abstract class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	private   String nome;
	private   int dose;
	private   String laboratorio;
	private   int valor;
	protected String categoria;
	
	public Produto(String nome, int dose, String laboratorio, int valor2) {
		this.nome = nome;
		this.dose = dose;
		this.laboratorio = laboratorio;
		this.valor = valor2;
	}
	public String toString() {
		String retorno = "";
		retorno += "Nome: "     + this.nome     + "\n";
		retorno += "Dose: "    + this.dose    + " mg\n";
		retorno += "Laboratório: "     + this.laboratorio     + "\n";
		retorno += "Valor: R$ "  + this.valor  + "\n";
		retorno += "Categoria: "  + this.categoria  + "\n";
		retorno += "Prescrição médica: "  + precisaPrescricao()        + "\n";
		return retorno;
	}
	public abstract String precisaPrescricao();
}


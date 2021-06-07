package Farmacia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class GerarProdutos {

	private ArrayList<Produto> produtos;

	public GerarProdutos( ) {
		this.produtos = new ArrayList<Produto>();
	}

	public void adicionaProduto(Produto mani) {
		this.produtos.add(mani);
	}

	public void listarProdutos() {
		for(Produto mani:produtos) {
			System.out.println(mani.toString());
		}
		System.out.println("Total = " + this.produtos.size() + " produtos listados com sucesso!\n");
	}
	
	public void excluirProduto(Produto mani) {
		if (this.produtos.contains(mani)) {
			this.produtos.remove(mani);
			System.out.println("[Produto " + mani.toString() + "excluído com sucesso!]\n");
		}
		else
			System.out.println("Produto inexistente!\n");
	}

	public void excluirProdutos() {
		produtos.clear();
		System.out.println("Produtos excluídos com sucesso!\n");
	}

    public void gravarProdutos()  {
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream (new FileOutputStream("c:\\temp\\Farmacia.dat"));
			for(Produto mani:produtos) {
				outputStream.writeObject(mani);
			}
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (outputStream != null ) {
					outputStream.flush();
					outputStream.close();
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

    public void recuperarProdutos() {
		ObjectInputStream inputStream = null;
		try {
			inputStream	= new ObjectInputStream (new FileInputStream ("c:\\temp\\Farmacia.dat"));
			Object obj = null;
			while((obj = inputStream.readObject ()) != null) {
				if (obj instanceof Medicamento)  
					this.produtos.add((Medicamento)obj);
				else if (obj instanceof Cosmetico)  
					this.produtos.add((Cosmetico)obj);
			}
		}catch (EOFException ex) {     // when EOF is reached
			System.out.println ("End of file reached");
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally{
			try {
				if (inputStream != null ) {
					inputStream.close();
					System.out.println("Produtos recuperados com sucesso!\n");
				}
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {

        GerarProdutos estoque  = new GerarProdutos();

		Medicamento paracetamol    = new Medicamento("Paracetamol", 750, "Teuto", 10);
		Medicamento dipirona = new Medicamento("Dipirona", 500, "Medley", 8);
		Cosmetico  protetorSolar      = new Cosmetico ("Protetor Solar Anthelios",  60, "La Roche-Posay", 97);
		Cosmetico  clareadorPele     = new Cosmetico ("Clareador Vitacid Plus", 1, "TheraSkin", 150);
		estoque.adicionaProduto(paracetamol);
		estoque.adicionaProduto(dipirona);
		estoque.adicionaProduto(protetorSolar);
		estoque.adicionaProduto(clareadorPele);
		estoque.listarProdutos();
		estoque.gravarProdutos();
		estoque.listarProdutos();
		estoque.excluirProdutos();
		estoque.listarProdutos();
		estoque.recuperarProdutos();
		estoque.listarProdutos();
	}

}

package br.nom.wbarbosa.model;

public class Produto {
	String nome;
	double preco;
	String descricao;
	int codigo;

	public Produto(int codigo, String nome, double preco, String descricao) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.codigo = codigo;
	}

}

package br.nom.wbarbosa.model;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(codigo, descricao, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Produto other = (Produto) obj;
		return codigo == other.codigo && Objects.equals(descricao, other.descricao) && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco);
	}

}

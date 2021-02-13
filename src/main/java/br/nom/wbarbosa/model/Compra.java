package br.nom.wbarbosa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Compra {

	int id;
	List<Produto> produtos = new ArrayList<>();

	public Compra(int id, List<Produto> produtos) {
		super();
		this.id = id;
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, produtos);
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
		Compra other = (Compra) obj;
		return id == other.id && Objects.equals(produtos, other.produtos);
	}

}

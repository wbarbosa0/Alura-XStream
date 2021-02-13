package br.nom.wbarbosa.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class CompraTest {

	// @formatter:off 
	String xmlCompra="<compra>\n"
			 +"  <id>18</id>\n"
			 +"  <produtos>\n"
			 +"    <produto codigo=\"1542\">\n"
			 +"      <nome>Geladeira</nome>\n"
			 +"      <preco>2340.0</preco>\n"
			 +"      <descrição>Geladeira 2 portas</descrição>\n"
			 +"    </produto>\n"
			 +"    <produto codigo=\"1586\">\n"
			 +"      <nome>Ferro de passar</nome>\n"
			 +"      <preco>184.0</preco>\n"
			 +"      <descrição>Ferro de passar com vaporizador</descrição>\n"
			 +"    </produto>\n"
			 +"  </produtos>\n"
	         +"</compra>"; 
	// @formatter:on 

	@Test
	public void compraComGeladeiraEFerroDePassarDeveGerarXMLEsperado() {


		Compra compra = geraCompraComGeladeiraEFerroDePassar();

		XStream xstream = configuraXStream();

		String xmlGerado = xstream.toXML(compra);

		assertEquals(xmlCompra, xmlGerado);
	}

	@Test
	public void deveGerarUmaCompraComOsProdutosAdequados() {
		XStream xstream = configuraXStream();

		Compra compraResultado = (Compra) xstream.fromXML(xmlCompra);

		assertEquals((Compra) xstream.fromXML(xmlCompra), compraResultado);
	}

	private Compra geraCompraComGeladeiraEFerroDePassar() {

		Produto geladeira = geladeira();
		Produto ferroDePassar = ferroDePassar();

		List<Produto> produtos = new ArrayList<>();
		produtos.add(geladeira);
		produtos.add(ferroDePassar);

		Compra compra = new Compra(18, produtos);
		return compra;
	}

	private XStream configuraXStream() {
		XStream xstream = new XStream();
		xstream.alias("produto", Produto.class);
		xstream.aliasField("descrição", Produto.class, "descricao");
		xstream.useAttributeFor(Produto.class, "codigo");
		xstream.alias("compra", Compra.class);
		return xstream;
	}

	private Produto ferroDePassar() {
		return new Produto(1586, "Ferro de passar", 184.0, "Ferro de passar com vaporizador");
	}

	private Produto geladeira() {
		return new Produto(1542, "Geladeira", 2340.0, "Geladeira 2 portas");
	}

}

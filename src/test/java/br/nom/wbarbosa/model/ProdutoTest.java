package br.nom.wbarbosa.model;

import static org.junit.Assert.assertEquals;

import java.lang.invoke.MethodHandles;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class ProdutoTest {
	@Test
	public void deveGerarProdutoComOsAtributos() {
		// @formatter:off 
		String resultadoEsperado = "<produto codigo=\"1542\">\n" 
	                             + "  <nome>Geladeira</nome>\n" 
				                 + "  <preco>2340.0</preco>\n"
	                             + "  <descrição>Geladeira 2 portas</descrição>\n" 
				                 + "</produto>";
		// @formatter:on

		Produto geladeira = new Produto(1542, "Geladeira", 2340.0, "Geladeira 2 portas");
		XStream xstream = new XStream();

		System.out.println(MethodHandles.lookup().lookupClass());
		xstream.alias("produto", geladeira.getClass());
		xstream.aliasField("descrição", geladeira.getClass(), "descricao");
		xstream.useAttributeFor(geladeira.getClass(), "codigo");

		String xmlGerado = xstream.toXML(geladeira);

		assertEquals(resultadoEsperado, xmlGerado);

	}

}

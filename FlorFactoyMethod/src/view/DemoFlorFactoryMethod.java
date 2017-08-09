package view;

import factory.FlorFactory;
import factory.FlorI;

public class DemoFlorFactoryMethod {

	public static void main(String[] args) {

		FlorFactory tipoFlor = new FlorFactory();
		FlorI minhaFlor = tipoFlor.gerarFlor("rosa");
		minhaFlor.criarFlor();
		
		minhaFlor = tipoFlor.gerarFlor("margarida");
		minhaFlor.criarFlor();

		minhaFlor = tipoFlor.gerarFlor("orquidea");
		minhaFlor.criarFlor();

	}

}

package view;

import banco.ConexaoBanco;

public class Principal {

	public static void main(String[] args) {
		ConexaoBanco.getInstance().conectar();
		ConexaoBanco.getInstance().desconectar();

	}

}

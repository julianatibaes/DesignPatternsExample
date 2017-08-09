package view;

import tamplate.LoginBiblioteca;

public class Principal {

	public static void main(String[] args) {

		LoginBiblioteca lBib = new LoginBiblioteca();
		if(lBib.valida("root", "1234") == true) {
			System.out.println("Bem vindo!");
		}
		else {
			System.out.println("Senha  ou usuário inválido");
		}

	}

}

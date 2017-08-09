package tamplate;

public abstract class LoginAbstrato {

	public void autoriza() {
		System.out.println("Login autorizado");
	}
	
	public abstract boolean valida(String usuario, String senha);
}

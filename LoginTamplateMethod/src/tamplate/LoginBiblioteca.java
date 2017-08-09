package tamplate;

public class LoginBiblioteca extends LoginAbstrato{

	@Override
	public boolean valida(String usuario, String senha) {
		if(usuario.toLowerCase().equals("root") && senha.equals("1234")) {
			return true;
		}
		return false;
	} 
	
	
}

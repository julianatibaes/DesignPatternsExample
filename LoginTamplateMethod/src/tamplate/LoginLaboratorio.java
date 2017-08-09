package tamplate;

public class LoginLaboratorio extends LoginAbstrato{
	
	@Override
	public boolean valida(String usuario, String senha) {
		if(usuario.toLowerCase().equals("adimn") && senha.equals("1234")) {
			return true;
		}
		return false;
	} 
}

package factory;

public class FlorFactory {
	
	public FlorI gerarFlor(String flor) {
		if (flor == "" || flor == null) {
			return null;
		}
		if (flor.toUpperCase().equals("ROSA")) {
			return new Rosa();
		}
		if (flor.toUpperCase().equals("ORQUIDEA")) {
			return new Orquidea();
		}
		if (flor.toUpperCase().equals("MARGARIDA")) {
			return new Margarida();
		}
		return null;
	}

}

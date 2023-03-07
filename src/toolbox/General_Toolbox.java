package toolbox;

public class General_Toolbox {

	/**
	 * 
	 * @param entrada
	 * @return
	 */
	public static String vectoAstringQuerys(String[] entrada) {
		String salida = "";
		for (int i = 1; i < entrada.length; i++) {
			salida.concat("," + entrada[i] + " ");
		}
		return salida;
	}
}

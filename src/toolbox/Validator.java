package toolbox;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	public static boolean esEmailValido(String email) {
		List<String> proveedores = Arrays.asList("gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "aol.com",
				"icloud.com", "gmx.com", "zoho.com", "protonmail.com", "mail.com");

		String[] partes = email.split("@");
		if (partes.length != 2) {
			return false;
		}

		String dominio = partes[1];
		if (!proveedores.contains(dominio)) {
			return false;
		}

		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:" + Pattern.quote(dominio) + ")$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
}

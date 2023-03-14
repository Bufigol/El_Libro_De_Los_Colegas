package modeling;

import java.util.Date;

import constantes.INT_Constantes;
import toolbox.BBDD_Handeling;
import toolbox.Validator;

public class Persona {
	private String Nombre, Apellido, nick, pwd, email;
	private Date fechaNacimiento;
	private int  Id_Usuario_Unico;

	/**
	 * @param nombre
	 * @param apellido
	 * @param nick
	 * @param pwd
	 * @param email
	 * @param fecha
	 * @param i
	 */
	public Persona(String nombre, String apellido, String nick, String pwd, String email, Date fecha,
			int i) {
		Nombre = nombre;
		Apellido = apellido;
		this.nick = nick;
		this.pwd = pwd;
		if (Validator.esEmailValido(email)) {
			this.email = email;
		} else {
			this.email = "";
		}
		this.fechaNacimiento = fecha;
		Id_Usuario_Unico = i;
		BBDD_Handeling ddbb = new BBDD_Handeling();
		String[] query = { "Nombre", "Apellido", "nick", "pwd", "email", "fechaNacimiento", "Id_Usuario_Unico" };
		if (!ddbb.tablaExiste(INT_Constantes.Tabla_Persona)) {
			ddbb.crearTabla(INT_Constantes.Tabla_Persona, query);
		}
		String[] datos = { nombre, apellido, nick, pwd, email, fecha.toString(), String.valueOf(i) };
		ddbb.insertarDatos(INT_Constantes.Tabla_Persona, datos);
	}

}

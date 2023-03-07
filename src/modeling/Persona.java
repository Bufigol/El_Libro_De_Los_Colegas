package modeling;

import java.util.Date;

import constantes.INT_Constantes;
import toolbox.BBDD_Handeling;
import toolbox.Validator;

public class Persona {
	private String Nombre, Apellido, nick, pwd, email;
	private Date fechaNacimiento;
	private Integer Id_Usuario_Unico;

	/**
	 * @param nombre
	 * @param apellido
	 * @param nick
	 * @param pwd
	 * @param email
	 * @param fecha
	 * @param id_Usuario_Unico
	 */
	public Persona(String nombre, String apellido, String nick, String pwd, String email, Date fecha,
			Integer id_Usuario_Unico) {
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
		Id_Usuario_Unico = id_Usuario_Unico;
		BBDD_Handeling ddbb = new BBDD_Handeling();
		String[] query = { "Nombre", "Apellido", "nick", "pwd", "email", "fechaNacimiento", "Id_Usuario_Unico" };
		if (!ddbb.tablaExiste(INT_Constantes.Tabla_Persona)) {
			ddbb.crearTabla(INT_Constantes.Tabla_Persona, query);
		}
		String[] datos = { nombre, apellido, nick, pwd, email, fecha.toString(), id_Usuario_Unico.toString() };
		ddbb.insertarDatos(INT_Constantes.Tabla_Persona, datos);
	}

}

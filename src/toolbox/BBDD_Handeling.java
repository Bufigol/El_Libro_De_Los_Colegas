package toolbox;

import java.sql.*;

import constantes.INT_Constantes;

public class BBDD_Handeling {
	private Connection connection;

	public BBDD_Handeling() {
		try {
			Class.forName(INT_Constantes.DRIVER);
			connection = DriverManager.getConnection(INT_Constantes.URL, INT_Constantes.USER, INT_Constantes.PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void crearTabla(String tabla, String campos) {
		String query = "CREATE TABLE IF NOT EXISTS " + tabla + "(" + campos + ")";
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void crearTabla(String tabla, String[] campos) {
		String query = campos[0];
		for (int i = 1; i < campos.length; i++) {
			query.concat("," + campos[i] + " ");
		}
		crearTabla(tabla, query);
	}

	public void insertarDatos(String tabla, String valores) {
		String query = "INSERT INTO " + tabla + " VALUES(" + valores + ")";
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertarDatos(String tabla, String[] valores) {
		insertarDatos(tabla, General_Toolbox.vectoAstringQuerys(valores));
	}

	public ResultSet consultarDatos(String tabla, String campos) {
		String query = "SELECT " + campos + " FROM " + tabla;
		Statement statement;
		try {
			statement = connection.createStatement();
			return statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public ResultSet consultarDatos(String tabla, String[] campos) {
		String query = campos[0];
		return consultarDatos(tabla, query);
	}

	/**
	 * En este método, se utiliza la clase DatabaseMetaData para obtener los
	 * metadatos de la base de datos y luego se utiliza el método getTables para
	 * obtener información sobre todas las tablas de la base de datos. Luego, se
	 * utiliza un bucle while para recorrer los resultados y se compara el nombre de
	 * cada tabla con el nombre de la tabla que se desea verificar. Si la tabla
	 * existe, el método devuelve true. Si no existe, el método devuelve false.
	 * 
	 * Es importante tener en cuenta que esta es solo una implementación básica del
	 * método tablaExiste. La implementación final dependerá de las necesidades
	 * específicas de tu proyecto y de la forma en que quieras manejar las
	 * excepciones que puedan ocurrir durante la verificación de la tabla.
	 * 
	 * @param tabla
	 * @return
	 * @throws SQLException
	 */
	public boolean tablaExiste(String tabla) {
		DatabaseMetaData metaData;
		try {
			metaData = connection.getMetaData();
			ResultSet tables = metaData.getTables(null, null, "%", null);
			while (tables.next()) {
				if (tables.getString(3).equalsIgnoreCase(tabla)) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}

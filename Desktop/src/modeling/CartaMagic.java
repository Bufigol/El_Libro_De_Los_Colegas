package modeling;

public class CartaMagic {
	private String nombre;
	private String tipo;
	private String rareza;
	private String[] colores;
	private int fuerza;
	private int resistencia;
	private String texto;

	// Constructor vacío
	public CartaMagic() {
	}

	// Constructor con parámetros
	public CartaMagic(String nombre, String tipo, String rareza, String[] colores, int fuerza, int resistencia,
			String texto) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.rareza = rareza;
		this.colores = colores;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
		this.texto = texto;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getRareza() {
		return rareza;
	}

	public String[] getColores() {
		return colores;
	}

	public int getFuerza() {
		return fuerza;
	}

	public int getResistencia() {
		return resistencia;
	}

	public String getTexto() {
		return texto;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setRareza(String rareza) {
		this.rareza = rareza;
	}

	public void setColores(String[] colores) {
		this.colores = colores;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}

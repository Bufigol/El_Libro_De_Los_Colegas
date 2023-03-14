package testing;

import java.util.Date;

import modeling.Persona;

public class TEsting {

	public static void main(String[] args) {
		Date fecha = new Date();
		fecha.setDate(25);
		fecha.setMonth(06);
		fecha.setYear(1989);
		Persona test = new Persona("Felipe", "Vasquez", "Bufigol", "12345", "felipe2@gmail.con", fecha, 1);
		
	}

}

package ejercicioTema12;

import java.io.Serializable;

/**
 * 
 * @author speedemon -> Antonio Ruiz Benito
 *
 */
public class Contacto implements Serializable{ // implemento Serializable para que la clase pueda ser serializable
	
	/*
	 * Crea la clase Contacto con los atributos nombre (cadena de caracteres) y teléfono (long).
	 * Implementa el constructor, los métodos getters y setters, y el método toString. Esta clase
	 * debe ser serializable.
	 */

	// Creo los atributos de la clase
	private String nombre;
	private long telefono;
	
	// Creo el constructor
	public Contacto(String nombre, long telefono){
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	// Setters y Getters
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getTelefono() {
		return telefono;
	}
	
	public void setTelefono(long telef) {
		this.telefono = telef;
	}
	
	// Sobrescribo el metodo toString()
	public String toString() {
		return "Nombre -> " + nombre + " - Teléfono -> " + telefono;
	}
	
}

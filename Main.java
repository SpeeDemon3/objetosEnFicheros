package ejercicioTema12;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 
 * @author speedemon -> Antonio Ruiz Benito
 *
 */
public class Main {

	/*
	 * En el programa principal, crea una ArrayList y almacena en él 4 contactos. A continuación,
	 * deberás crear el archivo “Agenda” y recorrer el ArrayList, guardando los objetos que
	 * contiene dentro del archivo.
	 * Por último, lee el archivo para recuperar los contactos, y muestra por pantalla el total de
	 * contactos recuperados y sus datos.
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		// Creo 4 contactos
		Contacto uno = new Contacto("Antonio", 666666666);
		Contacto dos = new Contacto("Arya", 333333333);
		Contacto tres = new Contacto("Patricia", 222222222);
		Contacto cuatro = new Contacto("Chula", 123456789);

		// Creo el arrayList y almaceno 4 contactos
		ArrayList<Contacto> contactos= new ArrayList<>();
		contactos.add(uno); // Añado los objetos al arrayList con el metodo add()
		contactos.add(dos);
		contactos.add(tres);
		contactos.add(cuatro);
		
		// Creo el archivo Agenda
		
		String rutaProyecto = System.getProperty("user.dir"); // Ruta absoluta del proyecto
		
		String sep = File.separator; // Separador del systema donde se ejecute
		
		String rutaArchivo = rutaProyecto + sep + "Agenda"; // Ruta hasta el archivo
		
		File agenda = new File(rutaArchivo); // Creo un objeto File para trabajar con el archivo
		
		
		// Creo un objeto ObjectOutputStream para guardar el objeto en el fichero
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(agenda));
		// Con un bucle for recorro el arrayList y voy insertando los objetos en el fichero
		for (int i = 0; i < contactos.size(); i++) {
			// Con el metodo writeObject() escribo sobre el fichero
			oos.writeObject(contactos.get(i));
		}
		// Cierro el buffer
		oos.close();
		
		// Creo un objeto ObjectInputStream para leer los datos del archivo 'agenda'
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(agenda));
		
		// Creo una variable de tipo Contacto para utilizar dentro del bucle while como condición
		Contacto contLectura;
		
		// Controlo la excepcion EOFExcepcion
		try {
			// Con un bucle while recorro el archivo
			// Realizo un cast para que los datos leidos se conviertan en un objeto Contacto
			// Con el metodo readObject() obtengo los datos
			while((contLectura = (Contacto) ois.readObject()) != null ) {
				System.out.println(contLectura);
			}
			

		} catch (EOFException e) { // Controlo la excepcion cuando el bucle while lea todos los objetos y lance la excepcion EOFExcepcion
			System.out.println("No hay más objetos en el archivo.");
		}
		
		// Cierro la conexión con el archivo
		ois.close();
				
	}

}

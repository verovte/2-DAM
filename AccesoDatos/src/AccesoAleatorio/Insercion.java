package AccesoAleatorio;

import java.io.*;
import java.util.Scanner;

public class Insercion {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		File fichero = new File ("Empleados.dat");

		RandomAccessFile file = new RandomAccessFile (fichero, "rw"); 

		int id, dep ,posicion;

		Double salario;

		char apellido[]= new char[10], aux;

		posicion =0;

		StringBuffer buffer = null; 

		System.out.println("Introduzca el id del empleado :");

		int idInsercion = scanner.nextInt();

		System.out.println("Introduzca el apellido del empleado :");

		String apellidoInsercion = scanner.next();

		System.out.println("Introduzca el departamento del empleado :");

		int depInsercion = scanner.nextInt();

		System.out.println("Introduzca el salario del empleado :");

		double salarioInsercion = scanner.nextDouble();

		for ( ; ; ){

			file.seek (posicion); // NOS POSICIONAMOS 

			id = file.readInt();     // SE OBTIENE EL IDENTIFICADOR DEL EMPLEADO 

			for ( int i =0; i<apellido.length; i++) { 

				aux = file.readChar(); // VA LEYENDO CARACTER A CARACTER EL APELLIDO Y SE GUARDA EL ARRAY APELLIDO 

				apellido[i]=aux;         

			} String apellidos = new String (apellido);

			dep = file.readInt();              // LECTURA DEL DEPARTAMENTO Y SALARIO  

			salario = file.readDouble();

			if (id >0) {

				// SE SITUA AL PRINCIPIO DEL FICHERO
				
				posicion = posicion + 36;

			}

			if(id == idInsercion) {

				System.out.println("Este id ya existe en la base de datos.");

				break;

			}	

			if (file.getFilePointer() ==file.length()) {

				file.writeInt (idInsercion); 

				buffer = new StringBuffer (apellidoInsercion); 

				buffer.setLength(10); // FIJO EN 10 CARACTERES LA LONGITUD DEL APELLIDO 

				file.writeChars (buffer.toString()); 

				file.writeInt(depInsercion); 

				file.writeDouble (salarioInsercion);
				
				// TRIM() => ELIMINA LOS ESPACIOS AL PRINCIPIO Y AL FINAL DE LAS CADENAS

				System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", idInsercion, apellidoInsercion.trim(), depInsercion, salarioInsercion);

				break;  // SI SE HA RECORRIDO TODO EL FICHERO SE SALE                                                                              

			}	

		}

		file.close(); 
		

	}

}

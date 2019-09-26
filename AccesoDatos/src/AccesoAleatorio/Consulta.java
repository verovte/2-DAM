package AccesoAleatorio;

import java.io.*;
import java.util.Scanner;

public class Consulta {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		File fichero = new File ("Empleados.dat");

		RandomAccessFile file = new RandomAccessFile (fichero, "r"); 

		int id, dep ,posicion;

		Double salario;

		char apellido[]= new char[10], aux;

		posicion =0;

		System.out.println("Introduzca el id del empleado que desea consultar :");

		int idConsulta = scan.nextInt();

		for ( ; ; ){
			
			file.seek (posicion); // NOS POSICIONAMOS 

			id = file.readInt();     // SE OBTIENE EL IDENTIFICADOR DEL EMPLEADO 

			for ( int i =0; i<apellido.length; i++) { 

				aux = file.readChar(); // VA LEYENDO CARACTER A CARACTER EL APELLIDO Y SE GUARDA EL ARRAY APELLIDO 

				apellido[i]=aux;       

			} String apellidos = new String (apellido);

			dep = file.readInt();              // LECTURA DEL DEPARTAMENTO Y SALARIO 

			salario = file.readDouble();

			if(id >0) {
				
				// SE SITUA AL PRINCIPIO DEL FICHERO

				posicion = posicion + 36;

			}

			if(id == idConsulta) {
				
				// TRIM() => ELIMINA LOS ESPACIOS AL PRINCIPIO Y AL FINAL DE LAS CADENAS

				System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(), dep, salario);

				break;

			} 


				if(id != idConsulta) {

					System.out.println("El usuario indicado no se encuentra en la base de datos.");

					break;

				} // SI SE HA RECORRIDO TODO EL FICHERO SE SALE 

		}

		file.close();

	}

}

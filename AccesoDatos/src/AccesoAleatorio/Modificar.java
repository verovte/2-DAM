package AccesoAleatorio;

import java.io.*;
import java.util.Scanner;

public class Modificar {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		File fichero = new File("Empleados.dat");

		RandomAccessFile file = new RandomAccessFile(fichero, "rw");

		int id, dep, posicion;

		Double salario, nuevoSalario;

		char apellido[] = new char[10], aux;

		posicion = 0;

		long puntero = 0;

		StringBuffer buffer = null;

		System.out.println("Introduzca el id del empleado :");

		int idModifcacion = scanner.nextInt();

		System.out.println("Introduzca el importe del empleado :");

		double importeModifcacion = scanner.nextDouble();

		for (;;) {

			try {

				file.seek(posicion); // NOS POSICIONAMOS

				id = file.readInt(); // SE OBTIENE EL IDENTIFICADOR DEL EMPLEADO

				if (id == idModifcacion) {

					for (int i = 0; i < apellido.length; i++) {

						aux = file.readChar(); // VA LEYENDO CARACTER A CARACTER EL APELLIDO 

						apellido[i] = aux; // Y SE GUARDA EN EL ARRAY APELLIDO

					}
					String apellidos = new String(apellido);

					file.skipBytes(4);

					salario = file.readDouble();

					puntero = file.getFilePointer() - 8;

					file.seek(puntero);

					nuevoSalario =  importeModifcacion;

					file.writeDouble(nuevoSalario);
					
					// TRIM() => ELIMINA LOS ESPACIOS AL PRINCIPIO Y AL FINAL DE LAS CADENAS

					System.out.printf("ID: %s, Apellido: %s, Salario: %.2f, Nuevo Salario: %.2f %n", id,
							apellidos.trim(), salario, nuevoSalario);

				}

				if (id > 0) {

					// SE SITUA AL PRINCIPIO DEL FICHERO

					posicion = posicion + 36;

				}

				if (file.getFilePointer() == file.length()) {

					System.out.println("Este id no existe en base de datos");

					break; // SI SE HA RECORRIDO TODO EL FICHERO SE SALE DEL FOR

				}

			} catch (EOFException e) {

				break;

			}

		}

		file.close();

	}

}

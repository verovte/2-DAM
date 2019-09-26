package AccesoAleatorio;

import java.io.*;
import java.util.Scanner;

public class Borrado {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

		File fichero = new File ("Empleados.dat");

		RandomAccessFile file = new RandomAccessFile (fichero, "rw"); 

		int id, posicion;

		posicion =0;

		long puntero;

		System.out.println("Introduzca el id del empleado :");

		int idBorrado = scanner.nextInt();

		while(true){

			try {

				file.seek (posicion); // NOS POSICIONAMOS 

				id = file.readInt();     // SE OBTIENE EL IDENTIFICADOR DEL EMPLEADO  

				if(id == idBorrado) {

					puntero = file.getFilePointer()-4;

					file.seek(puntero);

					file.writeInt(-1);

					file.writeInt(idBorrado);

					file.skipBytes(16);

					file.writeInt(0);

					file.writeDouble(0);
					
					System.out.println("Borrado exitoso");

				}

				if (id >0) {

					// SE SITUA AL PRINCIPIO DEL FICHERO

					posicion = posicion + 36;

				}

				if (id != idBorrado) {

					System.out.println("Este id no existe en la base de datos");

					break;  // SI SE HA RECORRIDO TODO EL FICHERO SE SALE                                                                                     // del for 

				}	

			} catch (EOFException e) {

				break;

			}

		}

		file.close(); 

	}

}

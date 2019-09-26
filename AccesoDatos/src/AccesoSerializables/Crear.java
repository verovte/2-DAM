package AccesoSerializables;

import java.io.*;
import java.util.Scanner;

public class Crear {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Departamento dep;
		
		Scanner scan = new Scanner(System.in);
		
		File fichero = new File("departamento.dat");
		
        FileOutputStream fos = new FileOutputStream(fichero);

        DataOutputStream dos = new DataOutputStream(fos);
		
		String nombre, localidad;
		
		int nDepartamento;
		
		System.out.println("Introduce el nº de departamentos a introducir");
		int numDep = scan.nextInt();
		
		for(int i = 0; i < numDep; i ++) {
			
			System.out.println("Nombre del departamento: ");
			nombre = scan.next();
			dos.writeUTF(nombre);
			
			System.out.println("Localidad del departamento: ");
			localidad = scan.next();
			dos.writeUTF(localidad);
			
			System.out.println("Número del departamento: ");
			nDepartamento = scan.nextInt();
			dos.writeInt(nDepartamento);

		}
		
		System.out.println("Fichero creado exitosamente");
		
		fos.close();
		dos.close();

	}

}

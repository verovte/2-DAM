package AccesoSerializables;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Leer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Departamento dep;
		
		File fichero = new File("departamento.dat");
		
		FileInputStream fis = new FileInputStream(fichero);
		
		DataInputStream dis = new DataInputStream(fis);
		
		String nom, loc;
		int nDep;
		
		System.out.println("Nombre\t\tLocalidad\t\tDepartamento");
		
		try {
			while(true) {
				
				nom = dis.readUTF();
				System.out.print(nom + "\t\t");
				
				loc = dis.readUTF();
				System.out.print(loc + "\t\t\t");
				
				nDep = dis.readInt();
				System.out.println(nDep + "\t\t");
				
				System.out.println("");
			
			}
		}catch(EOFException eo) {
			System.out.println("Fin");
		}

	}

}

package AccesoSerializables;

import java.io.*;
import java.io.Serializable;
import java.util.HashMap;

public class Empresas implements Serializable {

	private Departamento dep;

	private FileOutputStream fos;

	private FileInputStream fis;

	private ObjectOutputStream oos;

	private ObjectInputStream ois;

	private HashMap<Integer, Departamento> empresas = new HashMap<Integer, Departamento>();

	
	public void escribir() throws IOException {

		fos = new FileOutputStream("departamento.dat");

		oos = new ObjectOutputStream(fos);

		oos.writeObject(empresas);

		oos.close();

		fos.close();

	}

	public void init() throws IOException, ClassNotFoundException {

		try {

			fis = new FileInputStream("empresas.dat");

			ois = new ObjectInputStream(fis);

			empresas = (HashMap<Integer, Departamento>) ois.readObject();

			ois.close();

			fis.close();

		} catch (FileNotFoundException e) {

			System.out.println("Creando Archivo");

			File archivo = new File("empresas.dat");

			PrintWriter inicializador = new PrintWriter(new FileWriter(archivo));

			inicializador.close();

			init();

		} catch (EOFException e) {

			// ois.close();

			fis.close();

		}

		try {

			System.out.println(empresas.get(1).getNombre());

		} catch (NullPointerException e) {

			System.out.println("No existen departamentos");

		}

	}

	public void contarEmpresas() {

		System.out.println("Actualmente hay registrados " + empresas.size() + " departamentos");

	}

	public void insertarDep() throws NumberFormatException, IOException {

		int n;

		String nombre;

		String localidad;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Inroduzca número de Departamento");

		n = Integer.parseInt(entrada.readLine());

		System.out.println("Inroduzca nombre de Departamento");

		nombre = entrada.readLine();

		System.out.println("Inroduzca localidad de Departamento");

		localidad = entrada.readLine();

		dep = new Departamento(nombre, localidad, n);

		empresas.put(n, dep);

		System.out.println("Departamento registrado con éxito");

		escribir();

	}

	public void modificarDep() throws NumberFormatException, IOException {

		int n;

		String nombre;

		String localidad;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		boolean valido;

		do {

			valido = true;

			System.out.println("Inroduzca número de Departamento a modificar");

			n = Integer.parseInt(entrada.readLine());

			if (!empresas.containsKey(n)) {

				System.out.println("No existe el departamento.");

				valido = false;

			}

		} while (!valido);

		System.out.println("Inroduzca nuevo nombre de Departamento");

		nombre = entrada.readLine();

		System.out.println("Inroduzca nueva localidad de Departamento");

		localidad = entrada.readLine();

		dep = new Departamento(nombre, localidad, n);

		empresas.put(n, dep);

		System.out.println("Departamento registrado con éxito");

		escribir();

	}

	public void borrarDep() throws NumberFormatException, IOException {

		int n;

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		boolean valido;

		do {

			valido = true;

			System.out.println("Inroduzca número de Departamento a borrar");

			n = Integer.parseInt(entrada.readLine());

			if (!empresas.containsKey(n)) {

				System.out.println("No existe el departamento.");

				valido = false;

			}

		} while (!valido);

		empresas.remove(n);

		System.out.println("Departamento eliminado con éxito");

		escribir();

		contarEmpresas();

	}

}

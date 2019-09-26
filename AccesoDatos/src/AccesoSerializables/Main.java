package AccesoSerializables;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub

		Empresas empresa = new Empresas();
		
		empresa.init();
		
		empresa.insertarDep();

		empresa.contarEmpresas();
		
		empresa.modificarDep();

		empresa.borrarDep();
		


	}

}

package AccesoSerializables;

import java.io.Serializable;

public class Departamento implements Serializable {

	private String nombre;

	private String localidad;
	
	private int nDepartamento;
	

	public Departamento() {

		

	}

	

	public Departamento( String nombre, String localidad, int nDepartamento) {

		this.nombre=nombre;

		this.localidad=localidad;

		this.nDepartamento=nDepartamento;

	}



	public int getnDepartamento() {

		return nDepartamento;

	}



	public void setnDepartamento(int nDepartamento) {

		this.nDepartamento = nDepartamento;

	}



	public String getNombre() {

		return nombre;

	}



	public void setNombre(String nombre) {

		this.nombre = nombre;

	}



	public String getLocalidad() {

		return localidad;

	}



	public void setLocalidad(String localidad) {

		this.localidad = localidad;

	}

}

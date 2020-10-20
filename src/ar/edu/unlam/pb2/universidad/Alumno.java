package ar.edu.unlam.pb2.universidad;

public class Alumno {

	private Long dni;
	private String apellido;
	
	
	public Alumno(Long dni, String apellido) {
		this.dni = dni;
		this.apellido = apellido;
	}

	
	
	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", apellido=" + apellido + "]";
	}



	public Long getDni() {
		return dni;
	}
	
	
	public void setDni(Long dni) {
		this.dni = dni;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

	//Generamos equals y hashcode para dni
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}



	

	
}

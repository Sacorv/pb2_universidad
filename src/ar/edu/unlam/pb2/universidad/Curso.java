package ar.edu.unlam.pb2.universidad;

import java.util.HashSet;

public class Curso {

	private Long id;
	private String descripcion;  //Ejemplo pb1 turno mañana
	private Materia materia; //ejemplo materia pb1 (el objeto)
	//falta lista de dias ejemplo martes y jueves
	private HashSet<Profesor> profesores = new HashSet<>();
	//lista de alumnos  
	
	public Curso(Long id, String descripcion, Materia materia) {
		this.id = id;
		this.descripcion = descripcion;
		this.materia = materia;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Materia getMateria() {
		return materia;
	}


	public void setMateria(Materia materia) {
		this.materia = materia;
	}


	public HashSet<Profesor> getProfesores() {
		return profesores;
	}


	public void setProfesores(HashSet<Profesor> profesores) {
		this.profesores = profesores;
	}


	
	//Por id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}

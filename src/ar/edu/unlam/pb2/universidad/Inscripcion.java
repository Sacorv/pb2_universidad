package ar.edu.unlam.pb2.universidad;

import java.util.HashSet;

public class Inscripcion {
	private Long id;
	private Curso curso;
	private Integer cicloLectivo;
	private HashSet<Alumno> alumnos = new HashSet<>();
	
	
	
	public Inscripcion(Long id, Curso curso, Integer cicloLectivo) {
	
		this.id = id;
		this.curso = curso;
		this.cicloLectivo = cicloLectivo;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Curso getCurso() {
		return curso;
	}



	public void setCurso(Curso curso) {
		this.curso = curso;
	}



	public Integer getCicloLectivo() {
		return cicloLectivo;
	}



	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}



	public HashSet<Alumno> getAlumnos() {
		return alumnos;
	}



	public void setAlumnos(HashSet<Alumno> alumnos) {
		this.alumnos = alumnos;
	}



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
		Inscripcion other = (Inscripcion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}

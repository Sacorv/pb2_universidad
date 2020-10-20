package ar.edu.unlam.pb2.universidad;

import java.util.ArrayList;
import java.util.HashSet;

public class Universidad {
 
	private String nombre;
	//private ArrayList<Profesor> profesores = new ArrayList <Profesor> ();
	private HashSet<Profesor> profesores = new HashSet<>();
	private HashSet<Alumno> alumnos = new HashSet <> ();
	private HashSet<Materia> materias = new HashSet <> ();
	private HashSet<Curso> cursos = new HashSet <>();
	private HashSet<Inscripcion> inscripciones = new HashSet<>();
	
	
	public Universidad(String nombre) {
		this.nombre = nombre;
	}


	public Boolean agregarProfesor(Profesor profesor) {
		//if(!this.profesores.contains(profesor)) {
			return this.profesores.add(profesor);
			
			//return true;
		//}
		//return false;
	}
	
	//BUSCAR PROFESOR POR ID
	public Profesor buscarProfesor(Long id) {
		for(Profesor profesor : this.profesores) {
			if(profesor.getId().equals(id)) {
				return profesor;
			}
		}
		return null;
	}
	
//	public Profesor buscarProfesor(Profesor profesor) {

//		return null;
//	}
	
	
	
	
	//Agrega un alumno a la coleccion alumnos
	public Boolean inscribirAlumno(Alumno alumno) {
		
		return alumnos.add(alumno);
	}
	
	//Busca un alumno por dni
	public Alumno buscarAlumno(Long dni) {
		for(Alumno alumno : this.alumnos) {
			if(alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		return null;
	}
	
	
	
	//agrega materia a la coleccion materias
	public Boolean agregarMateria(Materia materia) {
		
		return this.materias.add(materia);
	}
	
	//Busca materia por id
	public Materia buscarMateria(Long id) {
		for (Materia materia : materias) {
			if(materia.getId().equals(id)) {
				return materia;
			}
		}
		return null;
	}
	
	//Elimina materia buscandola por id
	public Boolean eliminarMateria(Long id) {
		Materia materiaBuscada = buscarMateria(id);
		
		if(materiaBuscada!=null) {
			return this.materias.remove(materiaBuscada);
		}
		
		return false;
	}
	
	
	
	//Si la materia que esta en el curso pasado por parametro, existe en la universidad, agrego el curso a la universidad
	public Boolean agregarCurso(Curso curso) {
		Materia materiaABuscar = buscarMateria(curso.getMateria().getId());
		if(materiaABuscar!=null) {
			return this.cursos.add(curso);
		}
		return false;
	}
	
	public Curso buscarCurso(Long id) {
		for(Curso curso : this.cursos) {
			if(curso.getId().equals(id)) {
				return curso;
			}
		}
		return null;
	}
	
	
	//verifico que el curso este registrado en la universidad y despues verifico si el profe que quiero
	//asignar al curso esta registrado en la universidad, entonces lo agrego a la lista de profes que tiene
	//ese curso.
	public Boolean agregarProfesoresAUnCurso(Long idCurso, Profesor profesor) {
		Boolean profesorAgregadoCorrectamente = false;
		
		Curso cursoBuscado = buscarCurso(idCurso);
			if(cursoBuscado!=null) {
				if(buscarProfesor(profesor.getId())!=null) {
					profesorAgregadoCorrectamente = cursoBuscado.getProfesores().add(profesor);
				}
			}
		return profesorAgregadoCorrectamente;
	}

	//Agrega inscripciones a la lista de inscripciones de la universidad
	public Boolean agregarUnaListaDeInscripciones(Inscripcion inscripcion) {
		
		return this.inscripciones.add(inscripcion);	
	}
	
	
	//inscripcion: verifico que la inscripcion este abierta en la universidad, luego verifico que el curso 
	//correspondiente a esa inscripcion exista en la universidad, y por ultimo se inscribe el alumno. 
	public Boolean inscribirAlumnoAUnCurso(Long idInscripcion, Alumno alumno) {
		
		for(Inscripcion inscripcion : this.inscripciones) {
			if(inscripcion.getId().equals(idInscripcion)) {
				if(buscarCurso(inscripcion.getCurso().getId())!= null) {
					if(buscarAlumno(alumno.getDni())!=null) {
						return inscripcion.getAlumnos().add(alumno);
					}
				}
			}
		}
		return false;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public HashSet<Profesor> getProfesores() {
		return profesores;
	}


	public void setProfesores(HashSet<Profesor> profesores) {
		this.profesores = profesores;
	}


	public HashSet<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(HashSet<Alumno> alumnos) {
		this.alumnos = alumnos;
	}


	public HashSet<Materia> getMaterias() {
		return materias;
	}


	public void setMaterias(HashSet<Materia> materias) {
		this.materias = materias;
	}


	public HashSet<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(HashSet<Curso> cursos) {
		this.cursos = cursos;
	}
	
	
	
	
	
}

package ar.edu.unlam.pb2.universidad;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniversidadTest {

	@Test
	public void queSePuedaAgregarUnProfesorALaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		Profesor moreira = new Profesor(1L, "ruben");
		
		assertTrue(unlam.agregarProfesor(moreira));
	}

	
	@Test
	public void queNoSePuedaAgregarUnProfesorDuplicadoALaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		Profesor moreira = new Profesor(1L, "ruben");
		unlam.agregarProfesor(moreira);
		Profesor borgeat = new Profesor(1L, "ruben");
		
		assertFalse(unlam.agregarProfesor(borgeat)); 
		//Lo dos profesores tienen el mismo id pero sin embargo me deja agragarlos porq la direccion de memoria es distinta
		//Debemos sobreescribir el metodo Equals y HashCode en clase profesor, para que el programa pueda comparar por los atributos y no por las referencias de memoria
	}
	
	@Test 
	public void queSePuedaEliminarUnaMateria() {
		Universidad unlam = new Universidad("Unlam");
		Materia pb1 = new Materia(1L, "Programacion 1", 1);
		Materia pb2 = new Materia(2L, "Programacion 2", 2);
		
		unlam.agregarMateria(pb1);
		unlam.agregarMateria(pb2);
		
		assertTrue(unlam.eliminarMateria(2L));
		assertNull(unlam.buscarMateria(2L));
		
		assertEquals(1, unlam.getMaterias().size());
	}
	
	@Test
	public void queNoSePuedaEliminarUnaMateriaInexistente() {
		Universidad unlam = new Universidad("Unlam");
		Materia pb1 = new Materia(1L, "Programacion 1", 1);
		
		unlam.agregarMateria(pb1);
		
		assertFalse(unlam.eliminarMateria(5L));
	}
	
	@Test
	public void queSePuedaAgregarUnProfesorAUnCurso() {
		Universidad unlam = new Universidad("Unlam");
		Materia pb1 = new Materia(1L, "Programacion 1", 1);
		Curso pb1TM = new Curso(20L, "Programacion 1, Turno mañana", pb1);
		Profesor moreira = new Profesor(1L, "ruben");
		
		unlam.agregarMateria(pb1);
		unlam.agregarCurso(pb1TM);
		unlam.agregarProfesor(moreira);
		unlam.agregarProfesoresAUnCurso(20L, moreira);
		
		assertEquals(1, pb1TM.getProfesores().size());
	}
	
	
	@Test 
	public void queSePuedaInscribirUnAlumnoAUnCurso() {
		Universidad unlam = new Universidad("Unlam");
		Materia pb1 = new Materia(1L, "Programacion 1", 1);
		unlam.agregarMateria(pb1);
		Alumno kila = new Alumno(356L, "Kila");
		unlam.inscribirAlumno(kila);
		Curso pb1TM = new Curso(20L, "Programacion 1, Turno mañana", pb1);
		unlam.agregarCurso(pb1TM);
		Inscripcion pb1TM1 = new Inscripcion(110L, pb1TM, 2020);
		unlam.agregarUnaListaDeInscripciones(pb1TM1);
		
		
		assertTrue(unlam.inscribirAlumnoAUnCurso(110L, kila));
	}
	
	@Test
	public void queNoSePuedanInscribirAlumnosDuplicadosEnLaUniversidad() {
		Universidad unlam = new Universidad("Unlam");
		Alumno kila = new Alumno(356L, "Kila");
		unlam.inscribirAlumno(kila);
		Alumno dolores = new Alumno(356L, "Kila");
		
		assertFalse(unlam.inscribirAlumno(dolores));
	}
	
	
	
	
	
	
	
}

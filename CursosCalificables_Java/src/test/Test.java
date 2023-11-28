package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import modeloClases.Alumno;
import modeloClases.Curso;
import modeloClases.DiaDeClase;
import modeloClases.Instituto;
import modeloClases.Materia;
import modeloClases.MateriaPresencial;
import modeloClases.MateriaVirtual;
import modeloClases.Turno;

public class Test {
	
	public static void main(String[] args) {
		
		/*
			NO SE DEBE TOCAR ABSOLUTAMENTE NADA DE ESTA CLASE TEST (EXCLUYENTE)
			TAMPOCO ES NECESARIO COMPRENDER CADA LÍNEA DE CÓDIGO ESCRITA AQUÍ.
			SI RESOLVÉS LOS 'TODO' SIGUIENDO LOS PASOS DEL ENUNCIADO, VA A ANDAR ;)
		 */
		
		System.out.println("---- Test creación Instituto inválido ----");		
		Instituto instituto = testCrearInstituto(new ArrayList<Curso>(), null);
		instituto = testCrearInstituto(new ArrayList<Curso>(), "");		
		
		System.out.println("---- Test creación Instituto con datos ficticios ----");	
		List<Curso> cursosConDatosFake = generarDatosFicticios();
		instituto = testCrearInstituto(cursosConDatosFake, "ORT");
		
		System.out.println("---- Test muestra del instituto ----");
		testMostrarInstituto(instituto);		
	}
	
	private static Instituto testCrearInstituto(List<Curso> cursos, String nombre) {
		Instituto retorno = null;
		try {
			retorno = new Instituto(cursos, nombre);
		} catch (RuntimeException e) {
			System.err.println("\t"+ e.getMessage());
		}
		return retorno;
	}
	
	private static void testMostrarInstituto(Instituto instituto) {
		try {
			instituto.mostrar();
		} catch (RuntimeException e) {
			System.err.println("\t"+ e.getMessage());
		}		
	}

	private static void testAgregarMateriaACurso(Curso c, Materia m, Turno t, DiaDeClase d) {
		try {
			c.agregarMateria(m, t, d);
		} catch (RuntimeException e) {
			System.err.println("\t" + e.getMessage());
		}
	}
	
	private static void testAgregarAlumnoAMateria(Materia m, Alumno a) {
		try {
			m.agregarAlumnos(a);
		} catch (RuntimeException e) {
			System.err.println("\t" + e.getMessage());
		}
	}
	
	private static List<Curso> obtenerCursosFicticios() {
		Curso cuW = new Curso("YA-11w");
		Curso cuX = new Curso("BE-11x");
		return new ArrayList<>(Arrays.asList(new Curso[] {cuW, cuX}));
	}
	
	private static List<Materia> obtenerMateriasFicticias() {
		Materia fp = new MateriaVirtual("FP", "Fundamentos de Programación");
		Materia p1 = new MateriaVirtual("P1", "Programación I");
		Materia thp = new MateriaPresencial("THP", "Taller de herramientas de Programación");
		Materia tp1 = new MateriaPresencial("TP1", "Taller de Programación I");
		return new ArrayList<>(Arrays.asList(new Materia[] {fp, p1, thp, tp1}));
	}
	
	private static List<Alumno> obtenerAlumnosFicticios() {
		Alumno a23 = new Alumno(23, "Dibu Martínez");
		Alumno a7 = new Alumno(7, "Rodrigo De Paul");
		Alumno a10 = new Alumno(10, "Leo Messi");
		Alumno a13 = new Alumno(13, "Cuti Romero");
		Alumno a11 = new Alumno(11, "Ángel Di María");	
		return new ArrayList<>(Arrays.asList(new Alumno[] {a23, a7, a10, a13, a11}));
	}

	private static List<Curso> generarDatosFicticios() {
		System.out.println("Generando datos ficticios...");
		
		List<Curso> cursos = obtenerCursosFicticios();
		List<Alumno> alumnos = obtenerAlumnosFicticios();
		List<Materia> materias = obtenerMateriasFicticias();
		
		System.out.println("Agregando alumnos a las materias");
		for (int m = 0; m < materias.size(); m++) {
			Materia materia = materias.get(m);
			for (int a = 0 + (m % 2); a < alumnos.size() - m; a++) {
				Alumno alumno = alumnos.get(a);
				testAgregarAlumnoAMateria(materia, alumno);
			}
		}
		
		System.out.println("Agregando materias a los cursos");
		testAgregarMateriaACurso(cursos.get(0), materias.get(0), Turno.MANIANA, DiaDeClase.LUNES);
		testAgregarMateriaACurso(cursos.get(0), materias.get(2), Turno.MANIANA, DiaDeClase.LUNES);
		testAgregarMateriaACurso(cursos.get(0), materias.get(2), Turno.TARDE, DiaDeClase.LUNES);
		
		testAgregarMateriaACurso(cursos.get(1), materias.get(3), Turno.NOCHE, DiaDeClase.MARTES);
		testAgregarMateriaACurso(cursos.get(1), materias.get(1), Turno.NOCHE, DiaDeClase.JUEVES);		
		testAgregarMateriaACurso(cursos.get(1), materias.get(0), Turno.NOCHE, DiaDeClase.JUEVES);	
		
		return cursos;
	}

}


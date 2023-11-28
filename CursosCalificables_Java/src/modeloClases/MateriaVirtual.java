package modeloClases;

import tdas.implementaciones.PilaNodos;

public class MateriaVirtual extends Materia{
	
	private PilaNodos<Alumno> pilaAlumnos;

	public MateriaVirtual(String id, String nombre) {
		super(id, nombre);
		this.pilaAlumnos = new PilaNodos<>();
	}

	@Override
	public void agregarAlumnos(Alumno a) {
		if (a!= null) {
			this.pilaAlumnos.push(a);
		}
		
	}
	
	@Override
	public void mostrar() {
		super.mostrar();
		PilaNodos<Alumno> aux = new PilaNodos<>();
		Alumno a;
		while (!pilaAlumnos.isEmpty()) {
			aux.push(pilaAlumnos.pop());
		}
		while (!aux.isEmpty()) {
			a= aux.pop();
			a.mostrar();
			pilaAlumnos.push(a);
		}
		
	}

}

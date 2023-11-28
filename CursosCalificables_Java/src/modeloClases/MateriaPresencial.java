package modeloClases;

import tdas.implementaciones.ColaNodos;

public class MateriaPresencial extends Materia{
	
	private ColaNodos<Alumno> colaAlumnos;

	public MateriaPresencial(String id, String nombre) {
		super(id, nombre);
		this.colaAlumnos = new ColaNodos<>();
	}

	@Override
	public void agregarAlumnos(Alumno a) {
		if (a!= null) {
			this.colaAlumnos.add(a);
		}
		
	}
	
	@Override
	public void mostrar() {
		super.mostrar();
		Alumno centinela = new Alumno(0, "CENTINELA");
		Alumno aux;
		
		this.colaAlumnos.add(centinela);
		aux= colaAlumnos.remove();
		
		while(aux != centinela) {
			aux.mostrar();
			colaAlumnos.add(aux);
			aux = colaAlumnos.remove();
		}
	}

}

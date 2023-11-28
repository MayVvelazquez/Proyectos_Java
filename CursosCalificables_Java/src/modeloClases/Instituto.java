package modeloClases;

import java.util.List;

/*TODO Que se vuelva mostrable, así imprime por consola a sus cursos. */

public class Instituto implements Mostrable {
	
	private String nombre;
	private ListaCursosPorCodigo listaCursos;
	/*TODO Resolver atributo/s faltante/s. */

	public Instituto(List<Curso> list, String nombre) {
		setNombre(nombre);
		cargarListaCursos(list);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("NOMBRE INVALIDO");
		}
		this.nombre = nombre;
	}
	
	private void cargarListaCursos(List<Curso> list) {
		if (list == null) {
			throw new IllegalArgumentException("LA LISTA NO PUEDE SER NULA");
		}
		this.listaCursos = new ListaCursosPorCodigo();
		for (Curso curso : list) {
			listaCursos.add(curso);
		}
	}

	@Override
	public void mostrar() {
		System.out.println("Instituto " + getNombre());
		for (Curso curso : listaCursos) {
			curso.mostrar();
		}
	}
	
}

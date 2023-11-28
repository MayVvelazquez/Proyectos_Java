package modeloClases;

/*TODO Que se vuelva identificable y cumpla el contrato correspondiente. */

/*TODO Que se vuelva mostrable, así imprime por consola lo que la hace identificable,
 * su nombre y a sus alumnos inscriptos, siempre en orden de inscripción */

public abstract class Materia implements Mostrable, Identificable<String>{

	private String id;
	private String nombre;
	
	public Materia(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public void mostrar() {
		System.out.println("\t"+"Materia " + getId() + "( " +this.nombre+ ")");
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public boolean sameId(String id) {
		// TODO Auto-generated method stub
		return this.id.equalsIgnoreCase(id);
	}
	
	public abstract void agregarAlumnos(Alumno a);
	
}

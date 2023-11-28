package modeloClases;

/*TODO Que se vuelva identificable y cumpla el contrato correspondiente. */

/*TODO Que se vuelva mostrable, así imprime por consola lo que lo hace identificable y su nombre completo. */
public class Alumno implements Mostrable, Identificable<Integer> {

	private int legajo;
	private String nombreCompleto;
	
	public Alumno(int legajo, String nombreCompleto) {
		super();
		this.legajo = legajo;
		this.nombreCompleto = nombreCompleto;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.legajo;
	}

	@Override
	public boolean sameId(Integer id) {
		// TODO Auto-generated method stub
		return this.legajo == id;
	}

	@Override
	public void mostrar() {
		System.out.println("\t"+ "\t"+ getId() + " - " + this.nombreCompleto);
	}
}

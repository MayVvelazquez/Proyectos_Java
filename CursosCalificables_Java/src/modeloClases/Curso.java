package modeloClases;

import java.util.Iterator;

/*TODO Que se vuelva mostrable, así imprime por consola su código y sus materias existentes. */

public class Curso implements Mostrable{

	private String codigo;
	private Materia[][] grilla;
	
	public Curso(String codigo) {
		setCodigo(codigo);
		this.grilla = new Materia[DiaDeClase.values().length][Turno.values().length];
	}
	
	public void agregarMateria(Materia m, Turno t, DiaDeClase d) {
		if (m == null ) {
			throw new RuntimeException("No se puede agregar una matria en nulo");
		}
		if(grilla[d.ordinal()][t.ordinal()] != null) {
			throw new RuntimeException("Ya hay una materia el " +d+ " a la "+t+" en el curso "+ codigo);
		}
		grilla[d.ordinal()][t.ordinal()]= m;
	}
	/*TODO Desarrollar su constructor. */

	public String getCodigo() {
		return codigo;
	}

	private void setCodigo(String codigo) {
		if (codigo == null || codigo.isEmpty()) {
			throw new IllegalArgumentException("CODIGO INVALIDO");
		}
		this.codigo = codigo;
	}

	@Override
	public void mostrar() {
		System.out.println("El curso " + codigo + " posee las materias ");
		for (int dia = 0; dia < grilla.length; dia++) {
			for (int turno = 0; turno < grilla[dia].length; turno++) {
				if (this.grilla[dia][turno] != null) {
					this.grilla[dia][turno].mostrar();
				}
				
			}
			
		}
	}

	/*TODO Que sepa agregar una materia a cierto día de clase y turno, siempre que no haya otra en ese lugar. */
}

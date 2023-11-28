package modeloClases;

public interface Identificable<T> {

	public T getId();
	public boolean sameId(T id);
}

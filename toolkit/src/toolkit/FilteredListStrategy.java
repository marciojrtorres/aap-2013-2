package toolkit;

public class FilteredListStrategy<T> extends List<T> {

	private ObjectFilter<T> filtro;

	public FilteredListStrategy(ObjectFilter<T> filtro) {
		super();
		this.filtro = filtro;
	}
	
	@Override
	public void append(T o) {
		if (filtro.isInvalid(o)) return;
		super.append(o);
	}
	
	@Override
	public void prepend(T o) {
		if (filtro.isInvalid(o)) return;
		super.prepend(o);
	}
	
	@Override
	public void insert(int i, T o) {
		if (filtro.isInvalid(o)) return;
		super.insert(i, o);
	}
	
}

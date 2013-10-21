package toolkit;

public abstract class FilteredListTemplate<T> 
				extends List<T> {

	@Override
	public void append(T o) {
		if (accept(o)) super.append(o);
	}
	
	@Override
	public void prepend(T o) {
		if (accept(o)) super.prepend(o);
	}
	
	@Override
	public void insert(int i, T o) {
		if (accept(o)) super.insert(i, o);
	}
	
	protected abstract boolean accept(T o);
	
}

package toolkit;

public class List<T> {

    private static final int DEFAULT_LENGTH = 2;

    private Object[] elementos;
    private      int length;


    public List() {
        initialize();        
    }

    private void initialize() {
        this.elementos = new Object[DEFAULT_LENGTH];
        this.length = 0;
    }

    public void append(T o) {    	
        if (o == null) return;
        this.checkCapacity();
        this.elementos[this.length++] = o;
    }

    public void prepend(T o) {
        this.insert(0, o);
    }

    public T get(int i) {
        if (i < 0 || i > this.lastIndex()) return null;
        return (T) this.elementos[i];
    }

    public int length() {
        return this.length;
    }

    public T first() {
        return this.get(0);
    }

    public T last() {
        return this.get(lastIndex());
    }

    public void insert(int i, T o) {        

        if (o == null) return;
        
        if (i > this.lastIndex()) {
            this.append(o);
            return;
        }

        if (i < 0) i = 0;
        
        this.checkCapacity();

        length++;

        for (int j = this.length; j > i; j--) {
            this.elementos[j] = this.elementos[j-1];
        }        

        this.elementos[i] = o;   
    }

    public void wipe() {
        initialize();
    }
    
    public T drop(int i) {
        if (i < 0 || i > this.lastIndex()) return null;
        T ret = get(i);
        for (int j = i; j < this.length; j++) {            
            if (j == this.lastIndex()) this.elementos[j] = null;
            else this.elementos[j] = this.elementos[j+1];        
        }
        this.length--;
        return ret;
    }
    
    public Iterator<T> getIterator() {
    	return new ListIterator<T>();
    }
    

    private int lastIndex() {
        return this.length - 1;
    }

    private void checkCapacity() {        
        boolean hasSpaceForOneMore = this.length + 1 < this.elementos.length;

        if (hasSpaceForOneMore) return;

        this.stretch();
    }


    private void stretch() {
        int doubleSize = this.elementos.length * 2;

        Object[] copy = new Object[doubleSize];

        for (int i = 0; i < this.elementos.length; i++) {
            copy[i] = this.elementos[i];
        }
        
        this.elementos = copy;
    }
    
    @Override
    public String toString() {
    	StringBuilder str = new StringBuilder("[");    	
    	for (int i = 0; i < length(); i++) {
    		str.append(elementos[i] + ", ");
    	}
    	return str.append("]").toString();
    }
    
    
    private class ListIterator<T> 
    			implements Iterator<T> {

    	private int i = 0;
    	
		@Override
		public boolean hasNext() {
			return i < length();
		}

		@Override
		public T next() {
			return (T) get(i++);
		}
    	
    }
    
    
    
}
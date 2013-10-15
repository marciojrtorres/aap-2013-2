package cobaia;

import static java.lang.System.out;
import toolkit.List;
import toolkit.ObjectFilter;

public class Main {
    public static void main(String[] argumentos) {
        	
    	Endereco e1 = new Endereco();
    	e1.setRua("Alfredo Huch");    	
    	
    	Endereco e2 = new Endereco();
    	e2.setRua("General Camara");
    	e2.setNumero("555");
    	
    	List<Endereco> lista = new List<Endereco>();
    	
//    	lista.setFilter(new ObjectFilter<Endereco>() {
//
//			@Override
//			public boolean isInvalid(Endereco o) {
//				return o.getNumero() == null;
//			}
//		});
    	
    	lista.append(e1);
    	lista.append(e2);
        
    	System.out.println(lista); // [Alfredo Huch, General Camara 555]    	      
    	
    	// testaLista();

    }

    
    
    
    
    
	private static void testaLista() {
		ListComContador lista = new ListComContador();
        
        lista.append("aaa");
        lista.append("bbb");
        
        System.out.println(lista.getCont()); 
        
        lista.prepend("ccc");
        
        System.out.println(lista.getCont());
        
        lista.insert(1, "ccc");
        
        System.out.println(lista.getCont());
	}   
}

class ListComContador<T> extends List<T> {
	
	private int cont;
	
	public int getCont() { return cont; }
	
	@Override
	public void append(T o) {
		cont++;
		super.append(o);
	}
	
	@Override
	public void prepend(T o) {
		// cont++;
		super.prepend(o);
	}
	
	@Override
	public void insert(int i, T o) {
		cont++;
		super.insert(i, o);
	}	
	
}



package cobaia;

import toolkit.List;

public class Main {
    public static void main(String[] argumentos) {
        	
    	Cliente c1 = new Cliente();
    	c1.setCodigo(0);
    	c1.setNome("Bruno Lima");
    	c1.setCpf("11122233344");
    	
    	Cliente c2 = new Cliente();
    	c2.setCodigo(12);
    	c2.setNome("Bruno Lima");
    	c2.setCpf("11122233344");
    	
    	ListClienteValido clientes =
    			new ListClienteValido();
    	
    	clientes.append(c1);
    	clientes.append(c2);
    	
    	System.out.println(clientes);
    	
    

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



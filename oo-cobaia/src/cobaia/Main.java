package cobaia;

import toolkit.Iterator;
import toolkit.List;

public class Main {
    public static void main(String[] argumentos) {
        	
    	List<String> nomes = new List<String>();
    	
    	nomes.append("Andrei Garcia");
    	nomes.append("Vinicius Porto");
    	nomes.append("Vinicius Montenegro");
    	nomes.append("Leandro Marques");
    	nomes.append("Marcos Scholl");
    	nomes.append("Bruno Lima");
    	nomes.append("Gabrieli Roldao");
    	nomes.append("Pedro Costa");
    	    
    	for (Iterator<String> it = nomes.getIterator(); it.hasNext();) {
    		System.out.println(it.next());
    	}
    	
    	Iterator<String> it = nomes.getIterator();
    	while (it.hasNext()) System.out.println(it.next());
    	
    	Cliente c1 = new Cliente();    	
    	c1.addTelefone("32334455");
    	c1.addTelefone("32544455");
    	
    	Iterator<String> telefones = c1.getTelefones();
    	while (telefones.hasNext()) {
    		System.out.println(telefones.next());
    	}
    	    	

    }

    
    
    
    
    
    private static void testaTemplateMethod() {
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



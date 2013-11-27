package main;

import java.lang.reflect.Field;
import java.util.Date;

import model.Cliente;
import model.Intervalo;
import model.NaoNulo;

public class Main {

	public static void main(String[] args) {
		Cliente c = new Cliente();
		c.setId(4);
		c.setNome("Paulo Silva");
		c.setDataNascimento(new Date());
		
		refletir(c);
		refletir("");
		refletir(1);

	}
	
	public static void refletir(Object o) {
		Class clazz = o.getClass();
		System.out.println(clazz);
		
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field f : fields) {
			System.out.println(f);
			f.setAccessible(true);
			try {
				System.out.println(f.get(o));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (f.isAnnotationPresent(NaoNulo.class)) {
				System.out.println(f + " tem NaoNulo");
			}
			if (f.isAnnotationPresent(Intervalo.class)) {
				System.out.println(f 
						+ " tem min " 
						+ f.getAnnotation(Intervalo.class).min()
						+ " tem max"
						+ f.getAnnotation(Intervalo.class).max());
			}
		}	
	}
}

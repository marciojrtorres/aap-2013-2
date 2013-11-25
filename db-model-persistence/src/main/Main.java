package main;

import model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		u.setEmail("raquel@uni.com");
		u.setSenha("1234");
		
		System.out.println(u); // id == null
		
		u.save();
		
		
		System.out.println(u); // id?
		

	}

}

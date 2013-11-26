package main;

import model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		new Usuario()
			.setEmail("pedro@hotmail.com")
			.setSenha("3456")
			.save();
		
		Usuario.load(2).setSenha("1212").save();
		
		
//		Usuario u = Usuario.load(1);
//		
//		u.getPerfil().setDataNascimento(new Date());
//		
//		System.out.println(u.getPerfil());
//		
//		u.save();
		
		
		
		
		
//		Usuario u = new Usuario();
//		u.setEmail("manoel223ee22@outlook.com");
//		u.setSenha("123443423423432434234");
//		
//		u.getPerfil().setNome("Manoel");
//		u.getPerfil().setSobrenome("Almeida");
//		
//		u.save();
//		
//		System.out.println(u); // id?
		

	}

}

package web;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import domain.Contato;

public class Server {
	
	private final Contato contato;
	private HttpServer server;
	
	public Server(Contato contato) {
		
		this.contato = contato;
		
		try {
			initializeServer();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	private void initializeServer() throws IOException {
		server = HttpServer.create(new InetSocketAddress(8989), 0);
		
		server.createContext("/contato/altera", new HttpHandler() {
			
			@Override
			public void handle(HttpExchange ex) throws IOException {
				
				Map<String,String> params = new HashMap<String, String>();
				
				String[] pairs = ex.getRequestURI().getQuery().split("&");
				
				for (String pair : pairs) {
					String[] values = pair.split("=");
					params.put(values[0], values[1]);
				}
				
				String responseText = "";
				
				if (params.containsKey("nome")) {
					contato.setNome(params.get("nome"));
					responseText += "Nome do contato alterado para " + params.get("nome") + "; ";
				}
				
				if (params.containsKey("telefone")) {
					contato.setTelefone(params.get("telefone"));
					responseText += "Telefone do contato alterado para " + params.get("telefone") + "; ";
				}
				
			    OutputStream out = ex.getResponseBody();
				ex.sendResponseHeaders(200, responseText.length());
				out.write(responseText.getBytes());
				out.close();
				
			}
		});
		
		server.createContext("/contato/consulta", new HttpHandler() {
			
			@Override
			public void handle(HttpExchange ex) throws IOException {
				
				String responseText = "";
				
				responseText += "O contato se chama " + contato.getNome() 
						+  " e seu telefone eh " + contato.getTelefone();
				
			    OutputStream out = ex.getResponseBody();
				ex.sendResponseHeaders(200, responseText.length());
				out.write(responseText.getBytes());
				out.close();
				
			}
		});
		
	}

	public void start() {
		server.start();
	}
	
	public void stop() {
		server.stop(1000);
	}

}

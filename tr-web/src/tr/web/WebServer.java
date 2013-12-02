package tr.web;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tr.domain.Produto;
import tr.persistencia.ProdutoDAO;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class WebServer {
	
	// acessando o Singleton
	private ProdutoDAO dao = ProdutoDAO.getDAO();
	private HttpServer server;
	
	public WebServer() {
		try {
			initializeServer();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void initializeServer() throws IOException {
		server = HttpServer.create(new InetSocketAddress(9090), 0);
		
		server.createContext("/produto/insere", new HttpHandler() {
			
			@Override
			public void handle(HttpExchange ex) throws IOException {
				
				System.out.println("handling /produto/insere");
				
				Map<String,String> params = new HashMap<String, String>();
				
				String[] pairs = ex.getRequestURI().getQuery().split("&");
				
				for (String pair : pairs) {
					String[] values = pair.split("=");
					params.put(values[0], values[1]);
				}
				
				Produto p = new Produto();
				
				String responseText = "";
				
				if (params.containsKey("descricao")) {
					p.setDescricao(params.get("descricao"));	
					try {
						dao.salva(p);
						responseText += "Produto " + p.getDescricao() + " salvo com o ID " + p.getId();
					} catch (Exception e) {
						responseText += e;
					}
				} else {
					responseText += "descricao nao informada, produto NAO inserido";
				}
				
				System.out.println(responseText);
				
			    OutputStream out = ex.getResponseBody();
				ex.sendResponseHeaders(200, responseText.length());
				out.write(responseText.getBytes());
				out.close();
				
			}
		});
		
		server.createContext("/produto/consulta", new HttpHandler() {
			
			@Override
			public void handle(HttpExchange ex) throws IOException {
				
				System.out.println("handling /produto/consulta");
				
				String responseText = "";
				
				try {
					responseText += dao.lista();
				} catch (Exception e) {
					responseText += e;
				}
				
				System.out.println(responseText);
				
			    OutputStream out = ex.getResponseBody();
				ex.sendResponseHeaders(200, responseText.length());
				out.write(responseText.getBytes());
				out.close();
				
			}
		});
		
	}

	public void start() {
		server.start();
		System.out.println("WebServer running ...");
	}
	
	public void stop() {
		server.stop(1000);
	}

}

package tr.persistencia;

import tr.domain.Produto;

public class ProdutoSalvaEvent {

	private final Produto produto;

	public ProdutoSalvaEvent(Produto p) {
		this.produto = p;
	}

	public Produto getProduto() {
		return produto;
	}	

}

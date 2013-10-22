package cobaia;

import toolkit.Iterator;
import toolkit.List;

// Entidade: tem identidade
// Modelo de Domínio 
// Vai ser persistente? SIM
public class Cliente {
    
    private Integer id; // wrapper de int's
    private String  nome;
    private String  cpf;
    
    private Endereco endereco = new Endereco(); 
    private Genero genero;
    private Boolean vip;

    private List<String> telefones = new List<String>();
    
    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void addTelefone(String t) {
		if (t.startsWith("32")) this.telefones.append(t);
    }

    public Iterator<String> getTelefones() {
        return telefones.getIterator();
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public Boolean isVip() {
        return this.vip;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setCodigo(Integer id) {
        this.id = id;        
    }

    public int getCodigo() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    @Override
    public boolean equals(Object outro) {
    	if (outro == null) return false;
    	if (!(outro instanceof Cliente)) return false;
    	if (outro == this) return true;
    	Cliente outroCliente = (Cliente) outro;
    	if (this.cpf == null || outroCliente.cpf == null) {
    		return false;
    	}
    	return this.cpf.equals(outroCliente.cpf);
    }
    
    @Override
    public int hashCode() {
    	if (cpf == null) return 0;
    	return cpf.hashCode();
    }
    

}
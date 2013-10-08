package cobaia;

import toolkit.List;

// Modelo de Domínio
// Vai ser persistente? SIM
public class Cliente {
    
    private Integer id; // wrapper de int's
    private String  nome;
    
    private Endereco endereco = new Endereco(); 
    private Genero genero;
    private Boolean vip;

    private List telefones = new List();
    
    public void setTelefones(List telefones) {
        this.telefones = telefones;
    }

    public List getTelefones() {
        return telefones;
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



}
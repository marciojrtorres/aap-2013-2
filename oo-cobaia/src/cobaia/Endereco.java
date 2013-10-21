package cobaia;

// Objeto de Valor (Value Object)
// identificado por todos os seus atributos
public class Endereco {

    private String  rua;
    private String  numero;

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return this.rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }
    
    @Override
    public boolean equals(Object o) {
    	if (o == null) return false;
    	if (this == o) return true;
    	if (!(o instanceof Endereco)) return false;
    	Endereco outroEnd = (Endereco) o;
    	return (this.rua.equals(outroEnd.rua) &&
    			 this.numero.equals(outroEnd.numero));	
    }
    
    @Override
    public int hashCode() {
    	return rua.hashCode() + numero.hashCode();
    }
    
}
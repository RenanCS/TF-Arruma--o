package ClassesPrincipais;

public class Pessoa{
	
	public String nome;
	public String CPF;
	public String napto;
	
	Pessoa(String nome, String CPF, String napto){
		
	setNome(nome);
	setCPF(CPF);
	setNapto(napto);
		
	}
	
		
	public Pessoa() {
		
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNapto() {
		return napto;
	}

	public void setNapto(String napto) {
		this.napto = napto;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", CPF=" + CPF + ", napto=" + napto + " ";
	}

	
	


}


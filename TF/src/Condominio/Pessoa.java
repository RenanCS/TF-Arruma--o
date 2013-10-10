package Condominio;

public class Pessoa Comparable <Pessoa> {
	
	public String nome;
	public int CPF;
	public int napto;
	
	Pessoa(String nome, int CPF, int napto){
		
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

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public int getNapto() {
		return napto;
	}

	public void setNapto(int napto) {
		this.napto = napto;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", CPF=" + CPF + ", napto=" + napto + " ";
	}

	
	


}


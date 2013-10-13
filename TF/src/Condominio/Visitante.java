package Condominio;

public class Visitante extends Pessoa {

private String time; 
	
	Visitante(String nome, int CPF, int napto, int telefone, String time){
	super(nome, CPF, napto);
	setTime(time);
	}
    
	public Visitante() {
		
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Visitante [time=" + time + ", nome=" + nome + ", CPF=" + CPF
				+ ", napto=" + napto + "]";
	}

	
}

package Condominio;

import java.util.List;

public class Visitante extends Pessoa {

private String time; 
	
	Visitante(String nome, String CPF, String napto, String telefone, String time){
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

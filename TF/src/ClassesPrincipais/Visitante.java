package ClassesPrincipais;

import java.util.List;

public class Visitante extends Pessoa {

private String time; 

	public Visitante proxvi;
	public Visitante antvi;

	public Visitante(String nome, String CPF, String napto, String time){
	super(nome, CPF, napto);
	setTime(time);
	proxvi = null;
	antvi = null;
	}
    

	public Visitante getProxvi() {
		return proxvi;
	}

	public void setProxvi(Visitante proxvi) {
		this.proxvi = proxvi;
	}

	public Visitante getAntvi() {
		return antvi;
	}

	public void setAntvi(Visitante antvi) {
		this.antvi = antvi;
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

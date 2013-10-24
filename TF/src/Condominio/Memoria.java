package Condominio;

import java.util.ArrayList;

public class Memoria {


    private ArrayList<Morador> morador; 
	private ArrayList<Visitante> visitante; 
	private int contador;
	
    Memoria(){
    	morador = new ArrayList<Morador>();
    	visitante = new ArrayList<Visitante>();
    }
	
	public void adicionaPes(Visitante vis){
		visitante.add(vis);
		LeituraGravacaoArquivo.gravarDadosVisitante(visitante);
		ContatoTableModel tabela = new ContatoTableModel(visitante);
	}
	
	public void adicionarMorador(Morador mo){
		morador.add(mo);		
		LeituraGravacaoArquivo.gravarDados(morador);
		contador++;
	}
	
	public int tamanhoMorador(){
		contador = visitante.size();
		return contador;
	}
	
}

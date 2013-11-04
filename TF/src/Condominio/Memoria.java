package Condominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ClassesPrincipais.Morador;
import ClassesPrincipais.Visitante;
import DoubleListIterator.ListDoubleLinked;

public class Memoria {

	
    public static ArrayList<Morador> morador = new ArrayList<Morador>(); 
    public static ListDoubleLinked<Visitante> visitante = new ListDoubleLinked<Visitante>(); 
	public static int contador = 0;
	
    public Memoria(){   	

    }
       
    public Memoria(ArrayList listamorador, ListDoubleLinked listavisitante) {
    	morador = new ArrayList<Morador>(listamorador);     	
    	visitante = listavisitante;
    	contador = listamorador.size();
	}
	
	public static void adicionaPes(Visitante vis){
	visitante.add(vis);
	LeituraGravacaoArquivo.gravarDadosVisitante(visitante);
	}
	
	public static void adicionarMorador(Morador mo){
		morador.add(mo);		
		LeituraGravacaoArquivo.gravarDados(morador);
	}
	
	public static int tamanhoMorador(){
		contador = morador.size();
		return contador;
	}
	
	public static String verificarVisitaMorador(String apto){
		String pessoa = null;
		for(Morador mo: morador){
			if(mo.getNapto().equals(apto)){
				pessoa = mo.getNome();
				return pessoa;
			}
		}
		return null;
	}

//	public void adicionaPesLeitura(Visitante pessoaVisitante) {
	//	visitante.add(pessoaVisitante);
//	}
	
}

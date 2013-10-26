	package Condominio;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ClassesPrincipais.Morador;
import ClassesPrincipais.Visitante;


public class LeituraGravacaoArquivo{
		
	
public static void gravarDados(ArrayList<Morador> mo) {
			
			FileWriter arq;
			try {
				arq = new FileWriter("moradores.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				for (int i=0; i<mo.size(); i++)
					{ 
					gravarArq.printf("%s-%s-%s-%s%n", mo.get(i).getNome(), mo.get(i).getCPF(), mo.get(i).getNapto(), mo.get(i).getTelefone()); 
					} 
					gravarArq.close();
				
			} 
			catch (IOException e) {
					e.printStackTrace();
			} 
	
}

public static void gravarDadosVisitante(ArrayList<Visitante> visitante) {
	
	FileWriter arq;
	try {
		arq = new FileWriter("visitante.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		for (int i=0; i<visitante.size(); i++)
			{ 
			gravarArq.printf("%s-%s-%s-%s-%s%n", visitante.get(i).getNome(), visitante.get(i).getCPF(), visitante.get(i).getNapto(), visitante.get(i).getNomemorador(), visitante.get(i).getTime()); 
			} 
			gravarArq.close();
		
	} 
	catch (IOException e) {
			e.printStackTrace();
	} 

}

public static ArrayList lerDadosVisitante() {
	 
	ArrayList<Visitante> vis = new ArrayList<Visitante>();
	Memoria memoria = new Memoria();
	Path path2 = Paths.get("visitante.txt");
	try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset())))
	{
	    sc.useDelimiter("[-\n]"); // separadores: - e nova linha
	    //String header = sc.nextLine(); // pula cabeçalho
	    String nome, cpf, data, telefone, napto, nomemorador; 
	    
	    while (sc.hasNext()) {
	    	nome = sc.next();
	        cpf = sc.next();
	        napto = sc.next();
	        nomemorador = sc.next();
	        data = sc.next();
	        vis.add(PessoaVisitante(nome, cpf, napto, nomemorador, data));
	     }
	    return vis;
	}
	catch (IOException x)
	{
	    System.err.format("Erro de E/S: %s%n", x);
	}
	return null;
}

public static ArrayList LerDadosMorador() {

	ArrayList<Morador> morador = new ArrayList<Morador>();
	Memoria memoria = new Memoria();
	Path path2 = Paths.get("moradores.txt");
	try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset())))
	{
	    sc.useDelimiter("[-\n]"); // separadores: - e nova linha
	    //String header = sc.nextLine(); // pula cabeçalho
	    String nome, cpf, data, telefone, napto, nomemorador; 
	    
	    while (sc.hasNext()) {
	    	nome = sc.next();
	        cpf = sc.next();
	        napto = sc.next();
	        telefone = sc.next();
	        morador.add(PessoaMorador(nome, cpf, napto, telefone));
	     }
	    return morador;
	}
	catch (IOException x)
	{
	    System.err.format("Erro de E/S: %s%n", x);
	}
	return null;
}

private static Visitante PessoaVisitante(String nome, String cpf, String napto, String nomemorador, String data) {
	 Visitante vis;
	 return vis = new Visitante(nome, cpf, napto, nomemorador, data);
}

private static Morador PessoaMorador(String nome, String cpf, String napto, String telefone) {
	Morador mo;
	return mo = new Morador(nome, cpf, napto, telefone);
}


}

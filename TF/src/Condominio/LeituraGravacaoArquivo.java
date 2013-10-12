	package Condominio;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LeituraGravacaoArquivo{
	
	private ArrayList morador;

	LeituraGravacaoArquivo(int x){
	
	if (x==1){gravarDados(morador);}
	else { lerDados();}
	
}
	

	
	

public static void gravarDados(ArrayList<Morador> mo) {
		
		try 
		{	
		
			String caminho = "C:/Users/Renan/git/TF-Arruma--o/TF/src/Condominio/moradores.txt";
			FileWriter escrita = new FileWriter (caminho);
			BufferedWriter gravar = new BufferedWriter(escrita);
			
			for(int i=0; i<mo.size(); i++){	
				gravar.write(mo.get(i).toString());
				gravar.newLine();
			}
		
		}
		catch (IOException x)
		{
		    System.err.format("Erro de E/S: %s%n", x);
		}		
		
}



public void lerDados() {
	Pessoa pes = new Pessoa();
	Memoria memoria = new Memoria();
	
	Path morador = Paths.get("moradores.txt");
	try (Scanner sc = new Scanner(Files.newBufferedReader(morador, Charset.defaultCharset())))
	{
	    sc.useDelimiter("[ ; \n]"); // separadores: ; e nova linha
	    String header = sc.nextLine(); // pula cabeçalho
	    
	    String nome = null;
	    int CPF = 0;
		int napto = 0;
	    
	    while (sc.hasNext()) {
	    	
	    	nome = sc.next();
	        CPF = Integer.parseInt(sc.next());
	        napto = Integer.parseInt(sc.next());
	 
	    	
	    	pes.setNome(nome);
	    	pes.setCPF(CPF);
	    	pes.setNapto(napto);
	    	memoria.adicionaPes(pes);
	     }
	}
	catch (IOException x)
	{
	    System.err.format("Erro de E/S: %s%n", x);
	}
	
}
	
	
			
	
}

	package Condominio;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class LeituraGravacaoArquivo{
		
	

public static void gravarDados(ArrayList<Morador> mo) {
			
			FileWriter arq;
			try {
				arq = new FileWriter("moradores.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				for (int i=0; i<mo.size(); i++)
					{ 
					gravarArq.printf("%s - %s - %s - %s; %n", mo.get(i).getNome(), mo.get(i).getCPF(), mo.get(i).getNapto(), mo.get(i).getTelefone()); 
					} 
					gravarArq.close();
				
			} 
			catch (IOException e) {
					e.printStackTrace();
			} 
	
}


public static void gravarDadosVisitante(ArrayList<Visitante> vis) {
	
	FileWriter arq;
	try {
		arq = new FileWriter("visitante.txt");
		PrintWriter gravarArq = new PrintWriter(arq);
		for (int i=0; i<vis.size(); i++)
			{ 
			gravarArq.printf("%s - %s - %s - %s; %n", vis.get(i).getNome(), vis.get(i).getCPF(), vis.get(i).getNapto(), vis.get(i).getTime()); 
			} 
			gravarArq.close();
		
	} 
	catch (IOException e) {
			e.printStackTrace();
	} 

}



public void lerDados() {
		
	
	}


}

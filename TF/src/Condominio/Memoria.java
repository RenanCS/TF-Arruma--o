package Condominio;

import java.util.ArrayList;

public class Memoria {


    private ArrayList<Pessoa> pessoa;   
	
	Memoria(){
		pessoa = new ArrayList<Pessoa>();
		
	}
	
	public boolean adicionaPes(Pessoa pes){
		return pessoa.add(pes);
	}
	
	
	
}

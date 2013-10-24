package Condominio;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

public class ContatoTableModel extends AbstractTableModel{

		
	private List<Visitante> dados;
	private String[] colunas = {"Visitante", "CPF", "Morador", "Data/Hora"};
	

	
	public ContatoTableModel(){
		dados = new ArrayList<Visitante>();
	}

	public 	ContatoTableModel(List<Visitante> listavisitante){
		dados = new ArrayList<Visitante>(listavisitante);
	}

	/* Retorna a quantidade de colunas. */
    @Override
    public int getColumnCount() {
        // Está retornando o tamanho do array 
        return colunas.length;
    }
    

    /* Retorna a quantidade de linhas. */
    @Override
    public int getRowCount() {
        // Retorna o tamanho da lista de sócios.
        return dados.size();
    }
    
    /* Retorna o nome da coluna no índice especificado.
     * Este método é usado pela JTable para saber o texto do cabeçalho. */
    @Override
    public String getColumnName(int columnIndex) {
        // Retorna o conteúdo do Array que possui o nome das colunas
        // no índice especificado.
        return colunas[columnIndex];
    };
    
    
    /* Retorna a classe dos elementos da coluna especificada.
     * Este método é usado pela JTable na hora de definir o editor da célula. */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Retorna a classe referente a coluna especificada.
        // Aqui é feito um switch para verificar qual é a coluna
        // e retornar o tipo adequado. As colunas são as mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {

        case 0: // Primeira coluna é o nome, que é uma String.
            return Long.class;
        case 1: // Segunda coluna é o CPF, que também é uma String..
            return String.class;
        case 2: // Segunda coluna é o Nome do Morador, que também é uma String.
            return String.class;
        case 3: // Segunda coluna é o Data/Hora, que também é uma String..
            return String.class;
        default:
            // Se o índice da coluna não for válido, lança um
            // IndexOutOfBoundsException (Exceção de índice fora dos limites).
            // Não foi necessário verificar se o índice da linha é inválido,
            // pois o próprio ArrayList lança a exceção caso seja inválido.
        	throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
    }
    
    /* Retorna o valor da célula especificada
     * pelos índices da linha e da coluna. */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o sócio da linha especificada.       
        Visitante vis = dados.get(rowIndex);
        Pessoa pes = dados.get(rowIndex);

        // Retorna o campo referente a coluna especificada.
        // Aqui é feito um switch para verificar qual é a coluna
        // e retornar o campo adequado. As colunas são as mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {
        case 0: 
            return vis.getNome();
        case 1: 
            return vis.getCPF();
        case 2: 
            return pes.getNome();
        case 3: 
            return vis.getTime();        
        default:
            // Se o índice da coluna não for válido, lança um
            // IndexOutOfBoundsException (Exceção de índice fora dos limites).
            // Não foi necessário verificar se o índice da linha é inválido,
            // pois o próprio ArrayList lança a exceção caso seja inválido.
			throw new IndexOutOfBoundsException("columnIndex out of bounds");        }
    }
    
    /* Retorna um valor booleano que define se a célula em questão
     * pode ser editada ou não.
     * Este método é utilizado pela JTable na hora de definir o editor da célula.
     * Neste caso, estará sempre retornando false, não permitindo que nenhuma
     * célula seja editada. */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    
    
    /////////////////////////
    
    /* Retorna o sócio da linha especificada. */
    public Visitante getFuncionario(int indiceLinha) {
            if(indiceLinha < dados.size()){
                return dados.get(indiceLinha);
            }
        return null;
    }
    

    /* Adiciona um registro. */
    public void addVisitante(Visitante vis) {
        // Adiciona o registro.
        dados.add(vis);

        // Pega a quantidade de registros e subtrai um para achar
        // o último índice. É preciso subtrair um, pois os índices
        // começam pelo zero.
        int ultimoIndice = getRowCount() - 1;

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    
    /* Remove a linha especificada. */
    public void removeVisitante(int indiceLinha) {
        // Remove o sócio da linha especificada.  
            if(indiceLinha < dados.size()){
                dados.remove(indiceLinha);

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
            }

    }
    
    
    /* Adiciona uma lista de sócios ao final dos registros. */
    public void addListaDeVisitante(List<Visitante> vis) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();

        // Adiciona os registros.
        dados.addAll(vis);

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
    
    /* Remove todos os registros. */
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        dados.clear();

        // Reporta a mudança. O JTable recebe a notificação
        // e se redesenha permitindo que visualizemos a atualização.
        fireTableDataChanged();
    }
    
    
    /* Verifica se este table model está vazio. */
    public boolean isEmpty() {
        return dados.isEmpty();
    }
    
    public Object getObject(int index) {
        return dados.get(index);
    }
	
}

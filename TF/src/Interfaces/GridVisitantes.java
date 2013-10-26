package Interfaces;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;





import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import AcoesInterface.ContatoTableModel;
import ClassesPrincipais.Visitante;
import Condominio.LeituraGravacaoArquivo;


public class GridVisitantes extends JFrame {

	private JTable tblVisitante;
	private ContatoTableModel model;
	LeituraGravacaoArquivo grave;
	public GridVisitantes(){
		super("Visitante");
		initialize();
	}

	private void initialize() {
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(new JScrollPane(getTblVisitantes()));
		
	}

	private JTable getTblVisitantes() {
		grave = new LeituraGravacaoArquivo();
		if (tblVisitante == null) {
			tblVisitante = new JTable();
			tblVisitante.setModel(new ContatoTableModel(grave.lerDadosVisitante()));
		}
		return tblVisitante;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GridVisitantes().setVisible(true);
			}
		});
	}

}
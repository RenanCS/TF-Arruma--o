package Condominio;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GridVisitantes extends JFrame {
	private JTable table;

	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridVisitantes frame = new GridVisitantes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GridVisitantes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Visitante", "CPF", "Morador", "Data/Hora"
			}
		));
		table.setBounds(10, 11, 414, 168);
		getContentPane().add(table);
		
		
		
	}

}
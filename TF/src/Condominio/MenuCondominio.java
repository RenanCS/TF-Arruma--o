package Condominio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuCondominio extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCondominio frame = new MenuCondominio();
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
	public MenuCondominio() {
		setTitle("Alpro2 - Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Dados");
		menuBar.add(mnMenu);
		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnMenu.add(mnCadastrar);
		
		JMenuItem mntmMorador = new JMenuItem("Morador");
		mnCadastrar.add(mntmMorador);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnCadastrar.add(mntmNewMenuItem);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMenu.setBounds(124, 31, 156, 44);
		contentPane.add(lblMenu);
		
		final JRadioButton rdbtnCadastrarVisitante = new JRadioButton("Cadastrar Visitante");
		rdbtnCadastrarVisitante.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCadastrarVisitante.setBounds(32, 102, 156, 23);
		contentPane.add(rdbtnCadastrarVisitante);
		
		final JRadioButton rdbtnCadastrarMorador = new JRadioButton("Cadastrar Morador");
		rdbtnCadastrarMorador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCadastrarMorador.setBounds(32, 128, 156, 23);
		contentPane.add(rdbtnCadastrarMorador);
		

		final JRadioButton rdbtnVisitaMes = new JRadioButton("Consultar Visitas");
		rdbtnVisitaMes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnVisitaMes.setBounds(204, 128, 188, 23);
		contentPane.add(rdbtnVisitaMes);
		
		ButtonGroup opcao = new ButtonGroup();
		opcao.add(rdbtnVisitaMes);
		opcao.add(rdbtnCadastrarMorador);
		opcao.add(rdbtnCadastrarVisitante);

		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
			
				if(rdbtnVisitaMes.isSelected()){
					    InterfaceMorador morador  = new InterfaceMorador();  
		        	    morador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		                morador.setLocationRelativeTo(null);  
		                morador.setVisible(true);  	                
		                
				}
				if(rdbtnCadastrarMorador.isSelected()){
					 InterfaceConsultaVisita consultavisitante  = new InterfaceConsultaVisita();  
					  consultavisitante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
					  consultavisitante.setLocationRelativeTo(null);  
					  consultavisitante.setVisible(true);  
					
				}
				if(rdbtnCadastrarVisitante.isSelected()){
				      InterfaceVisitante visitante  = new InterfaceVisitante();  
			          visitante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
			          visitante.setLocationRelativeTo(null);  
			          visitante.setVisible(true);  
				}
				
				
			}
		});
		btnOk.setBounds(140, 195, 156, 33);
		contentPane.add(btnOk);
	}
}

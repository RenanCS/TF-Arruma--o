package Condominio;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InterfaceMorador extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtNomeMorador;
	private JTextField txtCPFMorador;
	private JTextField txtAptoMorador;
	private JTextField txtTelefoneMorador;
	Memoria memoria = new Memoria();
	Morador morador;
	Verificacao verifica = new Verificacao();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceMorador frame = new InterfaceMorador();
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
	public InterfaceMorador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadstroDeMoradores = new JLabel("Cadastro de Moradores");
		lblCadstroDeMoradores.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadstroDeMoradores.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadstroDeMoradores.setBounds(86, 11, 254, 63);
		contentPane.add(lblCadstroDeMoradores);
		
		txtNomeMorador = new JTextField();
		txtNomeMorador.setBounds(109, 85, 287, 20);
		contentPane.add(txtNomeMorador);
		txtNomeMorador.setColumns(10);
		
		txtCPFMorador = new JTextField();
		txtCPFMorador.setColumns(10);
		txtCPFMorador.setBounds(110, 116, 144, 20);
		contentPane.add(txtCPFMorador);
		
		txtAptoMorador = new JTextField();
		txtAptoMorador.setColumns(10);
		txtAptoMorador.setBounds(110, 147, 74, 20);
		contentPane.add(txtAptoMorador);
		
		txtTelefoneMorador = new JTextField();
		txtTelefoneMorador.setColumns(10);
		txtTelefoneMorador.setBounds(282, 147, 114, 20);
		contentPane.add(txtTelefoneMorador);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(32, 88, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCPF.setBounds(32, 119, 46, 14);
		contentPane.add(lblCPF);
		
		JLabel lblApto = new JLabel("Apto:");
		lblApto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApto.setBounds(32, 150, 46, 14);
		contentPane.add(lblApto);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(214, 150, 58, 14);
		contentPane.add(lblTelefone);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				validacao();
			
			}
		});
		btnCadastrar.setBounds(129, 199, 193, 38);
		contentPane.add(btnCadastrar);
	}
	

	private void validacao() {


		
		String nome = txtNomeMorador.getText();
		String cpf = txtCPFMorador.getText();
		String apto = txtAptoMorador.getText();
		String telefone = txtTelefoneMorador.getText();
		
		if(!verifica.ValidacaoMorador(nome, cpf, apto, telefone)){
		    morador = new Morador(nome, (Integer.parseInt(cpf)),(Integer.parseInt(apto)),(Integer.parseInt(telefone)));
		    
			memoria.adicionarMorador(morador);	
			
			JOptionPane.showMessageDialog(null,"CADASTRO MORADOR EFETUADO COM SUCESSO!");
			dispose();
			
		}
		else{
			 JOptionPane.showMessageDialog(null,"EXISTE CAMPOS EM ABERTO");
		}
		

		
	}

	
}

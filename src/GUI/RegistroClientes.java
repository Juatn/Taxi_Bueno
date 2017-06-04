package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;

import Models.Cliente;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroClientes extends JFrame {

	protected JFrame frame;
	private JLabel lblFechaEntrada;
	private JLabel lblFechaSalida;
	private JLabel lblDinero;
	private JTextPane fechaentrada;
	private JTextPane fechasalida;
	private JTextPane dinerocliente;
	private JButton btnAnterior;
	private JButton buttonsiguiente;
	private JLabel lbrecaudacion;
	private JLabel lbdinerototal;
	private JButton btnNewButton;


	/**
	 * Create the application.
	 */
	public RegistroClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 0));
		frame.getContentPane().setLayout(null);
		
		lblFechaEntrada = new JLabel("Fecha Entrada");
		lblFechaEntrada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaEntrada.setBounds(59, 86, 138, 20);
		frame.getContentPane().add(lblFechaEntrada);
		
		lblFechaSalida = new JLabel("Fecha Salida");
		lblFechaSalida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFechaSalida.setBounds(59, 166, 138, 35);
		frame.getContentPane().add(lblFechaSalida);
		
		lblDinero = new JLabel("Dinero:");
		lblDinero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDinero.setBounds(59, 251, 138, 35);
		frame.getContentPane().add(lblDinero);
		
		fechaentrada = new JTextPane();
		fechaentrada.setBounds(59, 122, 196, 26);
		frame.getContentPane().add(fechaentrada);
		
		fechasalida = new JTextPane();
		fechasalida.setBounds(69, 209, 186, 26);
		frame.getContentPane().add(fechasalida);
		
		dinerocliente = new JTextPane();
		dinerocliente.setBounds(69, 292, 174, 26);
		frame.getContentPane().add(dinerocliente);
		
		btnAnterior = new JButton("<");
		btnAnterior.setBounds(145, 16, 45, 44);
		frame.getContentPane().add(btnAnterior);
		
		buttonsiguiente = new JButton(">");
		buttonsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ImprimirCliente();
			}
		});
		buttonsiguiente.setBounds(246, 16, 45, 44);
		frame.getContentPane().add(buttonsiguiente);
		
		lbrecaudacion = new JLabel("Recaudaci\u00F3n total:");
		lbrecaudacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbrecaudacion.setBounds(332, 62, 186, 44);
		
		frame.getContentPane().add(lbrecaudacion);
		
		lbdinerototal = new JLabel("0");
		lbdinerototal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbdinerototal.setBounds(354, 122, 210, 44);
		lbdinerototal.setText(""+Contador.dineroencaja);
		frame.getContentPane().add(lbdinerototal);
		
		btnNewButton = new JButton("Volver atras");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				Entrada a=new Entrada();
				a.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 102, 102));
		btnNewButton.setBounds(342, 265, 156, 53);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 623, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void ImprimirCliente(){
		
		for(Cliente cliente:Entrada.listaclientes){
			
			fechaentrada.setText(cliente.getHoraentrada().toString());
			fechasalida.setText(cliente.getHorasalida().toString());
			dinerocliente.setText(cliente.getDinero());
		}
	}

}

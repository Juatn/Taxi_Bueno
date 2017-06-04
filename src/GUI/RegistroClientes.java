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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroClientes extends JFrame {

	protected JFrame frame;
	private JLabel lblFechaEntrada;
	private JLabel lblFechaSalida;
	private JLabel lblDinero;
	protected JTextPane fechaentrada;
	protected JTextPane fechasalida;
	protected JTextPane dinerocliente;
	private JButton btnAnterior;
	private JButton buttonsiguiente;
	private JLabel lbrecaudacion;
	private JLabel lbdinerototal;
	private JButton btnNewButton;
	private JButton buttonverclientes;
	private JLabel labelindiceclientes;
	protected int indice = 0;

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
		fechaentrada.setEnabled(false);
		fechaentrada.setBounds(59, 122, 196, 26);
		frame.getContentPane().add(fechaentrada);

		fechasalida = new JTextPane();
		fechasalida.setEnabled(false);
		fechasalida.setBounds(69, 209, 186, 26);
		frame.getContentPane().add(fechasalida);

		dinerocliente = new JTextPane();
		dinerocliente.setEnabled(false);
		dinerocliente.setBounds(69, 292, 174, 26);
		frame.getContentPane().add(dinerocliente);

		btnAnterior = new JButton("<");
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				anteriorCliente();
				ImprimirCliente();
				updateContador();
			}
		});
		btnAnterior.setBounds(229, 16, 45, 44);
		frame.getContentPane().add(btnAnterior);

		buttonsiguiente = new JButton(">");
		buttonsiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				siguienteCliente();
				ImprimirCliente();
				updateContador();
			}
		});
		buttonsiguiente.setBounds(406, 16, 45, 44);
		frame.getContentPane().add(buttonsiguiente);

		lbrecaudacion = new JLabel("Recaudaci\u00F3n total:");
		lbrecaudacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbrecaudacion.setBounds(332, 62, 186, 44);

		frame.getContentPane().add(lbrecaudacion);

		lbdinerototal = new JLabel("0");
		lbdinerototal.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbdinerototal.setBounds(354, 122, 210, 44);
		lbdinerototal.setText("" + Contador.dineroencaja);
		frame.getContentPane().add(lbdinerototal);

		btnNewButton = new JButton("Volver atras");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				Entrada a = new Entrada();
				a.frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(255, 102, 102));
		btnNewButton.setBounds(342, 265, 156, 53);
		frame.getContentPane().add(btnNewButton);

		buttonverclientes = new JButton("Ver Clientes");
		buttonverclientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateContador();
				

			}
		});
		buttonverclientes.setBackground(new Color(204, 255, 153));
		buttonverclientes.setBounds(55, 24, 128, 29);
		frame.getContentPane().add(buttonverclientes);

		labelindiceclientes = new JLabel("");
		labelindiceclientes.setBounds(305, 28, 69, 20);
		frame.getContentPane().add(labelindiceclientes);
		frame.setBounds(100, 100, 623, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	

	private void updateContador() {
		labelindiceclientes.setText((indice + 1) + " de " + Contenedor.Lista.ListaClientes.size());
	}
	private int siguienteCliente(){
		++indice;
		if (indice == Contenedor.Lista.ListaClientes.size()) {
			indice = 0;
		}
		return indice;
		
	}
	private int anteriorCliente(){
		--indice;
		if (indice < 0) {
			indice = Contenedor.Lista.ListaClientes.size()-1;
		}
		return indice;
		
	}
	public void ImprimirCliente() {

		Cliente p = Contenedor.Lista.ListaClientes.get(indice);

		fechaentrada.setText(p.getHoraentrada().toString());
		fechasalida.setText(p.getHorasalida().toString());
		dinerocliente.setText(p.getDinero());

	}

}

package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Models.Cliente;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import java.awt.SystemColor;

public class Entrada extends JFrame {

	public JFrame frame;
	private JButton buttonsubidaviajero;
	private JButton buttoncaja;
	static Cliente c1;
	

	/**
	 * Create the application.
	 */
	public Entrada() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 727, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		buttonsubidaviajero = new JButton("Subida Viajero");
		buttonsubidaviajero.setBackground(new Color(255, 255, 153));
		buttonsubidaviajero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// AÑADIRLO AL ARRAYLIST

				Date fecha = new Date();

			      c1 = new Cliente(fecha);
				
				
				
				Contenedor.Lista.ListaClientes.add(c1);

				// ABRIR VENTANA CON CONTADOR
				frame.setVisible(false);

				Contador p = new Contador();
				p.frame.setVisible(true);

			}
		});
		buttonsubidaviajero.setBounds(90, 128, 221, 142);
		frame.getContentPane().add(buttonsubidaviajero);

		buttoncaja = new JButton("Caja dia");
		buttoncaja.setBackground(new Color(204, 255, 255));
		buttoncaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				frame.setVisible(false);
				RegistroClientes c = new RegistroClientes();
				
				c.frame.setVisible(true);
			
			    

			}
		});
		buttoncaja.setBounds(402, 128, 221, 142);
		frame.getContentPane().add(buttoncaja);
	}

}

package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Models.Cliente;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Contador extends JFrame {

	protected JFrame frame;
	private JCheckBox radiosemana;
	private JButton btnGo;
	private JCheckBox radiofestivo;
	private JCheckBox radioaero;
	private JCheckBox radionocturna;
	private JLabel lbcontador;
	protected JLabel lbldinerorecibido;
	private JTextPane textdinerorecibido;
	protected boolean controlContador = false;
	private JButton buttonatras;
	private JLabel lbDinero;
	private Thread contador;
	private JButton btnLlegada;
	private JLabel lblEuros;
	private JLabel lblCambio;
	private JTextPane textCambio;
	private JButton buttoncambio;
	protected static double dineroencaja;
	protected boolean controldinero=true;

	/**
	 * Create the application.
	 */
	public Contador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 0));
		frame.setBounds(100, 100, 650, 596);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnGo = new JButton("GO");
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ATRIBUTOS
				controlContador = true;
				lbcontador.setVisible(true);
				lbDinero.setVisible(true);
				contador = new Thread(new Runnable() {
					// RUN
					@Override
					public void run() {

						// AJUSTAR TARIFA
						float tarifa = 0;

						if (radiosemana.isSelected()) {
							lbDinero.setText("3.65");
							tarifa = 0.18f;
						}
						if (radiofestivo.isSelected()) {
							lbDinero.setText("4.55");
							tarifa = 0.26f;
						}
						if (!radiosemana.isSelected() && !radiofestivo.isSelected()) {
							controlContador = false;
							JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna bajada de bandera",
									"Errorsito", JOptionPane.ERROR_MESSAGE);

						}

						int segundos = Integer.parseInt(lbcontador.getText());
						double dinero = Double.parseDouble(lbDinero.getText());

						if (radioaero.isSelected()) {
							dinero=dinero+5.5;

						}
						if (radionocturna.isSelected()){
							dinero=dinero+2;
						}
						

						while (controlContador) {
							try {
								Thread.sleep(1000);
							} catch (Exception e) {
							}
							segundos++;
							lbcontador.setText("" + segundos);
							if (segundos >= 60) {
								dinero = dinero + tarifa;
								segundos = 0;

								lbDinero.setText("" + dinero);
							}
						}

					}
				});
				contador.start();

			}
		});
		btnGo.setBounds(123, 54, 115, 29);
		frame.getContentPane().add(btnGo);

		radiosemana = new JCheckBox("Entre semana");
		radiosemana.setBounds(411, 54, 139, 29);
		frame.getContentPane().add(radiosemana);

		radiofestivo = new JCheckBox("Fin semana/festivo");
		radiofestivo.setBounds(411, 110, 172, 29);
		frame.getContentPane().add(radiofestivo);

		radioaero = new JCheckBox("Tarifa aeropuerto");
		radioaero.setBounds(411, 166, 162, 29);
		frame.getContentPane().add(radioaero);

		radionocturna = new JCheckBox("Tarifa nocturna");
		radionocturna.setBounds(411, 218, 162, 29);
		frame.getContentPane().add(radionocturna);

		lbcontador = new JLabel("0");
		lbcontador.setHorizontalAlignment(SwingConstants.CENTER);
		lbcontador.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbcontador.setBounds(123, 152, 128, 45);
		frame.getContentPane().add(lbcontador);

		btnLlegada = new JButton("Fin de trayecto");
		btnLlegada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Cerrar bucle
				controlContador = false;

			}
		});
		btnLlegada.setBounds(113, 252, 152, 37);
		frame.getContentPane().add(btnLlegada);

		lbldinerorecibido = new JLabel("Dinero recibido :");
		lbldinerorecibido.setBounds(56, 399, 128, 45);
		lbldinerorecibido.setVisible(false);
		frame.getContentPane().add(lbldinerorecibido);

		textdinerorecibido = new JTextPane();
		textdinerorecibido.setText("0");
		textdinerorecibido.setBounds(199, 411, 89, 26);
		textdinerorecibido.setVisible(false);
		frame.getContentPane().add(textdinerorecibido);

		buttonatras = new JButton("Volver atras");
		buttonatras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Anadir fecha salida cliente
				Date c=new Date();
				Entrada.c1.setHorasalida(c);
				Entrada.c1.setDinero(lbDinero.getText());
				frame.setVisible(false);
				Entrada p = new Entrada();
				p.frame.setVisible(true);
			}
		});
		buttonatras.setBackground(new Color(255, 102, 102));
		buttonatras.setBounds(411, 377, 139, 45);
		frame.getContentPane().add(buttonatras);

		lbDinero = new JLabel("0");
		lbDinero.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbDinero.setForeground(new Color(0, 0, 0));
		lbDinero.setHorizontalAlignment(SwingConstants.CENTER);
		lbDinero.setBounds(123, 311, 224, 45);
		frame.getContentPane().add(lbDinero);

		lblEuros = new JLabel("Euros");
		lblEuros.setBackground(new Color(0, 0, 204));
		lblEuros.setForeground(new Color(0, 0, 153));
		lblEuros.setBounds(182, 363, 69, 20);
		frame.getContentPane().add(lblEuros);

		lblCambio = new JLabel("Cambio:");
		lblCambio.setBounds(56, 470, 69, 20);
		lblCambio.setVisible(false);
		frame.getContentPane().add(lblCambio);

		textCambio = new JTextPane();
		textCambio.setText("0");
		textCambio.setEnabled(false);
		textCambio.setBounds(199, 470, 89, 26);
		textCambio.setVisible(false);
		frame.getContentPane().add(textCambio);

		buttoncambio = new JButton("Calcular Cambio");
		buttoncambio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbldinerorecibido.setVisible(true);
				textdinerorecibido.setVisible(true);

				// DAR CAMBIO
				// variables
				double dineroapagar = Double.parseDouble(lbDinero.getText());
				double dinerorecibido = Double.parseDouble(textdinerorecibido.getText());
				double cambio = dinerorecibido - dineroapagar;
				// Comprobar que haya introducido dinero y mostrar cambio

				if (dinerorecibido >= dineroapagar) {
					lblCambio.setVisible(true);
					textCambio.setVisible(true);

					textCambio.setText("" + cambio);

				}
				if (dinerorecibido == dineroapagar) {
					JOptionPane.showMessageDialog(null, "Me has dado el dinero justo", "Sin cambio",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (dinerorecibido < dineroapagar) {
					JOptionPane.showMessageDialog(null, "FALTAN " + cambio + " Euros", "EEH!",
							JOptionPane.ERROR_MESSAGE);
				}
				if(controldinero){
				dineroencaja = dineroencaja + (dinerorecibido - cambio);
				controldinero=false;
				
			}
			}

		});
		buttoncambio.setBounds(15, 372, 152, 29);
		frame.getContentPane().add(buttoncambio);
	}
}

package info.unlp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Test extends JFrame {
	private JLabel label = new JLabel("Tablero de control de peliculas", JLabel.CENTER), otroLabel, labelResultados;
	private JComboBox<Integer> cant;
	private JTable tabla = new JTable();
	private JButton boton;
	private JProgressBar progreso;
	private String[] titulo = { "Nombre", "Usuarios", "Votos" };
	private Object[][] datos = { 
			{ "Pedrito", 15, 999 },
			{ "Pedrito", 15, 999 }, 
			{ "Pedrito", 15, 999 },
			{ "Pedrito", 15, 999 } 
	};

	public Test() {
		setLayout(new BorderLayout());
		add(new panelNorte(), BorderLayout.NORTH);
		add(new panelCentro(), BorderLayout.CENTER);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();

		setSize((int) pantalla.getWidth() / 2, (int) pantalla.getHeight() / 2);
		setLocation((int) pantalla.getWidth() / 4, (int) pantalla.getHeight() / 4);
		setVisible(true);
		setResizable(false);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Test a = new Test();

	}

	class panelNorte extends JPanel {
		public panelNorte() {
			// TODO Auto-generated constructor stub
			setLayout(new BorderLayout());
			add(label, BorderLayout.NORTH);
			add(new panelVarios(), BorderLayout.CENTER);
		}
	}

	class panelCentro extends JPanel {
		panelCentro() {
			setLayout(new BorderLayout());
			JPanel aux = new JPanel(new BorderLayout());
			aux.add(new panelDatosgenerales(), BorderLayout.CENTER);
			add(aux, BorderLayout.NORTH);
			add(new cantidadDatosAMostrar(), BorderLayout.CENTER);

		}
	}

	class panelVarios extends JPanel {
		public panelVarios() {
			// TODO Auto-generated constructor stub
			setLayout(new FlowLayout(FlowLayout.CENTER));
			boton = new JButton("Falopa");
			boton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "mas falopa", "nose", JOptionPane.OK_OPTION);
				}
			});
			boton.setPreferredSize(new Dimension(300, 25));
			add(boton);
			progreso = new JProgressBar();
			add(progreso);

		}
	}

	class panelTabla extends JPanel {
		public panelTabla() {
			// TODO Auto-generated constructor stub
			setLayout(new BorderLayout());

			DefaultTableModel modelo = new DefaultTableModel(titulo, 0);
			tabla.setModel(modelo);
			tabla.setEnabled(false);

			add(new JScrollPane(tabla),BorderLayout.CENTER);

		}
	}

	class cantidadDatosAMostrar extends JPanel {
		public cantidadDatosAMostrar() {
			labelResultados = new JLabel("Cantidad de resultados a mostrar");
			setLayout(new BorderLayout());
			Integer [] myNum= new Integer[datos.length];
			for(int i =0; i<datos.length;i++) {
				myNum[i]=i;
			}
			cant = new JComboBox<Integer>(myNum);
			cant.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel modelo = new DefaultTableModel(titulo, 0);
					int a = (Integer) cant.getSelectedItem();
					for (int i = 0; i < a; i++) {
						modelo.addRow(datos[i]);
					}
					tabla.setModel(modelo);

				}
			});
			JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
			panelInferior.add(labelResultados);
			panelInferior.add(cant);
			add(new panelTabla(), BorderLayout.CENTER);
			add(panelInferior, BorderLayout.NORTH);
		}
	}

	class panelDatosgenerales extends JPanel {
		public panelDatosgenerales() {
			int unDato = 0;
			Dimension d = new Dimension(300, 100);
			setLayout(new FlowLayout(FlowLayout.CENTER));
			otroLabel = new JLabel("<html>" + unDato + "<br>Usuarios</html>", JLabel.CENTER);
			otroLabel.setBackground(Color.CYAN);
			otroLabel.setOpaque(true);
			otroLabel.setPreferredSize(d);
			add(otroLabel);
			otroLabel = new JLabel("<html>" + unDato + "<br>Peliculas</html>", JLabel.CENTER);
			otroLabel.setBackground(Color.CYAN);
			otroLabel.setOpaque(true);
			otroLabel.setPreferredSize(d);
			add(otroLabel);
			otroLabel = new JLabel("<html>" + unDato + "<br>Cant. de votos</html>", JLabel.CENTER);
			otroLabel.setBackground(Color.CYAN);
			otroLabel.setOpaque(true);
			otroLabel.setPreferredSize(d);
			add(otroLabel);
			
		}
	}

}

package info.unlp.partes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

import info.unlp.pruebas.LeerArchivo;

public class PanelSuperior extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton boton = new JButton("Procesar datos");
	private LeerArchivo arch = new LeerArchivo();
	public PanelSuperior() {
		String titulo = "Tablero de control de Películas";
		TitledBorder border = BorderFactory.createTitledBorder(titulo);
		border.setTitleJustification(TitledBorder.CENTER);
		border.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		this.setBorder(border);
		this.setLayout(new FlowLayout(FlowLayout.RIGHT,50,0));
		componentes();
	}

	public void componentes() {
		arch.getBarra().setPreferredSize(new Dimension(300, 25));
		
		boton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					Thread hilo= new Thread(arch);
					hilo.start();
					
					boton.setEnabled(false);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				;
				
			}
		});
		add(boton);
		add(arch.getBarra());
		
	}
	

	class pruebaBarra extends Thread {
		private JProgressBar algo;// le tengo q cambiar el nombre

		public pruebaBarra(JProgressBar progreso) {
			this.algo = progreso;
		}

		@Override
		public void run() {
			for (int i = 1; i <= algo.getMaximum(); i++) {
				algo.setValue(i);
				try {
					sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

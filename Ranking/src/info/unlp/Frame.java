package info.unlp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.*;
import info.unlp.partes.CantidadDatosAMostrar;
import info.unlp.partes.PanelDatosGenerales;
import info.unlp.partes.PanelSuperior;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final URL ubiImagen = getClass().getResource("icono.jpg");
	private PanelSuperior pSup = new PanelSuperior();
	private JPanel panelCentro = new JPanel(new BorderLayout());
	private CantidadDatosAMostrar cant =new CantidadDatosAMostrar();
	private PanelDatosGenerales datosGen = new PanelDatosGenerales();
	private static Frame instance = new Frame();
	private Frame() {
		super("Ranking de peliculas");
		// setFocusable(true);
		ImageIcon img = new ImageIcon(ubiImagen);
		panelCentro.add(datosGen, BorderLayout.NORTH);
		panelCentro.add(cant, BorderLayout.CENTER);
		panelCentro.add(cant.getPintura(), BorderLayout.SOUTH);
		setIconImage(img.getImage());
		setLayout(new BorderLayout());
		add(pSup, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) pantalla.getWidth() / 4, (int) pantalla.getHeight() / 15);
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		instance.setVisible(true);
		// a.setMinimumSize(a.getSize());
	}

	public JPanel getpSup() {
		return pSup;
	}


	public CantidadDatosAMostrar getCant() {
		return cant;
	}

	public PanelDatosGenerales getDatosGen() {
		return datosGen;
	}

	public static Frame getInstance() {
		return instance;
	}
	

}

package info.unlp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import info.unlp.partes.CantidadDatosAMostrar;
import info.unlp.partes.PanelDatosGenerales;
import info.unlp.partes.PanelSuperior;

public class Test extends JFrame {
	private static final long serialVersionUID = 1L;
	private final String ubiImagen = "ico/icono.jpg ";
	private JPanel pSup = new PanelSuperior();
	private JPanel pCentro = new PanelCentro();

	public Test() {
		super("Ranking de peliculas");
		// setFocusable(true);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
				
				}
					
			}
		});
		ImageIcon img = new ImageIcon(ubiImagen);
		setIconImage(img.getImage());
		setLayout(new BorderLayout());
		add(pSup, BorderLayout.NORTH);
		add(pCentro, BorderLayout.CENTER);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) pantalla.getWidth() / 4, (int) pantalla.getHeight() / 15);
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Test a = new Test();
		a.setVisible(true);
		// a.setMinimumSize(a.getSize());
	}

	class PanelCentro extends JPanel {
		private static final long serialVersionUID = 1L;

		PanelCentro() {
			setLayout(new BorderLayout());
			add(new PanelDatosGenerales(), BorderLayout.NORTH);
			add(new CantidadDatosAMostrar(), BorderLayout.CENTER);
			add(CantidadDatosAMostrar.getP(), BorderLayout.SOUTH);
		}
	}

}

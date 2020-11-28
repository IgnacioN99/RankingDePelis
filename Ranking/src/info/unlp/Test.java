package info.unlp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import info.unlp.partes.CantidadDatosAMostrar;
import info.unlp.partes.PanelDatosGenerales;
import info.unlp.partes.PanelSuperior;


public class Test extends JFrame {

	private static final long serialVersionUID = 1L;

	public Test() {
		super("Ranking de peliculas");
		setLayout(new BorderLayout());
		add(new PanelSuperior(), BorderLayout.NORTH);
		add(new panelCentro(), BorderLayout.CENTER);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) pantalla.getWidth()/4, (int) pantalla.getHeight() / 15);
		
		setResizable(false);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Test a = new Test();
		a.setVisible(true);

	}

	class panelCentro extends JPanel {
		private static final long serialVersionUID = 1L;
		panelCentro() {
			setLayout(new BorderLayout());
			add(new PanelDatosGenerales(), BorderLayout.NORTH);
			add(new CantidadDatosAMostrar(), BorderLayout.CENTER);
			add(CantidadDatosAMostrar.getP(),BorderLayout.SOUTH);
		
		}
	}

}

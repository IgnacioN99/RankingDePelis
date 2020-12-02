package info.unlp.partes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelDatosGenerales extends JPanel {

	private static final long serialVersionUID = 1L;
	private  JLabel L1;
	private  JLabel L2;
	private  JLabel L3;
	private JLabel Linf;
	private Dimension tamanio = new Dimension(300, 50);
	public PanelDatosGenerales() {
		setLayout(new GridLayout(2,3));
		this.datosSuperiores();
		this.datosInferiores();
	}
	public void datosSuperiores() {
		L1 = new JLabel("???", JLabel.CENTER);
		L1.setBackground(Color.CYAN);
		L1.setOpaque(true);
		L1.setPreferredSize(tamanio);
		this.add(L1);
	
		L2 = new JLabel("???", JLabel.CENTER);
		L2.setBackground(Color.CYAN);
		L2.setOpaque(true);
		L2.setPreferredSize(tamanio);
		this.add(L2);
		
		L3 = new JLabel("???", JLabel.CENTER);
		L3.setBackground(Color.CYAN);
		L3.setOpaque(true);
		L3.setPreferredSize(tamanio);
		this.add(L3);
	}
	public void datosInferiores() {
		Linf = new JLabel("Usuarios", JLabel.CENTER);
		Linf.setBackground(Color.CYAN);
		Linf.setOpaque(true);
		Linf.setPreferredSize(tamanio);
		this.add(Linf);
	
		Linf = new JLabel("Peliculas", JLabel.CENTER);
		Linf.setBackground(Color.CYAN);
		Linf.setOpaque(true);
		Linf.setPreferredSize(tamanio);
		this.add(Linf);
		
		Linf = new JLabel("Cant. de votos", JLabel.CENTER);
		Linf.setBackground(Color.CYAN);
		Linf.setOpaque(true);
		Linf.setPreferredSize(tamanio);
		this.add(Linf);
	}
	public void cargarDatos(int...s) {
		L1.setText(Integer.toString(s[0]));
		L2.setText(Integer.toString(s[1]));
		L3.setText(Integer.toString(s[2]));
	}
}

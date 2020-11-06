package info.unlp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Test extends JFrame {
	private JLabel label = new JLabel("Tablero de control de peliculas",JLabel.CENTER),aux;
	
	private JButton boton;

	public Test() {
		setLayout(new BorderLayout());
		add(new panelNorte(),BorderLayout.NORTH);
		add(new panelCentro(),BorderLayout.CENTER);
		Dimension pantalla= Toolkit.getDefaultToolkit().getScreenSize();
		
		setSize((int)pantalla.getWidth()/2,(int)pantalla.getHeight()/2);
		setLocation((int)pantalla.getWidth()/4, (int)pantalla.getHeight()/4);
		setVisible(true);
		setResizable(false);
		//pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Test a = new Test();

	}
	class panelNorte extends JPanel{
		public panelNorte() {
			// TODO Auto-generated constructor stub
			setLayout(new BorderLayout());
			add(label,BorderLayout.NORTH);
			add(new panelVarios(),BorderLayout.CENTER);
		}
	}
	class panelVarios extends JPanel{
		public panelVarios() {
			// TODO Auto-generated constructor stub
			setLayout(new FlowLayout(FlowLayout.CENTER));
			boton=new JButton("Falopa");
			boton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "mas falopa", "nose", JOptionPane.OK_OPTION);
				}
			});
			add(boton);
			
		}
	}
	class panelCentro extends JPanel{
		panelCentro(){
			setLayout(new BorderLayout());
			JPanel aux = new JPanel(new BorderLayout());
			aux.add(new panelDatosgenerales(),BorderLayout.CENTER);
			add(aux,BorderLayout.NORTH);
		}
	}
	class panelDatosgenerales extends JPanel{
		public panelDatosgenerales() {
			setLayout(new BorderLayout());
			aux=new JLabel("Usuarios",JLabel.CENTER);
			aux.setBackground(Color.CYAN);
			aux.setOpaque(true);
			add(aux,BorderLayout.LINE_START);
			aux=new JLabel("Peliculas",JLabel.CENTER);
			aux.setBackground(Color.CYAN);
			aux.setOpaque(true);
			add(aux,BorderLayout.CENTER);
			aux=new JLabel("Algo",JLabel.CENTER);
			aux.setBackground(Color.CYAN);
			aux.setOpaque(true);
			add(aux,BorderLayout.LINE_END);
		}
	}
}

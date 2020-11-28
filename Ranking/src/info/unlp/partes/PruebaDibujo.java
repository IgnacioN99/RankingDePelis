package info.unlp.partes;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PruebaDibujo extends JPanel {
	private static final long serialVersionUID = 1L;
	private int alto0 = 0, alto1 = 0, alto2 = 0, alto3 = 0, alto4 = 0, alto5 = 0;
	private List<Integer> a = new LinkedList<Integer>();

	public PruebaDibujo() {
		// TODO Auto-generated constructor stub
		String title = "HISTOGRAMA";
		TitledBorder border = BorderFactory.createTitledBorder(title);
		border.setTitleJustification(TitledBorder.CENTER);
		border.setTitleFont(new Font("SansSerif", Font.BOLD, 20));
		for (int i = 1; i <= 5; i++) {
			a.add(i*1000);
		}
		this.setBorder(border);
		this.setLayout(new FlowLayout());
		add(new Papel());

		repaint();
	}

	class Papel extends JPanel {
		private static final long serialVersionUID = 1L;

		public Papel() {
			setLayout(new BorderLayout());
			setPreferredSize(new Dimension(690, 320));
			setBackground(Color.WHITE);
			repaint();
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D graf = (Graphics2D) g;
			Font fontT = new Font("Serif", Font.BOLD, 12);
			Font fontE = new Font("SansSerif", Font.BOLD, 20);

			graf.setColor(Color.BLACK); // Color de linea y numeros
			graf.setStroke(new BasicStroke(3)); // Cambia el grosor de la linea
			graf.drawLine(123, 280, 568, 280); // Eje X
			//graf.fillPolygon(new int[] { 625, 641, 626 }, new int[] { 275, 280, 286 }, 3); // Flecha del final eje Y

			graf.drawLine(213, 320, 213, 40); // Eje Y
			graf.fillPolygon(new int[] { 208, 213, 219 }, new int[] { 50, 34, 50 }, 3); // Flecha del final eje Y

			graf.setFont(fontT);
			graf.drawString("Viewers", 163, 40);
			graf.drawString("SCORE", 543, 300);

			graf.setFont(fontE);
			graf.drawString("0", 263, 310);
			graf.drawString("1", 313, 310);
			graf.drawString("2", 363, 310);
			graf.drawString("3", 413, 310);
			graf.drawString("4", 463, 310);
			graf.drawString("5", 513, 310);
			graf.setStroke(new BasicStroke(2));
			// Lineas de escala X
			int j = 269;
			for (int i = 0; i < 6; i++) {
				graf.drawLine(j, 280, j, 290);
				j += 50;
			}

			j = 280;

			for (int i = 0; i <= a.size(); i++) {
				graf.drawLine(208, j, 218, j);
				if (a.size() == 5)
					j -= 40;
				else
					j = j-20;
			}
			if (a.size() == 5)
				j += 40;
			else
				j +=20;
			fontE=new Font("SansSerif", Font.BOLD, 15);
			graf.setFont(fontE);
			for (int i = a.size()-1; i >=0; i--) {
				graf.drawString(String.valueOf(a.get(i)), 160, j);
				if (a.size() == 5)
					j += 40;
				else
					j +=20;
			}
            graf.setColor(Color.CYAN);//Color del rectangulo
            graf.fillRect(253, 279-alto0, 30, alto0); 
            graf.fillRect(303, 279-alto1, 30, alto1);
            graf.fillRect(353, 279-alto2, 30, alto2);
            graf.fillRect(403, 279-alto3, 30, alto3);
            graf.fillRect(453, 279-alto4, 30, alto4);
            graf.fillRect(503, 279-alto5, 30, alto5);
            //Se le resta la altura porque se grafica de arriba para abajo.
            //De modo que si aumenta la altura la coordenada Y sube y no traspace el eje X.
		}

		
	}

	public void setAlturas(int[] ranks) {
		int max = obtenerMax(ranks);
		a.clear();
		if (max > 5000) {
			for (int i = 3000; i <= 33000; i = i+3000) {
				a.add(i);
			}
			 for (int b = 0; b < ranks.length; b++) {
				 if(ranks[b]>33000)
					 ranks[b]=34000;
				 ranks[b]=ranks[b]*20/3000;
			 }
		} else if (max <= 220) {
			for (int i = 20; i <= 220; i =i +20) {
				a.add(i);
			}
		}

		alto0 = ranks[0];
        alto1 = ranks[1];
        alto2 = ranks[2];
        alto3 = ranks[3];
        alto4 = ranks[4];
        alto5 = ranks[5];


		repaint();

	}

	private int obtenerMax(int[] ranks) {
		int max = 0;
		for (int i = 0; i < ranks.length; i++) {
			if (ranks[i] > max) {
				max = ranks[i];
			}
		}
		return max;
	}
}
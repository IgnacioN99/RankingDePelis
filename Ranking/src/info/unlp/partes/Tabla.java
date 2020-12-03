package info.unlp.partes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import info.unlp.lector.LeerArchivo;
import info.unlp.lector.Pelicula;

public class Tabla extends JPanel {
	private static final long serialVersionUID = 1L;
	private String[] titulo = { "Nombre", "Usuarios", "Votos" };
	private JTable tabla = new JTable() {
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	public JTable getTabla() {
		return tabla;
	}

	public Tabla(Histograma p) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500, 100));
		DefaultTableModel modelo = new DefaultTableModel(titulo, 0);
		tabla.setModel(modelo);
		tabla.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable celdaSelect = (JTable)e.getSource();
			      int fila = celdaSelect.getSelectedRow();
			      Pelicula aux = LeerArchivo.getListaPelis().get(fila);
			      p.setAlturas(aux.getVotos());
			    }
			  }
			});
		
		JScrollPane scrollPane = new JScrollPane(tabla);
		scrollPane.setPreferredSize(getPreferredSize());
		add(scrollPane, BorderLayout.CENTER);
	}
}
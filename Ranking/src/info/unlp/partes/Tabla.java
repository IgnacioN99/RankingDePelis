package info.unlp.partes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import info.unlp.pruebas.LeerArchivo;
import info.unlp.pruebas.Pelicula;

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

	public Tabla() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500, 100));
		DefaultTableModel modelo = new DefaultTableModel(titulo, 0);
		tabla.setModel(modelo);
		tabla.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable celdaSelect = (JTable)e.getSource();
			      int row = celdaSelect.getSelectedRow();
			      Pelicula aux = LeerArchivo.getListaPelis().get(row);
			      CantidadDatosAMostrar.getP().setAlturas(aux.getVotos());
			    }
			  }
			});
		
		JScrollPane a = new JScrollPane(tabla);
		a.setPreferredSize(getPreferredSize());
		add(a, BorderLayout.CENTER);
	}
}
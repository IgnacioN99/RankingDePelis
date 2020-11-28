package info.unlp.partes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import info.unlp.pruebas.LeerArchivo;
import info.unlp.pruebas.Pelicula;

public class CantidadDatosAMostrar extends JPanel {
	private String[] titulo = { "Nombre", "Usuarios", "Votos" };
	private JLabel labelResultados;
	private Tabla tab= new Tabla();
	private  JComboBox<String> cant;
	private static final long serialVersionUID = 1L;
	private static PruebaDibujo p = new PruebaDibujo();

	public static PruebaDibujo getP() {
		return p;
	}

	public CantidadDatosAMostrar() {
		labelResultados = new JLabel("Cantidad de resultados a mostrar");
		String[] myNum = {"0", "5", "10", "20", "100", "1000", "TODOS" };
		cant = new JComboBox<String>(myNum);
		cant.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int cantPelis = LeerArchivo.getListaPelis().size();
					DefaultTableModel modelo = new DefaultTableModel(titulo, 0);
					int a, contador = 0;
					if (cant.getSelectedItem().equals("TODOS")) {
						a = cantPelis;
					} else {
						a = Integer.parseInt((String) cant.getSelectedItem());
					}
					for (Pelicula p : LeerArchivo.getListaPelis()) {
						if (contador == a)
							break;
						modelo.addRow(new Object[] { p.getNombre(), p.getCantUsuarios(), p.getPromedio() });
						contador++;
						
					}
					tab.getTabla().setModel(modelo);
				} catch (Exception ex) {
					JOptionPane.showConfirmDialog(null, "No se cargaron los archivos", "ERROR",
							JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE);
					cant.setSelectedIndex(0);
				}

			}
		});
		JPanel aux = new JPanel(new FlowLayout(FlowLayout.LEFT));
		aux.add(labelResultados);
		aux.add(cant);
		setLayout(new BorderLayout());
		add(aux,BorderLayout.NORTH);
		add(tab,BorderLayout.CENTER);		
	}

}

package info.unlp.pruebas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import info.unlp.partes.CantidadDatosAMostrar;
import info.unlp.partes.PanelDatosGenerales;

public class LeerArchivo extends Thread {
	public final String Separador = ",";
	private HashMap<Integer, Pelicula> hashDePelis;
	private static List<Pelicula> list;
	private int[] ranks = new int[6];
	private JProgressBar barra = new JProgressBar(0, 100838);
	private int cantUsuarios = 1, cantPeliculas = 0, votosProcesados = 0, contador = 0;

	@Override
	public void run() {
		try {
			FileInputStream fstream = new FileInputStream("csv/movies.csv");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));
			String lineaPeliculas = buffer.readLine();
			hashDePelis = new HashMap<Integer, Pelicula>();
			lineaPeliculas = buffer.readLine();// No tomo en cuenta la primera linea
			while (lineaPeliculas != null) {
				String[] campos = lineaPeliculas.split(Separador);
				campos = textoEntero(lineaPeliculas, campos);
				cantPeliculas++;
				hashDePelis.put(Integer.parseInt(campos[0]), new Pelicula(campos[1]));
				lineaPeliculas = buffer.readLine();
			}
			fstream = new FileInputStream("csv/ratings.csv");
			buffer = new BufferedReader(new InputStreamReader(fstream));
			String lineaRatings = buffer.readLine();
			lineaRatings = buffer.readLine();
			int anteriorUser = Integer.parseInt(lineaRatings.split(Separador)[0]);
			while (lineaRatings != null ) {
				String[] campos = lineaRatings.split(Separador);
				Integer key = Integer.parseInt(campos[1]);
				int usuario = Integer.parseInt(campos[0]);
				if (anteriorUser != usuario) {
					cantUsuarios++;
					anteriorUser = usuario;
				}
				votosProcesados++;
				double voto = Double.parseDouble(campos[2]);
				ranks(voto);
				hashDePelis.get(key).setCantUsuarios();
				hashDePelis.get(key).setCantVotos(voto);
				lineaRatings = buffer.readLine();
				barra.setValue(++contador);
				barra.repaint();
				sleep(1);
				//System.out.println(contador);
			}
			PanelDatosGenerales.cargarDatos(cantUsuarios, cantPeliculas, votosProcesados);
			list = new ArrayList<Pelicula>(hashDePelis.values());
			Collections.sort(list);
			CantidadDatosAMostrar.getP().setAlturas(ranks);
			buffer.close();
			JOptionPane.showConfirmDialog(null, "se cargaron los archivos", "yay", JOptionPane.PLAIN_MESSAGE,
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) { // Pongo exeption para poder tomar tanto la IO como Interrupted en un solo try
			e.printStackTrace();
		}

	}

	public String[] textoEntero(String linea, String[] campos) {
		char[] caracteres = linea.toCharArray();
		String[] ret = new String[3];
		ret[0] = campos[0];
		int segundaAparicion = 0;
		ret[1] = "";
		for (int i = campos[0].toCharArray().length + 1; i < caracteres.length; i++) {
			if (caracteres[i] == '\"') {
				if (segundaAparicion != 0) {
					break;
				}
				segundaAparicion++;
			} else {
				if (caracteres[i] == ',' && segundaAparicion != 1) // hardcoding foerte tengo q cambiarlo
					break;
				ret[1] = ret[1] + caracteres[i];
			}
		}
		ret[2] = campos[campos.length - 1];

		return ret;
	}

	public void ranks(double voto) {
		if (voto == 0 && voto < 0.5) {
			this.ranks[0]++;
		} else if (voto >= 0.5 && voto < 1.5) {
			this.ranks[1]++;
		} else if (voto >= 1.5 && voto < 2.5) {
			this.ranks[2]++;
		} else if (voto >= 2.5 && voto < 3.5) {
			this.ranks[3]++;
		} else if (voto >= 3.5 && voto < 4.5) {
			this.ranks[4]++;
		} else if (voto >= 4.5) {
			this.ranks[5]++;
		}
	}

	public JProgressBar getBarra() {
		return barra;
	}

	public static List<Pelicula> getListaPelis() {
		return list;
	}

}

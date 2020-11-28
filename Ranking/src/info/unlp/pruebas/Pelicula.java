package info.unlp.pruebas;

public class Pelicula implements Comparable<Pelicula> {
	private double cantVotos = 0;
	private int cantUsuarios = 0;
	private String Nombre;
	private int[] votos = {0,0,0,0,0,0};

	public int[] getVotos() {
		return votos;
	}

	public Pelicula(String Nombre) {
		this.Nombre = Nombre;
	}

	public double getCantVotos() {
		return cantVotos;
	}

	public void setCantVotos(double cantVotos) {
		int posVotos=(int) cantVotos;
		votos[posVotos]=votos[posVotos]+1;
		double aux = this.cantVotos + cantVotos;
		this.cantVotos = aux;
	}

	public int getCantUsuarios() {
		return cantUsuarios;
	}

	public void setCantUsuarios() {
		int aux= this.cantUsuarios +1;
		this.cantUsuarios=aux;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return this.Nombre + " Cant usuarios " + this.cantUsuarios + " Votos " + this.cantVotos+" votos "+this.votos;
	}

	public double getPromedio() {
		if (cantUsuarios != 0) {
			return this.cantVotos / this.cantUsuarios;
		} else {
			return 0;
		}
	}

	@Override
	public int compareTo(Pelicula o) {
		if (o.getPromedio() == this.getPromedio()) {
			return 0;
		} else if (o.getPromedio() > this.getPromedio()) {
			return -1;
		} else {
			return 1;
		}

	}
	
	

}
package Principal;

public class ClasificacionEquipo {
	
	String nombreEquipo = "";
	int puntos = 0;
	int partidosJugados = 0;
	int partidosGanados = 0;
	int partidosPerdidos = 0;
	
	
	
	public ClasificacionEquipo() {
		super();
	}

	public ClasificacionEquipo(String equipo, int puntos, int J, int G, int P) {
		super();
		this.nombreEquipo = equipo;
		this.puntos = puntos;
		this.partidosJugados = J;
		this.partidosGanados = G;
		this.partidosPerdidos = P;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	@Override
	public String toString() {
		return "ClasificacionEquipo [Equipo: " + nombreEquipo + ", Puntos: " + puntos + ", J: "
				+ partidosJugados + ", G: " + partidosGanados + ", P: " + partidosPerdidos
				+ "]";
	}

}

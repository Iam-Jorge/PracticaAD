package Principal;

import java.util.List;

public interface Persistencia {

	// CLub
	
	Club buscarClub(String nombre);

	int guardarClub(Club club);

	int borrarClub(Club club);

	List<Club> listadoClub(String filtro);

	// Competicion
	
	Competicion buscarCompeticion(String nombre);

	int borrarCompeticion(Competicion competicion);

	int guardarCompeticion(Competicion competicion);
	
	List<Competicion> listadoCompeticion(String filtro);
	
	// Jugador

	Jugador buscarJugador(String email);
	
	List<Jugador> listadoJugador(String nombre, String email);
	
	List<Jugador> listadoJugador();
	
	Jugador buscarJugadorNombre(String nombre);
	
	int borrarJugador(Jugador jugador);

	int guardarJugador(Jugador jugador);
	
	// Equipo

	Equipo buscarEquipo(String id);

	int borrarEquipo(Equipo equipo);

	int guardarEquipo(Equipo equipo);
	
	List<Equipo> listadoEquipo();

	// Grupo

	int guardarGrupo(Grupo grupo);

	int guardarPartido(Partido partido);
	
	Grupo buscarGrupo(String id);

	// Set

	int guardarSet(Set set);
	
	Principal.Set buscarSet(int id);
	
	// Partido 
	
	Partido buscarPartido(int id);
	
}

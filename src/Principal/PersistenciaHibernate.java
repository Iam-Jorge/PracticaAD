package Principal;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class PersistenciaHibernate implements Persistencia {
	Session sesion;
	
    public PersistenciaHibernate(String fichCfg, boolean mostrarSQL) {
    	SessionFactory sessionFactory;
    	Configuration configuration = new Configuration();
    	try {
    		configuration.configure(fichCfg);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error con el archivo de configuración de hibernate " + e.getCause(), "Error", JOptionPane.ERROR_MESSAGE);
		}
    	if (mostrarSQL) {
    		configuration.setProperty("hibernate.show_sql", "true");
    		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	    sesion=sessionFactory.openSession();
		}
	}
    
    public Session getSesion() {
		return sesion;
	}
    
    public void abrirSesion() {
    	SessionFactory sessionFactory;
    	Configuration configuration = new Configuration();
    	configuration.setProperty("hibernate.show_sql", "true");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    this.sesion=sessionFactory.openSession();
	}
    
    public void cerrarSesion() {
		sesion.close();
	}
    
    
    // Club
	public Club buscarClub(String nombre) {
		Query query = sesion.createQuery("Select c from Club c WHERE nombre = ?");
		query.setString(0, nombre);
		Club club = (Club) query.uniqueResult();
		return club;
	}

	public int guardarClub(Club club){
		sesion.beginTransaction();
		sesion.save(club);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.clear();
		return club.getId();
	}
	
	public int borrarClub(Club club){
		sesion.beginTransaction();
		sesion.delete(club);
		sesion.getTransaction().commit();
		return club.getId();
	}
	
	public List listadoClub(String nombre) {
		Query query = sesion.createQuery("SELECT c FROM Club c WHERE nombre like '%" + nombre + "%'");
		List<Club> clubs = query.list();
		return clubs;
	}
	
	// Competicion
	public Competicion buscarCompeticion(String nombre) {
		Query query = sesion.createQuery("Select c from Competicion c WHERE nombre = ?");
		query.setString(0, nombre);
		Competicion competicion = (Competicion) query.uniqueResult();
		return competicion;
	}
	
	public int guardarCompeticion(Competicion competicion){
		sesion.beginTransaction();
		sesion.save(competicion);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.clear();
		return competicion.getId();
	}
	
	public int borrarCompeticion(Competicion competicion) {
		sesion.beginTransaction();
		sesion.delete(competicion);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.clear();
		return competicion.getId();
	}
	
	public List listadoCompeticion(String nombre) {
		Query query = sesion.createQuery("SELECT c FROM Competicion c WHERE nombre like '%" + nombre + "%'");
		List<Competicion> competiciones = query.list();
		return competiciones;
	}
	
	// Jugador
	public Jugador buscarJugador(String email) {
		Query query = sesion.createQuery("Select j from Jugador j WHERE email = ?");
		query.setString(0, email);
		Jugador jugador = (Jugador) query.uniqueResult();
		return jugador;
	}
	
	public Jugador buscarJugadorNombre(String nombre) {
		Query query = sesion.createQuery("Select j from Jugador j WHERE nombre = ?");
		query.setString(0, nombre);
		Jugador jugador = (Jugador) query.uniqueResult();
		return jugador;
	}
	
	public int guardarJugador(Jugador jugador){
		sesion.beginTransaction();
		sesion.save(jugador);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.clear();
		return jugador.getId();
	}
	
	public int borrarJugador(Jugador jugador) {
		sesion.beginTransaction();
		sesion.delete(jugador);
		sesion.getTransaction().commit();
		sesion.flush();
		sesion.clear();
		return jugador.getId();
	}
	
	public List listadoJugador(String email, String nombre) {
		Query query = sesion.createQuery("SELECT j FROM Jugador j WHERE email like '%" + email + "%' and nombre like '%" + nombre +"%'");
		List<Jugador> jugadores = query.list();
		return jugadores;
	}
	
	public List listadoJugador() {
		Query query = sesion.createQuery("SELECT j FROM Jugador j");
		List<Jugador> jugadores = query.list();
		return jugadores;
	}
	
	// Equipo
	public Equipo buscarEquipo(String id) {
		Query query = sesion.createQuery("Select e from Equipo e WHERE id = ?");
		query.setString(0, id);
		Equipo equipo = (Equipo) query.uniqueResult();
		return equipo;
	}
	
	public int guardarEquipo(Equipo equipo) {
		sesion.beginTransaction();
		sesion.save(equipo);
		sesion.getTransaction().commit();
		sesion.flush();
		return equipo.getId();
	}
	
	public int borrarEquipo(Equipo equipo) {
		sesion.beginTransaction();
		sesion.delete(equipo);
		sesion.getTransaction().commit();
		sesion.flush();
		return equipo.getId();
	}
	
	public List listadoEquipo() {
		Query query = sesion.createQuery("SELECT e FROM Equipo e");
		List<Equipo> equipos = query.list();
		return equipos;
	}
	
	public boolean aniadirPartido(Equipo e, Partido p) {
		e.getPartidos().add(p);
		p.getEquipos().add(e);
		sesion.beginTransaction();
		sesion.save(e);
		sesion.getTransaction().commit();
		return true;
	}
	
	// Grupo
	public int guardarGrupo(Grupo grupo){
		sesion.beginTransaction();
		sesion.save(grupo);
		sesion.getTransaction().commit();
		sesion.flush();
		return grupo.getId();
	}
	
	public Integer borrarGrupo(Grupo grupo) {
		sesion.beginTransaction();
		sesion.delete(grupo);
		sesion.getTransaction().commit();
		sesion.flush();
		return grupo.getId();
	}
	
	public List listadoGrupo() {
		Query query = sesion.createQuery("SELECT g FROM Grupo g");
		List<Grupo> grupos = query.list();
		return grupos;
	}
	
	// Partido
	public int guardarPartido(Partido partido){
		sesion.beginTransaction();
		sesion.save(partido);
		sesion.getTransaction().commit();
		return partido.getId();
	}
	
	// Set 
	public int guardarSet(Principal.Set set){
		sesion.beginTransaction();
		sesion.save(set);
		sesion.getTransaction().commit();
		return set.getId();
	}

	@Override
	public Partido buscarPartido(int id) {
		Query query = sesion.createQuery("Select p from Partido p WHERE id = ?");
		query.setInteger(0, id);
		Partido partido = (Partido) query.uniqueResult();
		return partido;
	}

	@Override
	public Principal.Set buscarSet(int id) {
		Query query = sesion.createQuery("Select s from set s WHERE id = ?");
		query.setInteger(0, id);
		Principal.Set set = (Principal.Set) query.uniqueResult();
		return set;
	}

	public Grupo buscarGrupo(String id) {
		return null;
	}
}
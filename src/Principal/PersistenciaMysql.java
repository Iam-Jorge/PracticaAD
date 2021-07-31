package Principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import java.util.Set;

public class PersistenciaMysql implements Persistencia {
	Connection conn;

	public PersistenciaMysql(String ip, String puerto, String usuario, String passwd, String baseDatos)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String cadenaConexion = "jdbc:mysql://" + ip + ":" + puerto + "/" + baseDatos;
		conn = DriverManager.getConnection(cadenaConexion, usuario, passwd);
	}

	public void desconectar() throws Exception {
		conn.close();
	}

	@Override
	public Club buscarClub(String nombre) {
		PreparedStatement ps;
		Club club = null;
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Club where nombre = '" + nombre + "'");
			while (rs.next()) { 
				club = new Club();
				club.setId(rs.getInt("id"));
				club.setNombre(rs.getString("nombre"));
				club.setDireccion(rs.getString("direccion"));
				Set<Competicion> competiciones = listadoCompeticionClub(club.getId());
				club.setCompeticions(competiciones);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return club;
	}

	@Override
	public int guardarClub(Club club) {
		PreparedStatement ps = null;
		int id = 0;
		try {
			if (club.getId() == null) {
				String sqlInsert = "INSERT INTO CLUB (nombre,direccion) VALUES(?,?)";
				ps = (PreparedStatement) conn.prepareStatement(sqlInsert);
				ps.setString(1, club.getNombre());
			    ps.setString(2, club.getDireccion());
			    ps.executeUpdate();
			    ps.close();
			} else {
				String sqlInsert = "UPDATE CLUB SET nombre = ?, direccion = ?  WHERE id = ?";
				ps = (PreparedStatement) conn.prepareStatement(sqlInsert);
				ps.setString(1, club.getNombre());
			    ps.setString(2, club.getDireccion());
			    Set<Competicion> competiciones = club.getCompeticions();
			    for (Competicion competicion : competiciones) {
			    	String sqlInsertCompeticion = "INSERT INTO COMPETICION (id,nombre,fechaIni,fechaFin,maxEquipGrupo,ascDesc,indivDobles,idclub) VALUES(?,?,?,?,?,?,?,?)";
					Competicion comp = new Competicion();
			    	ps = (PreparedStatement) conn.prepareStatement(sqlInsertCompeticion);
					ps.setInt(1, comp.getId());
				    ps.setString(2, comp.getNombre());
				    ps.setDate(3, (Date) comp.getFechaIni());
				    ps.setDate(4, (Date) comp.getFechaFin());
				    ps.setInt(5, comp.getMaxEquipGrupo());
				    ps.setInt(6, comp.getAscDesc());
				    ps.setString(7, comp.getIndivDobles());
				    ps.setInt(8, club.getId());
				    ps.executeUpdate();
				}
			    ps.executeUpdate();
			    ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return club.getId();
	}

	@Override
	public int borrarClub(Club club) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.execute("DELETE FROM CLUB WHERE ID = " + club.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return club.getId();
	}

	@Override
	public List<Club> listadoClub(String nombre) {
		PreparedStatement ps;
		Club club = null;
		List<Club> clubs = new ArrayList<Club>();
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM club WHERE nombre LIKE '%" + nombre + "%'");
			while (rs.next()) { 
				club = new Club();
				club.setId(rs.getInt("id"));
				club.setNombre(rs.getString("nombre"));
				club.setDireccion(rs.getString("direccion"));
				clubs.add(club);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clubs;
	}
	
	// Competicion

	@Override
	public Competicion buscarCompeticion(String nombre) {
		PreparedStatement ps;
		Competicion competicion = null;
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM competicion WHERE nombre like '%" + nombre + "%'";
			ResultSet rs = stmt.executeQuery (sql);
			while (rs.next()) { 
				competicion = new Competicion();
				competicion.setId(rs.getInt("id"));
				competicion.setNombre(rs.getString("nombre"));
				competicion.setFechaIni(rs.getDate("fechaIni"));
				competicion.setFechaFin(rs.getDate("fechaFin"));
				competicion.setMaxEquipGrupo(rs.getInt("maxEquipGrupo"));
				competicion.setAscDesc(rs.getInt("ascDesc"));
				competicion.setIndivDobles(rs.getString("indivDobles"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competicion;
	}

	@Override
	public int borrarCompeticion(Competicion competicion) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.execute("DELETE FROM Competicion WHERE ID = " + competicion.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competicion.getId();
	}
	
	@Override
	public List<Competicion> listadoCompeticion(String filtro) {
		PreparedStatement ps;
		Competicion competicion = null;
		List<Competicion> competiciones = new ArrayList<Competicion>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Competicion WHERE nombre LIKE '%" + filtro + "%'");
			while (rs.next()) { 
				competicion = new Competicion();
				competicion.setId(rs.getInt("id"));
				competicion.setNombre(rs.getString("nombre"));
				competicion.setFechaIni(rs.getDate("fechaIni"));
				competicion.setFechaFin(rs.getDate("fechaFin"));
				competicion.setMaxEquipGrupo(rs.getInt("maxEquipGrupo"));
				competicion.setAscDesc(rs.getInt("ascDesc"));
				competicion.setIndivDobles(rs.getString("indivDobles"));
				competiciones.add(competicion);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competiciones;
	}
	
	public Set<Competicion> listadoCompeticionClub(int idclub) {
		PreparedStatement ps;
		Competicion competicion = null;
		Set<Competicion> competiciones = new HashSet<Competicion>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Competicion WHERE idclub = '" + idclub + "'");
			while (rs.next()) { 
				competicion = new Competicion();
				competicion.setId(rs.getInt("id"));
				competicion.setNombre(rs.getString("nombre"));
				competicion.setFechaIni(rs.getDate("fechaIni"));
				competicion.setFechaFin(rs.getDate("fechaFin"));
				competicion.setMaxEquipGrupo(rs.getInt("maxEquipGrupo"));
				competicion.setAscDesc(rs.getInt("ascDesc"));
				competicion.setIndivDobles(rs.getString("indivDobles"));
				competiciones.add(competicion);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competiciones;
	}

	@Override
	public int guardarCompeticion(Competicion competicion) {
		PreparedStatement ps = null;
		try {
			if (competicion.getId() == null) {
				String sqlInsert = "INSERT INTO COMPETICION (id,nombre,fechaIni,fechaFin,maxEquipGrupo,ascDesc,indivDobles,idclub) VALUES(?,?,?,?,?,?,?,?)";
				ps = (PreparedStatement) conn.prepareStatement(sqlInsert);
				Competicion comp = new Competicion();
		    	ps = (PreparedStatement) conn.prepareStatement(sqlInsert);
				ps.setInt(1, comp.getId());
			    ps.setString(2, comp.getNombre());
			    ps.setDate(3, (Date) comp.getFechaIni());
			    ps.setDate(4, (Date) comp.getFechaFin());
			    ps.setInt(5, comp.getMaxEquipGrupo());
			    ps.setInt(6, comp.getAscDesc());
			    ps.setString(7, comp.getIndivDobles());
			    //ps.setInt(8, club.getId());
			    ps.executeUpdate();
			    ps.close();
			} else {
				
			    ps.executeUpdate();
			    ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// ID
		return 0;
	}
	
	// Jugador

	@Override
	public Jugador buscarJugador(String email) {
		PreparedStatement ps;
		Jugador jugador = null;
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Jugador where email = '" + email + "'");
			while (rs.next()) { 
				jugador = new Jugador();
				jugador.setId(rs.getInt("id"));
				jugador.setEmail(rs.getString("email"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setFechaNac(rs.getDate("fechaNac"));
				jugador.setNivel(rs.getInt("nivel"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jugador;
	}
	
	@Override
	public List<Jugador> listadoJugador(String nombre, String email) {
		PreparedStatement ps;
		Jugador jugador = null;
		List<Jugador> jugadores = new ArrayList<Jugador>();
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Jugador WHERE nombre LIKE '%" + nombre + "%' AND email LIKE '%" + email + "%'");
			while (rs.next()) { 
				jugador = new Jugador();
				jugador.setId(rs.getInt("id"));
				jugador.setEmail(rs.getString("email"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setFechaNac(rs.getDate("fechaNac"));
				jugador.setNivel(rs.getInt("nivel"));
				jugadores.add(jugador);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jugadores;
	}
	
	@Override
	public List<Jugador> listadoJugador() {
		PreparedStatement ps;
		Jugador jugador = null;
		List<Jugador> jugadores = new ArrayList<Jugador>();
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Jugador");
			while (rs.next()) { 
				jugador = new Jugador();
				jugador.setId(rs.getInt("id"));
				jugador.setEmail(rs.getString("email"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setFechaNac(rs.getDate("fechaNac"));
				jugador.setNivel(rs.getInt("nivel"));
				jugadores.add(jugador);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jugadores;
	}

	@Override
	public Jugador buscarJugadorNombre(String nombre) {
		PreparedStatement ps;
		Jugador jugador = null;
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Jugador where nombre = '" + nombre + "'");
			while (rs.next()) { 
				jugador = new Jugador();
				jugador.setId(rs.getInt("id"));
				jugador.setEmail(rs.getString("email"));
				jugador.setNombre(rs.getString("nombre"));
				jugador.setFechaNac(rs.getDate("fechaNac"));
				jugador.setNivel(rs.getInt("nivel"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jugador;
	}
	
	@Override
	public int borrarJugador(Jugador jugador) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.execute("DELETE FROM Jugador WHERE ID = " + jugador.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jugador.getId();
	}
	
	@Override
	public int guardarJugador(Jugador jugador) {
		return 0;
	}
	
	// Equipo
	
	@Override
	public Equipo buscarEquipo(String id) {
		PreparedStatement ps;
		Equipo equipo = null;
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Equipo where nombre = '" + id + "'");
			while (rs.next()) { 
				equipo = new Equipo();
				equipo.setId(rs.getInt("id"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipo;
	}

	@Override
	public int borrarEquipo(Equipo equipo) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.execute("DELETE FROM Equipo WHERE ID = " + equipo.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipo.getId();
	}

	@Override
	public int guardarEquipo(Equipo equipo) {
		return 0;
	}
	
	@Override
	public List<Equipo> listadoEquipo() {
		PreparedStatement ps;
		Equipo equipo = null;
		List<Equipo> equipos = new ArrayList<Equipo>();
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Equipo");
			while (rs.next()) { 
				equipo = new Equipo();
				equipo.setId(rs.getInt("id"));
				equipos.add(equipo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return equipos;
	}

	// Grupo
	
	@Override
	public int guardarGrupo(Grupo grupo) {
		return 0;
	}

	@Override
	public Grupo buscarGrupo(String id) {
		PreparedStatement ps;
		Grupo grupo = null;
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Grupo where nombre = '" + id + "'");
			while (rs.next()) { 
				grupo = new Grupo();
				grupo.setId(rs.getInt("id"));
				grupo.setOrden(rs.getInt("orden"));
				grupo.setNombre(rs.getString("nombre"));
				int idCompeticion = rs.getShort("idcompeticion");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grupo;
	}
	
	// Partido
	
	@Override
	public int guardarPartido(Partido partido) {
		return 0;
	}

	@Override
	public Partido buscarPartido(int id) {
		PreparedStatement ps;
		Partido partido = null;
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Partido where nombre = '" + id + "'");
			while (rs.next()) { 
				partido = new Partido();
				partido.setId(rs.getInt("id"));
				partido.setFechaHora(rs.getDate("fechaHora"));
				String idGrupo = rs.getString("idgrupo");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return partido;
	}
	
	// Set

	@Override
	public int guardarSet(Principal.Set set) {
		return 0;
	}

	@Override
	public Principal.Set buscarSet(int id) {
		PreparedStatement ps;
		Principal.Set set = null;
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery ("SELECT * FROM Set where id = '" + id + "'");
			while (rs.next()) { 
				set = new Principal.Set();
				set.setId(rs.getInt("id"));
				set.setOrden(rs.getInt("orden"));
				set.setRes1(rs.getInt("res1"));
				set.setRes2(rs.getInt("res2"));
				String idEquipo = rs.getString("idequipoganador");
				Equipo equipo = buscarEquipo(idEquipo);
				set.setEquipo(equipo);
				String idPartido = rs.getString("idpartido");
				Partido partido = buscarPartido(Integer.parseInt(idPartido));
				set.setPartido(partido);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return set;
	}

}

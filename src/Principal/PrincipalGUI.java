package Principal;

import java.awt.EventQueue;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class PrincipalGUI extends JFrame implements Persistencia {

	private JPanel contentPane;
	private JButton btnNewButton_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalGUI frame = new PrincipalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalGUI() {
		setTitle("PrincipalGUI");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnNewButton = new JButton("MySql");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoPersistencia = "mysqlJDBC";
				persistencia(tipoPersistencia);
			}
		});
		btnNewButton.setBounds(37, 137, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Hibernate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoPersistencia = "hibernate";
				persistencia(tipoPersistencia);
			}
		});
		btnNewButton_1.setBounds(299, 137, 89, 23);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("Pr\u00E1ctica. Competiciones Tenis/P\u00E1del");
		lblNewLabel.setFont(new Font("Garamond", Font.BOLD, 18));
		lblNewLabel.setBounds(64, 31, 303, 28);
		contentPane.add(lblNewLabel);
	}

	public static Persistencia per;
	private JLabel lblNewLabel;
	protected void persistencia(String tipoPersistencia) {
		//Cargar CFG.INI
		Properties prop=new Properties();
		try {
			prop.load(new FileReader("CFG.INI"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Tipo persistencia
		switch (tipoPersistencia){
		   case "mysqlJDBC":
		      String servidor=prop.getProperty("mysqlJDBC.servidor");
		      String baseDatos=prop.getProperty("mysqlJDBC.basedatos");
		      String puerto=prop.getProperty("mysqlJDBC.puerto");
		      String usuario=prop.getProperty("mysqlJDBC.usuario");
		      String password=prop.getProperty("mysqlJDBC.password");
		      if (servidor.length() == 0 || baseDatos.length() == 0 || puerto.length() == 0 || usuario.length() == 0 || password.length() == 0) {
		    	  JOptionPane.showMessageDialog(null, "Faltan parámetros en el archivo de configuracion.", "Error", JOptionPane.ERROR_MESSAGE);
		    	  System.exit(1);
		      } else {
		    	  try {
						per=new PersistenciaMysql(servidor, puerto, usuario, password, baseDatos);
				      } catch (ClassNotFoundException e) {
						JOptionPane.showMessageDialog(null, "No fue posible encontrar el Driver de MySql " + e.getCause(), "Error",
								JOptionPane.ERROR_MESSAGE);
						System.exit(1);
				      } catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Se ha producido un error inesperado " + "\n" + 
								"SQLException " + e.getMessage() + "\n" +
								"SQLState " + e.getSQLState() + "\n" + 
								"VendorError " + e.getErrorCode(), "Error",
								JOptionPane.ERROR_MESSAGE);
				      }
		      }
		      break;
		   case "hibernate":
			   String archivoHibernate = prop.getProperty("hibernate.archivoCFG");
			   if (archivoHibernate.length() == 0) {
				   JOptionPane.showMessageDialog(null, "El archivo de configuración de hibernate no fue especificado.", "Error", JOptionPane.ERROR_MESSAGE);
				   System.exit(1);
			   } else {
				   per = new PersistenciaHibernate(prop.getProperty("hibernate.archivoCFG"), true);
			   }
		      break;
		   default:
	   }
		ClubGUI clubGUI = new ClubGUI();
		clubGUI.setVisible(true);
		this.dispose();
	}

	public Club buscarClub(String nombre) {
		return null;
	}

	public int guardarClub(Club club) {
		return 0;
	}

	public int borrarClub(Club club) {
		return 0;
	}

	public List<Club> listadoClub(String filtro) {
		return null;
	}

	public Competicion buscarCompeticion(String nombre) {
		return null;
	}

	public int borrarCompeticion(Competicion competicion) {
		return 0;
	}

	public int guardarCompeticion(Competicion competicion) {
		return 0;
	}

	public Jugador buscarJugador(String email) {
		return null;
	}

	public Equipo buscarEquipo(String id) {
		return null;
	}

	public int borrarEquipo(Equipo equipo) {
		return 0;
	}

	public int guardarEquipo(Equipo equipo) {
		return 0;
	}

	public List<Jugador> listadoJugador(String nombre, String email) {
		return null;
	}

	public int guardarGrupo(Grupo grupo) {
		return 0;
	}

	public int guardarPartido(Partido partido) {
		return 0;
	}

	public List<Competicion> listadoCompeticion(String filtro) {
		return null;
	}

	public List<Jugador> listadoJugador() {
		return null;
	}

	public Jugador buscarJugadorNombre(String nombre) {
		return null;
	}

	public List<Equipo> listadoEquipo() {
		return null;
	}

	public int borrarJugador(Jugador jugador) {
		return 0;
	}

	public int guardarJugador(Jugador jugador) {
		return 0;
	}

	public int guardarSet(Set set1) {
		return 0;
	}

	public Partido buscarPartido(int id) {
		return null;
	}

	public Set buscarSet(int id) {
		return null;
	}

	public void abrirSesion() {
	}

	public void cerrarSesion() {
	}

	public Grupo buscarGrupo(String id) {
		return null;
	}

}

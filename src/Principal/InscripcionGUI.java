package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Principal.ClubGUI.Listado;
import Principal.CompeticionGUI.ListadoCompeticion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class InscripcionGUI extends JFrame {
	static Persistencia pers = PrincipalGUI.per;
	private JPanel contentPane;
	private JLabel lblClub;
	private JTextField textFieldClub;
	private JLabel lblNewLabel;
	private JTextField textFieldCompeticion;
	private JButton btnBuscarClub;
	private JButton btnBuscarCompeticion;
	private JScrollPane scrollPane_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionGUI frame = new InscripcionGUI();
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
	public InscripcionGUI() {
		setResizable(false);
		setTitle("Inscripi\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 378);
		setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Clubes");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Nuevo Club");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClubGUI clubGUI = new ClubGUI();
				clubGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Competiciones");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Nueva Competici\u00F3n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompeticionGUI competicionGUI = new CompeticionGUI();
				competicionGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_4 = new JMenuItem("Inscripci\u00F3n");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		mntmNuevoGrupo = new JMenuItem("Nuevo Grupo");
		mntmNuevoGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrupoGUI grupoGUI = new GrupoGUI();
				grupoGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNuevoGrupo);
		
		mntmPartidos = new JMenuItem("Resultados");
		mntmPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultadosGUI resultadosGUI = new ResultadosGUI();
				resultadosGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmPartidos);
		
		mntmPromocin = new JMenuItem("Promoci\u00F3n");
		mntmPromocin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromocionGUI promocionGui = new PromocionGUI();
				promocionGui.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmPromocin);
		
		mnNewMenu_2 = new JMenu("Jugadores");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_2 = new JMenuItem("Nuevo Jugador");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JugadorGUI jugadorGUI = new JugadorGUI();
				jugadorGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Nuevo Equipo");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipoGUI equipoGUI = new EquipoGUI();
				equipoGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		mntmNewMenuItem_5 = new JMenuItem("Clasificaci\u00F3n");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeClasificacionGUI clasificacionGUi = new InformeClasificacionGUI();
				clasificacionGUi.setVisible(true);
				dispose();
			}
		});
		mnInformes.add(mntmNewMenuItem_5);
		
		mntmNewMenuItem_6 = new JMenuItem("Partidos jugados");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformePartidosJugadorGUI partidosJugadosGUI = new InformePartidosJugadorGUI();
				partidosJugadosGUI.setVisible(true);
				dispose();
			}
		});
		mnInformes.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblClub = new JLabel("Club");
		lblClub.setBounds(28, 30, 46, 14);
		contentPane.add(lblClub);
		
		textFieldClub = new JTextField();
		textFieldClub.setBounds(111, 27, 199, 20);
		contentPane.add(textFieldClub);
		textFieldClub.setColumns(10);
		
		lblNewLabel = new JLabel("Competici\u00F3n");
		lblNewLabel.setBounds(28, 75, 75, 14);
		contentPane.add(lblNewLabel);
		
		textFieldCompeticion = new JTextField();
		textFieldCompeticion.setColumns(10);
		textFieldCompeticion.setBounds(111, 72, 199, 20);
		contentPane.add(textFieldCompeticion);
		
		btnBuscarClub = new JButton("Buscar");
		btnBuscarClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarClub();
			}
		});
		btnBuscarClub.setBounds(320, 26, 89, 23);
		contentPane.add(btnBuscarClub);
		
		btnBuscarCompeticion = new JButton("Buscar");
		btnBuscarCompeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCompeticion();
			}
		});
		btnBuscarCompeticion.setBounds(320, 71, 89, 23);
		contentPane.add(btnBuscarCompeticion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 128, 120, 164);
		contentPane.add(scrollPane);
		
		jListSinInscribir = new JList();
		scrollPane.setViewportView(jListSinInscribir);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(289, 129, 120, 164);
		contentPane.add(scrollPane_1);
		
		jListInscritos = new JList();
		scrollPane_1.setViewportView(jListInscritos);
		
		JLabel lblPorInscribir = new JLabel("Sin inscribir");
		lblPorInscribir.setBounds(59, 103, 100, 14);
		contentPane.add(lblPorInscribir);
		
		JLabel lblInscritos = new JLabel("Inscritos");
		lblInscritos.setBounds(330, 104, 57, 14);
		contentPane.add(lblInscritos);
		
		btnAniadir = new JButton("A\u00F1adir");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirEquipo();
			}
		});
		btnAniadir.setBounds(170, 156, 89, 23);
		contentPane.add(btnAniadir);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarInscripcion();
			}
		});
		btnQuitar.setBounds(170, 190, 89, 23);
		contentPane.add(btnQuitar);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldClub.setText("");
				textFieldCompeticion.setText("");
				btnBuscarCompeticion.setEnabled(false);
				btnBuscarClub.setEnabled(true);
				btnAniadir.setEnabled(false);
				btnQuitar.setEnabled(false);
				modelInscritos.removeAllElements();
				modelSinInscribir.removeAllElements();
			}
		});
		btnCancelar.setBounds(170, 248, 89, 23);
		contentPane.add(btnCancelar);
		btnAniadir.setEnabled(false);
		btnQuitar.setEnabled(false);
		btnBuscarCompeticion.setEnabled(false);
		textFieldCompeticion.setEnabled(false);
	}
	
	public static DefaultListModel modelInscritos = new DefaultListModel();
	public static DefaultListModel modelSinInscribir = new DefaultListModel();
	protected void aniadirEquipo() {
		try {
			String equipoString = "";
			try {
				equipoString = (String) modelSinInscribir.get(jListSinInscribir.getSelectedIndex());
				modelSinInscribir.remove(jListSinInscribir.getSelectedIndex());
				modelInscritos.add(0, equipoString);
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			
			String[] tokens = equipoString.split(" ");
			String idEquipo = "";
			String jugadorUno = "";
			Jugador juador1 = null;
			String jugadorDos = "";
			Jugador jugador2 = null;
			if (tokens.length > 2) {
				jugadorDos = tokens[2];
				jugador2 = pers.buscarJugadorNombre(jugadorDos);
			}
			idEquipo = tokens[0];
			try {
				jugadorUno = tokens[1];
			} catch (ArrayIndexOutOfBoundsException e) {
			}
			juador1 = pers.buscarJugadorNombre(jugadorUno);
			
			Competicion competicion = pers.buscarCompeticion(textFieldCompeticion.getText());
			Set<Equipo> equiposInscritos = competicion.getEquipos();
			List<Equipo> equipos = pers.listadoEquipo();
			for (Equipo equipo : equipos) {
				if (equipo.getId().toString().equalsIgnoreCase(idEquipo)) {
					equiposInscritos.add(equipo);
				}
			}
			pers.guardarCompeticion(competicion);
			JOptionPane.showMessageDialog(this, "Inscrito");
			//JOptionPane.showMessageDialog(this, "Número máximo de jugadores alcanzado", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void quitarInscripcion() {
		try {
			String equipoString = (String) modelInscritos.get(jListInscritos.getSelectedIndex());
			
			String[] tokens = equipoString.split(" ");
			String idEquipo = "";
			String jugadorUno = "";
			Jugador juador1 = null;
			String jugadorDos = "";
			Jugador jugador2 = null;
			if (tokens.length > 2) {
				jugadorDos = tokens[2];
				jugador2 = pers.buscarJugadorNombre(jugadorDos);
			}
			idEquipo = tokens[0];
			jugadorUno = tokens[1];
			juador1 = pers.buscarJugadorNombre(jugadorUno);
			
			Competicion competicion = pers.buscarCompeticion(textFieldCompeticion.getText());
			Set<Equipo> equiposInscritos = competicion.getEquipos();
			List<Equipo> equipos = pers.listadoEquipo();
			for (Equipo equipo : equipos) {
				if (equipo.getId().toString().equalsIgnoreCase(idEquipo)) {
					Set<Partido> partidos = equipo.getPartidos();
					if (partidos.size() == 0) {
						equiposInscritos.remove(equipo);
						pers.guardarCompeticion(competicion);
						JOptionPane.showMessageDialog(this, "Inscripción cancelada");
						// Inscritos / Sin inscribir
						modelInscritos.remove(jListInscritos.getSelectedIndex());
						modelSinInscribir.add(0, equipoString);
					} else {
						JOptionPane.showMessageDialog(this, "Competición activa, no puede cancelar su inscripción.");
					}
				}
			}
			//JOptionPane.showMessageDialog(this, "Número máximo de jugadores alcanzado", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			
		}
	}
	

	protected void buscarClub() {
		Listado listado = new Listado();
		listado.setVisible(true);
		
	}
	
	// GUI Listado
	public Club clubSeleccionado = null;
	class Listado extends JFrame {

		public Listado() {
			setTitle("Clubs");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setLocationRelativeTo(null);
			
			// Boton Cancelar
	    	JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancelar.setBounds(316, 216, 89, 23);
			contentPane.add(btnCancelar);
			
			String filtro = textFieldClub.getText().trim().toUpperCase();
			List<Club> listadoClub = pers.listadoClub(filtro);
			if (listadoClub.size() == 0) {
				JLabel lbl1 = new JLabel("Clubs que contienen \"" + filtro + "\"");
				lbl1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lbl1.setBounds(118, 11, 188, 14);
				contentPane.add(lbl1);
				JLabel lbl2 = new JLabel("No se encontr\u00F3 ninguna coincidencia de Club con el filtro " + filtro + ".");
				lbl2.setBounds(35, 35, 380, 50);
				contentPane.add(lbl2);
			} else {
				// Crear tabla
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(25, 25, 380, 180);
				contentPane.add(scrollPane);
				table = new JTable();
				table.setRowSelectionAllowed(true);
		        table.setColumnSelectionAllowed(false);
		        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
				
				// Cargar tabla
				DefaultTableModel modelo = new DefaultTableModel();
				String[] encabezado = {"ID", "Nombre", "Descripcón" }; 
				modelo.setColumnIdentifiers(encabezado);
				table.setModel(modelo);
				Object Obj [] = null;
		    	for (int i = 0; i < listadoClub.size(); i++) {
		    		modelo.addRow(Obj);
		            Club club = (Club) listadoClub.get(i);
		            modelo.setValueAt(club.getId(), i, 0);
		            modelo.setValueAt(club.getNombre(), i, 1);
		            modelo.setValueAt(club.getDireccion(), i, 2);
		    	}
		    	
		    	// Selecciona tabla
		    	table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						int seleccion = table.getSelectedRow();
						clubSeleccionado = listadoClub.get(seleccion);
						textFieldClub.setText(clubSeleccionado.getNombre());
						textFieldCompeticion.setEnabled(true);
						btnBuscarCompeticion.setEnabled(true);
						textFieldClub.setEnabled(false);
						btnBuscarClub.setEnabled(false);
						dispose();
					}
				});
			}
			
		}
	}
	
	protected void buscarCompeticion() {
		ListadoCompeticion listadoCompeticion = new ListadoCompeticion();
		listadoCompeticion.setVisible(true);
	}
	
	public static Set<String> parejasUnicasInscritas = new HashSet();
	// GUI Listado competicion
	public Competicion competicionSeleccionada = null;
	private JButton btnAniadir;
	private JButton btnQuitar;
	private JButton btnCancelar;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JList jListInscritos;
	private JList jListSinInscribir;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNuevoGrupo;
	private JMenu mnInformes;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmPartidos;
	private JMenuItem mntmPromocin;
	class ListadoCompeticion extends JFrame {

		public ListadoCompeticion() {
			setTitle("Competiciones");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setLocationRelativeTo(null);
			
			// Boton Cancelar
	    	JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCancelar.setBounds(316, 216, 89, 23);
			contentPane.add(btnCancelar);

			
			String filtroClub = textFieldClub.getText().trim().toUpperCase();
			String filtro = textFieldCompeticion.getText().trim().toUpperCase();
			
			// Competiciones del Club
			Club club = pers.buscarClub(filtroClub);
			List<Competicion> competiciones = new ArrayList<Competicion>(club.getCompeticions());
			
			if (competiciones.size() == 0) {
				JLabel lbl1 = new JLabel("Competiciones que contienen \"" + filtro + "\"");
				lbl1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lbl1.setBounds(110, 11, 220, 14);
				contentPane.add(lbl1);
				JLabel lbl2 = new JLabel("No se encontr\u00F3 ninguna coincidencia de competición con el filtro " + filtro + ".");
				lbl2.setBounds(35, 35, 380, 50);
				contentPane.add(lbl2);
			} else {
				// Crear tabla
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(25, 25, 380, 180);
				contentPane.add(scrollPane);
				table = new JTable();
				table.setRowSelectionAllowed(true);
		        table.setColumnSelectionAllowed(false);
		        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
				
				// Cargar tabla
				DefaultTableModel modelo = new DefaultTableModel();
				String[] encabezado = {"ID", "Nombre", "Fecha inicio", "Fecha fin", "Número de grupos", "Modalidad" }; 
				modelo.setColumnIdentifiers(encabezado);
				table.setModel(modelo);
				Object Obj [] = null;
		    	for (int i = 0; i < competiciones.size(); i++) {
		    		modelo.addRow(Obj);
		            Competicion competicion = (Competicion) competiciones.get(i);
		            modelo.setValueAt(competicion.getId(), i, 0);
		            modelo.setValueAt(competicion.getNombre(), i, 1);
		            modelo.setValueAt(competicion.getFechaIni(), i, 2);
		            modelo.setValueAt(competicion.getFechaFin(),i , 3);
		            modelo.setValueAt(competicion.getMaxEquipGrupo(), i, 4);
		            modelo.setValueAt(competicion.getIndivDobles(), i, 5);
		    	}}
		    	
			// Selecciona tabla
			try {
	    	table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int seleccion = table.getSelectedRow();
					Competicion competicionSeleccionada = competiciones.get(seleccion);
					textFieldCompeticion.setText(competicionSeleccionada.getNombre());
					textFieldCompeticion.setEnabled(false);
					btnBuscarCompeticion.setEnabled(false);
					btnAniadir.setEnabled(true);
					btnQuitar.setEnabled(true);
					cargarInscritos();
					cargarSinInscribir();
					dispose();
				}
			});
			} catch (Exception e) {
			}
		}
		
		protected void cargarInscritos() {
			modelInscritos.clear();
			parejasUnicasInscritas.clear();
			Competicion competicon = pers.buscarCompeticion(textFieldCompeticion.getText().trim());
			
			List<Equipo> equiposList = new ArrayList<Equipo>(competicon.getEquipos());
			for (Equipo equipo : equiposList) {
				List<Jugador> jugadoresList = new ArrayList<Jugador>(equipo.getJugadors());
				String pareja = "";
				for (int i = 0; i < jugadoresList.size(); i++) {
					if (jugadoresList.size() == 1) {
						parejasUnicasInscritas.add(equipo.getId() + " " + jugadoresList.get(i).getNombre());
					} else if (jugadoresList.size() > 1) {
						pareja = jugadoresList.get(0).getNombre() + " " + jugadoresList.get(1).getNombre();
						parejasUnicasInscritas.add(equipo.getId() + " " + pareja);
					}
				}
			}
			List<String> parejasUnicasInscritasList = new ArrayList<String>(parejasUnicasInscritas);
			for (String pareja : parejasUnicasInscritasList) {
				modelInscritos.addElement(pareja);
			}
			jListInscritos.setModel(modelInscritos);
		}

		protected void cargarSinInscribir() {
			modelSinInscribir.clear();
			Competicion competicion = pers.buscarCompeticion(textFieldCompeticion.getText());
			String modalidad = competicion.getIndivDobles();
			if (modalidad.equalsIgnoreCase("I")) {
				//System.out.println("Individual");
				Set<String> parejasUnicasSinInscribir = new HashSet();
				List<Jugador> jugadores = pers.listadoJugador("", "");
				List<Equipo> equiposList = new ArrayList<Equipo>();
				for (Jugador jugador : jugadores) {
					List<Equipo> equiposListTemp = new ArrayList<Equipo>(jugador.getEquipos());
					for (Equipo equipo : equiposListTemp) {
						List<Jugador> jugadoresEquipoList = new ArrayList<Jugador>(equipo.getJugadors());
						for (Jugador jugadorEquipo : jugadoresEquipoList) {
							if (jugadoresEquipoList.size() == 1) {
								parejasUnicasSinInscribir.add(equipo.getId() + " " + jugadorEquipo.getNombre());
							}
						}
					}
				}
				parejasUnicasSinInscribir.removeAll(parejasUnicasInscritas);
				List<String> parejasUnicasSinInscribirList = new ArrayList<String>(parejasUnicasSinInscribir);
				for (String pareja : parejasUnicasSinInscribirList) {
					modelSinInscribir.addElement(pareja);
				}
				jListSinInscribir.setModel(modelSinInscribir);
			} else {
				//System.out.println("Dobles");
				Set<String> parejasUnicasSinInscribir = new HashSet();
				List<Jugador> jugadores = pers.listadoJugador("", "");
				List<Equipo> equiposList = new ArrayList<Equipo>();
				// Listado de todos los Jugadores
				for (Jugador jugador : jugadores) {
					List<Equipo> equiposListTemp = new ArrayList<Equipo>(jugador.getEquipos());
					// Equipos de los que es parte un jugador
					for (Equipo equipo : equiposListTemp) {
						List<Jugador> jugadoresEquipoList = new ArrayList<Jugador>(equipo.getJugadors());
						String pareja = "";
						int cnt = 0;
						// Jugadores que forman el equipo
						for (int i = 0; i < jugadoresEquipoList.size(); i++) {
							if (jugadoresEquipoList.size() > 1) {
								pareja = jugadoresEquipoList.get(0).getNombre() + " " + jugadoresEquipoList.get(1).getNombre();
								parejasUnicasSinInscribir.add(equipo.getId() + " " + pareja);
							}
						}
					}
				}
				parejasUnicasSinInscribir.removeAll(parejasUnicasInscritas);
				List<String> parejasUnicasSinInscribirList = new ArrayList<String>(parejasUnicasSinInscribir);
				for (String pareja : parejasUnicasSinInscribirList) {
					modelSinInscribir.addElement(pareja);
				}
				jListSinInscribir.setModel(modelSinInscribir);
			}
			
		}
	}
}

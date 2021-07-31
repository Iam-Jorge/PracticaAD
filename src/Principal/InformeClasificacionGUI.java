package Principal;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class InformeClasificacionGUI extends JFrame {
	static Persistencia pers = PrincipalGUI.per;
	private JPanel contentPane;
	private JTextField textFieldClub;
	private JTextField textFieldCompeticion;
	private JTextField textFieldGrupo;
	private JTable tableEquipos;
	private JButton btnBuscarClub;
	private JButton btnBuscarCompeticion;
	private JButton btnBuscarGrupo;
	public static DefaultTableModel modelo = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformeClasificacionGUI frame = new InformeClasificacionGUI();
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
	public InformeClasificacionGUI() {
		setTitle("Clasificaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblClub = new JLabel("Club");
		lblClub.setBounds(27, 25, 46, 14);
		contentPane.add(lblClub);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClubs = new JMenu("Clubs");
		menuBar.add(mnClubs);
		
		JMenuItem mntmClub = new JMenuItem("Nuevo club");
		mntmClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClubGUI clubGUI = new ClubGUI();
				clubGUI.setVisible(true);
				dispose();
			}
		});
		mnClubs.add(mntmClub);
		
		JMenu mnCompeticion = new JMenu("Competiciones");
		menuBar.add(mnCompeticion);
		
		JMenuItem mntmNuevaCompeticion = new JMenuItem("Nueva Competici\u00F3n");
		mntmNuevaCompeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompeticionGUI competicionGUI = new CompeticionGUI();
				competicionGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticion.add(mntmNuevaCompeticion);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Inscripci\u00F3n");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InscripcionGUI inscripcionGUI = new InscripcionGUI();
				inscripcionGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticion.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Nuevo Grupo");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GrupoGUI grupoGUI = new GrupoGUI();
				grupoGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticion.add(mntmNewMenuItem_3);
		
		JMenuItem mntmPartidos = new JMenuItem("Resultados");
		mntmPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultadosGUI resultadosGUI = new ResultadosGUI();
				resultadosGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticion.add(mntmPartidos);
		
		JMenuItem mntmPromocin = new JMenuItem("Promoci\u00F3n");
		mntmPromocin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromocionGUI promocionGui = new PromocionGUI();
				promocionGui.setVisible(true);
				dispose();
			}
		});
		mnCompeticion.add(mntmPromocin);
		
		JMenuItem mnNewMenu_2 = new JMenu("Jugadores");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo Jugador");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JugadorGUI jugadorGUI = new JugadorGUI();
				jugadorGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Nuevo equipo");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EquipoGUI equipoGUI = new EquipoGUI();
				equipoGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Clasificaci\u00F3n");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeClasificacionGUI clasificacionGUI = new InformeClasificacionGUI();
				clasificacionGUI.setVisible(true);
				dispose();
			}
		});
		mnInformes.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Partidos jugados");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformePartidosJugadorGUI partidosJugados = new InformePartidosJugadorGUI();
				partidosJugados.setVisible(true);
				dispose();
			}
		});
		mnInformes.add(mntmNewMenuItem_5);
		
		
		
		textFieldClub = new JTextField();
		textFieldClub.setBounds(103, 22, 198, 20);
		contentPane.add(textFieldClub);
		textFieldClub.setColumns(10);
		
		JLabel lblCompeticin = new JLabel("Competici\u00F3n");
		lblCompeticin.setBounds(27, 58, 79, 14);
		contentPane.add(lblCompeticin);
		
		textFieldCompeticion = new JTextField();
		textFieldCompeticion.setBounds(103, 53, 198, 20);
		contentPane.add(textFieldCompeticion);
		textFieldCompeticion.setColumns(10);
		
		btnBuscarClub = new JButton("Buscar");
		btnBuscarClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarClub();
			}
		});
		btnBuscarClub.setBounds(323, 21, 89, 23);
		contentPane.add(btnBuscarClub);
		
		btnBuscarCompeticion = new JButton("Buscar");
		btnBuscarCompeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCompeticion();
			}
		});
		btnBuscarCompeticion.setBounds(323, 54, 89, 23);
		contentPane.add(btnBuscarCompeticion);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(27, 92, 46, 14);
		contentPane.add(lblGrupo);
		
		btnBuscarGrupo = new JButton("Buscar");
		btnBuscarGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarGrupo();
			}
		});
		btnBuscarGrupo.setBounds(323, 88, 89, 23);
		contentPane.add(btnBuscarGrupo);
		
		textFieldGrupo = new JTextField();
		textFieldGrupo.setBounds(101, 89, 200, 20);
		contentPane.add(textFieldGrupo);
		textFieldGrupo.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 150, 380, 119);
		contentPane.add(scrollPane);
		
		tableEquipos = new JTable();
		scrollPane.setViewportView(tableEquipos);
		
		lblEquipos = new JLabel("");
		lblEquipos.setBounds(27, 125, 274, 14);
		contentPane.add(lblEquipos);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(323, 122, 89, 23);
		contentPane.add(btnLimpiar);
		textFieldCompeticion.setEnabled(false);
		btnBuscarCompeticion.setEnabled(false);
		btnBuscarGrupo.setEnabled(false);
		textFieldCompeticion.setEnabled(false);
		textFieldGrupo.setEnabled(false);
	}

	protected void limpiar() {
		textFieldClub.setText("");
		textFieldCompeticion.setText("");
		textFieldGrupo.setText("");
		textFieldClub.setEnabled(true);
		btnBuscarGrupo.setEnabled(false);
		btnBuscarClub.setEnabled(true);
		tableEquipos.removeAll();
		modelo = new DefaultTableModel();
		tableEquipos.setModel(modelo);
	}

	protected void buscarGrupo() {
		ListadoGrupo listado = new ListadoGrupo();
		listado.setVisible(true);
	}

	protected void buscarCompeticion() {
		ListadoCompeticion listado = new ListadoCompeticion();
		listado.setVisible(true);
	}

	protected void buscarClub() {
		Listado listado = new Listado();
		listado.setVisible(true);
	}
	
	
		// Listado Grupo
		public Grupo grupoSeleccionado = null;
		class ListadoGrupo extends JFrame {

			public ListadoGrupo() {
				JTable table = new JTable();
				setTitle("Grupo");
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
				
				String filtro = textFieldGrupo.getText().trim().toUpperCase();
				List<Club> listadoClub = pers.listadoClub(filtro);
				// Crear tabla
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(25, 25, 380, 180);
				contentPane.add(scrollPane);
				table.setRowSelectionAllowed(true);
		        table.setColumnSelectionAllowed(false);
		        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
				
				// Cargar tabla
				Set<Grupo> grupos = competicionSeleccionada.getGrupos();
				List<Grupo> gruposList = new ArrayList<Grupo>(grupos);
				DefaultTableModel modelo = new DefaultTableModel();
				String[] encabezado = {"ID", "Nombre" }; 
				modelo.setColumnIdentifiers(encabezado);
				table.setModel(modelo);
				Object Obj [] = null;
		    	for (int i = 0; i < gruposList.size(); i++) {
		    		modelo.addRow(Obj);
		            Grupo grupo = (Grupo) gruposList.get(i);
		            modelo.setValueAt(grupo.getId(), i, 0);
		            modelo.setValueAt(grupo.getNombre(), i, 1);
		    	}
		    	
		    	// Selecciona tabla
		    	table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						int seleccion = table.getSelectedRow();
						grupoSeleccionado = gruposList.get(seleccion);
						textFieldGrupo.setText(grupoSeleccionado.getNombre());
						textFieldGrupo.setEnabled(false);
						btnBuscarGrupo.setEnabled(false);
						clasificacionEquipos();
						btnLimpiar.setEnabled(true);
						dispose();
					}
				});
			}

			protected void clasificacionEquipos() {
				lblEquipos.setText("Clasificación del " + grupoSeleccionado.getNombre() + " con ID " + grupoSeleccionado.getId());
				
				// Limpiar tabla
				modelo.setRowCount(0);
				
				// Nombre de los jugadores del grupo
				List<Equipo> equiposList = new ArrayList<Equipo>(grupoSeleccionado.getEquipos());
				List<ClasificacionEquipo> resultadoEquipos = new ArrayList<ClasificacionEquipo>();
		    	for (int i = 0; i < equiposList.size(); i++) {
		            Equipo equipo = (Equipo) equiposList.get(i);
		            List<Jugador> jugadores = new ArrayList<Jugador>(equipo.getJugadors());
		            String nombreJugadores = "";
		            for (Jugador jugador : jugadores) {
						nombreJugadores = nombreJugadores + " " + jugador.getNombre() + " ";
					}
		            ClasificacionEquipo resultadoPartido = new ClasificacionEquipo();
		            resultadoPartido.setNombreEquipo(nombreJugadores);
		            resultadoEquipos.add(resultadoPartido);
		    	}
	            //modelo.setValueAt(jugadoresNombres, i, 0);
	            // Total partidos del grupo
	            List<Partido> partidos = new ArrayList<Partido>(grupoSeleccionado.getPartidos());
	            for (Partido partido : partidos) {
	            	// Equipos que forman el partido
	            	List<Equipo> equiposPartido = new ArrayList<Equipo>(partido.getEquipos());
	            	String pareja1 = "";
	            	String pareja2 = "";
	            	for (int j = 0; j < equiposPartido.size(); j++) {
						List<Jugador> jugadoresEquipo = new ArrayList<Jugador>(equiposPartido.get(j).getJugadors());
						for (int k = 0; k < jugadoresEquipo.size(); k++) {
							if (j == 0) {
								pareja1 = pareja1 + " " + jugadoresEquipo.get(k).getNombre() + " ";
							} else {
								pareja2 = pareja2 + " " + jugadoresEquipo.get(k).getNombre() + " ";
							}
						}
					}
	            	// Resultados partido
	            	List<Principal.Set> sets = new ArrayList<Principal.Set>(partido.getSets());
	            	Equipo equipoSet1 = null;
	            	Equipo equipoSet2 = null;
	            	Equipo equipoSet3 = null;
	            	Equipo equipoGanador = null;
	            	try {
	            		for (Principal.Set set : sets) {
	            			if (set.getOrden() == 1) {
	            				equipoSet1 = set.getEquipo();
							}
	            			if (set.getOrden() == 2) {
	            				equipoSet2 = set.getEquipo();
							}
	            			if (set.getOrden() == 3) {
	            				equipoSet3 = set.getEquipo();
							}
						}
	            		if (sets.size() == 2) {
							equipoGanador = equipoSet1;
						} else {
							if (equipoSet1.getId() == equipoSet2.getId()) {
		            			equipoGanador = equipoSet1;
							} else if (equipoSet1.getId() == equipoSet3.getId()) {
								equipoGanador = equipoSet1;
							} else if (equipoSet2.getId() == equipoSet3.getId()) {
								equipoGanador = equipoSet2;
							}
						}
	            		// Nombre jugadores equipo ganador
	            		String parejaGanadora = "";
	            		List<Jugador> parejaEquipoGanador = new ArrayList<Jugador>(equipoGanador.getJugadors());
	            		for (Jugador jugador : parejaEquipoGanador) {
	            			parejaGanadora = parejaGanadora + " " + jugador.getNombre() + " ";
						}
	            		for (ClasificacionEquipo equipoC : resultadoEquipos) {
            				if (equipoC.getNombreEquipo().trim().equalsIgnoreCase(pareja1.trim())) {
            					equipoC.setPartidosJugados(equipoC.getPartidosJugados() + 1);
            					equipoC.setPartidosGanados(equipoC.getPartidosGanados() + 1);
            					equipoC.setPuntos(equipoC.getPuntos() + 3);
            				}
							if (equipoC.getNombreEquipo().trim().equalsIgnoreCase(pareja2.trim())) {
            					equipoC.setPartidosJugados(equipoC.getPartidosJugados() + 1);
            					equipoC.setPartidosPerdidos(equipoC.getPartidosPerdidos() + 1);
            					equipoC.setPuntos(equipoC.getPuntos() + 1);
            				}
						}
					} catch (Exception e) {
					}
				}
		    	// Crear tabla
				tableEquipos.setRowSelectionAllowed(true);
				tableEquipos.setColumnSelectionAllowed(false);
				tableEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableEquipos.setAutoCreateRowSorter(true);
				String[] encabezado = {"Equipo", "Puntos", "J", "G", "P"}; 
				modelo.setColumnIdentifiers(encabezado);
				tableEquipos.setModel(modelo);
				Object Obj [] = null;
		    	for (int i = 0; i < resultadoEquipos.size(); i++) {
		    		modelo.addRow(Obj);
		    		modelo.setValueAt(resultadoEquipos.get(i).getNombreEquipo(), i, 0);
		    		modelo.setValueAt(resultadoEquipos.get(i).getPuntos(), i, 1);
		    		modelo.setValueAt(resultadoEquipos.get(i).getPartidosJugados(), i, 2);
		    		modelo.setValueAt(resultadoEquipos.get(i).getPartidosGanados(), i, 3);
		    		modelo.setValueAt(resultadoEquipos.get(i).getPartidosPerdidos(), i, 4);
				}
			}
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
				JTable table = new JTable();
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
						textFieldClub.setText(clubSeleccionado.getNombre().trim().toUpperCase());
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
	
	// GUI Listado competicion
	public static Competicion competicionSeleccionada = null;
	private JLabel lblEquipos;
	private JButton btnLimpiar;
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
			Set<Competicion> listadoCompeticion = club.getCompeticions();
			List<Competicion> competiciones = new ArrayList<>(listadoCompeticion);
			JTable table = new JTable();
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
					competicionSeleccionada = competiciones.get(seleccion);
					textFieldCompeticion.setText(String.valueOf(competicionSeleccionada.getMaxEquipGrupo()));
					textFieldCompeticion.setEnabled(false);
					btnBuscarCompeticion.setEnabled(false);
					textFieldGrupo.setEnabled(true);
					btnBuscarGrupo.setEnabled(true);
					dispose();
				}
			});
			} catch (Exception e) {
			}
		}
	}
}

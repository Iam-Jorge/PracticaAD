package Principal;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;

public class InformePartidosJugadorGUI extends JFrame {
	static Persistencia pers = PrincipalGUI.per;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JButton btnBuscar;
	private JTable tablaPartidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InformePartidosJugadorGUI frame = new InformePartidosJugadorGUI();
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
	public InformePartidosJugadorGUI() {
		setResizable(false);
		setTitle("Partidos jugados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(92, 24, 217, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
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
		
		
		
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(32, 27, 70, 14);
		contentPane.add(lblNombre);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarJugador();
			}
		});
		btnBuscar.setBounds(319, 23, 78, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblPartidosDisputados = new JLabel("Partidos disputados");
		lblPartidosDisputados.setBounds(32, 97, 206, 14);
		contentPane.add(lblPartidosDisputados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 122, 365, 133);
		contentPane.add(scrollPane);
		
		tablaPartidos = new JTable();
		scrollPane.setViewportView(tablaPartidos);
		
		JLabel lblEquipo = new JLabel("Equipo");
		lblEquipo.setBounds(32, 57, 46, 14);
		contentPane.add(lblEquipo);
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setBounds(92, 55, 217, 20);
		contentPane.add(textFieldEquipo);
		textFieldEquipo.setColumns(10);
		
		btnBuscarEquipo = new JButton("Buscar");
		btnBuscarEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarEquipo();
			}
		});
		btnBuscarEquipo.setBounds(319, 53, 78, 23);
		contentPane.add(btnBuscarEquipo);
		
		btnCargarPartidos = new JButton("Cargar Partidos");
		btnCargarPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarPartidos();
			}
		});
		btnCargarPartidos.setBounds(174, 93, 135, 23);
		contentPane.add(btnCargarPartidos);
		setLocationRelativeTo(null);
		btnCargarPartidos.setEnabled(false);
		btnBuscarEquipo.setEnabled(false);
		textFieldEquipo.setEnabled(false);
		
		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		btnNewButton.setBounds(319, 93, 78, 23);
		contentPane.add(btnNewButton);
	}
	
	protected void limpiar() {
		btnBuscar.setEnabled(true);
		textFieldNombre.setEnabled(true);
		textFieldEquipo.setText("");
		textFieldEquipo.setEnabled(false);
		textFieldNombre.setText("");
		btnBuscarEquipo.setEnabled(false);
		btnCargarPartidos.setEnabled(false);
		tablaPartidos.removeAll();
		modelo.setRowCount(0);
		tablaPartidos.setModel(modelo);
	}

	protected void buscarEquipo() {
		ListadoEquipos listado = new ListadoEquipos();
		listado.setVisible(true);
	}

	protected void buscarJugador() {
		Listado listado = new Listado();
		listado.setVisible(true);
	}

	// GUI Listado
	public Jugador jugadorSeleccionado = null;
	private JTextField textFieldEquipo;
	class Listado extends JFrame {

		public Listado() {
			setTitle("Listado jugadores");
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
			
			String nombre = textFieldNombre.getText().trim().toUpperCase();
			List<Jugador> listadoJugadores = pers.listadoJugador();
			if (listadoJugadores.size() == 0) {
				JLabel lbl1 = new JLabel("Jugadores con Nombre \"" + nombre + "\".");
				lbl1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lbl1.setBounds(118, 11, 188, 14);
				contentPane.add(lbl1);
				JLabel lbl2 = new JLabel("No se encontr\u00F3 ninguna coincidencia de Jugador con el filtro indicados.");
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
				String[] encabezado = {"ID", "Email", "Nombre", "Fecha de nacimiento", "Nivel" }; 
				modelo.setColumnIdentifiers(encabezado);
				table.setModel(modelo);
				Object Obj [] = null;
		    	for (int i = 0; i < listadoJugadores.size(); i++) {
		    		modelo.addRow(Obj);
		            Jugador jugador = (Jugador) listadoJugadores.get(i);
		            modelo.setValueAt(jugador.getId(), i, 0);
		            modelo.setValueAt(jugador.getEmail(), i, 1);
		            modelo.setValueAt(jugador.getNombre(), i, 2);
		            modelo.setValueAt(jugador.getFechaNac(), i, 3);
		            modelo.setValueAt(jugador.getNivel(), i, 4);
		    	}
		    	
		    	// Selecciona tabla
		    	table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						int seleccion = table.getSelectedRow();
						jugadorSeleccionado = listadoJugadores.get(seleccion);
						textFieldNombre.setText(jugadorSeleccionado.getNombre());
						btnBuscar.setEnabled(false);
						textFieldNombre.setEnabled(false);
						btnBuscarEquipo.setEnabled(true);
						textFieldEquipo.setEnabled(true);
						dispose();
					}
				});
			}
			
		}
	}
	
	
	// GUI ListadoEquipos
	public Equipo equipoSeleccionado = null;
	private JButton btnBuscarEquipo;
	private JButton btnCargarPartidos;
	class ListadoEquipos extends JFrame {

		public ListadoEquipos() {
			setTitle("Equipos en los que participa el Jugador " + jugadorSeleccionado.getNombre());
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
			
			Set<Equipo> equipos = jugadorSeleccionado.getEquipos();
			List<Equipo> listadoEquipos = new ArrayList<Equipo>(equipos);
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
			String[] encabezado = {"ID", "Nombre", "Nombre pareja" }; 
			modelo.setColumnIdentifiers(encabezado);
			table.setModel(modelo);
			Object Obj [] = null;
	    	for (int i = 0; i < listadoEquipos.size(); i++) {
	    		modelo.addRow(Obj);
	    		Equipo equipo = (Equipo) listadoEquipos.get(i);
	            modelo.setValueAt(equipo.getId(), i, 0);
	            Set<Jugador> jugadoresEquipo = equipo.getJugadors();
	            List<Jugador> jugadoresEquipoList = new ArrayList<Jugador>(jugadoresEquipo);
	            for (int j = 0; j < jugadoresEquipoList.size(); j++) {
	            	if (j==0) {
	            		modelo.setValueAt(jugadoresEquipoList.get(j).getNombre(), i, 1);
					} else {
						modelo.setValueAt(jugadoresEquipoList.get(j).getNombre(), i, 2);
					}
				}
	    	}
	    	
	    	// Selecciona tabla
	    	table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					int seleccion = table.getSelectedRow();
					equipoSeleccionado = listadoEquipos.get(seleccion);
					textFieldEquipo.setText(String.valueOf(equipoSeleccionado.getId()));
					textFieldEquipo.setEnabled(false);
					btnBuscarEquipo.setEnabled(false);
					btnCargarPartidos.setEnabled(true);
					dispose();
				}
			});
		}
	}
	
	
	private static DefaultTableModel modelo = new DefaultTableModel();
	private void cargarPartidos() {
		Set<Partido> partidos = equipoSeleccionado.getPartidos();
		List<Partido> partidosList = new ArrayList<Partido>(partidos);

		tablaPartidos.setRowSelectionAllowed(true);
		tablaPartidos.setColumnSelectionAllowed(false);
		tablaPartidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaPartidos.setAutoCreateRowSorter(true);
		String[] encabezado = {"Rival", "Resultado", "Fecha", "Grupo", "Competición", "Club" };
		modelo.setColumnIdentifiers(encabezado);
		tablaPartidos.setModel(modelo);
		Object Obj [] = null;
		for (int i = 0; i < partidosList.size(); i++) {
    		modelo.addRow(Obj);
    		Partido partido = (Partido) partidosList.get(i);
    		if (partido.getFechaHora() != null) {
    			Set<Equipo> equiposPartido = partido.getEquipos();
              	List<Equipo> equiposPartidoList = new ArrayList<Equipo>(equiposPartido);
              	for (int k = 0; k < equiposPartidoList.size(); k++)  {
              		List<String> rivales = new ArrayList<String>();
    				Set<Jugador> jugadoresEquipo = equiposPartidoList.get(k).getJugadors();
    				List<Jugador> jugadoresEquipoList = new ArrayList<Jugador>(jugadoresEquipo);
    				String jugadores = "";
    				for (int j = 0; j < jugadoresEquipoList.size(); j++)  {
    					if (!jugadoresEquipoList.get(j).getNombre().equalsIgnoreCase(textFieldNombre.getText())) {
    						rivales.add(jugadoresEquipoList.get(j).getNombre());
    					}
    				}
    				for (String rival : rivales) {
    					jugadores = jugadores + " " + rival + " ";
    					if (rivales.size() == 2) {
    						modelo.setValueAt(jugadores, i, 0);
    					} else {
    						modelo.setValueAt(rival, i, 0);
    					}
    				}
    			}
              	Set<Grupo> grupo = equipoSeleccionado.getGrupos();
              	List<Grupo> gruposList = new ArrayList<Grupo>(grupo);
              	for (Grupo grupo2 : gruposList) {
              		modelo.setValueAt(grupo2.getNombre(), i,3);
    			}
              	List<Competicion> competicionesList = new ArrayList<Competicion>(equipoSeleccionado.getCompeticions());
              	for (Competicion competicion2 : competicionesList) {
              		modelo.setValueAt(competicion2.getNombre(), i,4);
              		modelo.setValueAt(competicion2.getClub().getNombre(), i,5);
    			}
              	
              	modelo.setValueAt(partido.getFechaHora(), i, 2);
              	Set<Principal.Set> sets = partido.getSets();
              	List<Principal.Set> setsList = new ArrayList<Principal.Set>(sets);
              	Equipo ganadorPrimerSet = null;
              	Equipo ganadorSegundoSet = null;
              	Equipo ganadorTercerSet = null;
              	Equipo equipoGanador = null;
              	String resultado = "";
              	for (Principal.Set set : setsList) {
    				switch (set.getOrden()) {
    				case 1:
    					ganadorPrimerSet = set.getEquipo();
    					resultado = resultado + "Set 1: " + set.getRes1() + "/" + set.getRes2() + " ";
    					break;
    				case 2:
    					ganadorSegundoSet = set.getEquipo();
    					resultado = resultado + "Set 2: " + set.getRes1() + "/" + set.getRes2() + " ";
    					break;
    				case 3:
    					ganadorTercerSet = set.getEquipo();
    					resultado = resultado + "Set 3: " + set.getRes1() + "/" + set.getRes2() + " ";
    					break;
    				default:
    					break;
    				}
    			}
              	modelo.setValueAt(resultado, i, 1);
              	if (ganadorPrimerSet != null) {
              		if (ganadorPrimerSet.getId() == ganadorSegundoSet.getId()) {
                  		equipoGanador = ganadorPrimerSet;
        			} else if (ganadorTercerSet.getId() != null){
        				if (ganadorPrimerSet.getId() == ganadorSegundoSet.getId()) {
        					equipoGanador = ganadorPrimerSet;
    					} else if (ganadorPrimerSet.getId() == ganadorTercerSet.getId()) {
    						equipoGanador = ganadorPrimerSet;
    					} else if (ganadorPrimerSet.getId() == ganadorPrimerSet.getId()) {
    						equipoGanador = ganadorPrimerSet;
    					}
        			}
    			}
			}
		}
	}
}

package Principal;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class GrupoGUI extends JFrame {
	static PersistenciaHibernate pers = new PersistenciaHibernate("hibernate.cfg.xml", true);
	private JPanel contentPane;
	private JTextField textFieldClub;
	private JTextField textFieldCompeticion;
	private JButton btnBuscarCompeticion;
	private JButton btnBuscarClub;
	private JTable table;
	private JButton btnCrearGrupos;
	private JButton btnCancelar;
	private static DefaultTableModel modeloTabla = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrupoGUI frame = new GrupoGUI();
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
	public GrupoGUI() {
		setResizable(false);
		setTitle("Grupos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClub = new JMenu("Clubs");
		menuBar.add(mnClub);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo Club");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClubGUI clubGUI = new ClubGUI();
				clubGUI.setVisible(true);
				dispose();
			}
		});
		mnClub.add(mntmNewMenuItem);
		
		JMenu mnCompeticiones = new JMenu("Competiciones");
		menuBar.add(mnCompeticiones);
		
		JMenuItem mntmNuevaCompeticin = new JMenuItem("Nueva Competici\u00F3n");
		mntmNuevaCompeticin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompeticionGUI competicionGUI = new CompeticionGUI();
				competicionGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticiones.add(mntmNuevaCompeticin);
		
		JMenuItem mntmInscripcin = new JMenuItem("Inscripci\u00F3n");
		mntmInscripcin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscripcionGUI inscripcionGUI = new InscripcionGUI();
				inscripcionGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticiones.add(mntmInscripcin);
		
		JMenuItem mntmNuevoGrupo = new JMenuItem("Nuevo Grupo");
		mntmNuevoGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnCompeticiones.add(mntmNuevoGrupo);
		
		JMenuItem mntmPartidos = new JMenuItem("Partidos");
		mntmPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultadosGUI resultadosGUI = new ResultadosGUI();
				resultadosGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticiones.add(mntmPartidos);
		
		JMenuItem mntmPromocin = new JMenuItem("Promoci\u00F3n");
		mntmPromocin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PromocionGUI promocionGUI = new PromocionGUI();
				promocionGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticiones.add(mntmPromocin);
		
		JMenu mnJugadores = new JMenu("Jugadores");
		menuBar.add(mnJugadores);
		
		JMenuItem mntmNuevoJugador = new JMenuItem("Nuevo Jugador");
		mntmNuevoJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JugadorGUI jugadorGUI = new JugadorGUI();
				jugadorGUI.setVisible(true);
				dispose();
			}
		});
		mnJugadores.add(mntmNuevoJugador);
		
		JMenuItem mntmNuevoEquipo = new JMenuItem("Nuevo Equipo");
		mntmNuevoEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipoGUI equipoGUI = new EquipoGUI();
				equipoGUI.setVisible(true);
				dispose();
			}
		});
		mnJugadores.add(mntmNuevoEquipo);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clasificaci\u00F3n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeClasificacionGUI clasificacionGUI = new InformeClasificacionGUI();
				clasificacionGUI.setVisible(true);
				dispose();
			}
		});
		mnInformes.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Partidos jugados");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformePartidosJugadorGUI partidosJugadosGUI = new InformePartidosJugadorGUI();
				partidosJugadosGUI.setVisible(true);
				dispose();
			}
		});
		mnInformes.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClub = new JLabel("Club");
		lblClub.setBounds(23, 28, 46, 14);
		contentPane.add(lblClub);
		
		JLabel lblCompeticin = new JLabel("Competici\u00F3n");
		lblCompeticin.setBounds(23, 68, 71, 14);
		contentPane.add(lblCompeticin);
		
		textFieldClub = new JTextField();
		textFieldClub.setBounds(108, 25, 192, 20);
		contentPane.add(textFieldClub);
		textFieldClub.setColumns(10);
		
		textFieldCompeticion = new JTextField();
		textFieldCompeticion.setBounds(108, 65, 192, 20);
		contentPane.add(textFieldCompeticion);
		textFieldCompeticion.setColumns(10);
		
		btnBuscarClub = new JButton("Buscar");
		btnBuscarClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarClub();
			}
		});
		btnBuscarClub.setBounds(317, 24, 89, 23);
		contentPane.add(btnBuscarClub);
		
		btnBuscarCompeticion = new JButton("Buscar");
		btnBuscarCompeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCompeticion();
			}
		});
		btnBuscarCompeticion.setBounds(317, 64, 89, 23);
		contentPane.add(btnBuscarCompeticion);
		
		JLabel lblEquiposInscritosOrdenados = new JLabel("Equipos inscritos");
		lblEquiposInscritosOrdenados.setBounds(170, 111, 109, 14);
		contentPane.add(lblEquiposInscritosOrdenados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 147, 380, 120);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnCrearGrupos = new JButton("Crear Grupos");
		btnCrearGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generarGrupos();
			}
		});
		btnCrearGrupos.setBounds(266, 278, 140, 23);
		contentPane.add(btnCrearGrupos);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarCompeticion.setEnabled(false);
				textFieldCompeticion.setEnabled(false);
				textFieldCompeticion.setText("");
				textFieldClub.setText("");
				textFieldClub.requestFocus();
				textFieldClub.setEnabled(true);
				btnBuscarClub.setEnabled(true);
				btnCrearGrupos.setEnabled(false);
				modeloTabla.setRowCount(0);
			}
		});
		btnCancelar.setBounds(23, 278, 140, 23);
		contentPane.add(btnCancelar);
		btnBuscarCompeticion.setEnabled(false);
		textFieldCompeticion.setEnabled(false);
		btnCrearGrupos.setEnabled(false);
	}

	private static List<Equipo> equiposOrdenados = new ArrayList<Equipo>();
	protected void generarGrupos() {
		Grupo grupo = new Grupo();
        Set<Grupo> gruposCompeticion = new HashSet<Grupo>();
        String[] nombreGrupos = {"Grupo A","Grupo B","Grupo C","Grupo D","Grupo E", "Grupo F", "Grupo G", "Grupo H", "Grupo I", "Grupo J"};
        Set<Equipo> equiposPorGrupo = new HashSet<Equipo>();
        int cntNombre = 0;
        int cnt = 0;
       
        for (Equipo equipo : equiposOrdenados) {
        	equiposPorGrupo.add(equipo);
        	String nombreGrupo = nombreGrupos[cntNombre];
        	grupo.setNombre(nombreGrupo);
			cnt++;
			if (cnt % competicionSeleccionada.getMaxEquipGrupo() == 0) {
				cntNombre++;
				grupo.setEquipos(equiposPorGrupo);
				grupo.setCompeticion(competicionSeleccionada);
				gruposCompeticion.add(grupo);
				if (equiposPorGrupo.size() > 1) {
					pers.guardarGrupo(grupo);
				}
				grupo = new Grupo();
				equiposPorGrupo = new HashSet<Equipo>();
			} else {
				grupo.setOrden(cntNombre + 1);
				grupo.setEquipos(equiposPorGrupo);
				grupo.setCompeticion(competicionSeleccionada);
				gruposCompeticion.add(grupo);
				if (equiposPorGrupo.size() > 1) {
					pers.guardarGrupo(grupo);
				}
			}
		}
        competicionSeleccionada.setGrupos(gruposCompeticion);
        pers.guardarCompeticion(competicionSeleccionada);
        JOptionPane.showMessageDialog(this, "Grupos generados");
        generarPartidosGrupo();
	}

	private void generarPartidosGrupo() {
		Competicion competicion = pers.buscarCompeticion(textFieldCompeticion.getText());
		Set<Grupo> grupos = competicion.getGrupos();
		List<Grupo> gruposList = new ArrayList<Grupo>(grupos);
		for (Grupo grupo : gruposList) {
			Set<Equipo> equipos = grupo.getEquipos();
			List<Equipo> equiposList = new ArrayList<Equipo>(equipos);
			for (int i = 0; i < equiposList.size(); i++) {
				Set<Partido> partidosEquipo = new HashSet<Partido>();
				for (int j = 1; j < equiposList.size(); j++) {
					Partido partido = new Partido();
					partido.setGrupo(grupo);
					partido.setFechaHora(null);
					Set<Equipo> equiposPartido = new HashSet<Equipo>();
					equiposPartido.add(equiposList.get(i));
					equiposPartido.add(equiposList.get(j));
					if (equiposPartido.size() > 1 && (equiposList.get(i).getId() != equiposList.get(j).getId())) {
						//System.out.println("Equipo 1: " + equiposList.get(i).getId());
						//System.out.println("Equipo 2: " + equiposList.get(j).getId());
						//System.out.println("Numero de equipos: " + equiposPartido.size());
						partido.setEquipos(equiposPartido);
						partidosEquipo.add(partido);
						pers.guardarPartido(partido);
						//pers.aniadirPartido(equiposList.get(i), partido);
						//pers.aniadirPartido(equiposList.get(j), partido);
					}
				}
				equiposList.get(i).setPartidos(partidosEquipo);
				pers.guardarEquipo(equiposList.get(i));
			}
		}
		pers.guardarCompeticion(competicion);
		btnCrearGrupos.setEnabled(false);
		btnBuscarClub.setEnabled(true);
		textFieldClub.setText("");
		textFieldCompeticion.setText("");
		modeloTabla.setRowCount(0);
	}

	protected void buscarCompeticion() {
		ListadoCompeticion	listado = new ListadoCompeticion();
		listado.setVisible(true);	
	}

	protected void BuscarClub() {
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
						textFieldClub.setEnabled(false);
						textFieldCompeticion.setEnabled(true);
						btnBuscarClub.setEnabled(false);
						btnBuscarCompeticion.setEnabled(true);
						dispose();
					}
				});
			}
			
		}
	}
	
	
	
	// GUI Listado competicion
	public Competicion competicionSeleccionada = null;
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
			
			String filtro = textFieldCompeticion.getText().trim().toUpperCase();
			List<Competicion> listadoCompeticiones = new ArrayList<Competicion>(clubSeleccionado.getCompeticions());
			if (listadoCompeticiones.size() == 0) {
				JLabel lbl1 = new JLabel("Competiciones que contienen \"" + filtro + "\"");
				lbl1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lbl1.setBounds(118, 11, 188, 14);
				contentPane.add(lbl1);
				JLabel lbl2 = new JLabel("No se encontr\u00F3 ninguna coincidencia de Competiciones con el filtro " + filtro + ".");
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
				String[] encabezado = {"ID", "Nombre", "Fecha inicio", "Fecha fin", "Número de grupos", "Modalidad" }; 
				modelo.setColumnIdentifiers(encabezado);
				table.setModel(modelo);
				Object Obj [] = null;
		    	for (int i = 0; i < listadoCompeticiones.size(); i++) {
		    		modelo.addRow(Obj);
		            Competicion competicion = (Competicion) listadoCompeticiones.get(i);
		            modelo.setValueAt(competicion.getId(), i, 0);
		            modelo.setValueAt(competicion.getNombre(), i, 1);
		            modelo.setValueAt(competicion.getFechaIni(), i, 2);
		            modelo.setValueAt(competicion.getFechaFin(), i, 3);
		            modelo.setValueAt(competicion.getMaxEquipGrupo(), i, 4);
		            modelo.setValueAt(competicion.getIndivDobles(), i, 5);
		    	}
		    	
		    	// Selecciona tabla
		    	table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						int seleccion = table.getSelectedRow();
						competicionSeleccionada = listadoCompeticiones.get(seleccion);
						textFieldClub.setText(clubSeleccionado.getNombre().trim().toUpperCase());
						textFieldClub.setEnabled(false);
						textFieldCompeticion.setEnabled(false);
						btnBuscarClub.setEnabled(false);
						btnBuscarCompeticion.setEnabled(false);
						textFieldCompeticion.setText(competicionSeleccionada.getNombre());
						listadoEquipos();
						btnCrearGrupos.setEnabled(true);
						dispose();
					}
				});
			}
			
		}

		protected void listadoEquipos() {
			Set<Equipo> nivel1 = new HashSet<Equipo>();
			Set<Equipo> nivel2 = new HashSet<Equipo>();
			Set<Equipo> nivel3 = new HashSet<Equipo>();
			// Crear tabla
			table.setRowSelectionAllowed(true);
	        table.setColumnSelectionAllowed(false);
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			// Cargar tabla
			String[] encabezado = {"ID Equipo", "Nombre", "Nombre", "Nivel Pareja" }; 
			modeloTabla.setColumnIdentifiers(encabezado);
			table.setModel(modeloTabla);
			Object Obj [] = null;
			
			Set<Equipo> equipos = competicionSeleccionada.getEquipos();
			List<Equipo> equiposList = new ArrayList<Equipo>(equipos);
			
	    	for (int i = 0; i < equiposList.size(); i++) {
	    		modeloTabla.addRow(Obj);
	            Equipo equipo = (Equipo) equiposList.get(i);
	            modeloTabla.setValueAt(equipo.getId(), i, 0);
	            Set<Jugador> jugadores = equipo.getJugadors();
	            List<Jugador> jugadoresList = new ArrayList<Jugador>(jugadores);
	            int nivelPareja = 0;
	            for (int j = 0; j < jugadoresList.size(); j++) {
	            	if (j == 0) {
	            		modeloTabla.setValueAt(jugadoresList.get(j).getNombre(), i, 1);
	            		nivelPareja = jugadoresList.get(j).getNivel();
					} else {
						modeloTabla.setValueAt(jugadoresList.get(j).getNombre(), i, 2);
						nivelPareja = nivelPareja + jugadoresList.get(j).getNivel();
						nivelPareja = nivelPareja / 2;
					}
	            	modeloTabla.setValueAt(nivelPareja, i, 3);
				}
	            switch (nivelPareja) {
				case 1:
					nivel1.add(equipo);
					break;
				case 2:
					nivel2.add(equipo);
					break;
				case 3:
					nivel3.add(equipo);
					break;
				default:
					break;
				}
	    	}
	    	List<Equipo> nivel1List = new ArrayList<Equipo>(nivel1);
            List<Equipo> nivel2List = new ArrayList<Equipo>(nivel2);
            List<Equipo> nivel3List = new ArrayList<Equipo>(nivel3);
            equiposOrdenados.clear();
            equiposOrdenados.addAll(nivel1List);
            equiposOrdenados.addAll(nivel2List);
            equiposOrdenados.addAll(nivel3List);
		}
	}	
}

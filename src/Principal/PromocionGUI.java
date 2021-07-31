package Principal;

import java.awt.BorderLayout;
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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.naming.LimitExceededException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class PromocionGUI extends JFrame {
	static Persistencia pers = PrincipalGUI.per;
	private JPanel contentPane;
	private JTextField textFieldClub;
	private JTextField textFieldCompeticion;
	private JButton btnBuscarClub;
	private JButton btnBuscarCompeticion;
	private JTextField textFieldNuevaCompeticion;
	private JButton btnCancelar;
	private JButton btnCrear;
	private static Competicion competicionSeleccionada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromocionGUI frame = new PromocionGUI();
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
	public PromocionGUI() {
		setTitle("Promoci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClubs = new JMenu("Clubs");
		menuBar.add(mnClubs);
		
		JMenuItem mntmClub = new JMenuItem("Nuevo club");
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
		
		JLabel lblClub = new JLabel("Club");
		lblClub.setBounds(24, 27, 46, 14);
		contentPane.add(lblClub);
		
		JLabel lblCompeticin = new JLabel("Competici\u00F3n");
		lblCompeticin.setBounds(24, 56, 76, 14);
		contentPane.add(lblCompeticin);
		
		textFieldClub = new JTextField();
		textFieldClub.setBounds(110, 24, 188, 20);
		contentPane.add(textFieldClub);
		textFieldClub.setColumns(10);
		
		textFieldCompeticion = new JTextField();
		textFieldCompeticion.setBounds(110, 53, 188, 20);
		contentPane.add(textFieldCompeticion);
		textFieldCompeticion.setColumns(10);
		
		btnBuscarClub = new JButton("Buscar");
		btnBuscarClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarClub();
			}
		});
		btnBuscarClub.setBounds(308, 23, 89, 23);
		contentPane.add(btnBuscarClub);
		
		btnBuscarCompeticion = new JButton("Buscar");
		btnBuscarCompeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCompeticion();
			}
		});
		btnBuscarCompeticion.setBounds(308, 52, 89, 23);
		contentPane.add(btnBuscarCompeticion);
		
		JLabel lblNuevaCompeticin = new JLabel("Nombre de la nueva competici\u00F3n");
		lblNuevaCompeticin.setBounds(24, 90, 188, 14);
		contentPane.add(lblNuevaCompeticin);
		
		textFieldNuevaCompeticion = new JTextField();
		textFieldNuevaCompeticion.setBounds(222, 84, 178, 20);
		contentPane.add(textFieldNuevaCompeticion);
		textFieldNuevaCompeticion.setColumns(10);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnCancelar.setBounds(24, 195, 89, 23);
		contentPane.add(btnCancelar);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearNuevaCompeticion();
			}
		});
		btnCrear.setBounds(308, 195, 89, 23);
		contentPane.add(btnCrear);
		textFieldNuevaCompeticion.setText("");
		textFieldNuevaCompeticion.setEnabled(false);
		textFieldCompeticion.setText("");
		textFieldCompeticion.setEnabled(false);
		textFieldClub.setText("");
		btnCrear.setEnabled(false);
		btnBuscarCompeticion.setEnabled(false);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(24, 120, 89, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(24, 149, 76, 14);
		contentPane.add(lblFechaFin);
		
		textFieldFechaIni = new JTextField();
		textFieldFechaIni.setBounds(110, 117, 115, 20);
		contentPane.add(textFieldFechaIni);
		textFieldFechaIni.setColumns(10);
		
		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setBounds(110, 149, 115, 20);
		contentPane.add(textFieldFechaFin);
		textFieldFechaFin.setColumns(10);
		textFieldFechaFin.setEnabled(false);
		textFieldFechaIni.setEnabled(false);
	}

	protected void limpiar() {
		btnBuscarClub.setEnabled(true);
		textFieldNuevaCompeticion.setText("");
		textFieldNuevaCompeticion.setEnabled(false);
		textFieldCompeticion.setText("");
		textFieldCompeticion.setEnabled(false);
		textFieldClub.setText("");
		btnCrear.setEnabled(false);
		btnBuscarCompeticion.setEnabled(false);
		textFieldNuevaCompeticion.setEnabled(false);
		textFieldNuevaCompeticion.setText("");
		textFieldFechaIni.setText("");
		textFieldFechaIni.setEnabled(false);
		textFieldFechaFin.setText("");
		textFieldFechaFin.setEnabled(false);
	}

	protected void crearNuevaCompeticion() {
		if (textFieldNuevaCompeticion.getText().length() == 0) {
			JOptionPane.showMessageDialog(this, "Debe especificar el nombre de la nueva competición.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(!textFieldFechaIni.getText().trim().matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\/](0?[1-9]|1[012])[\\/\\/]\\d{4}$")) {
			JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto (dd/mm/yyyy)", "Fecha inicio", JOptionPane.ERROR_MESSAGE);
			return;
		}	
		
		if(!textFieldFechaFin.getText().trim().matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\/](0?[1-9]|1[012])[\\/\\/]\\d{4}$")) {
			JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto (dd/mm/yyyy)", "Fecha Fin", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Competicion nuevaCompeticion = new Competicion();
		Date fechaFin;
		Date fechaIni;
		try {
			fechaFin = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldFechaFin.getText());
			nuevaCompeticion.setFechaFin(fechaFin);
			fechaIni = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldFechaIni.getText());
			nuevaCompeticion.setFechaIni(fechaIni);
			if (fechaIni.before(competicionSeleccionada.getFechaFin())) {
				JOptionPane.showMessageDialog(this, "La fecha de inicio a de ser posterior a la fecha fin de la competición seleccionada", "Feche", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String nombreNuevaCompeticion = textFieldNuevaCompeticion.getText().trim().toUpperCase();
		nuevaCompeticion.setClub(competicionSeleccionada.getClub());
		nuevaCompeticion.setIndivDobles(competicionSeleccionada.getIndivDobles());
		Set<Equipo> equipos = new HashSet<Equipo>(competicionSeleccionada.getEquipos());
		nuevaCompeticion.setEquipos(equipos);
		nuevaCompeticion.setMaxEquipGrupo(competicionSeleccionada.getMaxEquipGrupo());
		nuevaCompeticion.setNombre(nombreNuevaCompeticion);
		listadoEquipos(nuevaCompeticion);
		generarGrupos(nuevaCompeticion);
		
		JOptionPane.showMessageDialog(this, "Competicion creada");
		limpiar();
		textFieldClub.setEnabled(true);
		
	}
	
	private static List<Equipo> equiposOrdenados = new ArrayList<Equipo>();
	protected void generarGrupos(Competicion nuevaCompeticion) {
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
        nuevaCompeticion.setGrupos(gruposCompeticion);
        pers.guardarCompeticion(nuevaCompeticion);
	}
	
	
	protected void listadoEquipos(Competicion nuevaCompeticion) {
		Set<Equipo> nivel1 = new HashSet<Equipo>();
		Set<Equipo> nivel2 = new HashSet<Equipo>();
		Set<Equipo> nivel3 = new HashSet<Equipo>();

		
		Set<Equipo> equipos = nuevaCompeticion.getEquipos();
		List<Equipo> equiposList = new ArrayList<Equipo>(equipos);
		
    	for (int i = 0; i < equiposList.size(); i++) {
            Equipo equipo = (Equipo) equiposList.get(i);
            Set<Jugador> jugadores = equipo.getJugadors();
            List<Jugador> jugadoresList = new ArrayList<Jugador>(jugadores);
            int nivelPareja = 0;
            for (int j = 0; j < jugadoresList.size(); j++) {
            	if (j == 0) {
            		nivelPareja = jugadoresList.get(j).getNivel();
				} else {
					nivelPareja = nivelPareja + jugadoresList.get(j).getNivel();
					nivelPareja = nivelPareja / 2;
				}
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
	

	protected void buscarCompeticion() {
		ListadoCompeticion listadoCompeticion = new ListadoCompeticion();
		listadoCompeticion.setVisible(true);
	}

	protected void buscarClub() {
		Listado listadoClub = new Listado();
		listadoClub.setVisible(true);
	}
	
	// GUI Listado
	public Club clubSeleccionado = null;
	private JTextField textFieldFechaIni;
	private JTextField textFieldFechaFin;
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
						textFieldCompeticion.setEnabled(true);
						textFieldClub.setEnabled(false);
						btnBuscarClub.setEnabled(false);
						btnBuscarCompeticion.setEnabled(true);
						dispose();
					}
				});
			}
			
		}
	}
	
	// GUI Listado competicion
	class ListadoCompeticion extends JFrame {

	public ListadoCompeticion() {
		JTable table = new JTable();
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
				textFieldCompeticion.setText(competicionSeleccionada.getNombre());
				textFieldCompeticion.setEnabled(false);
				btnBuscarCompeticion.setEnabled(false);
				btnCrear.setEnabled(true);
				textFieldNuevaCompeticion.setEnabled(true);
				textFieldFechaFin.setEnabled(true);
				textFieldFechaIni.setEnabled(true);
				dispose();
			}
		});
		} catch (Exception e) {
		}
	}
}
}

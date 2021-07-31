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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;

public class ResultadosGUI extends JFrame {
	static Persistencia pers = PrincipalGUI.per;
	private JPanel contentPane;
	private JTextField textFieldClub;
	private JTextField textFieldCompeticion;
	private JTextField textFieldGrupo;
	private JTextField textFieldPartido;
	private JComboBox comboBoxSet1Equipo1;
	private JComboBox comboBoxSet1Equipo2;
	private JComboBox comboBoxSet2Equipo1;
	private JComboBox comboBoxSet2Equipo2;
	private JButton btnCancelar;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadosGUI frame = new ResultadosGUI();
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
	public ResultadosGUI() {
		setTitle("Resultados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 358);
		
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JLabel lblClub = new JLabel("Club");
		lblClub.setBounds(20, 28, 46, 14);
		contentPane.add(lblClub);
		
		JLabel lblCompeticin = new JLabel("Competici\u00F3n");
		lblCompeticin.setBounds(20, 61, 76, 14);
		contentPane.add(lblCompeticin);
		
		textFieldClub = new JTextField();
		textFieldClub.setBounds(100, 25, 202, 20);
		contentPane.add(textFieldClub);
		textFieldClub.setColumns(10);
		
		textFieldCompeticion = new JTextField();
		textFieldCompeticion.setBounds(100, 58, 202, 20);
		contentPane.add(textFieldCompeticion);
		textFieldCompeticion.setColumns(10);
		
		btnBuscarClub = new JButton("Buscar");
		btnBuscarClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarClub();
			}
		});
		btnBuscarClub.setBounds(312, 24, 89, 23);
		contentPane.add(btnBuscarClub);
		
		btnBuscarCompeticion = new JButton("Buscar");
		btnBuscarCompeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCompeticion();
			}
		});
		btnBuscarCompeticion.setBounds(312, 57, 89, 23);
		contentPane.add(btnBuscarCompeticion);
		
		JLabel lblGrupo = new JLabel("Grupo");
		lblGrupo.setBounds(20, 97, 46, 14);
		contentPane.add(lblGrupo);
		
		textFieldGrupo = new JTextField();
		textFieldGrupo.setBounds(99, 94, 203, 20);
		contentPane.add(textFieldGrupo);
		textFieldGrupo.setColumns(10);
		
		btnBuscarGrupo = new JButton("Buscar");
		btnBuscarGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarGrupo();
			}
		});
		btnBuscarGrupo.setBounds(312, 93, 89, 23);
		contentPane.add(btnBuscarGrupo);
		
		JLabel lblPartido = new JLabel("Partido");
		lblPartido.setBounds(20, 136, 63, 14);
		contentPane.add(lblPartido);
		
		textFieldPartido = new JTextField();
		textFieldPartido.setBounds(100, 133, 202, 20);
		contentPane.add(textFieldPartido);
		textFieldPartido.setColumns(10);
		
		btnBuscarPartido = new JButton("Buscar");
		btnBuscarPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPartido();
			}
		});
		btnBuscarPartido.setBounds(312, 132, 89, 23);
		contentPane.add(btnBuscarPartido);
		
		JLabel lblSet = new JLabel("Set 1");
		lblSet.setBounds(50, 167, 46, 14);
		contentPane.add(lblSet);
		
		JLabel lblSet_1 = new JLabel("Set 2");
		lblSet_1.setBounds(195, 167, 46, 14);
		contentPane.add(lblSet_1);
		
		JLabel lblSet_2 = new JLabel("Set3");
		lblSet_2.setBounds(337, 167, 46, 14);
		contentPane.add(lblSet_2);
		
		comboBoxSet1Equipo1 = new JComboBox();
		comboBoxSet1Equipo1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		comboBoxSet1Equipo1.setBounds(20, 192, 40, 20);
		contentPane.add(comboBoxSet1Equipo1);
		
		comboBoxSet1Equipo2 = new JComboBox();
		comboBoxSet1Equipo2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		comboBoxSet1Equipo2.setBounds(70, 192, 40, 20);
		contentPane.add(comboBoxSet1Equipo2);
		
		comboBoxSet2Equipo1 = new JComboBox();
		comboBoxSet2Equipo1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		comboBoxSet2Equipo1.setBounds(172, 189, 40, 20);
		contentPane.add(comboBoxSet2Equipo1);
		
		comboBoxSet2Equipo2 = new JComboBox();
		comboBoxSet2Equipo2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		comboBoxSet2Equipo2.setBounds(222, 189, 40, 20);
		contentPane.add(comboBoxSet2Equipo2);
		
		comboBoxSet3Equipo1 = new JComboBox();
		comboBoxSet3Equipo1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		comboBoxSet3Equipo1.setBounds(311, 191, 40, 20);
		contentPane.add(comboBoxSet3Equipo1);
		
		comboBoxSet3Equipo2 = new JComboBox();
		comboBoxSet3Equipo2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7"}));
		comboBoxSet3Equipo2.setBounds(361, 191, 40, 20);
		contentPane.add(comboBoxSet3Equipo2);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarTodo();
			}
		});
		btnCancelar.setBounds(20, 247, 89, 23);
		contentPane.add(btnCancelar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarResultado();
			}
		});
		btnGuardar.setBounds(312, 247, 89, 23);
		contentPane.add(btnGuardar);
		textFieldCompeticion.setEnabled(false);
		textFieldGrupo.setEnabled(false);
		textFieldPartido.setEnabled(false);
		btnBuscarCompeticion.setEnabled(false);
		btnBuscarGrupo.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnBuscarPartido.setEnabled(false);
		comboBoxSet1Equipo1.setEnabled(false);
		comboBoxSet1Equipo2.setEnabled(false);
		comboBoxSet2Equipo2.setEnabled(false);
		comboBoxSet2Equipo1.setEnabled(false);
		comboBoxSet3Equipo1.setEnabled(false);
		comboBoxSet3Equipo2.setEnabled(false);
	}

	protected void guardarResultado() {
	    Date date;
		try {
			LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy ss:mm:HH");
		    String formattedDate = myDateObj.format(myFormatObj);
		    SimpleDateFormat dateParser = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH");
			date = dateParser.parse(formattedDate);
			partidoSeleccionado.setFechaHora(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		    
		
		Set<Equipo> equipos = partidoSeleccionado.getEquipos();
		List<Equipo> equiposList = new ArrayList<Equipo>(equipos);
		Set<Principal.Set> sets = new HashSet<Principal.Set>();

		Principal.Set set1 = new Principal.Set();
		set1.setRes1(Integer.parseInt(comboBoxSet1Equipo1.getSelectedItem().toString()));
		set1.setRes2(Integer.parseInt(comboBoxSet1Equipo2.getSelectedItem().toString()));
		set1.setOrden(1);
		set1.setPartido(partidoSeleccionado);
		if (Integer.parseInt(comboBoxSet1Equipo1.getSelectedItem().toString()) > Integer.parseInt(comboBoxSet1Equipo2.getSelectedItem().toString())) {
			set1.setEquipo(equiposList.get(0));
		} else {
			set1.setEquipo(equiposList.get(1));
		}
		pers.guardarSet(set1);
		sets.add(set1);
		
		Principal.Set set2 = new Principal.Set();
		set2.setRes1(Integer.parseInt(comboBoxSet2Equipo1.getSelectedItem().toString()));
		set2.setRes2(Integer.parseInt(comboBoxSet2Equipo2.getSelectedItem().toString()));
		set2.setOrden(2);
		set2.setPartido(partidoSeleccionado);
		if (Integer.parseInt(comboBoxSet2Equipo1.getSelectedItem().toString()) > Integer.parseInt(comboBoxSet2Equipo2.getSelectedItem().toString())) {
			set2.setEquipo(equiposList.get(0));
		} else {
			set2.setEquipo(equiposList.get(1));
		}
		pers.guardarSet(set2);
		sets.add(set2);
		
		Principal.Set set3 = null;
		if (Integer.parseInt(comboBoxSet3Equipo1.getSelectedItem().toString()) != 0 && Integer.parseInt(comboBoxSet3Equipo2.getSelectedItem().toString()) != 0) {
			set3 = new Principal.Set();
			set3.setRes1(Integer.parseInt(comboBoxSet3Equipo1.getSelectedItem().toString()));
			set3.setRes2(Integer.parseInt(comboBoxSet3Equipo2.getSelectedItem().toString()));
			set3.setOrden(3);
			set3.setPartido(partidoSeleccionado);
			if (Integer.parseInt(comboBoxSet3Equipo1.getSelectedItem().toString()) > Integer.parseInt(comboBoxSet3Equipo2.getSelectedItem().toString())) {
				set3.setEquipo(equiposList.get(0));
			} else {
				set3.setEquipo(equiposList.get(1));
			}
			pers.guardarSet(set3);
			sets.add(set3);
		}
		
		partidoSeleccionado.setSets(sets);		

		int id = pers.guardarPartido(partidoSeleccionado);
		JOptionPane.showMessageDialog(this, "Resultados guardado del partido con ID: " + id);
		comboBoxSet1Equipo1.setEnabled(false);
		comboBoxSet1Equipo2.setEnabled(false);
		comboBoxSet2Equipo2.setEnabled(false);
		comboBoxSet2Equipo1.setEnabled(false);
		comboBoxSet3Equipo1.setEnabled(false);
		comboBoxSet3Equipo2.setEnabled(false);
		comboBoxSet1Equipo1.setSelectedIndex(0);
		comboBoxSet1Equipo2.setSelectedIndex(0);
		comboBoxSet2Equipo2.setSelectedIndex(0);
		comboBoxSet2Equipo1.setSelectedIndex(0);
		comboBoxSet3Equipo1.setSelectedIndex(0);
		comboBoxSet3Equipo2.setSelectedIndex(0);
		btnBuscarClub.setEnabled(true);
		textFieldClub.setEnabled(true);
		textFieldClub.setText("");
		textFieldCompeticion.setText("");
		textFieldGrupo.setText("");
		textFieldPartido.setText("");
		btnGuardar.setEnabled(false);
	}

	protected void buscarPartido() {
		ListadoPartidos listado = new ListadoPartidos();
		listado.setVisible(true);
	}

	protected void cancelarTodo() {
		textFieldCompeticion.setEnabled(false);
		textFieldGrupo.setEnabled(false);
		textFieldPartido.setEnabled(false);
		btnBuscarCompeticion.setEnabled(false);
		btnBuscarGrupo.setEnabled(false);
		btnGuardar.setEnabled(false);
		textFieldPartido.setText("");
		textFieldGrupo.setText("");
		textFieldCompeticion.setText("");
		textFieldClub.setText("");
		textFieldClub.setEnabled(true);
		textFieldClub.requestFocus();
		btnBuscarClub.setEnabled(true);
		btnBuscarPartido.setEnabled(false);
		comboBoxSet1Equipo1.setEnabled(false);
		comboBoxSet1Equipo2.setEnabled(false);
		comboBoxSet2Equipo2.setEnabled(false);
		comboBoxSet2Equipo1.setEnabled(false);
		comboBoxSet3Equipo1.setEnabled(false);
		comboBoxSet3Equipo2.setEnabled(false);
		comboBoxSet1Equipo1.setSelectedIndex(0);
		comboBoxSet1Equipo2.setSelectedIndex(0);
		comboBoxSet2Equipo2.setSelectedIndex(0);
		comboBoxSet2Equipo1.setSelectedIndex(0);
		comboBoxSet3Equipo1.setSelectedIndex(0);
		comboBoxSet3Equipo2.setSelectedIndex(0);
	}

	protected void buscarGrupo() {
		ListadoGrupos listado = new ListadoGrupos();
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
	
	// GUI Listado
	public Club clubSeleccionado = null;
	private JButton btnBuscarClub;
	private JButton btnBuscarCompeticion;
	private JButton btnBuscarGrupo;
	private JButton btnBuscarPartido;
	private JComboBox comboBoxSet3Equipo2;
	private JComboBox comboBoxSet3Equipo1;
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
						textFieldClub.setText(clubSeleccionado.getNombre());
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
	public Competicion competicionSeleccionada = null;
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
				JLabel lbl3 = new JLabel("Desea crear un nueva competición \"" + filtro + "\"?");
				lbl3.setBounds(105, 70, 280, 15);
				contentPane.add(lbl3);
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
					Competicion competicionSeleccionada = competiciones.get(seleccion);
					textFieldCompeticion.setText(competicionSeleccionada.getNombre());
					btnBuscarCompeticion.setEnabled(false);
					textFieldCompeticion.setEnabled(false);
					textFieldGrupo.setEnabled(true);
					btnBuscarCompeticion.setEnabled(false);
					btnBuscarGrupo.setEnabled(true);
					dispose();
				}
			});
			} catch (Exception e) {
			}
		}
	}
	
	// GUI Listado grupos
		public static Grupo grupoSeleccionado = null;
		class ListadoGrupos extends JFrame {

			public ListadoGrupos() {
				setTitle("Grupos");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				setLocationRelativeTo(null);
				
				String filtro = textFieldClub.getText().trim().toUpperCase();
				Competicion competicion = pers.buscarCompeticion(textFieldCompeticion.getText());
				Set<Grupo> grupos = competicion.getGrupos();
				List<Grupo> gruposList = new ArrayList<Grupo>(grupos);
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
				String[] encabezado = {"ID", "Nombre"}; 
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
						textFieldClub.setEnabled(false);
						btnBuscarClub.setEnabled(false);
						btnBuscarPartido.setEnabled(true);
						btnBuscarGrupo.setEnabled(false);
						dispose();
					}
				});
				
			}
		}
		
		// GUI Listado partidos
		public static Partido partidoSeleccionado = null;
		class ListadoPartidos extends JFrame {
			public ListadoPartidos() {
				setTitle("Partidos");
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				setLocationRelativeTo(null);
				
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
				String[] encabezado = {"ID Partido", "Fecha","Equipo 1", "Equipo 2", "Set 1", "Set 2", "Set 3"}; 
				modelo.setColumnIdentifiers(encabezado);
				table.setModel(modelo);
				Object Obj [] = null;
				Set<Partido> partidos = grupoSeleccionado.getPartidos();
				List<Partido> partidosList = new ArrayList<Partido>(partidos);
		    	for (int i = 0; i < partidosList.size(); i++) {
		    		modelo.addRow(Obj);
		            Partido partido = (Partido) partidosList.get(i);
		            modelo.setValueAt(partido.getId(), i, 0);
		            modelo.setValueAt(partido.getFechaHora(), i, 1);
		           
		            Set<Equipo> equipos = partido.getEquipos();
		            List<Equipo> equiposList = new ArrayList<Equipo>(equipos);
		            for (int j = 0; j < equiposList.size(); j++) {
						Set<Jugador> jugadores = equiposList.get(j).getJugadors();
						List<Jugador> jugadoresList = new ArrayList<Jugador>(jugadores);
						String jugadoresString = "";
						for (Jugador jugador : jugadoresList) {
							jugadoresString = jugadoresString + " " + jugador.getNombre();
						}
						if (j == 0) {
							modelo.setValueAt(jugadoresString, i, 2);
						} else {
							modelo.setValueAt(jugadoresString, i, 3);
						}
						
					}
		            
		            Set<Principal.Set> sets = partido.getSets();
		            List<Principal.Set> setsList = new ArrayList<Principal.Set>(sets);
		            try {
		            	 for (Principal.Set set : setsList) {
				            	switch (set.getOrden()) {
								case 1:
									modelo.setValueAt(" " + set.getRes1()+"/"+set.getRes2(), i, 4);
									break;
								case 2:
									modelo.setValueAt(" " + set.getRes1()+"/"+set.getRes2(), i, 5);						
									break;
								case 3:
									modelo.setValueAt(" " + set.getRes1()+"/"+set.getRes2(), i, 6);
									break;
								default:
									break;
								}
				            }
					} catch (Exception e) {
					}
				}
		    	// Selecciona tabla
		    	table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						int seleccion = table.getSelectedRow();
						partidoSeleccionado = partidosList.get(seleccion);
						textFieldPartido.setText(String.valueOf(partidoSeleccionado.getId()));
						cargarResultado();
						textFieldPartido.setEnabled(false);
						btnBuscarPartido.setEnabled(false);
						comboBoxSet1Equipo1.setEnabled(true);
						comboBoxSet1Equipo2.setEnabled(true);
						comboBoxSet2Equipo1.setEnabled(true);
						comboBoxSet2Equipo2.setEnabled(true);
						comboBoxSet3Equipo1.setEnabled(true);
						comboBoxSet3Equipo2.setEnabled(true);
						btnGuardar.setEnabled(true);
						dispose();
					}
				});
			}

			private void cargarResultado() {
				Partido partido = pers.buscarPartido(Integer.parseInt(textFieldPartido.getText()));
				List<Principal.Set> sets = new ArrayList<Principal.Set>(partido.getSets());
				for (Principal.Set set : sets) {
					int res1 = set.getRes1();
					int res2 = set.getRes2();
					if (set.getOrden() == 1) {
						comboBoxSet1Equipo1.setSelectedIndex(res1);
						comboBoxSet1Equipo2.setSelectedIndex(res2);
					} else if (set.getOrden() == 2) {
						comboBoxSet2Equipo1.setSelectedIndex(set.getRes1());
						comboBoxSet2Equipo2.setSelectedIndex(set.getRes2());
					} else {
						comboBoxSet3Equipo1.setSelectedIndex(set.getRes1());
						comboBoxSet3Equipo2.setSelectedIndex(set.getRes2());
					}
				}
			}
		}
}

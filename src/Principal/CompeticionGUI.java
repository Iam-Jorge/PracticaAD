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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CompeticionGUI extends JFrame {
	static Persistencia pers = PrincipalGUI.per;
	private JPanel contentPane;
	private JTextField textFieldNombreClub;
	private JTextField textFieldNombre;
	private JTextField textFieldFechaIni;
	private JTextField textFieldFechaFin;
	private JTextField textFieldNumEquipGrupo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnIndividual;
	private JRadioButton rdbtnDobles;
	private JButton btnBuscar;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JMenu mnNewMenu;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompeticionGUI frame = new CompeticionGUI();
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
	public CompeticionGUI() {
		setTitle("Competici\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClubs = new JMenu("Clubs");
		menuBar.add(mnClubs);
		
		JMenuItem mntmNuevoClub = new JMenuItem("Nuevo Club");
		mntmNuevoClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClubGUI clubGUI = new ClubGUI();
				clubGUI.setVisible(true);
				dispose();
			}
		});
		mntmNuevoClub.setHorizontalAlignment(SwingConstants.LEFT);
		mnClubs.add(mntmNuevoClub);
		
		mnNewMenu = new JMenu("Competiciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nueva competici\u00F3n");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_3 = new JMenuItem("Inscripci\u00F3n");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InscripcionGUI inscripcionGUI = new InscripcionGUI();
				inscripcionGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		mntmNuevoGrupo = new JMenuItem("Nuevo Grupo");
		mntmNuevoGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrupoGUI grupoGUI = new GrupoGUI();
				grupoGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNuevoGrupo);
		
		mntmResultados = new JMenuItem("Resultados");
		mntmResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultadosGUI resultadosGUI = new ResultadosGUI();
				resultadosGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmResultados);
		
		mntmPromocin = new JMenuItem("Promoci\u00F3n");
		mntmPromocin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromocionGUI promocionGui = new PromocionGUI();
				promocionGui.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmPromocin);
		
		mnNewMenu_1 = new JMenu("Jugadores");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Nuevo Jugador");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JugadorGUI jugadorGUI =new JugadorGUI();
				jugadorGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Nuevo Equipo");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EquipoGUI equipoGUI = new EquipoGUI();
				equipoGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mnNewMenu_2 = new JMenu("Informes");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_4 = new JMenuItem("Clasificaci\u00F3n");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeClasificacionGUI clasificacionGUI = new InformeClasificacionGUI();
				clasificacionGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Partidos jugados");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformePartidosJugadorGUI partidosJugadosGUI = new InformePartidosJugadorGUI();
				partidosJugadosGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Nombre club");
		lblId.setBounds(21, 22, 86, 14);
		contentPane.add(lblId);
		
		textFieldNombreClub = new JTextField();
		textFieldNombreClub.setBounds(117, 19, 156, 20);
		contentPane.add(textFieldNombreClub);
		textFieldNombreClub.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre competici\u00F3n");
		lblNewLabel.setBounds(21, 53, 118, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(149, 50, 124, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha inicio");
		lblNewLabel_1.setBounds(21, 84, 98, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha fin");
		lblNewLabel_1_1.setBounds(21, 115, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textFieldFechaIni = new JTextField();
		textFieldFechaIni.setBounds(149, 81, 124, 20);
		contentPane.add(textFieldFechaIni);
		textFieldFechaIni.setColumns(10);
		
		textFieldFechaFin = new JTextField();
		textFieldFechaFin.setBounds(149, 112, 124, 20);
		contentPane.add(textFieldFechaFin);
		textFieldFechaFin.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero de equipos por grupo");
		lblNewLabel_2.setBounds(21, 146, 180, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldNumEquipGrupo = new JTextField();
		textFieldNumEquipGrupo.setBounds(233, 143, 40, 20);
		contentPane.add(textFieldNumEquipGrupo);
		textFieldNumEquipGrupo.setColumns(10);
		
		rdbtnIndividual = new JRadioButton("Individual");
		buttonGroup.add(rdbtnIndividual);
		rdbtnIndividual.setBounds(319, 80, 109, 23);
		contentPane.add(rdbtnIndividual);
		
		rdbtnDobles = new JRadioButton("Dobles");
		buttonGroup.add(rdbtnDobles);
		rdbtnDobles.setBounds(319, 111, 109, 23);
		contentPane.add(rdbtnDobles);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setEnabled(false);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCompeticion();
			}
		});
		btnBuscar.setBounds(335, 194, 89, 23);
		contentPane.add(btnBuscar);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
				textFieldNombreClub.setEnabled(true);
				textFieldNombreClub.setText("");
			}
		});
		btnCancelar.setBounds(236, 194, 89, 23);
		contentPane.add(btnCancelar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guardarCompeticion();
			}
		});
		btnGuardar.setBounds(21, 194, 89, 23);
		contentPane.add(btnGuardar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarCompeticion();
			}
		});
		btnBorrar.setBounds(117, 194, 89, 23);
		contentPane.add(btnBorrar);
		
		btnBuscarClub = new JButton("Buscar club");
		btnBuscarClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarClub();
			}
		});
		btnBuscarClub.setBounds(297, 18, 109, 23);
		contentPane.add(btnBuscarClub);
		deshabilitarCampos();
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
			
			String filtro = textFieldNombreClub.getText().trim().toUpperCase();
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
						textFieldNombreClub.setText(clubSeleccionado.getNombre().trim().toUpperCase());
						textFieldNombreClub.setEnabled(false);
						textFieldNombre.setEnabled(true);
						btnBuscarClub.setEnabled(false);
						btnBuscar.setEnabled(true);
						dispose();
					}
				});
			}
			
		}
	}

	protected void borrarCompeticion() {
		Competicion competicion = pers.buscarCompeticion(textFieldNombre.getText().trim().toUpperCase());
		if (competicion != null) {
			int opcion = JOptionPane.showConfirmDialog(this, "Se borrará la competición " + competicion.getNombre() + " con id " + competicion.getId());
			if (opcion == 0) {
				int id = pers.borrarCompeticion(competicion);
				deshabilitarCampos();
				limpiarCampos();
				textFieldNombreClub.setEnabled(true);
				textFieldNombreClub.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Error al borrar la competición");
		}
		
	}

	protected void guardarCompeticion() {
		if (validarCampos() == true) {
			Competicion competicion = pers.buscarCompeticion(textFieldNombre.getText().trim().toUpperCase());
			if (competicion == null) {
				competicion = new Competicion();
				competicion.setNombre(textFieldNombre.getText().toUpperCase().trim());
				String indivDobles = "";
				if (rdbtnIndividual.isSelected()) {
					indivDobles = "I";
				} else {
					indivDobles = "D";
				}
				competicion.setIndivDobles(indivDobles);
				competicion.setMaxEquipGrupo(Integer.parseInt(textFieldNumEquipGrupo.getText()));
				Date fechaFin;
				Date fechaIni;
				try {
					fechaFin = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldFechaFin.getText());
					competicion.setFechaFin(fechaFin);
					fechaIni = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldFechaIni.getText());
					competicion.setFechaIni(fechaIni);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// Club al que pertenecera la competicion
				Club club = pers.buscarClub(textFieldNombreClub.getText().trim().toUpperCase());
				competicion.setClub(club);
				int id = pers.guardarCompeticion(competicion);
				JOptionPane.showMessageDialog(this, "Se ha guardado la competición " + competicion.getNombre() + " con id " + id + ". Perteneciente al club " + club.getNombre());
			} else {
				competicion.setNombre(textFieldNombre.getText());
				String indivDobles = "";
				if (rdbtnIndividual.isSelected()) {
					indivDobles = "I";
				} else {
					indivDobles = "D";
				}
				competicion.setIndivDobles(indivDobles);
				competicion.setMaxEquipGrupo(Integer.parseInt(textFieldNumEquipGrupo.getText()));
				Date fechaFin;
				Date fechaIni;
				try {
					fechaFin = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldFechaFin.getText());
					competicion.setFechaFin(fechaFin);
					fechaIni = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldFechaIni.getText());
					competicion.setFechaIni(fechaIni);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
				int id = pers.guardarCompeticion(competicion);
				JOptionPane.showMessageDialog(this, "Se ha modificado la competición " + competicion.getNombre() + " con id " + id);
			}
			deshabilitarCampos();
			limpiarCampos();
			textFieldNombreClub.setEnabled(true);
			textFieldNombreClub.setText("");
			btnBuscar.setEnabled(false);
			btnBuscarClub.setEnabled(true);
		} else {
			
		}
	}

	protected void cancelar() {
		deshabilitarCampos();
		limpiarCampos();
		btnBuscarClub.setEnabled(true);
	}

	protected void buscarCompeticion() {
		ListadoCompeticion listadoCompeticion = new ListadoCompeticion();
		listadoCompeticion.setVisible(true);
	}
	
	// GUI Listado competicion
	public Competicion competicionSeleccionada = null;
	private JButton btnBuscarClub;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNuevoGrupo;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmResultados;
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
			
			// Boton Nuevo
			JButton btnNuevo = new JButton("Nuevo");
			btnNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBorrar.setVisible(true);
					btnGuardar.setVisible(true);
					btnBorrar.setEnabled(false);
					textFieldFechaFin.setEnabled(true);
					textFieldFechaIni.setEnabled(true);
					textFieldNumEquipGrupo.setEnabled(true);
					rdbtnIndividual.setEnabled(true);
					rdbtnDobles.setEnabled(true);
					dispose();
				}
			});
			btnNuevo.setBounds(25, 216, 89, 23);
			contentPane.add(btnNuevo);
			
			String filtroClub = textFieldNombreClub.getText().trim().toUpperCase();
			String filtro = textFieldNombre.getText().trim().toUpperCase();
			
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
		            modelo.setValueAt(competicion.getNombre().toUpperCase(), i, 1);
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
					textFieldNumEquipGrupo.setEnabled(true);
					textFieldNumEquipGrupo.setText(String.valueOf(competicionSeleccionada.getMaxEquipGrupo()));
					String indivDobles = competicionSeleccionada.getIndivDobles();
					rdbtnIndividual.setEnabled(true);
					rdbtnDobles.setEnabled(true);
					if (indivDobles.equalsIgnoreCase("I")) {
						rdbtnIndividual.setSelected(true);
					} else {
						rdbtnDobles.setSelected(true);
					}
					
					Format formatter = new SimpleDateFormat("dd/MM/yyyy");
					textFieldFechaIni.setEnabled(true);
					String fechaIni = formatter.format(competicionSeleccionada.getFechaIni());
					textFieldFechaIni.setText(fechaIni);
					
					textFieldFechaFin.setEnabled(true);
					String fechaFin = formatter.format(competicionSeleccionada.getFechaIni());
					textFieldFechaFin.setText(fechaFin);
					
					textFieldNombre.setText(competicionSeleccionada.getNombre());
					
					btnBorrar.setVisible(true);
					btnBuscarClub.setEnabled(false);
					btnGuardar.setVisible(true);
					btnBorrar.setEnabled(true);
					dispose();
				}
			});
			} catch (Exception e) {
			}
		}
	}

	private boolean validarCampos() {
		if (textFieldNombre.getText().trim().toUpperCase().length() == 0) {
			JOptionPane.showMessageDialog(this, "Debe introducir un nombre", "Nombre competición", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!textFieldFechaIni.getText().trim().matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\/](0?[1-9]|1[012])[\\/\\/]\\d{4}$")) {
			JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto (dd/mm/yyyy)", "Fecha inicio", JOptionPane.ERROR_MESSAGE);
			return false;
		}	
		
		if(!textFieldFechaFin.getText().trim().matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\/](0?[1-9]|1[012])[\\/\\/]\\d{4}$")) {
			JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto (dd/mm/yyyy)", "Fecha Fin", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!textFieldNumEquipGrupo.getText().trim().matches("[0-9]+")) {
			JOptionPane.showMessageDialog(this, "Introduce el número de equipos que formarán la competición", "Número de equipos", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!rdbtnDobles.isSelected() && !rdbtnIndividual.isSelected()) {
			JOptionPane.showMessageDialog(this, "Individual o dobles", "Individual dobles", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        try {
			Date fechaIni = dateFormat.parse(textFieldFechaIni.getText());
			Date fechaFin = dateFormat.parse(textFieldFechaFin.getText());
			if (fechaIni.before(fechaFin) == false) {
				JOptionPane.showMessageDialog(this, "Fecha fin no puede ser anterior a fecha inicio", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public void deshabilitarCampos() {
		textFieldNombre.setEnabled(false);
		textFieldFechaFin.setEnabled(false);
		textFieldFechaIni.setEnabled(false);
		textFieldNumEquipGrupo.setEnabled(false);
		rdbtnIndividual.setEnabled(false);
		rdbtnDobles.setEnabled(false);
		btnGuardar.setVisible(false);
		btnBorrar.setVisible(false);
		buttonGroup.clearSelection();
	}
	
	public void habilitarCampos() {
		textFieldNombreClub.setEnabled(false);
		textFieldNombre.setEnabled(true);
		textFieldFechaFin.setEnabled(true);
		textFieldFechaIni.setEnabled(true);
		textFieldNumEquipGrupo.setEnabled(true);
		rdbtnIndividual.setEnabled(true);
		rdbtnDobles.setEnabled(true);
	}
	
	public void limpiarCampos() {
		textFieldNombre.setText("");
		textFieldFechaFin.setText("");
		textFieldFechaIni.setText("");
		textFieldNumEquipGrupo.setText("");
		rdbtnIndividual.setEnabled(false);
		rdbtnDobles.setEnabled(false);
		btnGuardar.setVisible(false);
		btnBorrar.setVisible(false);
	}
}

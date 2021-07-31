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

import Principal.JugadorGUI.Listado;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class EquipoGUI extends JFrame {
	static Persistencia pers = PrincipalGUI.per;
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldEmail2;
	private JButton btnBuscar;
	private JTextField textFieldNombre2;
	private JTextField textFieldNombre;
	private JTextField textFieldId;
	private JTextField textFieldId2;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipoGUI frame = new EquipoGUI();
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
	public EquipoGUI() {
		setResizable(false);
		setTitle("Equipo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 459, 390);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Clubes");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo Club");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClubGUI clubGUI = new ClubGUI();
				clubGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Competiciones");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Nueva Competici\u00F3n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompeticionGUI competicionGUI = new CompeticionGUI();
				competicionGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmInscripcin = new JMenuItem("Inscripci\u00F3n");
		mntmInscripcin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InscripcionGUI inscripcionGUI = new InscripcionGUI();
				inscripcionGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmInscripcin);
		
		JMenuItem mntmNuevoGrupo = new JMenuItem("Nuevo Grupo");
		mntmNuevoGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrupoGUI grupoGUI = new GrupoGUI();
				grupoGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNuevoGrupo);
		
		JMenuItem mntmPartidos = new JMenuItem("Resultados");
		mntmPartidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultadosGUI resultadosGUI = new ResultadosGUI();
				resultadosGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmPartidos);
		
		JMenuItem mntmPromocin = new JMenuItem("Promoci\u00F3n");
		mntmPromocin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromocionGUI promocionGui = new PromocionGUI();
				promocionGui.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmPromocin);
		
		JMenu mnNewMenu_2 = new JMenu("Jugadores");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Nuevo Jugador");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JugadorGUI jugadorGUI = new JugadorGUI();
				jugadorGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Nuevo Equipo");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipoGUI equipoGUI = new EquipoGUI();
				equipoGUI.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
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
				InformePartidosJugadorGUI partidosJugadosGUI = new InformePartidosJugadorGUI();
				partidosJugadosGUI.setVisible(true);
				dispose();
			}
		});
		mnInformes.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarJugador1();
			}
		});
		btnBuscar.setBounds(333, 90, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblJugadoresQ = new JLabel("Jugadores que componen el equipo");
		lblJugadoresQ.setBounds(26, 11, 207, 14);
		contentPane.add(lblJugadoresQ);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(82, 50, 241, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("-------------------------------------------------------------------------------------------------");
		lblNewLabel.setBounds(26, 161, 393, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("-------------------------------------------------------------------------------------------------");
		lblNewLabel_1.setBounds(26, 28, 393, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(26, 53, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(26, 192, 46, 14);
		contentPane.add(lblEmail_1);
		
		textFieldEmail2 = new JTextField();
		textFieldEmail2.setColumns(10);
		textFieldEmail2.setBounds(82, 189, 241, 20);
		contentPane.add(textFieldEmail2);
		
		btnBuscar2 = new JButton("Buscar");
		btnBuscar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarJugador2();
			}
		});
		btnBuscar2.setBounds(333, 227, 89, 23);
		contentPane.add(btnBuscar2);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(26, 94, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(26, 231, 46, 14);
		contentPane.add(lblNombre_1);
		
		textFieldNombre2 = new JTextField();
		textFieldNombre2.setColumns(10);
		textFieldNombre2.setBounds(82, 228, 241, 20);
		contentPane.add(textFieldNombre2);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(82, 91, 241, 20);
		contentPane.add(textFieldNombre);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(336, 53, 23, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		textFieldId.setBounds(365, 50, 46, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setBounds(336, 192, 23, 14);
		contentPane.add(lblId_1);
		
		textFieldId2 = new JTextField();
		textFieldId2.setEnabled(false);
		textFieldId2.setColumns(10);
		textFieldId2.setBounds(365, 189, 46, 20);
		contentPane.add(textFieldId2);
		
		JLabel lblNewLabel_2 = new JLabel("-------------------------------------------------------------------------------------------------");
		lblNewLabel_2.setBounds(26, 261, 393, 14);
		contentPane.add(lblNewLabel_2);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarEquipo();
			}
		});
		btnGuardar.setBounds(333, 286, 89, 23);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBounds(234, 289, 89, 23);
		contentPane.add(btnCancelar);
		btnGuardar.setEnabled(false);
		textFieldEmail2.setEnabled(false);
		textFieldNombre2.setEnabled(false);
		btnBuscar2.setEnabled(false);
		
		comboBox = new JComboBox();
		comboBox.setBounds(82, 130, 241, 20);
		contentPane.add(comboBox);
		
		JLabel lblParejas = new JLabel("Parejas");
		lblParejas.setBounds(26, 133, 59, 14);
		contentPane.add(lblParejas);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarEquipo();
			}
		});
		btnBorrar.setBounds(333, 129, 89, 23);
		contentPane.add(btnBorrar);
		comboBox.setEnabled(true);
		btnBorrar.setEnabled(true);
		comboBox.setEnabled(false);
		btnBorrar.setEnabled(false);
	}


	protected void borrarEquipo() {
		String seleccion = comboBox.getSelectedItem().toString();
		System.out.println("Seleccion " + seleccion);
		String[] nombreJugadores = seleccion.split(",");
		Jugador jugadorUno = pers.buscarJugadorNombre(nombreJugadores[0].trim());
		Jugador jugadorDos = pers.buscarJugadorNombre(nombreJugadores[1].trim());
		
		System.out.println("jugador1 " + jugadorUno);
		System.out.println(" jugador 2 " + jugadorDos);
		
		Set<Equipo> equipos = jugadorDos.getEquipos();
		List<Equipo> equiposList = new ArrayList<Equipo>(equipos);
		for (Equipo equipo : equiposList) {
			Set<Jugador> jugadores = equipo.getJugadors();
			List<Jugador> jugadoresList = new ArrayList<Jugador>(jugadores);
			for (int i = 0; i < jugadoresList.size(); i++) {
				if (jugadoresList.get(i).getEmail().equalsIgnoreCase(jugadorUno.getEmail()) && jugadoresList.get(i+1).getEmail().equalsIgnoreCase(jugadorDos.getEmail())) {
					Equipo equipoPers = pers.buscarEquipo(String.valueOf(equipo.getId()));
					int id = pers.borrarEquipo(equipoPers);
					JOptionPane.showMessageDialog(this, "Se ha borrado el equipo con ID " + id, "Borrado", JOptionPane.INFORMATION_MESSAGE);
					textFieldEmail.setText("");
					textFieldId.setText("");
					textFieldNombre.setText("");
					btnBorrar.setEnabled(true);
					textFieldEmail.setEnabled(true);
					textFieldEmail2.setEditable(false);
					textFieldNombre2.setEditable(false);
					btnBuscar2.setEnabled(false);
					modeloComboBox.removeElementAt(comboBox.getSelectedIndex());
					comboBox.removeAllItems();
					btnBuscar.setEnabled(true);
					btnBorrar.setEnabled(false);
				}
			}
		}
	}

	protected void guardarEquipo() {
		// Recuperrar jugadores
		Jugador jugador1 = pers.buscarJugador(textFieldEmail.getText());
		Jugador jugador2 = pers.buscarJugador(textFieldEmail2.getText());
		// Crear equipo
		Equipo equipo= new Equipo();
		// Añadir los jugadores al equipo
		Set jugadores = new HashSet<Jugador>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		equipo.setJugadors(jugadores);
		int id = pers.guardarEquipo(equipo);
		JOptionPane.showMessageDialog(this, "Se ha guardado el equipo con ID " + id + " compuesto por " + "\n" 
		+ jugador1.getNombre() + " con email " + jugador2.getEmail() + "\n" + 
		" y " + jugador2.getNombre() + " con email " + jugador2.getEmail(), "Equipo guardado correctamente", JOptionPane.INFORMATION_MESSAGE);
		textFieldEmail.setText("");
		textFieldEmail2.setText("");
		textFieldId.setText("");
		textFieldId2.setText("");
		textFieldNombre.setText("");
		textFieldNombre2.setText("");
		btnBuscar.setEnabled(true);
		btnBuscar2.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnBorrar.setEnabled(false);
		textFieldEmail2.setEnabled(false);
		textFieldNombre2.setEnabled(false);
		comboBox.removeAllItems();
	}

	protected void cancelar() {
		textFieldEmail.setText("");
		textFieldEmail2.setText("");
		textFieldId.setText("");
		textFieldId2.setText("");
		textFieldNombre.setText("");
		textFieldNombre2.setText("");
		btnBuscar2.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnBorrar.setEnabled(false);
		textFieldEmail2.setEnabled(false);
		textFieldNombre2.setEnabled(false);
		btnBuscar2.setEnabled(false);
		comboBox.removeAllItems();
		btnBuscar.setEnabled(true);
		comboBox.setEnabled(false);
		textFieldEmail.setEnabled(true);
		textFieldNombre.setEnabled(true);
	}

	protected void buscarJugador2() {
		Listado listado = new Listado(2);
		listado.setVisible(true);
		textFieldEmail2.setEnabled(false);
		textFieldNombre2.setEnabled(false);
		btnBuscar2.setEnabled(false);
		btnGuardar.setEnabled(true);
	}

	protected void buscarJugador1() {
		Listado listado = new Listado(1);
		listado.setVisible(true);
		btnBuscar2.setEnabled(true);
		textFieldEmail2.setEnabled(true);
		textFieldNombre2.setEnabled(true);
		btnBuscar.setEnabled(false);
		textFieldEmail.setEnabled(false);
		textFieldNombre.setEnabled(false);
		btnBorrar.setEnabled(true);
		comboBox.setEnabled(true);
		comboBox.removeAllItems();
	}
	
	// GUI Listado
	public static DefaultComboBoxModel<String> modeloComboBox = new DefaultComboBoxModel<String>();
	public Jugador jugadorSeleccionado = null;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnBuscar2;
	private JComboBox comboBox;
	private JButton btnBorrar;
	class Listado extends JFrame {

		public Listado(int numJugador) {
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
			
			String nombre = "";
			String email = "";
			if (numJugador == 1) {
				nombre = textFieldNombre.getText().trim().toUpperCase();
				email = textFieldEmail.getText().trim().toUpperCase();
			} else {
				nombre = textFieldNombre2.getText().trim().toUpperCase();
				email = textFieldEmail2.getText().trim().toUpperCase();
			}
			List<Jugador> listadoJugadores = pers.listadoJugador(nombre, email);
			if (listadoJugadores.size() == 0) {
				JLabel lbl2 = new JLabel("No se encontr\u00F3 ninguna coincidencia de Jugador con los filtros indicados.");
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
				String[] encabezado = {"ID", "Email", "Nombre", "Fecha de nacimiento", "Nivel" }; 
				modelo.setColumnIdentifiers(encabezado);
				table.setModel(modelo);
				Object Obj [] = null;
		    	for (int i = 0; i < listadoJugadores.size(); i++) {
		    		modelo.addRow(Obj);
		            Jugador jugador = (Jugador) listadoJugadores.get(i);
	            	if (!textFieldEmail.getText().trim().equals(jugador.getEmail())) {
	            		modelo.setValueAt(jugador.getId(), i, 0);
			            modelo.setValueAt(jugador.getEmail(), i, 1);
			            modelo.setValueAt(jugador.getNombre(), i, 2);
			            modelo.setValueAt(jugador.getFechaNac(), i, 3);
			            modelo.setValueAt(jugador.getNivel(), i, 4);
					} else {
					}
		    	}
		    	
		    	// Selecciona tabla
		    	table.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						int seleccion = table.getSelectedRow();
						jugadorSeleccionado = listadoJugadores.get(seleccion);
						if (numJugador == 1) {
							textFieldId.setText(String.valueOf(jugadorSeleccionado.getId()));
							textFieldNombre.setText(jugadorSeleccionado.getNombre());
							textFieldEmail.setText(jugadorSeleccionado.getEmail());
						} else {
							textFieldId2.setText(String.valueOf(jugadorSeleccionado.getId()));
							textFieldNombre2.setText(jugadorSeleccionado.getNombre());
							textFieldEmail2.setText(jugadorSeleccionado.getEmail());
						}
						Set<Equipo> equipos = jugadorSeleccionado.getEquipos();
						Set<Jugador> jugadores = null;
						List<Jugador> juadoresList = new ArrayList<Jugador>();
						for (Equipo equipo : equipos) {
							jugadores = equipo.getJugadors();
							juadoresList.addAll(jugadores);
							juadoresList.add(null);
						}
						String compuestoPor = "";
						for (int i = 0; i < juadoresList.size(); i++) {
							if (juadoresList.get(i) != null && juadoresList.get(i+1) != null) {
								compuestoPor = juadoresList.get(i).getNombre() + " , " + juadoresList.get(i+1).getNombre();
								modeloComboBox.addElement(compuestoPor);
							}
						}
						comboBox.setEnabled(true);
						comboBox.setModel(modeloComboBox);
						dispose();
					}
				});
			}
			
		}
	}
}

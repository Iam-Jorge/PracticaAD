package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class ClubGUI extends JFrame {
	static Persistencia pers = PrincipalGUI.per;

	private JPanel contentPane;
	private JTextField textFieldIdClub;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JButton btnBorrar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnBuscar;
	private JMenuBar menuBar;
	private JMenu mnCompeticion;
	private JMenu mnNewMenu_2;
	private static JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClubGUI frame = new ClubGUI();
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
	public ClubGUI() {
		setResizable(false);
		setTitle("Club");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		//Color azul = new Color(202, 232, 252);
		//contentPane.setBackground(azul);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClubs = new JMenu("Clubs");
		menuBar.add(mnClubs);
		
		JMenuItem mntmClub = new JMenuItem("Nuevo club");
		mnClubs.add(mntmClub);
		
		mnCompeticion = new JMenu("Competiciones");
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
		
		mntmNewMenuItem_3 = new JMenuItem("Nuevo Grupo");
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
			public void actionPerformed(ActionEvent arg0) {
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
		
		mnNewMenu_2 = new JMenu("Jugadores");
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
		
		mntmNewMenuItem_1 = new JMenuItem("Nuevo equipo");
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
		
		JMenu mnVolver = new JMenu("Volver");
		menuBar.add(mnVolver);
		
		JMenuItem mntmMen = new JMenuItem("Men\u00FA principal");
		mntmMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrincipalGUI principalGUI = new PrincipalGUI();
				principalGUI.setVisible(true);
				dispose();
			}
		});
		mnVolver.add(mntmMen);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdClub = new JLabel("ID Club");
		lblIdClub.setBounds(16, 33, 46, 14);
		contentPane.add(lblIdClub);
		
		textFieldIdClub = new JTextField();
		textFieldIdClub.setEditable(false);
		textFieldIdClub.setBounds(93, 30, 52, 20);
		contentPane.add(textFieldIdClub);
		textFieldIdClub.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(16, 77, 46, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(93, 74, 355, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(16, 121, 68, 14);
		contentPane.add(lblDireccion);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setEditable(false);
		textFieldDireccion.setBounds(93, 118, 355, 20);
		contentPane.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarClub();
			}
		});
		btnBorrar.setBounds(119, 163, 106, 23);
		btnBorrar.setVisible(false);
		contentPane.add(btnBorrar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarClub();
			}
		});
		btnGuardar.setBounds(10, 163, 106, 23);
		btnGuardar.setVisible(false);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
				deshabilitarCampos();
			}
		});
		btnCancelar.setBounds(241, 163, 106, 23);
		contentPane.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				busqueda();
			}
		});
		btnBuscar.setBounds(351, 163, 106, 23);
		contentPane.add(btnBuscar);
	}
	
	protected void guardarClub() {
		Club club = null;
		int id = 0;
		try {
			club = pers.buscarClub(textFieldNombre.getText().trim().toUpperCase());
			if (club == null) {
				club = new Club();
				club.setNombre(textFieldNombre.getText().trim().toUpperCase());
				club.setDireccion(textFieldDireccion.getText().trim().toUpperCase());
				id = pers.guardarClub(club);
				JOptionPane.showMessageDialog(this, "Se ha guardado el club con ID: " + id, "Guardado", JOptionPane.INFORMATION_MESSAGE);
			} else {
				club.setNombre(textFieldNombre.getText().trim().toUpperCase());
				club.setDireccion(textFieldDireccion.getText().trim().toUpperCase());
				id = pers.guardarClub(club);
				JOptionPane.showMessageDialog(this, "Se ha modificado el club con ID: " + id, "Modificado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Se ha producido un error " + id + " " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		limpiarCampos();
		deshabilitarCampos();
	}

	protected void borrarClub() {
		Club club = null;
		try {
			club = pers.buscarClub(textFieldNombre.getText().trim().toUpperCase());
			int opcion = JOptionPane.showConfirmDialog(this, "Esta seguro de que desea borrar el club con ID: " + club.getId(), "Borrado", JOptionPane.INFORMATION_MESSAGE);
			if (opcion == 0) {
				pers.borrarClub(club);
				JOptionPane.showMessageDialog(this, "Se ha eliminado el club con ID: " + club.getId() + ".");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Se ha producido un error al borrar el club con ID: " + club.getId() + " " + e.getMessage(), "Borrado", JOptionPane.ERROR_MESSAGE);
		}
		textFieldIdClub.setText("");
		textFieldNombre.setText("");
		textFieldDireccion.setText("");
		textFieldIdClub.setEnabled(false);
		textFieldDireccion.setEditable(false);
		btnGuardar.setVisible(false);
		btnBorrar.setVisible(false);
	}

	protected void busqueda() {
		Listado listado = new Listado();
		listado.setVisible(true);
	}
	
	// GUI Listado
	public Club clubSeleccionado = null;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_3;
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
			
			// Boton Nuevo
			JButton btnNuevo = new JButton("Nuevo");
			btnNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textFieldDireccion.setText("");
					textFieldIdClub.setText("");
					textFieldDireccion.setEditable(true);
					textFieldDireccion.setEnabled(true);
					btnBorrar.setVisible(true);
					btnGuardar.setVisible(true);
					btnBorrar.setEnabled(false);
					dispose();
				}
			});
			btnNuevo.setBounds(25, 216, 89, 23);
			contentPane.add(btnNuevo);
			
			String filtro = textFieldNombre.getText().trim().toUpperCase();
			List<Club> listadoClub = pers.listadoClub(filtro);
			if (listadoClub.size() == 0) {
				JLabel lbl1 = new JLabel("Clubs que contienen \"" + filtro + "\"");
				lbl1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lbl1.setBounds(118, 11, 188, 14);
				contentPane.add(lbl1);
				JLabel lbl2 = new JLabel("No se encontr\u00F3 ninguna coincidencia de Club con el filtro " + filtro + ".");
				lbl2.setBounds(35, 35, 380, 50);
				contentPane.add(lbl2);
				JLabel lbl3 = new JLabel("Desea crear un nuevo Club \"" + filtro + "\"?");
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
						textFieldNombre.setText(clubSeleccionado.getNombre().trim().toUpperCase());
						textFieldIdClub.setText(String.valueOf(clubSeleccionado.getId()).trim().toUpperCase());
						textFieldDireccion.setText(clubSeleccionado.getDireccion().trim().toUpperCase());
						btnBorrar.setVisible(true);
						btnGuardar.setVisible(true);
						btnBorrar.setEnabled(true);
						textFieldDireccion.setEnabled(true);
						textFieldDireccion.setEditable(true);
						dispose();
					}
				});
			}
			
		}
	}

	public void limpiarCampos() {
		textFieldIdClub.setText("");
		textFieldNombre.setText("");
		textFieldDireccion.setText("");
		textFieldDireccion.setEditable(false);
		btnBorrar.setVisible(false);
		btnGuardar.setVisible(false);
	}
	
	public void deshabilitarCampos() {
		textFieldIdClub.setEnabled(false);
		textFieldNombre.setEnabled(true);
		textFieldDireccion.setEnabled(false);
		btnBorrar.setVisible(false);
		btnGuardar.setVisible(false);
	}
}

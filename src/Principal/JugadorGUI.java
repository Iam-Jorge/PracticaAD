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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class JugadorGUI extends JFrame {
	static Persistencia pers = PrincipalGUI.per;
	private JPanel contentPane;
	private JTextField textFieldId;
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField textFieldFechaNac;
	private JTextField textFieldNivel;
	private JButton btnBorrar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnBuscar;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JugadorGUI frame = new JugadorGUI();
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
	public JugadorGUI() {
		setTitle("Jugador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClubs = new JMenu("Clubes");
		menuBar.add(mnClubs);
		
		JMenuItem mntmNuevoClub = new JMenuItem("Nuevo Club");
		mntmNuevoClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClubGUI clubGui = new ClubGUI();
				clubGui.setVisible(false);
				dispose();
			}
		});
		mnClubs.add(mntmNuevoClub);
		
		JMenu mnCompeticiones = new JMenu("Competiciones");
		menuBar.add(mnCompeticiones);
		
		JMenuItem mntmCompeticion = new JMenuItem("Nueva Competici\u00F3n");
		mntmCompeticion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompeticionGUI competicionGUI = new CompeticionGUI();
				competicionGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticiones.add(mntmCompeticion);
		
		JMenuItem mntmCompeticionesActivas = new JMenuItem("Inscripci\u00F3n");
		mntmCompeticionesActivas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscripcionGUI inscripcionGUI = new InscripcionGUI();
				inscripcionGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticiones.add(mntmCompeticionesActivas);
		
		JMenuItem mntmNuevoGrupo = new JMenuItem("Nuevo Grupo");
		mntmNuevoGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrupoGUI grupoGUI = new GrupoGUI();
				grupoGUI.setVisible(true);
				dispose();
			}
		});
		mnCompeticiones.add(mntmNuevoGrupo);
		
		JMenuItem mntmPartidos = new JMenuItem("Resultados");
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
			public void actionPerformed(ActionEvent e) {
				PromocionGUI promocionGui = new PromocionGUI();
				promocionGui.setVisible(true);
				dispose();
			}
		});
		mnCompeticiones.add(mntmPromocin);
		
		JMenu mnJugadores = new JMenu("Jugadores");
		menuBar.add(mnJugadores);
		
		JMenuItem mntmNuevoJugador = new JMenuItem("Nuevo Jugador");
		mnJugadores.add(mntmNuevoJugador);
		
		JMenuItem mntmListadoJugadores = new JMenuItem("Nuevo Equipo");
		mntmListadoJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EquipoGUI equipoGUI = new EquipoGUI();
				equipoGUI.setVisible(true);
				dispose();
			}
		});
		mnJugadores.add(mntmListadoJugadores);
		
		JMenu mnInformes = new JMenu("Informes");
		menuBar.add(mnInformes);
		
		JMenuItem mntmClasificacin = new JMenuItem("Clasificaci\u00F3n");
		mntmClasificacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformeClasificacionGUI clasificacionGUI = new InformeClasificacionGUI();
				clasificacionGUI.setVisible(true);
				dispose();
			}
		});
		mnInformes.add(mntmClasificacin);
		
		JMenuItem mntmPartidosJugados = new JMenuItem("Partidos jugados");
		mntmPartidosJugados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformePartidosJugadorGUI partidosGUI = new InformePartidosJugadorGUI();
				partidosGUI.setVisible(true);
				dispose();
			}
		});
		mnInformes.add(mntmPartidosJugados);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(317, 30, 21, 14);
		contentPane.add(lblId);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(367, 27, 33, 20);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(20, 30, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(76, 27, 218, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 66, 46, 14);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(76, 63, 218, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblFechaDeNaciemiento = new JLabel("Fecha de naciemiento");
		lblFechaDeNaciemiento.setBounds(20, 107, 160, 14);
		contentPane.add(lblFechaDeNaciemiento);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(148, 104, 144, 20);
		contentPane.add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nivel");
		lblNewLabel_1.setBounds(317, 66, 33, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldNivel = new JTextField();
		textFieldNivel.setBounds(368, 63, 33, 20);
		contentPane.add(textFieldNivel);
		textFieldNivel.setColumns(10);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				borrarJugador();
			}
		});
		btnBorrar.setBounds(105, 187, 89, 23);
		contentPane.add(btnBorrar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarJugador();
			}
		});
		btnGuardar.setBounds(10, 187, 89, 23);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deshabilitarCampos();
				limpiarCampos();
			}
		});
		btnCancelar.setBounds(236, 187, 89, 23);
		contentPane.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarJugador();
			}
		});
		btnBuscar.setBounds(331, 187, 89, 23);
		contentPane.add(btnBuscar);
		deshabilitarCampos();
		limpiarCampos();
	}
	
	
	protected void borrarJugador() {
		Jugador jugador = pers.buscarJugador(textFieldEmail.getText());
		int opcion = JOptionPane.showConfirmDialog(this, "Se eliminará el jugador " + jugador.getNombre() + " con id " + jugador.getId(), "Borrar jugador", JOptionPane.INFORMATION_MESSAGE);
		if (opcion == 0) {
			JOptionPane.showMessageDialog(this, "Se ha eliminado el jugador " + jugador.getNombre() + " con Id " + jugador.getId());
			pers.borrarJugador(jugador);
		}
		deshabilitarCampos();
		limpiarCampos();
	}

	protected void guardarJugador() {
		boolean validado = validarCampos();
		if (validado == true) {
			Jugador jugador = pers.buscarJugador(textFieldEmail.getText());
			if (jugador == null) {
				jugador = new Jugador();
				jugador.setEmail(textFieldEmail.getText().trim().toUpperCase());
				jugador.setNombre(textFieldNombre.getText().trim().toUpperCase());
				jugador.setNivel(Integer.parseInt(textFieldNivel.getText().trim()));
				Date miFechaNac;
				try {
					miFechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldFechaNac.getText().trim());
					jugador.setFechaNac(miFechaNac);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					Equipo equipo = new Equipo();
					Set jugadores = new HashSet<Jugador>();
					jugadores.add(jugador);
					equipo.setJugadors(jugadores);
					pers.guardarJugador(jugador);
					pers.guardarEquipo(equipo);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(this, "Jugador duplicado", "Error", JOptionPane.ERROR_MESSAGE);
				}
				JOptionPane.showMessageDialog(this, "Se ha guardado el jugador " + jugador.getNombre() + " con id " + jugador.getId(), "Jugador guardado", JOptionPane.INFORMATION_MESSAGE);
			} else {
				btnBorrar.setEnabled(true);
				jugador.setEmail(textFieldEmail.getText().trim().toUpperCase());
				jugador.setNombre(textFieldNombre.getText().trim().toUpperCase());
				jugador.setNivel(Integer.parseInt(textFieldNivel.getText().trim()));
				textFieldNivel.setEnabled(true);
				textFieldFechaNac.setEnabled(true);
				Date miFechaNac;
				try {
					miFechaNac = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldFechaNac.getText());
					jugador.setFechaNac(miFechaNac);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				pers.guardarJugador(jugador);
				JOptionPane.showMessageDialog(this, "Se ha modificado el jugador " + jugador.getNombre() + " con id " + jugador.getId(), "Jugador guardado", JOptionPane.INFORMATION_MESSAGE);
			}
			limpiarCampos();
			deshabilitarCampos();
		} else {
			
		}
	}

	protected void buscarJugador() {
		Listado listado = new Listado();
		listado.setVisible(true);
	}
	
	// GUI Listado
	public Jugador jugadorSeleccionado = null;
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
			
			// Boton Nuevo
			JButton btnNuevo = new JButton("Nuevo");
			btnNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBorrar.setVisible(true);
					btnGuardar.setVisible(true);
					btnBorrar.setEnabled(false);
					textFieldNivel.setEnabled(true);
					textFieldFechaNac.setEnabled(true);
					dispose();
				}
			});
			btnNuevo.setBounds(25, 216, 89, 23);
			contentPane.add(btnNuevo);
			
			String nombre = textFieldNombre.getText().trim().toUpperCase();
			String email = textFieldEmail.getText().trim().toUpperCase();
			List<Jugador> listadoJugadores = pers.listadoJugador(nombre, email);
			if (listadoJugadores.size() == 0) {
				JLabel lbl1 = new JLabel("Jugadores con Email \"" + email + "\" y Nombre \"" + nombre + "\".");
				lbl1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lbl1.setBounds(118, 11, 188, 14);
				contentPane.add(lbl1);
				JLabel lbl2 = new JLabel("No se encontr\u00F3 ninguna coincidencia de Jugador con los filtros indicados.");
				lbl2.setBounds(35, 35, 380, 50);
				contentPane.add(lbl2);
				JLabel lbl3 = new JLabel("Desea crear un nuevo Jugador ?");
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
						textFieldId.setText(String.valueOf(jugadorSeleccionado.getId()));
						textFieldNombre.setText(jugadorSeleccionado.getNombre());
						textFieldEmail.setText(jugadorSeleccionado.getEmail());
						Format formatter = new SimpleDateFormat("dd/MM/yyyy");
						String fechaNac = formatter.format(jugadorSeleccionado.getFechaNac());
						textFieldFechaNac.setText(fechaNac);
						textFieldNivel.setText(String.valueOf(jugadorSeleccionado.getNivel()));
						textFieldNivel.setEnabled(true);
						textFieldFechaNac.setEnabled(true);
						btnBorrar.setVisible(true);
						btnGuardar.setVisible(true);
						btnBorrar.setEnabled(true);
						dispose();
					}
				});
			}
			
		}
	}

	public void deshabilitarCampos() {
		textFieldFechaNac.setEnabled(false);
		textFieldId.setEnabled(false);
		textFieldNivel.setEnabled(false);
		btnGuardar.setVisible(false);
		btnBorrar.setVisible(false);
	}
	
	public void habilitarCampos() {
		textFieldFechaNac.setEnabled(true);
		textFieldNivel.setEnabled(true);
		textFieldNombre.setEnabled(true);
		btnGuardar.setVisible(true);
		btnBorrar.setEnabled(true);
		btnBorrar.setVisible(true);
	}
	
	public void limpiarCampos() {
		textFieldEmail.setText("");
		textFieldFechaNac.setText("");
		textFieldId.setText("");
		textFieldNivel.setText("");
		textFieldNombre.setText("");
	}
	
	public boolean validarCampos() {
		if(!textFieldEmail.getText().trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			JOptionPane.showMessageDialog(this, "El email no cumple con el formato", "Error Email", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		String nombre = textFieldNombre.getText();
		if (nombre.length() == 0) {
			JOptionPane.showMessageDialog(this, "El campo nombre no puede ir vacío", "Error Nombre", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (textFieldNivel.getText().length() == 0) {
			textFieldNivel.setText("0");
		} else {
			int nivel = Integer.parseInt(textFieldNivel.getText());
			if (nivel > 3 || nivel < -1) {
				JOptionPane.showMessageDialog(this, "Nivel desconocido (0, 1, 2, 3)", "Error Nivel", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		if(!textFieldFechaNac.getText().trim().matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\/](0?[1-9]|1[012])[\\/\\/]\\d{4}$")) {
			JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto (dd/mm/yyyy)", "Error Fecha de nacimiento", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	
}

package com.videoclub.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.videoclub.dao.VideoclubDAO;
import com.videoclub.model.Pelicula;
import com.videoclub.model.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class App {

	private JFrame frame;
	private JTextField txtIDu;
	private JTextField txtnomU;
	private JTextField txtApeU;
	private JTextField txtEdadU;
	private JTextField txtTlfU;
	private JTextField txtCodP;
	private JTextField txtNomP;
	private JTextField txtDuracionP;
	private JTextField txtGeneroP;
	private JTextField txtYearP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(239, 189, 228));
		frame.setBounds(100, 100, 450, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		VideoclubDAO videoclubDAO=new VideoclubDAO();
		Pelicula pelicula=new Pelicula();
		Usuario usuario=new Usuario();
		
		
		//TABLA PELICULA
			//modelo
		DefaultTableModel modeloPeli = new DefaultTableModel();
		modeloPeli.addColumn("codigo");
		modeloPeli.addColumn("nombre");
		modeloPeli.addColumn("duracion");
		modeloPeli.addColumn("genero");
		modeloPeli.addColumn("año");
		
			//sustituto del try/catch de jdbc
		List<Pelicula> peliculas=videoclubDAO.selectAllPeliculas();
		
		for(Pelicula pe:peliculas) {
			Object[]fila= {pe.getCodigo(), pe.getNombre(), pe.getDuracion(), pe.getGenero(), pe.getYear()};
			modeloPeli.addRow(fila);
		}
		
			//crear tabla en interfaz
		JTable tablaPeli=new JTable(modeloPeli);
		tablaPeli.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scrollPanePeli=new JScrollPane(tablaPeli);
		scrollPanePeli.setBounds(241, 12, 197, 90);
		frame.getContentPane().add(scrollPanePeli);
		
		
		//TABLA PELICULA
		//modelo
	DefaultTableModel modeloUser = new DefaultTableModel();
	modeloUser.addColumn("id");
	modeloUser.addColumn("nombre");
	modeloUser.addColumn("apellido");
	modeloUser.addColumn("edad");
	modeloUser.addColumn("telefono");
	
		//sustituto del try/catch de jdbc
	List<Usuario> usuarios=videoclubDAO.selectAllUsuarios();
	
	for(Usuario us:usuarios) {
		Object[]fila= {us.getId(), us.getNombre(), us.getApellido(), us.getEdad(), us.getTelefono()};
		modeloUser.addRow(fila);
	}
	
		//crear tabla en interfaz
	JTable tablaUser=new JTable(modeloUser);
	tablaUser.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	
	JScrollPane scrollPaneUser=new JScrollPane(tablaUser);
	scrollPaneUser.setBounds(12, 12, 197, 90);
	frame.getContentPane().add(scrollPaneUser);
	
	JLabel lblId = new JLabel("id");
	lblId.setBounds(251, 114, 70, 15);
	frame.getContentPane().add(lblId);
	
	JLabel lblNombre = new JLabel("nombre");
	lblNombre.setBounds(251, 141, 70, 15);
	frame.getContentPane().add(lblNombre);
	
	JLabel lblApellido = new JLabel("apellido");
	lblApellido.setBounds(251, 168, 70, 15);
	frame.getContentPane().add(lblApellido);
	
	JLabel lblEdad = new JLabel("edad");
	lblEdad.setBounds(251, 195, 70, 15);
	frame.getContentPane().add(lblEdad);
	
	JLabel lblTelefono = new JLabel("telefono");
	lblTelefono.setBounds(251, 222, 70, 15);
	frame.getContentPane().add(lblTelefono);
	
	JLabel lblNewLabel = new JLabel("codigo");
	lblNewLabel.setBounds(12, 114, 70, 15);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNombre_1 = new JLabel("nombre");
	lblNombre_1.setBounds(12, 141, 70, 15);
	frame.getContentPane().add(lblNombre_1);
	
	JLabel lblDuracion = new JLabel("duracion");
	lblDuracion.setBounds(12, 168, 70, 15);
	frame.getContentPane().add(lblDuracion);
	
	JLabel lblEdad_1 = new JLabel("genero");
	lblEdad_1.setBounds(12, 195, 70, 15);
	frame.getContentPane().add(lblEdad_1);
	
	JLabel lblAo = new JLabel("año");
	lblAo.setBounds(12, 222, 70, 15);
	frame.getContentPane().add(lblAo);
	
	txtIDu = new JTextField();
	txtIDu.setBounds(324, 112, 114, 19);
	frame.getContentPane().add(txtIDu);
	txtIDu.setColumns(10);
	
	txtnomU = new JTextField();
	txtnomU.setColumns(10);
	txtnomU.setBounds(324, 139, 114, 19);
	frame.getContentPane().add(txtnomU);
	
	txtApeU = new JTextField();
	txtApeU.setColumns(10);
	txtApeU.setBounds(324, 166, 114, 19);
	frame.getContentPane().add(txtApeU);
	
	txtEdadU = new JTextField();
	txtEdadU.setColumns(10);
	txtEdadU.setBounds(324, 193, 114, 19);
	frame.getContentPane().add(txtEdadU);
	
	txtTlfU = new JTextField();
	txtTlfU.setColumns(10);
	txtTlfU.setBounds(324, 220, 114, 19);
	frame.getContentPane().add(txtTlfU);
	
	txtCodP = new JTextField();
	txtCodP.setColumns(10);
	txtCodP.setBounds(95, 110, 114, 19);
	frame.getContentPane().add(txtCodP);
	
	txtNomP = new JTextField();
	txtNomP.setColumns(10);
	txtNomP.setBounds(95, 137, 114, 19);
	frame.getContentPane().add(txtNomP);
	
	txtDuracionP = new JTextField();
	txtDuracionP.setColumns(10);
	txtDuracionP.setBounds(95, 164, 114, 19);
	frame.getContentPane().add(txtDuracionP);
	
	txtGeneroP = new JTextField();
	txtGeneroP.setColumns(10);
	txtGeneroP.setBounds(95, 191, 114, 19);
	frame.getContentPane().add(txtGeneroP);
	
	txtYearP = new JTextField();
	txtYearP.setColumns(10);
	txtYearP.setBounds(95, 218, 114, 19);
	frame.getContentPane().add(txtYearP);
	
	JButton btnAddP = new JButton("+");
	btnAddP.setBounds(51, 258, 58, 25);
	frame.getContentPane().add(btnAddP);
	
	JButton btndelP = new JButton("-");
	btndelP.setBounds(118, 258, 58, 25);
	frame.getContentPane().add(btndelP);
	
	JButton btnAddU = new JButton("+");
	btnAddU.setBounds(286, 258, 58, 25);
	frame.getContentPane().add(btnAddU);
	
	JButton btnDelU = new JButton("-");
	btnDelU.setBounds(353, 258, 58, 25);
	frame.getContentPane().add(btnDelU);
	
	JButton btnActU = new JButton("Actualizar");
	btnActU.setBounds(286, 302, 125, 25);
	frame.getContentPane().add(btnActU);
	
	JButton btnActP = new JButton("Actualizar");
	btnActP.setBounds(51, 302, 125, 25);
	frame.getContentPane().add(btnActP);
		
		
		
	}
}

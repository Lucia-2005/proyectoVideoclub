package com.videoclub.gui;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.videoclub.dao.PeliculaDAO;
import com.videoclub.dao.UsuarioDAO;
import com.videoclub.model.Pelicula;
import com.videoclub.model.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

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
	private JTextField textField;

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
	
	
	static void actualizarTablaUser() {
		
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
		frame.setBounds(100, 100, 981, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		UsuarioDAO usuarioDAO=new UsuarioDAO();
		PeliculaDAO peliculaDAO=new PeliculaDAO();
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
		List<Pelicula> peliculas=peliculaDAO.selectAllPeliculas();
		
		for(Pelicula pe:peliculas) {
			Object[]fila= {pe.getCodigo(), pe.getNombre(), pe.getDuracion(), pe.getGenero(), pe.getYear()};
			modeloPeli.addRow(fila);
		}
		
			//crear tabla en interfaz
		JTable tablaPeli=new JTable(modeloPeli);
		tablaPeli.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaPeli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=tablaPeli.getSelectedRow();
				TableModel model=tablaPeli.getModel();
				
				txtCodP.setText(modeloPeli.getValueAt(index,0).toString());
				txtNomP.setText(modeloPeli.getValueAt(index, 1).toString());
				txtDuracionP.setText(modeloPeli.getValueAt(index, 2).toString());
				txtGeneroP.setText(modeloPeli.getValueAt(index, 3).toString());
				txtYearP.setText(modeloPeli.getValueAt(index, 4).toString());
			}
		});
		
		JScrollPane scrollPanePeli=new JScrollPane(tablaPeli);
		scrollPanePeli.setBounds(43, 12, 296, 90);
		frame.getContentPane().add(scrollPanePeli);
		
		
		//TABLA USUARIO
		//modelo
	DefaultTableModel modeloUser = new DefaultTableModel();
	modeloUser.addColumn("id");
	modeloUser.addColumn("nombre");
	modeloUser.addColumn("apellido");
	modeloUser.addColumn("edad");
	modeloUser.addColumn("telefono");
	
		//sustituto del try/catch de jdbc
	List<Usuario> usuarios=usuarioDAO.selectAllUsuarios();
	
	for(Usuario us:usuarios) {
		Object[]fila= {us.getId(), us.getNombre(), us.getApellido(), us.getEdad(), us.getTelefono()};
		modeloUser.addRow(fila);
	}
	
		//crear tabla en interfaz
	JTable tablaUser=new JTable(modeloUser);
	tablaUser.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	tablaUser.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index=tablaUser.getSelectedRow();
			TableModel model=tablaUser.getModel();
			
			txtIDu.setText(modeloUser.getValueAt(index,0).toString());
			txtnomU.setText(modeloUser.getValueAt(index, 1).toString());
			txtApeU.setText(modeloUser.getValueAt(index, 2).toString());
			txtEdadU.setText(modeloUser.getValueAt(index, 3).toString());
			txtTlfU.setText(modeloUser.getValueAt(index, 4).toString());
		}
	});
	
	JScrollPane scrollPaneUser=new JScrollPane(tablaUser);
	scrollPaneUser.setBounds(593, 12, 296, 90);
	frame.getContentPane().add(scrollPaneUser);
	
	
	//LABEL
	JLabel lblId = new JLabel("id");
	lblId.setBounds(702, 114, 70, 15);
	frame.getContentPane().add(lblId);
	
	JLabel lblNombre = new JLabel("nombre");
	lblNombre.setBounds(702, 141, 70, 15);
	frame.getContentPane().add(lblNombre);
	
	JLabel lblApellido = new JLabel("apellido");
	lblApellido.setBounds(702, 168, 70, 15);
	frame.getContentPane().add(lblApellido);
	
	JLabel lblEdad = new JLabel("edad");
	lblEdad.setBounds(702, 195, 70, 15);
	frame.getContentPane().add(lblEdad);
	
	JLabel lblTelefono = new JLabel("telefono");
	lblTelefono.setBounds(702, 222, 70, 15);
	frame.getContentPane().add(lblTelefono);
	
	JLabel lblNewLabel = new JLabel("codigo");
	lblNewLabel.setBounds(43, 118, 70, 15);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel lblNombre_1 = new JLabel("nombre");
	lblNombre_1.setBounds(43, 141, 70, 15);
	frame.getContentPane().add(lblNombre_1);
	
	JLabel lblDuracion = new JLabel("duracion");
	lblDuracion.setBounds(43, 168, 70, 15);
	frame.getContentPane().add(lblDuracion);
	
	JLabel lblEdad_1 = new JLabel("genero");
	lblEdad_1.setBounds(215, 141, 70, 15);
	frame.getContentPane().add(lblEdad_1);
	
	JLabel lblAo = new JLabel("año");
	lblAo.setBounds(215, 168, 70, 15);
	frame.getContentPane().add(lblAo);
	
	//TEXTFIELDS
	txtIDu = new JTextField();
	txtIDu.setEditable(false);
	txtIDu.setBounds(775, 112, 114, 19);
	frame.getContentPane().add(txtIDu);
	txtIDu.setColumns(10);
	
	txtnomU = new JTextField();
	txtnomU.setColumns(10);
	txtnomU.setBounds(775, 139, 114, 19);
	frame.getContentPane().add(txtnomU);
	
	txtApeU = new JTextField();
	txtApeU.setColumns(10);
	txtApeU.setBounds(775, 166, 114, 19);
	frame.getContentPane().add(txtApeU);
	
	txtEdadU = new JTextField();
	txtEdadU.setColumns(10);
	txtEdadU.setBounds(775, 193, 114, 19);
	frame.getContentPane().add(txtEdadU);
	
	txtTlfU = new JTextField();
	txtTlfU.setColumns(10);
	txtTlfU.setBounds(775, 220, 114, 19);
	frame.getContentPane().add(txtTlfU);
	
	txtCodP = new JTextField();
	txtCodP.setEditable(false);
	txtCodP.setColumns(10);
	txtCodP.setBounds(126, 114, 79, 19);
	frame.getContentPane().add(txtCodP);
	
	txtNomP = new JTextField();
	txtNomP.setColumns(10);
	txtNomP.setBounds(126, 137, 79, 19);
	frame.getContentPane().add(txtNomP);
	
	txtDuracionP = new JTextField();
	txtDuracionP.setColumns(10);
	txtDuracionP.setBounds(126, 164, 79, 19);
	frame.getContentPane().add(txtDuracionP);
	
	txtGeneroP = new JTextField();
	txtGeneroP.setColumns(10);
	txtGeneroP.setBounds(298, 137, 79, 19);
	frame.getContentPane().add(txtGeneroP);
	
	txtYearP = new JTextField();
	txtYearP.setColumns(10);
	txtYearP.setBounds(298, 164, 79, 19);
	frame.getContentPane().add(txtYearP);
	
	//BOTON
	JButton btnAddUs = new JButton("+");
	btnAddUs.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Usuario usuIns=new Usuario();
			String nombre=txtnomU.getText();
			String ape=txtApeU.getText();
			int edad=Integer.parseInt(txtEdadU.getText());
			int tlf=Integer.parseInt(txtTlfU.getText());
			
			//actualizar clase usuario
			usuIns=new Usuario(nombre, ape, edad, tlf);
			
			//actualizar base de datos
			usuarioDAO.insertUsuario(usuIns);
			
			//actualizar la tabla instantaneamente
			modeloUser.setRowCount(0);
			List<Usuario> usuarios=usuarioDAO.selectAllUsuarios();
			
			for(Usuario us:usuarios) {
				Object[]fila= {us.getId(), us.getNombre(), us.getApellido(), us.getEdad(), us.getTelefono()};
				modeloUser.addRow(fila);
			}
			txtnomU.setText("");
			txtApeU.setText("");
			txtEdadU.setText("");
			txtTlfU.setText("");
			txtIDu.setText("");
		}
	});
	btnAddUs.setBounds(735, 249, 58, 25);
	frame.getContentPane().add(btnAddUs);
	
	JButton btndelUs = new JButton("-");
	btndelUs.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Usuario usuDel=new Usuario();
			
			//coger el ID del textfield rellenado
			int id=Integer.parseInt(txtIDu.getText());
			
			//Encontrar el objeto
			usuDel=usuarioDAO.selectUserById(id);
			
			//eliminar el objeto
			usuarioDAO.deleteUsuario(id);
			
			//actualizar tabla
			modeloUser.setRowCount(0);
			List<Usuario> usuarios=usuarioDAO.selectAllUsuarios();
			
			for(Usuario us:usuarios) {
				Object[]fila= {us.getId(), us.getNombre(), us.getApellido(), us.getEdad(), us.getTelefono()};
				modeloUser.addRow(fila);
			}
			txtnomU.setText("");
			txtApeU.setText("");
			txtEdadU.setText("");
			txtTlfU.setText("");
			txtIDu.setText("");
		}
	});
	btndelUs.setBounds(802, 249, 58, 25);
	frame.getContentPane().add(btndelUs);
	
	JButton btnActUs = new JButton("Actualizar");
	btnActUs.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Usuario usuAct=new Usuario();
			
			Usuario usuIns=new Usuario();
			String nombre=txtnomU.getText();
			String ape=txtApeU.getText();
			int edad=Integer.parseInt(txtEdadU.getText());
			int tlf=Integer.parseInt(txtTlfU.getText());
			int id=Integer.parseInt(txtIDu.getText());
			
			
			//encontrar el objeto especifico
			usuAct=usuarioDAO.selectUserById(id);
			
			//actualizar la clase
			usuAct.setNombre(nombre);
			usuAct.setApellido(ape);
			usuAct.setEdad(edad);
			usuAct.setTelefono(tlf);
			
			//actualiza los datos en la base de datos
			usuarioDAO.updateUsuario(usuAct);
			
			//actualizar tabla
			modeloUser.setRowCount(0);
			List<Usuario> usuarios=usuarioDAO.selectAllUsuarios();
			
			for(Usuario us:usuarios) {
				Object[]fila= {us.getId(), us.getNombre(), us.getApellido(), us.getEdad(), us.getTelefono()};
				modeloUser.addRow(fila);
			}
			txtnomU.setText("");
			txtApeU.setText("");
			txtEdadU.setText("");
			txtTlfU.setText("");
			txtIDu.setText("");
		}
	});
	btnActUs.setBounds(735, 293, 125, 25);
	frame.getContentPane().add(btnActUs);
	
	
		//pelicula
	JButton btnAddPe = new JButton("+");
	btnAddPe.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Pelicula peliAdd=new Pelicula();
			
			String nombre=txtNomP.getText();
			int duracion=Integer.parseInt(txtDuracionP.getText());
			String genero=txtGeneroP.getText();
			int year=Integer.parseInt(txtYearP.getText());
			
			//rellenar objeto
			peliAdd=new Pelicula(nombre, duracion, genero, year);
			
			//actualizar base de datos
			peliculaDAO.insertPelicula(peliAdd);
			
			//actualizar la tabla
			modeloPeli.setRowCount(0);
			List<Pelicula> peliculas=peliculaDAO.selectAllPeliculas();
			
			for(Pelicula pe:peliculas) {
				Object[]fila= {pe.getCodigo(), pe.getNombre(), pe.getDuracion(), pe.getGenero(), pe.getYear()};
				modeloPeli.addRow(fila);
			}
			txtCodP.setText("");
			txtNomP.setText("");
			txtDuracionP.setText("");
			txtGeneroP.setText("");
			txtYearP.setText("");
		}
	});
	btnAddPe.setBounds(136, 205, 58, 25);
	frame.getContentPane().add(btnAddPe);
	
	JButton btnDelPe = new JButton("-");
	btnDelPe.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Pelicula peliDel=new Pelicula();
			int id=Integer.parseInt(txtCodP.getText());
			
			//encontrar el objeto especifico
			peliDel=peliculaDAO.selectPeliById(id);
			
			//eliminar de la base de datos
			peliculaDAO.deletePelicula(id);
			
			//actualizar la tabla
			modeloPeli.setRowCount(0);
			List<Pelicula> peliculas=peliculaDAO.selectAllPeliculas();
			
			for(Pelicula pe:peliculas) {
				Object[]fila= {pe.getCodigo(), pe.getNombre(), pe.getDuracion(), pe.getGenero(), pe.getYear()};
				modeloPeli.addRow(fila);
			}
			txtCodP.setText("");
			txtNomP.setText("");
			txtDuracionP.setText("");
			txtGeneroP.setText("");
			txtYearP.setText("");
		}
	});
	btnDelPe.setBounds(203, 205, 58, 25);
	frame.getContentPane().add(btnDelPe);
	
	JButton btnActPe = new JButton("Actualizar");
	btnActPe.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Pelicula peliAct=new Pelicula();
			
			int id=Integer.parseInt(txtCodP.getText());
			String nombre=txtNomP.getText();
			int duracion=Integer.parseInt(txtDuracionP.getText());
			String genero=txtGeneroP.getText();
			int year=Integer.parseInt(txtYearP.getText());
			
			//encontrar la clase especifica
			peliAct=peliculaDAO.selectPeliById(id);
			
			//actualizar datos en el objeto
			peliAct.setNombre(nombre);
			peliAct.setDuracion(duracion);
			peliAct.setGenero(genero);
			peliAct.setYear(year);
			
			//actualizar base de datos
			peliculaDAO.updatePelicula(peliAct);
			
			//actualizar tabla
			modeloPeli.setRowCount(0);
			List<Pelicula> peliculas=peliculaDAO.selectAllPeliculas();
			
			for(Pelicula pe:peliculas) {
				Object[]fila= {pe.getCodigo(), pe.getNombre(), pe.getDuracion(), pe.getGenero(), pe.getYear()};
				modeloPeli.addRow(fila);
			}
			txtCodP.setText("");
			txtNomP.setText("");
			txtDuracionP.setText("");
			txtGeneroP.setText("");
			txtYearP.setText("");
		}
	});
	btnActPe.setBounds(136, 249, 125, 25);
	frame.getContentPane().add(btnActPe);
	
	JLabel lblAoMinimoPelicula = new JLabel("año minimo pelicula: ");
	lblAoMinimoPelicula.setBounds(31, 339, 149, 15);
	frame.getContentPane().add(lblAoMinimoPelicula);
	
	textField = new JTextField();
	textField.setBounds(190, 337, 58, 19);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
	JButton btnFiltrar = new JButton("Filtrar");
	btnFiltrar.setBounds(260, 334, 79, 25);
	frame.getContentPane().add(btnFiltrar);
	
	JScrollPane scrollPanePeli_1 = new JScrollPane((Component) null);
	scrollPanePeli_1.setBounds(43, 371, 296, 90);
	frame.getContentPane().add(scrollPanePeli_1);
	
	
		
		
		
	}
}

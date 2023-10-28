package interfaz;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import logica.Censista;
import logica.Grafo;
import logica.Instancia;

public class Manual extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombres;
	private JTextField textFieldManzana1, textFieldManzana2;
	private JLabel lblNombres, lblFoto;
	private Grafo grafo;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField textFieldManzana;
	private Instancia instancia;
	private ArrayList<Censista> censistas;
	private String fotoCensista,nombreCensista;
	private JButton botonIngresarNombre;

	/**
	 * Create the frame.
	 */
	public Manual() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Manual.class.getResource("/interfaz/logo.png")));
		setTitle("Censo 2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		grafo = new Grafo();
		censistas = new ArrayList<Censista>();
		contentPane.setLayout(null);
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Definir Radio Censal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 206, 548, 158);
		panel.setLayout(null);
		
		textFieldManzana1 = new JTextField();
		textFieldManzana1.setBounds(102, 100, 86, 20);
		panel.add(textFieldManzana1);
		textFieldManzana1.setColumns(10);
		
		JLabel lblManzana1 = new JLabel("manzana 1:");
		lblManzana1.setBounds(20, 103, 72, 14);
		panel.add(lblManzana1);
		
		JLabel lblManzana2 = new JLabel("manzana 2:");
		lblManzana2.setBounds(223, 103, 72, 14);
		panel.add(lblManzana2);
		
		textFieldManzana2 = new JTextField();
		textFieldManzana2.setBounds(305, 100, 86, 20);
		panel.add(textFieldManzana2);
		textFieldManzana2.setColumns(10);
		
		lblNombres = new JLabel("Ingrese numero de manzana:");
		lblNombres.setBounds(10, 33, 167, 19);
		panel.add(lblNombres);
		
		
		JButton btnEnviar = new JButton("Agregar");
		btnEnviar.setBounds(423, 99, 86, 23);
		
		// agrega las aristas al grafo
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String origen = textFieldManzana1.getText();
				textFieldManzana1.setText("");
				
				String destino = textFieldManzana2.getText();
				textFieldManzana2.setText("");
				
				try{
					grafo.agregarArista(origen, destino);
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Ingrese las manzanas contiguas","Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		panel.add(btnEnviar);
		
		textFieldManzana = new JTextField();
		textFieldManzana.setBounds(196, 32, 72, 20);
		textFieldManzana.setColumns(10);
		panel.add(textFieldManzana);
		
		//agrega las manzanas al grafo
		JButton botonIngresarNombre_1 = new JButton("Agregar");
		botonIngresarNombre_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldManzana.getText();
				textFieldManzana.setText("");
				
				try{
					grafo.agregarVertice(nombre);
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Ingrese un nombre","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonIngresarNombre_1.setBounds(291, 31, 89, 23);
		panel.add(botonIngresarNombre_1);
		
		JLabel lblIngreseManzanasVecinas = new JLabel("Ingrese manzanas contiguas:");
		lblIngreseManzanasVecinas.setBounds(10, 73, 167, 19);
		panel.add(lblIngreseManzanasVecinas);
		
		JPanel panelNombres = new JPanel();
		panelNombres.setBounds(10, 0, 548, 204);
		contentPane.add(panelNombres);
		panelNombres.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Censistas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNombres.setLayout(null);
		
		JLabel lblIngresarNombre = new JLabel("Nombre:",SwingConstants.LEFT);
		panelNombres.add(lblIngresarNombre);
		lblIngresarNombre.setBounds(30, 59, 89, 17);
		
		textFieldNombres = new JTextField();
		panelNombres.add(textFieldNombres);
		textFieldNombres.setBounds(30, 87, 165, 23);
		textFieldNombres.setColumns(10);
		
		// agregar censistas
		botonIngresarNombre = new JButton("Agregar");
		botonIngresarNombre.setEnabled(false);
		
		panelNombres.add(botonIngresarNombre);
		botonIngresarNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombreCensista = textFieldNombres.getText();
				textFieldNombres.setText("");		
				censistas.add(new Censista(nombreCensista, fotoCensista));
				lblFoto.setIcon(null);
			}
		});
		botonIngresarNombre.setBounds(62, 150, 116, 23);
		
		lblFoto = new JLabel("FOTO");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(289, 11, 224, 148);
		lblFoto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelNombres.add(lblFoto);
		
		JButton btnNewButton_1 = new JButton("Subir imagen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("jpg, png", "jpg", "png"); 
				fileChooser.setFileFilter(filtro);
			    
			    int opcion = fileChooser.showOpenDialog(fileChooser); 
				
			    if(opcion == JFileChooser.APPROVE_OPTION) { 
					File archivoElegido = fileChooser.getSelectedFile();
					fotoCensista = archivoElegido.toString();
					ImageIcon foto = new ImageIcon(fotoCensista);
					Icon icon = new ImageIcon(foto.getImage().getScaledInstance(lblFoto.getWidth(),lblFoto.getHeight(), Image.SCALE_DEFAULT));
					lblFoto.setIcon(icon);
					botonIngresarNombre.setEnabled(true);
			    }
			}
		});
		btnNewButton_1.setBounds(334, 170, 116, 23);
		panelNombres.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Listo");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(censistas.size()!=0 && grafo.tamano()!=0) {
					instancia = new Instancia(grafo, censistas);
					Resultado resultado = new Resultado(instancia,"manual");
					resultado.setVisible(true);
					dispose();
				}
				
				if(censistas.size()==0) {
					JOptionPane.showMessageDialog(null, "Debe agregar al menos un censista para continuar","Error", JOptionPane.ERROR_MESSAGE);
				}
				else if(grafo.tamano()==0) {
					JOptionPane.showMessageDialog(null, "Debe agregar al menos una manzana para continuar","Censo 2022", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(208, 367, 148, 23);
		contentPane.add(btnNewButton_2);
	}
}

package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import json.CensistasJSON;
import json.GrafoJSON;
import logica.Instancia;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.TextArea;

public class Archivo extends JFrame {
	private static final long serialVersionUID = 1L;
	private CensistasJSON censistas;
	private GrafoJSON radioCensal;
	private JPanel panelNombres;
	private JPanel panel;
	private JPanel panelNombresIngresados;
	private JButton btnNewButton, btnSubirArchivo1, btnSubirArchivo2;
	private JLabel lblNewLabel, lblRutaArchivo_1, lblNewLabel_1, lblRutaArchivo;
	private Instancia instancia;
	private TextArea textArea_1, textAreaCensistas;
	
	/**
	 * Create the frame.
	 */
	public Archivo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Archivo.class.getResource("/interfaz/logo.png")));
		setTitle("Censo ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 433);
		getContentPane().setLayout(null);
	
		getContentPane().setLayout(null);
		
		panelNombres = new JPanel();
		panelNombres.setLayout(null);
		panelNombres.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Censistas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNombres.setBounds(10, 11, 558, 191);
		getContentPane().add(panelNombres);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Radio Censal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 205, 558, 158);
		getContentPane().add(panel);
		
		lblRutaArchivo_1 = new JLabel("");
		lblRutaArchivo_1.setOpaque(true);
		lblRutaArchivo_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRutaArchivo_1.setBackground(Color.WHITE);
		lblRutaArchivo_1.setBounds(122, 23, 281, 19);
		panel.add(lblRutaArchivo_1);
		
		
		lblRutaArchivo = new JLabel("");
		lblRutaArchivo.setOpaque(true);
		lblRutaArchivo.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblRutaArchivo.setBackground(Color.WHITE);
		lblRutaArchivo.setBounds(122, 23, 281, 19);
		panelNombres.add(lblRutaArchivo);
		
		// subir archivo radio censal
		btnSubirArchivo2 = new JButton("Subir archivo");
		
		btnSubirArchivo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.json", "JSON"); 
				fileChooser.setFileFilter(filtro);
			    
			    int opcion = fileChooser.showOpenDialog(fileChooser); 
				
			    if(opcion == JFileChooser.APPROVE_OPTION) { 
					File archivoElegido = fileChooser.getSelectedFile();
					lblRutaArchivo_1.setText(archivoElegido.getName());
					
					radioCensal = new GrafoJSON();
					radioCensal = GrafoJSON.leerJSON(archivoElegido.getName());
					textArea_1.setText(radioCensal.toString());
				 }	
			}
		});
		btnSubirArchivo2.setBounds(416, 19, 132, 23);
		panel.add(btnSubirArchivo2);
		
		lblNewLabel_1 = new JLabel("Archivo: ");
		lblNewLabel_1.setBounds(26, 28, 55, 14);
		panel.add(lblNewLabel_1);
		
		textArea_1 = new TextArea();
		textArea_1.setBounds(10, 48, 538, 100);
		panel.add(textArea_1);


		panelNombresIngresados = new JPanel();
		panelNombresIngresados.setLayout(null);
		panelNombresIngresados.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Censistas Ingresados ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNombresIngresados.setBounds(10, 53, 541, 127);
		panelNombres.add(panelNombresIngresados);
		
		textAreaCensistas = new TextArea();
		textAreaCensistas.setBounds(10, 21, 521, 96);
		panelNombresIngresados.add(textAreaCensistas);
		
		
		// subir archivo censistas
		btnSubirArchivo1 = new JButton("Subir archivo");
		btnSubirArchivo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.json", "JSON"); 
				fileChooser.setFileFilter(filtro);
			    
			    int opcion = fileChooser.showOpenDialog(fileChooser); 
				
			    if(opcion == JFileChooser.APPROVE_OPTION) { 
					File archivoElegido = fileChooser.getSelectedFile();
					lblRutaArchivo.setText(archivoElegido.getName());
					
					censistas = new CensistasJSON();
					censistas = CensistasJSON.leerJSON(archivoElegido.getName());
				 }	
			    textAreaCensistas.setText(censistas.toString());
			}
		});
		btnSubirArchivo1.setBounds(416, 19, 132, 23);
		panelNombres.add(btnSubirArchivo1);
		
		lblNewLabel = new JLabel("Archivo: ");
		lblNewLabel.setBounds(22, 28, 55, 14);
		panelNombres.add(lblNewLabel);
		
		btnNewButton = new JButton("Listo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instancia = new Instancia(radioCensal, censistas);
				Resultado resultado = new Resultado(instancia,"archivo");
				resultado.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(209, 366, 142, 23);
		getContentPane().add(btnNewButton);
	}
}

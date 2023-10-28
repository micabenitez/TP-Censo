package interfaz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class Menu {
	private JFrame frame;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Fondo fondo = new Fondo();
		fondo.setBackground(Color.ORANGE);
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/interfaz/logo.png")));
		frame.setTitle("Censo 2022");
		frame.setContentPane(fondo);
		frame.setBounds(100, 100, 612, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnNewButton = new JButton("Manual");
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(236, 245, 127, 48);
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manual m = new Manual();
				m.setVisible(true);
				frame.dispose();;
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnArchivoJson = new JButton("Archivo JSON");
		btnArchivoJson.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnArchivoJson.setBackground(Color.WHITE);
		btnArchivoJson.setFocusable(false);
		btnArchivoJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Archivo archivo = new Archivo();
				archivo.setVisible(true);
				frame.dispose();
			}
		});
		btnArchivoJson.setBounds(236, 318, 127, 48);
		frame.getContentPane().add(btnArchivoJson);
	}
}

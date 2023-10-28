package interfaz;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import logica.Censista;
import logica.Instancia;
import logica.Solucion;
import logica.Solver;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;

public class Resultado extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();
	private Instancia _instancia;
	private Solucion solucion;
	private Solver solver; 

	/**
	 * Create the frame.
	 */
	public Resultado(Instancia instancia, String formato) {
		setTitle("Censo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Resultado.class.getResource("/interfaz/logo.png")));
		_instancia = instancia;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 673, 356);
		getContentPane().add(scrollPane);
		
		solver = new Solver(_instancia); // solver
		solucion = solver.resolver();
		ArrayList<Censista> censistas = solucion.getCensistas();
		
		table = new JTable();
		table.setDefaultRenderer(Object.class, new ImgTabla());
	
		model.addColumn("Foto"); 
		model.addColumn("Nombre"); 
		model.addColumn("N° de las Manzanas Asignadas");
		table.setRowHeight(100); 
		table.setModel(model);
		
		if(formato.equals("manual")) {
			for (int i = 0; i < censistas.size(); i++) {
				Object[] fila = {
					new JLabel(new ImageIcon(censistas.get(i).getFoto())),
					censistas.get(i).getNombre(),
					censistas.get(i).getManzanas()	
				};
				model.addRow(fila);
			}	
		}
		else { 
			for (int i = 0; i < censistas.size(); i++) {
				Object[] fila = {
					new JLabel(new ImageIcon(getClass().getResource(censistas.get(i).getFoto()))),
					censistas.get(i).getNombre(),
					censistas.get(i).getManzanas()	
				};
				model.addRow(fila);
			}	
		}
		scrollPane.setViewportView(table);
	}
}

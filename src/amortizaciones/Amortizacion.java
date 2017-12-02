package amortizaciones;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;

public class Amortizacion extends JFrame implements ItemListener{

	private JPanel contentPane;
	private JTable table;
	
	JComboBox comboBox;

	int anios=1;
	double sumaAnios = (double)anios*(anios+1)/2;
	double valorInicial=0,valorFinal=0,cuotaFija=0;
	double valorAmortizable=valorInicial-valorFinal;

	Object[][] matriz = new Object[anios-1][4];
	private String itemSeleccionado="";
	// double cuotaDeAmortizacion_creciente = valorAmortizable*anios/sumaAnios;
	// double cuotaDeAmortizacion_decreciente=valorAmortizable
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Amortizacion frame = new Amortizacion();
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
	public Amortizacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{414, 0};
		gbl_contentPane.rowHeights = new int[]{20, 198, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		comboBox =crearComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		contentPane.add(comboBox, gbc_comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		comboBox.addItemListener(this);
	}
	private JComboBox crearComboBox() {
		JComboBox<String> c = new JComboBox<String>();
//		c.addItem("fija");
//		c.addItemListener(new Amortizacion_Fija(this));
//		c.addItemListener(new Amortizacion_Creciente(this));
		c.addItem("fija");
		c.addItem("creciente");
		c.addItem("decreciente");
		return c;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==comboBox){
//			legajo=Integer.parseInt(comboBox.getSelectedItem().toString())
			itemSeleccionado=comboBox.getSelectedItem().toString();
		}
	}
	private JTable crearTabla() {
		 if(itemSeleccionado=="creciente")crearDatos_creciente();
	     String[] columnNames = {"Anios","valor inicial","cuota de amor. ","amor. acumulada","valor residual"};
	    return new JTable(matriz, columnNames);
	}
	public void crearDatos_creciente(){
//		matriz[0][3]=0;
//		matriz[0][4]=valorInicial;
//		
//
//		for(int i=0;i<anios;i++){
//		int anioActual=i+1;
//		matriz[i][0]=anioActual;
//		matriz[i][1]=valorInicial;
//		matriz[i][2]=cuotaDeAmortizacion_decreciente(anioActual);
//		double cuota = cuotaDeAmortizacion_decreciente(anioActual);
//		matriz[i][3]+=cuota;//amortizacion acumulada
//		matriz[i][4]=valorInicial-matriz[i][3];// valor residual
//		}
	}
	public void crearDatos_decreciente() {
//		matriz[0][3]=(double)0;
//		matriz[0][4]=valorInicial;
//		
//
//			for(int i=0;i<anios;i++){
//			int anioActual=i+1;
//			matriz[i][0]=(double)anioActual;
//			matriz[i][1]=valorInicial;
//			matriz[i][2]=cuotaDeAmortizacion_creciente(anioActual);
//			matriz[i][3]+=matriz[i][2];//amortizacion acumulada
//			matriz[i][4]=valorInicial-matriz[i][3];// valor residual
//			}	
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	void capturarEventoEnTabla() {	
		table.setPreferredScrollableViewportSize(new Dimension(500, 75));
        if (true){
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    actualizarYMostrarTabla();
                }
            });
        }   
	}
	public void actualizarYMostrarTabla() {
		
	}
	public double cuotaDeAmortizacion_creciente(int anio){
		return valorAmortizable*anio/sumaAnios;
	}
	public double sumaAnios() {
		return anios*(anios+1)/2;		
	}
	public double cuotaDeAmortizacion_decreciente(int anio){
		return valorAmortizable*(anios+1-anio)/sumaAnios;
	}
	public double valorAmortizable() {
		return valorInicial-valorFinal;
	}
	
}

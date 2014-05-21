package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

public class ErrorRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList <String> mensajesErrores;
	private JLabel lblNewLabel;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private Registro registro;
	private String errorLogin;
	static Locale currentLocale;
    static ResourceBundle messages;
	
	/**
	 *  Constructor para errores de Registro.
	 */
	public ErrorRegistro(ArrayList <String> err, Registro reg, ResourceBundle messages) {
		this.mensajesErrores=err;
		this.registro = reg;
		setBackground(Color.GRAY);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 153, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel(messages.getString("ErrorenReg"));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Fira Sans OT", Font.BOLD, 14));
		}
		
		JLabel lblPorFavorRevise = new JLabel(messages.getString("ReviseErrores"));
		lblPorFavorRevise.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorFavorRevise.setForeground(new Color(255, 255, 255));
		lblPorFavorRevise.setFont(new Font("Fira Sans OT Light", Font.BOLD, 14));
		
		
		JTextPane textoErrores = new JTextPane();
		textoErrores.setForeground(new Color(255, 255, 255));
		textoErrores.setEditable(false);
		textoErrores.setBackground(new Color(255, 153, 0));
		textoErrores.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		for(int i=0; i<mensajesErrores.size();i++){
	    	System.out.println("Error: ("+mensajesErrores.size()+")"+mensajesErrores.get(i) );
			textoErrores.setText(textoErrores.getText()+mensajesErrores.get(i)+"\n");
			
			txtNombre = new JTextField();
			txtNombre.setText("Nombre");
			contentPanel.add(new JTextField(mensajesErrores.get(i)), "2, 8+i*2, fill, default");
			txtNombre.setColumns(10);
		}
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("388px:grow"),},
			new RowSpec[] {
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("17px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("87px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		contentPanel.add(lblNewLabel, "2, 2, center, top");
		contentPanel.add(lblPorFavorRevise, "2, 4, left, top");
		contentPanel.add(textoErrores, "2, 6, 1, 5, fill, fill");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.setFocusable(false);
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						activarRegistro();
					}
				});
				btnOK.setForeground(Color.WHITE);
				btnOK.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
				btnOK.setBackground(new Color(255, 153, 51));
				buttonPane.add(btnOK);
			}
		}
	}

	/**
	 * Constructor para el error en el Login. Recibe un String.
	 * @param err
	 * @wbp.parser.constructor
	 */
	public ErrorRegistro(String err,ResourceBundle messages){
		this.messages=messages;
		this.errorLogin=err;
		setBackground(Color.GRAY);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 153, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel(messages.getString("ErrorenReg"));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Fira Sans OT", Font.BOLD, 14));
		}
		
		JLabel lblPorFavorRevise = new JLabel(messages.getString("ReviseErrores"));
		lblPorFavorRevise.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorFavorRevise.setForeground(new Color(255, 255, 255));
		lblPorFavorRevise.setFont(new Font("Fira Sans OT Light", Font.BOLD, 14));
		
		JTextPane textoErrores = new JTextPane();
		textoErrores.setForeground(new Color(255, 255, 255));
		textoErrores.setEditable(false);
		textoErrores.setBackground(new Color(255, 153, 0));
		textoErrores.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
		textoErrores.setText(errorLogin);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("388px:grow"),},
			new RowSpec[] {
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("17px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("15px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("87px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		contentPanel.add(lblNewLabel, "2, 2, center, top");
		contentPanel.add(lblPorFavorRevise, "2, 4, left, top");
		contentPanel.add(textoErrores, "2, 6, 1, 5, fill, fill");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.setFocusable(false);
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						cierraVentana();
					}
				});
				btnOK.setForeground(Color.WHITE);
				btnOK.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
				btnOK.setBackground(new Color(255, 153, 51));
				buttonPane.add(btnOK);
			}
		}
		contentPanel.setVisible(true);
	}
	
	public ArrayList<String> getErrores() {
		return mensajesErrores;
	}

	public void setErrores(ArrayList<String> errores) {
		this.mensajesErrores = errores;
	}
	
	public void activarRegistro(){
		this.registro.activaRegistro();
		this.dispose();
	}
	
	public void cierraVentana(){
		this.dispose();
	}
}

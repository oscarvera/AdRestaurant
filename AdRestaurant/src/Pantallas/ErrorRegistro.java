package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

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

public class ErrorRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList <String> errores;
	private JLabel lblNewLabel;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	/**
	 * Create the dialog.
	 */
	public ErrorRegistro(ArrayList <String> err) {
		this.errores=err;
		setBackground(Color.GRAY);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 153, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNewLabel = new JLabel("Error en Registro");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Fira Sans OT", Font.PLAIN, 16));
		}
		
		JLabel lblPorFavorRevise = new JLabel("Por favor, revise los siguientes errores:");
		lblPorFavorRevise.setForeground(new Color(255, 255, 255));
		lblPorFavorRevise.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 14));
		
		JTextPane textoErrores = new JTextPane();
		for(int i=0; i<errores.size();i++){
	    	System.out.println("Error: ("+errores.size()+")"+errores.get(i) );
			textoErrores.setText(errores.get(i)+"\n");
			txtNombre = new JTextField();
			txtNombre.setText("Nombre");
			contentPanel.add(new JTextField(errores.get(i)), "2, 8+i*2, fill, default");
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
		contentPanel.add(textoErrores, "2, 6, fill, fill");
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOK = new JButton("OK");
				btnOK.setForeground(Color.WHITE);
				btnOK.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
				btnOK.setBackground(new Color(255, 153, 51));
				buttonPane.add(btnOK);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				buttonPane.add(btnCancel);
				btnCancel.setForeground(Color.WHITE);
				btnCancel.setFont(new Font("Fira Sans OT Light", Font.PLAIN, 12));
				btnCancel.setBackground(new Color(255, 153, 51));
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public ArrayList<String> getErrores() {
		return errores;
	}

	public void setErrores(ArrayList<String> errores) {
		this.errores = errores;
	}
}

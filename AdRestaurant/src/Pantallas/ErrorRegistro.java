package Pantallas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;

public class ErrorRegistro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList <String> errores;
	private JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ErrorRegistro dialog = new ErrorRegistro();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ErrorRegistro() {
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
			textoErrores.setText(errores.get(i));
			textoErrores.nextFocus();
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(146)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPorFavorRevise))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(textoErrores, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPorFavorRevise)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textoErrores, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		for(String st:errores){
			
		}
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

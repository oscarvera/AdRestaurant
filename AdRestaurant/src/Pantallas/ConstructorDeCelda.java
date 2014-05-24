package Pantallas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ConstructorDeCelda implements ListCellRenderer<Object>{
    
	public Component getListCellRendererComponent(
            JList<?> list,                    
            Object value,
            int index, 
            boolean isSelected, 
            boolean cellHasFocus) {

		Component component = (Component)value;
		if (isSelected){
			component.setBackground(Color.RED);
		}else {
			component.setBackground(Color.BLUE);
		}
		return component;
	}
}	 


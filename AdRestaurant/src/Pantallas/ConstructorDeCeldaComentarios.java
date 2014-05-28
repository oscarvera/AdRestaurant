package Pantallas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ConstructorDeCeldaComentarios implements ListCellRenderer<Object>{
    
	public Component getListCellRendererComponent(
            JList<?> list,                    
            Object value,
            int index, 
            boolean isSelected, 
            boolean cellHasFocus) {

		Component component = (Component)value;
		InfoComentario comp =(InfoComentario)component;
		if (isSelected){
//			component.setBackground(new Color(255, 153, 0));
//			comp.colorBlanco();
		}else {
			component.setBackground(new Color(255, 255, 255));
//			comp.colorNaranja();
		}
		return component;
	}
	
}	 

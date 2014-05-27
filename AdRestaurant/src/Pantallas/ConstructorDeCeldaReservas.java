package Pantallas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ConstructorDeCeldaReservas implements ListCellRenderer<Object>{
	
	public Component getListCellRendererComponent(
            JList<?> list,                    
            Object value,
            int index, 
            boolean isSelected, 
            boolean cellHasFocus) {

		Component component = (Component)value;
		InfoReserva comp =(InfoReserva)component;
		if (isSelected){
			component.setBackground(new Color(255, 153, 0));
			comp.fondoBlanco();
		}else {
			component.setBackground(new Color(255, 255, 255));
			comp.fondoNaranja();
		}
		return component;
	}
	
}

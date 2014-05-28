package Pantallas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;

public class ConstructorDeCelda implements ListCellRenderer<Object>{
    
	public Component getListCellRendererComponent(
            JList<?> list,                    
            Object value,
            int index, 
            boolean isSelected, 
            boolean cellHasFocus) {

		Component component = (Component)value;
		InfoRestaurante comp =(InfoRestaurante)component;
		if (isSelected){
			component.setBackground(new Color(255, 255, 255));
			//component.setBackground(new Color(255, 153, 0));
			//comp.fondoBlanco();
			comp.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 140, 0), new Color(255, 140, 0), new Color(255, 140, 0), new Color(255, 140, 0)));
			
		}else {
			component.setBackground(new Color(255, 255, 255));
			//comp.fondoNaranja();
			comp.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 200, 0), Color.ORANGE, Color.ORANGE));
		}
		return component;
	}
	
}	 


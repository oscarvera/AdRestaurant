package Pantallas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;

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
			component.setBackground(new Color(255, 255, 255));
			comp.letraOscura();
			comp.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 140, 0), new Color(255, 140, 0), new Color(255, 140, 0), new Color(255, 140, 0)));
		}else {
			component.setBackground(new Color(255, 255, 255));
			comp.letraNormal();
			comp.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 222, 173), new Color(255, 222, 173), new Color(255, 222, 173), new Color(255, 222, 173)));
		}
		return component;
	}
	
}

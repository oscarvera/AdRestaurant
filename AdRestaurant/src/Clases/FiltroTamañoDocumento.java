package Clases;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;

public class FiltroTama�oDocumento extends DocumentFilter {
    int caracteresMaximos;
    boolean DEBUG = false;
    
    /**
     * Establece el n�mero m�ximo de caracteres permitidos para el comentario.
     * @param maxChars
     */
    public FiltroTama�oDocumento(int maxChars) {
        caracteresMaximos = maxChars;
    }
    
    /**
     * Impide la inserci�n de m�s caracteres en el comentario si ya tiene el tama�o m�ximo permitido
     */
    public void insertString(FilterBypass fb, int offs,
                             String str, AttributeSet a)
        throws BadLocationException {
        if (DEBUG) {
            System.out.println("in DocumentSizeFilter's insertString method");
        }

        //This rejects the entire insertion if it would make
        //the contents too long. Another option would be
        //to truncate the inserted string so the contents
        //would be exactly maxCharacters in length.
        if ((fb.getDocument().getLength() + str.length()) <= caracteresMaximos)
            super.insertString(fb, offs, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
    }
    
    /**
     * Impide el reemplazo de un conjunto de caracteres por otro mayor en el comentario si ya tiene el tama�o m�ximo permitido
     */
    public void replace(FilterBypass fb, int offs,
                        int length, 
                        String str, AttributeSet a)
        throws BadLocationException {
        if (DEBUG) {
            System.out.println("in DocumentSizeFilter's replace method");
        }
        //This rejects the entire replacement if it would make
        //the contents too long. Another option would be
        //to truncate the replacement string so the contents
        //would be exactly maxCharacters in length.
        if ((fb.getDocument().getLength() + str.length()
             - length) <= caracteresMaximos)
            super.replace(fb, offs, length, str, a);
        else
            Toolkit.getDefaultToolkit().beep();
    }

}
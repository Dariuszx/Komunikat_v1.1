package gui.KDialogs;

import javax.swing.*;

public class ExitDialog {

    public ExitDialog( JFrame parent ) {

        Object[] options = { "Tak", "Nie" };

        int a = JOptionPane.showOptionDialog( parent, "Czy na pewno?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,  options, options[0] );

        if( a == 0 )  {
            parent.dispose();
        }
    }
}

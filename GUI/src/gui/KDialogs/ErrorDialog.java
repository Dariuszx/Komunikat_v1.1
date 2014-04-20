package gui.KDialogs;

import javax.swing.*;
import java.awt.*;

public class ErrorDialog {

    Component window;

    public ErrorDialog( Component parent, String message ) {

        this.window = parent;
        Object[] options = { "Ok" };

        int a = JOptionPane.showOptionDialog(
                parent, message, "Error", JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, options, options[0]);

            System.exit(1);



    }
}

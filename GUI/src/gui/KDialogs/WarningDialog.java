package gui.KDialogs;

import javax.swing.*;
import java.awt.*;

public class WarningDialog {

    Component window;

    public WarningDialog(Component parent, String message) {

        this.window = parent;
        Object[] options = { "Ok" };

        int a = JOptionPane.showOptionDialog(
                parent, message, "Warning", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);





    }
}

package engine.actions;


import javax.swing.*;
import java.awt.event.*;

public abstract class WindowClose extends WindowAdapter {

    public JFrame parent;

    public WindowClose( JFrame parent ) {
        this.parent = parent;
    }

    public abstract void windowClosing( WindowEvent ev );

}

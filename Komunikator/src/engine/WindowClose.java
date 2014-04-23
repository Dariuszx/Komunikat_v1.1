package engine;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class WindowClose extends WindowAdapter {

    public JFrame parent;
    private Data data;

    public WindowClose( JFrame parent, Data data ) {
        this.parent = parent;
        this.data = data;
    }


    public abstract void windowClosing( WindowEvent ev );

}

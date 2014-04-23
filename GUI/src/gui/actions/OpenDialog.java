package gui.actions;

import gui.KContainers.KWindow;
import gui.KDialogs.KDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class OpenDialog implements ActionListener {

    public KWindow parent;
    public KDialog dialog;
    public String title = "";

    public OpenDialog( KWindow parent, String title ) {
        this.parent = parent;
        this.title = title;
    }

    public void setProperties() {
        dialog = new KDialog( parent, title );
    }


    @Override
    public abstract void actionPerformed( ActionEvent e );

}

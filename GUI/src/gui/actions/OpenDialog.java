package gui.actions;

import gui.KDialogs.KDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class OpenDialog implements ActionListener {

    public JFrame parent;
    public KDialog dialog;
    public String title = "";

    public OpenDialog( JFrame parent, String title ) {
        this.parent = parent;
        this.title = title;
    }

    public void setProperties() {
        dialog = new KDialog( parent, title );
    }


    @Override
    public abstract void actionPerformed( ActionEvent e );

}

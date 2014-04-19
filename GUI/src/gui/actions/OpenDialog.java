package gui.actions;

import gui.KDialogs.KDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class OpenDialog implements ActionListener {

    public JFrame parent;
    public KDialog dialog;
    public String title;

    public OpenDialog( JFrame parent, String title ) {

        this.parent = parent;
        this.title = title;
    }

    public OpenDialog( JFrame parent ) {

        this.parent = parent;
    }

    public abstract void handleDialog();

    @Override
    public void actionPerformed(ActionEvent e) {
        handleDialog();
        dialog.setVisible( true );
    }
}

package gui.forms;

import gui.KDialogs.ErrorDialog;
import gui.KDialogs.KDialog;
import gui.actions.OpenDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class InputText implements ActionListener {

    private KDialog dialog;
    private JFrame parent;
    private JPanel panel;
    private JButton submit;
    public HashMap<String, JTextField> input;
    Object data;

    private JTextField t1;

    public InputText( JFrame parent, KDialog dialog, Object d ) {

        data = d;
        input = new HashMap<String, JTextField>();
        submit = new JButton( "Submit" );
        panel = new JPanel();
        submit.addActionListener( this );

        this.parent = parent;
        this.dialog = dialog;
    }

    public void addInputArea( String title, String key, int lenght ) {

        try {
            if( input.containsKey( key ) ) throw new Exception();
            else {
                JLabel label = new JLabel( title );
                JTextField inputArea = new JTextField( lenght );
                label.setLabelFor( inputArea );

                input.put( key, inputArea );
                panel.add( label );
                panel.add( inputArea );
            }
        } catch( Exception e ) {
            new ErrorDialog( parent, e.toString() );
        }
    }

    public void setVisible( boolean b ) {
        if( b == true ) {
            panel.add( submit );
            dialog.add( panel );
        }
    }
}

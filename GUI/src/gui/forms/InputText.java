package gui.forms;

import gui.KDialogs.ErrorDialog;
import gui.KDialogs.KDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class InputText implements ActionListener {

    public JPanel panel;
    private JButton submit;

    protected KDialog dialog;

    public HashMap<String, JTextField> input;

    public InputText( KDialog dialog ) {

        this.dialog = dialog;
        this.input = new HashMap<String, JTextField>();
        this.submit = new JButton( "Submit" );

        this.panel = new JPanel( );

        GroupLayout layout = new GroupLayout( panel );
        layout.setAutoCreateGaps( true );
        layout.setAutoCreateContainerGaps( true );

        submit.addActionListener( this );
    }

    public JTextField getInputArea( String key ) {

        try {
            if( !input.containsKey( key ) ) throw new Exception();
            else {
                return input.get( key );
            }
        } catch( Exception e ) {
                new ErrorDialog( dialog, e.toString() );
        }
        return null;
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
            new ErrorDialog( dialog, e.toString() );
        }
    }

    public void setVisible( boolean b ) {
        if( b == true ) {
            panel.add( submit );
            dialog.add( panel );
        }
    }
}

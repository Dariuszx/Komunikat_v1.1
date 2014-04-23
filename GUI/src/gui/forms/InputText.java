package gui.forms;

import gui.KContainers.KPanel;
import gui.KDialogs.ErrorDialog;
import gui.KDialogs.KDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;

public abstract class InputText implements ActionListener {

    public KPanel panel;
    private JButton submit;

    private int inputWidth;
    private int inputHeight;
    private int padding;
    private int labelWidth;

    protected KDialog dialog;

    public HashMap<String, JTextField> input;

    public InputText( KDialog dialog ) {

        this.dialog = dialog;
        this.input = new HashMap<String, JTextField>();
        this.submit = new JButton( "Submit" );

        this.panel = new KPanel();

        inputWidth = 100;
        inputHeight = 17;
        padding = 5;
        labelWidth = 80;

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

                input.put( key, inputArea );

                panel.addObject( label, padding * 2, padding * 2 + ( input.size() - 1 ) * ( padding + inputHeight ), new Dimension( labelWidth, inputHeight) );
                panel.addObject( inputArea, padding * 2 + labelWidth + padding, padding * 2 + ( input.size() - 1 ) * ( padding + inputHeight ), new Dimension( inputWidth, inputHeight) );
            }
        } catch( Exception e ) {
            new ErrorDialog( dialog, e.toString() );
        }
    }

    public void setVisible( boolean b ) {
        if( b == true ) {
            panel.addObject( submit,
                    (   padding * 2 + labelWidth + padding + inputWidth + padding ) / 2, // x
                        padding * 2 + input.size() * ( padding + inputHeight ) + padding, // y
                        submit.getPreferredSize()
                    );

            dialog.add( panel );
        }
    }

    public Dimension getSize() {

        return new Dimension(
                padding * 6 + labelWidth + padding + inputWidth, //x
                padding * 2 + input.size() * ( padding + inputHeight ) + padding + submit.getPreferredSize().height //y
        );
    }

    public int getX() {
        return padding * 6 + labelWidth + padding + inputWidth;
    }

    public int getY() {
        return padding * 6 + input.size() * ( padding + inputHeight ) + padding + submit.getPreferredSize().height;
    }
}

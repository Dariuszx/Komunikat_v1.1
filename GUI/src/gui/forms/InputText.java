package gui.forms;

import gui.KContainers.KPanel;
import gui.KDialogs.ErrorDialog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class InputText extends KPanel {

    private int inputWidth;
    private int inputHeight;
    private int padding;
    private int labelWidth;

    public HashMap<String, JTextField> input;
    public ArrayList<JButton> buttons;

    private int yAvailable;

    public InputText( Dimension input, int padding, int labelWidth ) {

        this.input = new HashMap<String, JTextField>();
        this.buttons = new ArrayList<JButton>();

        this.inputWidth = input.width;
        this.inputHeight = input.height;
        this.padding = padding;
        this.labelWidth = labelWidth;

        yAvailable = padding * 2;
    }

    public void addButton( JButton button ) {

        int i, x=0;

        buttons.add( button );

        for( i=0; i < buttons.size(); i++ ) {
            x += buttons.get( i ).getPreferredSize().width + padding;
        }

        addObject(button, labelWidth + padding + inputWidth - x, yAvailable, button.getPreferredSize());
        if( buttons.size() == 0 ) yAvailable += 2 * padding + button.getPreferredSize().height;
    }

    public JTextField getInputArea( String key ) {

        try {
            if( !input.containsKey( key ) ) throw new Exception();
            else {
                return input.get( key );
            }
        } catch( Exception e ) {
                new ErrorDialog( null, e.toString() );
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

                addObject( label, padding * 2, yAvailable, new Dimension( labelWidth, inputHeight ) );
                addObject( inputArea, padding * 2 + labelWidth + padding, yAvailable, new Dimension( inputWidth, inputHeight ) );

                yAvailable += padding + inputHeight;
            }

        } catch( Exception e ) {
            new ErrorDialog( null, e.toString() );
        }
    }

    public Dimension getSize() {

        return new Dimension(
                padding * 6 + labelWidth + padding + inputWidth, //x
                yAvailable + 100 //y
        );
    }

}

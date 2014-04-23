package gui.KDialogs;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class StatusPanel extends JPanel {

    public JLabel statusLabel;

    public StatusPanel( Window window ) {

        this.setBorder( new BevelBorder( BevelBorder.LOWERED ) );
        window.add( this, BorderLayout.SOUTH);
        this.setPreferredSize( new Dimension( window.getWidth(), 16 ) );
        this.setLayout( new BoxLayout( this, BoxLayout.X_AXIS ) );
        addLabel();

    }

    public void addLabel( ) {
        statusLabel = new JLabel( );
        statusLabel.setHorizontalAlignment( SwingConstants.LEFT );
        add( statusLabel );
    }

    public void setText( String text ) {
        statusLabel.setText( text );
    }
}

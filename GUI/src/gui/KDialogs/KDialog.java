package gui.KDialogs;


import javax.swing.*;
import java.awt.*;

public class KDialog extends JDialog {

    public StatusPanel statusPanel;

    public KDialog( JFrame parent, Dimension dim, String title ) {

        dim.height += 20;
        setSize( dim );
        setTitle( title );
    }

    public KDialog( JFrame parent, String title ) {

        setTitle( title );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        //setLayout( new BoxLayout( this, BoxLayout.X_AXIS ) );

    }
}

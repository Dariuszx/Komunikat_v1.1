package gui.KDialogs;


import javax.swing.*;
import java.awt.*;

public class KDialog extends JDialog {

    public KDialog( JFrame parent, Dimension dim, String title ) {

        dim.height += 20;
        setSize( dim );
        setLocationRelativeTo( parent );
        setTitle( title );
    }

    public KDialog( JFrame parent, String title ) {

        setLocationRelativeTo( parent );
        setTitle( title );

    }
}

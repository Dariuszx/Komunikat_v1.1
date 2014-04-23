package gui.KContainers;

import javax.swing.*;
import java.awt.*;

public class KPanel extends JPanel {

    public KPanel() {
        setLayout( null );
    }

    public void addObject( Component object, int x, int y, Dimension size ) {

        object.setBounds( x, y, size.width, size.height );
        add( object );
    }

}

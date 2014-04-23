package gui.KContainers;

import gui.KDialogs.StatusPanel;

import javax.swing.*;
import java.awt.*;

public class KWindow extends JFrame {

    private int width;
    private int height;
    public StatusPanel statusPanel;

    private String title;

    public KWindow( String title ) {

        this.title = title;
        makeWindow();
    }

    private void makeWindow( ) {

        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();

        this.width = res.width / 2;
        this.height = res.height / 2;
        statusPanel = new StatusPanel( this );

        setSize( width, height );
        setTitle( title );
        setLocation( width / 2, height / 2 );
        setDefaultCloseOperation( DO_NOTHING_ON_CLOSE );

/*
        addWindowListener( new WindowClose( this ) {
            @Override
            public void windowClosing( WindowEvent ev ) {
                new ExitDialog( this.parent );
            }
        });
        */
    }
}
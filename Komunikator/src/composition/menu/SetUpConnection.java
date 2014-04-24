package composition.menu;

import engine.Data;
import engine.Klient;
import events.ConnectionSubmit;
import gui.KContainers.KContainer;
import gui.KContainers.KWindow;
import gui.KDialogs.KDialog;
import gui.KDialogs.StatusPanel;
import gui.KDialogs.WarningDialog;
import gui.actions.OpenDialog;
import gui.forms.InputText;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SetUpConnection extends OpenDialog {

    private Data data;


    public SetUpConnection( KWindow window, String title, Data data) {

        super( window, title ); //OpenDialog
        this.data = data;
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

        setProperties();
        dialog.setModal( true );
        dialog.statusPanel = new StatusPanel( dialog );
        dialog.setResizable( false );

        KContainer container = new KContainer();

            ConnectionForm form = new ConnectionForm( dialog, data );

        container.add( form );

        dialog.add( container );
        dialog.setSize( form.getSize() );

        if( data.serwer.isConnected() ) {
            form.getInputArea( "ip" ).setText( data.serwer.host );
            form.getInputArea( "port" ).setText( Integer.toString( data.serwer.port ) );
            dialog.statusPanel.setText( "Connected to " + data.serwer.gniazdo.getRemoteSocketAddress() );
        } else {
            dialog.statusPanel.setText( "Not connected." );
        }

        dialog.setLocationRelativeTo( parent );
        dialog.setVisible( true );
    }
}



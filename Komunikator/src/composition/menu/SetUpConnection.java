package composition.menu;

import engine.Data;
import engine.Klient;
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
        setProperties(); //Ustawiam parametry okna dialogowego
        dialog.setModal( true );
        dialog.statusPanel = new StatusPanel( dialog );

        ConnectionForm form = new ConnectionForm( parent,  dialog, data );

        form.addInputArea( "IP", "ip", 10 );
        form.addInputArea( "Port", "port", 10 );
        form.addInputArea( "Nickname", "nickname", 10 );
        form.addInputArea( "ID", "id", 10 );

        dialog.setSize( form.getX(), form.getY() + 35 );

        form.setVisible( true );

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

class ConnectionForm extends InputText {

    private Data data;
    private KWindow window;

    public ConnectionForm( KWindow window, KDialog dialog, Data d ) {

        super( dialog );
        this.data = d;
        this.window = window;
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

        try {
            data.connectToServer( dialog, input.get("ip").getText(), Integer.parseInt(input.get("port").getText()) );

        } catch ( NumberFormatException d ) {
            new WarningDialog( dialog, "Number Format Exception" );
        } catch ( Exception ex ) {
            new WarningDialog( dialog, ex.toString() );
        }
    }
}

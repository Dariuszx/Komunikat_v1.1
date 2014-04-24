package events;

import composition.menu.ConnectionForm;
import gui.KDialogs.WarningDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionSubmit implements ActionListener {

    ConnectionForm form;

    public ConnectionSubmit(  ConnectionForm form ) {

        this.form = form;
    }

    @Override
    public void actionPerformed( ActionEvent e ) {

        try {
            form.data.connectToServer( form.dialog, form.input.get("ip").getText(), Integer.parseInt( form.input.get("port").getText() ) );

        } catch ( NumberFormatException d ) {
            new WarningDialog( form.dialog, "Number Format Exception" );
        } catch ( Exception ex ) {
            new WarningDialog( form.dialog, ex.toString() );
        }
    }
}

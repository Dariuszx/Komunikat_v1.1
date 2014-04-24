package composition.menu;

import engine.Data;
import events.ConnectionSubmit;
import gui.KDialogs.KDialog;
import gui.forms.InputText;

import javax.swing.*;
import java.awt.*;

public class ConnectionForm extends InputText {

    public Data data;
    public KDialog dialog;

    public ConnectionForm( KDialog dialog, Data d ) {

        super( new Dimension( 150, 18 ), 5, 100 );
        this.dialog = dialog;
        this.data = d;

        addInputArea("IP", "ip", 10);
        addInputArea("Port", "port", 10);
        addInputArea("Nickname", "nickname", 10);
        addInputArea("ID", "id", 10);

        JButton submit = new JButton( "Submit" );
        submit.addActionListener( new ConnectionSubmit( this ) );

        addButton( submit );
        addButton(new JButton("Reset"));

    }
}

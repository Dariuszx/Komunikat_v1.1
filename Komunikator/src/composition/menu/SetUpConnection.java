package composition.menu;

import engine.Data;
import engine.Klient;
import gui.KDialogs.ErrorDialog;
import gui.KDialogs.WarningDialog;
import gui.actions.OpenDialog;
import gui.forms.InputText;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SetUpConnection extends OpenDialog {

    private Data data;

    public SetUpConnection( JFrame window, String title, Data data) {

        super( window, title ); //OpenDialog
        this.data = data;

    }

    @Override
    public void actionPerformed( ActionEvent e ) {
        setProperties(); //Ustawiam parametry okna dialogowego
        dialog.setModal( true );

       InputText form = new InputText( parent, dialog, data ) {

           @Override
            public void actionPerformed( ActionEvent e ) {

               try {
                   data.ip = input.get("ip").getText();
                   data.port = Integer.parseInt(input.get("port").getText());

                   new Klient( data.ip, data.port );

                   System.out.println("IP= " + data.ip + " Port= " + data.port);
               } catch ( NumberFormatException d ) {
                   new ErrorDialog( parent, "Number Format Exception" );
               } catch ( IOException io ) {
                   new WarningDialog( dialog, io.toString() );
               } catch ( Exception ex ) {
                   new WarningDialog( dialog, ex.toString() );
               }
           }
       };


        form.addInputArea( "IP", "ip", 10 );
        form.addInputArea( "Port", "port", 10 );
        form.setVisible( true );


        dialog.setSize( 300, 500 );

        dialog.setLocationRelativeTo( parent );
        dialog.setVisible( true );
    }

}

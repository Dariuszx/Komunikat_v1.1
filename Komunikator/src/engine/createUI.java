package engine;

import gui.KContainers.menu.Menu;
import gui.KContainers.KWindow;
import gui.KDialogs.ErrorDialog;
import gui.KExceptions.MenuException;
import composition.menu.SetUpConnection;
import gui.KDialogs.ExitDialog;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;

public class createUI implements Runnable {

    private KWindow window;
    private HashMap<String,Menu> menu;
    private Menu mainMenu;
    private Data data;


    public createUI( Data data ) {
        this.data = data;
    }

    @Override
    public void run() {
        menu = new HashMap<String, Menu>();
        window = new KWindow( "Komunikator" );

        /*
        WindowClose a = new WindowClose( window ) {
            @Override
            public void windowClosing( WindowEvent ev, Data data ) {

                //data.disconnectFromServer( this.parent );
                new ExitDialog( this.parent );
            }
        };
*/
        window.addWindowListener( new WindowClose( window, data ) {
            @Override
            public void windowClosing( WindowEvent ev ) {

                try {
                    data.serwer.sendString("exit");
                    new ExitDialog( this.parent );

                } catch ( IOException e ) {
                    new ErrorDialog( window, e.toString() );
                }


            }
        } );

        addMainMenu();

        window.setVisible( true );
    }

    public void addMainMenu() {

        mainMenu = new Menu();

        try {
            mainMenu.addKmenu("file", "File");
                mainMenu.addKMenuItem( "file", "open", "Open" );
                mainMenu.addKMenuItem( "file", "settings", "Settings" );
                mainMenu.addKMenuItem( "file", "exit", "Exit" );
            mainMenu.addKmenu("tools", "Tools");
                mainMenu.addKMenuItem( "tools", "connect", "Connect to server" );
                mainMenu.addKMenuItem( "tools", "showonline", "Show online users" );
            mainMenu.addKmenu("help", "Help");




            mainMenu.addToWindow( window );

            mainMenu.findKMenuItem( "connect" ).addActionListener( new SetUpConnection( window, "Set up connection", data) );

        }catch ( MenuException e ) {
            new ErrorDialog( window, e.toString() );
        }
    }

}

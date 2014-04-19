package engine;

import gui.KContainers.menu.Menu;
import gui.KContainers.KWindow;
import gui.KDialogs.ErrorDialog;
import gui.KExceptions.MenuException;

import java.util.HashMap;

public class createUI implements Runnable {

    KWindow window;
    HashMap<String,Menu> menu;
    Menu mainMenu;

    @Override
    public void run() {
        menu = new HashMap<String, Menu>();
        window = new KWindow( "Komunikator" );
        addMainMenu();

        window.setVisible( true );
    }

    public void addMainMenu() {

        mainMenu = new Menu();

        try {
            mainMenu.addKmenu("file", "File");
                mainMenu.addKMenuItem( "file", "new", "New" );
                mainMenu.addKMenuItem( "file", "open", "Open" );
                mainMenu.addKMenuItem( "file", "settings", "Settings" );
                mainMenu.addKMenuItem( "file", "exit", "Exit" );
            mainMenu.addKmenu("view", "View");
            mainMenu.addKmenu("help", "Help");

            mainMenu.addToWindow( window );

        }catch ( MenuException e ) {
            new ErrorDialog( window, e.toString() );
        }
    }

}

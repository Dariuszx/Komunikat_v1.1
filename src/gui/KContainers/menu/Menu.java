package gui.KContainers.menu;

import gui.KContainers.KWindow;
import gui.KExceptions.MenuException;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Menu {

    private HashMap<String, JMenuItem> KMenuItem; //Elementy menu
    private KMenu KMenu; //Menu
    public JMenuBar KMenubar; //Pasek menu

    public Menu() {

        KMenu = new KMenu();
        KMenuItem = new HashMap<String, JMenuItem>();
        KMenubar = new JMenuBar();
    }

    public void addKmenu( String key, String title ) throws MenuException {

        if( KMenu.containsKey( key ) ) throw new MenuException( "Próba dodania istniejącego już menu." );
        else {
            JMenu menu = new JMenu( title );
            KMenu.put( key, menu );
        }
    }

    public void addKMenuItem( String KMenu_key, String KMenuItem_key, String title ) throws MenuException {

        if( KMenuItem.containsKey( KMenuItem_key ) ) throw new MenuException( "Próba dodania istniejącego elementu menu." );
        if( KMenu.containsKey( KMenu_key ) != true ) throw new MenuException( "Próba dodania elementu menu do niestniejącego menu" );

        JMenuItem MenuItem = new JMenuItem( title );

        KMenu.get( KMenu_key ).add( MenuItem );
        KMenuItem.put( KMenuItem_key, MenuItem );
    }

    public JMenuItem findKMenuItem( String KMenuItem_key ) throws MenuException {

        if( KMenuItem.containsKey( KMenuItem_key ) != true ) throw new MenuException( "Nie istnieje KMenuItem o podanym kluczu." );

        return KMenuItem.get( KMenuItem_key );
    }

    public void addToWindow( KWindow window ) {

        for( int i=0; i < KMenu.size(); i++ ) {
            KMenubar.add( KMenu.get( i ) );
        }

       window.setJMenuBar( KMenubar );
    }

}

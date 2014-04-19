package gui.KContainers.menu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class KMenu {

    ArrayList<JMenu> KMenu;
    HashMap<String, Integer> KMenu_keys;

    public KMenu() {

        KMenu = new ArrayList<JMenu>();
        KMenu_keys = new HashMap<String, Integer>();
    }

    public void put( String key, JMenu value ) {

        int index = KMenu.size();
        KMenu.add( value );
        KMenu_keys.put( key, index );
    }

    public boolean containsKey( String key ) {

        return KMenu_keys.containsKey( key );
    }

    public JMenu get( String key ) {

        return KMenu.get( KMenu_keys.get( key ) );

    }

    public JMenu get( Integer key ) {

        if( key >= KMenu.size() ) return null;
        return KMenu.get( key );
    }

    public int size() {
        return  KMenu.size();
    }

}

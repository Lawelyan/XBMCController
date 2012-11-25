/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lawelyan.xbmccontroller;

import de.lawelyan.xbmccontroller.gui.Tray;
import de.lawelyan.xbmccontroller.gui.WinMovies;
import de.lawelyan.xbmccontroller.gui.WinTest;

/**
 *
 * @author Rainer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Tray.init();
            WinTest.init();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quit() {
        Tray.close();
        WinTest.close();
        WinMovies.close();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lawelyan.xbmccontroller.gui;

import de.lawelyan.xbmccontroller.Main;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rainer
 */
public class Menu {

    private static MenuItem i;
    private static String hilfsvar;

    protected static void init() {

        i = new MenuItem("Filme");
        i.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WinMovies.load();

            }
        });
        Tray.addMenuItem(i);

        i = new MenuItem("Tester");
        i.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WinTest.load();

            }
        });
        Tray.addMenuItem(i);


        i = new MenuItem("Beenden");
        i.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.quit();

            }
        });
        Tray.addMenuItem(i);

    }
}

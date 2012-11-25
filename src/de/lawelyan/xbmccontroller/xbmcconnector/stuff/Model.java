/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lawelyan.xbmccontroller.xbmcconnector.stuff;

/**
 *
 * @author Rainer
 */
abstract public class Model {

    public String toString() {
        String ret = "";
        try {
            for (int i = 0; i < Model.class.getDeclaredFields().length; i++) {
                ret += Model.class.getDeclaredFields()[i].getName() + ":\t";
                ret += Model.class.getDeclaredField(Model.class.getDeclaredFields()[i].getName());
                ret += "\n";
            }
        } catch (Exception e) {
            ret = "dieser Fehler hätte nie auftreten dürfen, toString im Model Parent";
        }

        return ret;
    }
}

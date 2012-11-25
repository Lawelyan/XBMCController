/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lawelyan.xbmccontroller.xbmcconnector.stuff;

import java.util.HashMap;

/**
 *
 * @author Rainer
 */
public class ParamsInteger  extends HashMap<String, Integer> {

    public ParamsInteger(String key, Integer value) {
        put(key, value);
    }

}

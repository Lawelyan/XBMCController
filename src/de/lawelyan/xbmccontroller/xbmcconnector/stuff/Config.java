/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lawelyan.xbmccontroller.xbmcconnector.stuff;

import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Rainer
 */
class Config {

    public final static int HTTP = 1;
    public final static int JSONRPC = 2;
    public static int useType = HTTP;
    public static String adress = "192.168.1.99";
    public static int port = 8080;
    public static String uri = "/jsonrpc";
    private static JSONRPC2Session session = null;

    protected static JSONRPC2Session getSession() throws MalformedURLException {
        if (session == null) {
            session = new JSONRPC2Session(new URL("http://" + adress + ":" + port + uri));
        }
        return session;
    }

    private Config() {
    }
}

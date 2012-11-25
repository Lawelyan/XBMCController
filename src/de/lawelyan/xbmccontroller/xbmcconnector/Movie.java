/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lawelyan.xbmccontroller.xbmcconnector;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Error;
import de.lawelyan.xbmccontroller.xbmcconnector.models.LimitsModel;
import de.lawelyan.xbmccontroller.xbmcconnector.models.MovieModel;
import de.lawelyan.xbmccontroller.xbmcconnector.stuff.Controller;
import de.lawelyan.xbmccontroller.xbmcconnector.stuff.NoConnectionException;
import de.lawelyan.xbmccontroller.xbmcconnector.stuff.ParamsInteger;
import de.lawelyan.xbmccontroller.xbmcconnector.stuff.ParamsString;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rainer
 */
abstract public class Movie extends Controller {

    protected MovieModel movie;

    public Movie(String id) throws NoConnectionException {

        HashMap<String, Object> request = new HashMap<String, Object>();
        request.put("movieid", new Integer(id));
        request.put("properties", MovieModel.getAllFields());


        connect("VideoLibrary.GetMovieDetails", request);
        try {
            movie = new MovieModel(getMap("moviedetails"));
        } catch (JSONRPC2Error ex) {
            ex.printStackTrace();
        }


    }
}

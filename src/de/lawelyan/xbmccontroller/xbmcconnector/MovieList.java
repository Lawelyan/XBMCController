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
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Rainer
 */
abstract public class MovieList extends Controller {

    /**
     * Feld aus der Abfrage
     */
    protected LimitsModel limits;
    /**
     * Liste von Filmen
     */
    protected ArrayList<MovieModel> movies = new ArrayList<MovieModel>();
    /**
     * Cache der Liste
     */
    protected static MovieList movieList = null;

    /**
     * Diese Methode wird aufgerufen sobald der Request abgeschlossen ist
     */
    abstract public void callback();

    /**
     * Wenn die Liste noch nicht geladen wurde, wird sie aus dem Cache geholt
     *
     * @throws NoConnectionException
     */
    public MovieList() throws NoConnectionException {
        // Die Liste ist noch nicht im cache
        if (movieList != null) {
            // Wenn es die Liste schon gibt, werden nur die RPC Ergebnisse übernommen
            limits = movieList.limits;
            movies = movieList.movies;

        } else {
            // RPC Call
            connect("VideoLibrary.GetMovies");
            // Das Parsen des JSON Strings kann zu einem Fehler führen, tritt nur auf wenn XBMC Müll sendet ;)
            try {
                // LimitsModel ist nur ein Objekt und kann direkt geladen werden
                limits = new LimitsModel(getMap("limits"));
                // Die Filme kommen als Liste und müssen in einer Schleife Iteriert werden
                MovieModel m;
                for (int i = 0; i < getListLength("movies"); i++) {

                    movies.add(new MovieModel(getMap("movies", i)));
                }
                // Speichern des Objekts, beim nächsten Aufruf wird es dann nur geladen
                movieList = this;

            } catch (JSONRPC2Error e) {
                e.printStackTrace();
                throw new NoConnectionException("JSONRPC Problems");
            }
        }
    }

    /**
     * Löschen des Cache, bei dem nächsten Aufruf wird die Liste neu vom Server
     * geladen
     */
    public static void clearCache() {
        movieList = null;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lawelyan.xbmccontroller.xbmcconnector.models;

import de.lawelyan.xbmccontroller.xbmcconnector.stuff.Model;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Error;
import com.thetransactioncompany.jsonrpc2.util.NamedParamsRetriever;
import java.util.Map;

/**
 *
 * @author Rainer
 */
public class MovieModel extends Model {

    public String label;
    public Integer movieId;
    public String studio;
    public String genre;
    public Integer year;
    public Integer rating;
    public String director;
    public String trailer;
    public String tagline;
    public String plot;
    public String plotoutline;
    public String originaltitle;
    public String lastplayed;
    public Integer playcount;
    public String writer;
    public String mpaa;
    public String cast;
    public String country;
    public String imdbnumber;
    public String premiered;
    public String productioncode;
    public String runtime;
    public String set;
    public String showlink;
    public String streamdetails;
    public Integer top250;
    public String votes;
    public String fanart;
    public String thumbnail;
    public String file;
    public String sorttitle;
    public String resume;
    public Integer setid;

    public MovieModel(Map json) throws JSONRPC2Error {
        NamedParamsRetriever erg = new NamedParamsRetriever(json);

        try {
            label = erg.getString("label");
            movieId = erg.getInt("movieid");
        } catch (Exception e) {
        }
        try {
            studio = erg.getString("studio");
            year = erg.getInt("year");
            rating = erg.getInt("rating");
            director = erg.getString("director");
            trailer = erg.getString("trailer");
            tagline = erg.getString("tagline");
            plot = erg.getString("plot");
            plotoutline = erg.getString("plotoutline");
            originaltitle = erg.getString("originaltitle");
            lastplayed = erg.getString("lastplayed");
            playcount = erg.getInt("playcount");
            writer = erg.getString("writer");
            mpaa = erg.getString("mpaa");
//        cast = erg.getString("cast");
            country = erg.getString("country");
            imdbnumber = erg.getString("imdbnumber");
            premiered = erg.getString("premiered");
            productioncode = erg.getString("productioncode");
            runtime = erg.getString("runtime");
//        set = erg.getString("set");
            showlink = erg.getString("showlink");
//        streamdetails = erg.getString("streamdetails");
            top250 = erg.getInt("top250");
            votes = erg.getString("votes");
            fanart = erg.getString("fanart");
            thumbnail = erg.getString("thumbnail");
            file = erg.getString("file");
            sorttitle = erg.getString("sorttitle");
//        resume = erg.getString("resume");
//        setid = erg.getInt("setid");

        } catch (Exception e) {
        }

    }

    public static String[] getAllFields() {
        String[] fields = { "title", "genre", "year", "rating", "director", "trailer", "tagline", "plot", "plotoutline", "originaltitle", "lastplayed", "playcount", "writer", "studio", "mpaa", "cast", "country", "imdbnumber", "premiered", "productioncode", "runtime", "set", "showlink", "streamdetails", "top250", "votes", "fanart", "thumbnail", "file", "sorttitle", "resume", "setid"};
        return fields;
    }

    public String toString() {
        return movieId + ".\t" + label + "\t" + year + "\t" + rating + "\t" + director + "\t" + trailer + "\t" + tagline + "\t" + plot + "\t" + plotoutline + "\t" + originaltitle + "\t" + lastplayed + "\t" + playcount + "\t" + writer + "\t" + studio + "\t" + mpaa + "\t" + cast + "\t" + country + "\t" + imdbnumber + "\t" + premiered + "\t" + productioncode + "\t" + runtime + "\t" + set + "\t" + showlink + "\t" + streamdetails + "\t" + top250 + "\t" + votes + "\t" + fanart + "\t" + thumbnail + "\t" + file + "\t" + sorttitle + "\t" + resume + "\t" + setid
                + "\r\n";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lawelyan.xbmccontroller.xbmcconnector.models;

import de.lawelyan.xbmccontroller.xbmcconnector.stuff.Model;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Error;
import com.thetransactioncompany.jsonrpc2.util.NamedParamsRetriever;
import java.util.Map;

public class LimitsModel extends Model{

    public int total;
    public int start;
    public int end;

    public LimitsModel(Map json) throws JSONRPC2Error  {
        NamedParamsRetriever namedParams = new NamedParamsRetriever(json);
        total = namedParams.getInt("total");
        start = namedParams.getInt("start");
        end = namedParams.getInt("end");
    }

    public String toString() {
        return "Limit: " + total + "\nStart: " + start + "\nEnd: " + end + "\n";
    }
}

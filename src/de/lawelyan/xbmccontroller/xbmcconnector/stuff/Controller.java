/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lawelyan.xbmccontroller.xbmcconnector.stuff;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Error;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;
import com.thetransactioncompany.jsonrpc2.util.NamedParamsRetriever;
import de.lawelyan.xbmccontroller.xbmcconnector.models.MovieModel;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rainer
 */
abstract public class Controller implements Runnable {

    private static Integer id = 0;
    private String error = "";
    private NamedParamsRetriever namedParams = null;

    protected Map getMap(String key) throws JSONRPC2Error {
        return (Map) namedParams.get(key);
    }

    protected Map getMap(String key, int item) throws JSONRPC2Error {
        return (Map) namedParams.getList(key).get(item);
    }

//    protected Model[] getMapList(String key) throws JSONRPC2Error {
//
//        List ergList = namedParams.getList(key);
//        Model list[] = new Model[ergList.size()];
//        for (int i = 0; i < ergList.size(); i++) {
//            list[i] = new MovieModel((Map) ergList.get(i));
//        }
//        return list;
//    }
    protected int getListLength(String key) throws JSONRPC2Error {
        return namedParams.getList(key).size();
    }

    public String getErrorMessage() {
        return error;
    }

    protected void connect(String method) throws NoConnectionException {
        jsonrpc(new JSONRPC2Request(method, id++));
    }

    protected void connect(String method, List params) throws NoConnectionException {
        jsonrpc(new JSONRPC2Request(method, params, id++));
    }

    protected void connect(String method, Map params) throws NoConnectionException {
        jsonrpc(new JSONRPC2Request(method, params, id++));
    }

    protected void jsonrpc(JSONRPC2Request request) throws NoConnectionException {
        try {

            System.out.println("request: " + request.toJSONString());
            JSONRPC2Response response = Config.getSession().send(request);
            System.out.println("response: " + response.toJSONString());
            if (response.indicatesSuccess()) {
                namedParams = new NamedParamsRetriever((Map) response.getResult());
            } else {
                error = response.getError().getMessage();
            }

        } catch (MalformedURLException e) {
            throw new NoConnectionException("Config Error");
        } catch (JSONRPC2SessionException e2) {
            throw new NoConnectionException("Cant entablisch connection to XBMC");
        }
    }

    abstract public void callback();

    @Override
    public void run() {
        callback();
    }
}

package com.example.vyphe.webservices;

import com.example.vyphe.listeners.HttpResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedHashMap;

/**
 * Created by Shanthakumar on 24-02-2017.
 */

public class HttpVolleyService {

    private static HttpVolleyService sInstance;

    public static HttpVolleyService getInstance() {
        if (sInstance == null) {
            sInstance = new HttpVolleyService();
        }
        return sInstance;
    }

    public synchronized void sendRequest(String url, int methodType, final int serviceIdentifier,
                                         final String sessionId, String jsonRequest,
                                         final LinkedHashMap<String, String> queryParams,
                                         final HttpResponseListener listener) {

        try {

            JSONObject jsonReq = new JSONObject(jsonRequest);
            System.out.println("Sham checking Request URL :::" + url);
            System.out.println("Sham checking jsonRequest :::" + jsonRequest.toString());



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

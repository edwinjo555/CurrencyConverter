package com.easycurrency;



import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class EasyCurrency {



    private static double convertCurrency(String from, String to) {

        String API_ENDPOINT="https://free.currencyconverterapi.com/api/v5/convert?q=";
        String reqString = from + "_" + to.toUpperCase();

        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(API_ENDPOINT + reqString + "&compact=ultra");
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpResponse response = null;
        try {
            response = client.execute(httpGet);
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        HttpEntity entity = response.getEntity();
        String responseString = null;
        try {
            responseString = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        JSONObject jsonObject = new JSONObject(responseString);
        Double output = jsonObject.getDouble(reqString);
        return output;

    }
}
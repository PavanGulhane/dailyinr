package com.hourlyinr.json;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonReader {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public static void main(String[] args) throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("http://openexchangerates.org/api/latest.json?app_id=64640d4677ec4495a1cc7b9bed501593");
    System.out.println(json.toString());
    System.out.println(json.get("rates"));
    JSONTokener jsontknr = new JSONTokener(json.get("rates").toString());
    String str=null;
    System.out.println(json.keySet());
    
    JSONObject jObject = new JSONObject(json.get("rates").toString());
    Iterator<?> keys = jObject.keys();

    HashMap currencyMap = new HashMap();
    
    while( keys.hasNext() ){
        String key = (String)keys.next();
        if( jObject.get(key) instanceof JSONObject ){
        	System.out.println(key+":"+jObject.get(key).toString());
        	currencyMap.put(key, jObject.get(key).toString());
        }else{
        	System.out.println(key+":"+jObject.get(key));
        	currencyMap.put(key, jObject.get(key).toString());
        }
        
        
        
    }
    
    System.out.println("*********************************");
    System.out.println("*********************************");
    System.out.println("*********************************");
    //System.out.println(currencyMap.get("INR"));
    //System.out.println(currencyMap.keySet().toString());
    float inr = Float.parseFloat((String)currencyMap.get("INR"));
    float gbp = Float.parseFloat((String)currencyMap.get("GBP"));
    float chf = Float.parseFloat((String)currencyMap.get("CHF"));
    float cad = Float.parseFloat((String)currencyMap.get("CAD"));
    float aud = Float.parseFloat((String)currencyMap.get("AUD"));
    float thb = Float.parseFloat((String)currencyMap.get("THB"));
    float eur = Float.parseFloat((String)currencyMap.get("EUR"));
    float sgd = Float.parseFloat((String)currencyMap.get("SGD"));

    String tweetString ="";
    tweetString = "www.dailyinr.com\n" +
    		"#USDINR:"+ inr +
    		"\n#CADINR:"+ ( inr/cad ) + 
    		"\n#GBPINR:"+ ( inr/gbp ) + 
    		"\n#EURINR:"+ ( inr/eur ) + 
    		"\n#AUDINR:"+ ( inr/aud ) + 
    		"\n#CHFINR:"+ ( inr/chf ) + 
    		"\n#SGDINR:"+ ( inr/sgd )  
    		//"\n#THBINR:"+ ( inr/thb )     		
    		;
    
    System.out.println(tweetString);
    System.out.println("*********************************");
    System.out.println("*********************************");
    
    
/*
    while(jsontknr.more()){
    	System.out.println( ((JSONObject)jsontknr.nextValue()).get("CHF"));
    }
    //System.out.println("first value"+);
  */
    
  }

  
  
  public static String getTweetString() throws IOException, JSONException {
	    String tweetString ="";
 
	  JSONObject json = readJsonFromUrl("http://openexchangerates.org/api/latest.json?app_id=64640d4677ec4495a1cc7b9bed501593");
	    //System.out.println(json.toString());
	    //System.out.println(json.get("rates"));
	    JSONTokener jsontknr = new JSONTokener(json.get("rates").toString());
	    String str=null;
	    //System.out.println(json.keySet());
	    
	    JSONObject jObject = new JSONObject(json.get("rates").toString());
	    Iterator<?> keys = jObject.keys();

	    HashMap currencyMap = new HashMap();
	    
	    while( keys.hasNext() ){
	        String key = (String)keys.next();
	        if( jObject.get(key) instanceof JSONObject ){
	        	//System.out.println(key+":"+jObject.get(key).toString());
	        	currencyMap.put(key, jObject.get(key).toString());
	        }else{
	        	//System.out.println(key+":"+jObject.get(key));
	        	currencyMap.put(key, jObject.get(key).toString());
	        }
	        
	        
	        
	    }
	    
	    System.out.println("*********************************");
	    System.out.println("*********************************");
	    System.out.println("*********************************");
	    //System.out.println(currencyMap.get("INR"));
	    //System.out.println(currencyMap.keySet().toString());
	    float inr = Float.parseFloat((String)currencyMap.get("INR"));
	    float gbp = Float.parseFloat((String)currencyMap.get("GBP"));
	    float chf = Float.parseFloat((String)currencyMap.get("CHF"));
	    float cad = Float.parseFloat((String)currencyMap.get("CAD"));
	    float aud = Float.parseFloat((String)currencyMap.get("AUD"));
	    float thb = Float.parseFloat((String)currencyMap.get("THB"));
	    float eur = Float.parseFloat((String)currencyMap.get("EUR"));
	    float sgd = Float.parseFloat((String)currencyMap.get("SGD"));

	    tweetString = "www.dailyinr.com\n" +
	    		"#USDINR:"+ new String(Float.toString(inr)).substring(0, 7) +
	    		"\n#CADINR:"+ new String(Float.toString( inr/cad )).subSequence(0, 7) + 
	    		"\n#GBPINR:"+ new String(Float.toString( inr/gbp )).subSequence(0, 7) + 
	    		"\n#EURINR:"+ new String(Float.toString( inr/eur )).subSequence(0, 7) + 
	    		"\n#AUDINR:"+ new String(Float.toString( inr/aud )).subSequence(0, 7) + 
	    		"\n#CHFINR:"+ new String(Float.toString( inr/chf )).subSequence(0, 7) + 
	    		"\n#SGDINR:"+ new String(Float.toString( inr/sgd )).subSequence(0, 7)  
	    		//"\n#THBINR:"+ ( inr/thb )     		
	    		;
	    
	    System.out.println(tweetString);
	    System.out.println("*********************************");
	    System.out.println("*********************************");
	    
	    
	/*
	    while(jsontknr.more()){
	    	System.out.println( ((JSONObject)jsontknr.nextValue()).get("CHF"));
	    }
	    //System.out.println("first value"+);
	  */
	    return tweetString;
	  }

 
  
  
}

package com.demo.coherence;

import com.tangosol.net.CacheFactory;
import java.util.*;
import java.text.SimpleDateFormat;

public class FinalTest {

    public FinalTest() {
        super();
    }

    public static void main(String[] args){
        String cacheName = "datacache";
        String cacheToPutKey = "DateRandom";
        String identifier = "";
        String time = "";
        Date date = new Date();
        Random generator = new Random();
        Hashtable<String, Object> cacheToPut = new Hashtable<String, Object>();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

        Hashtable<String, Object> cacheToGet = (Hashtable<String, Object>) CacheFactory.getCache(cacheName).get(cacheToPutKey);
        if (cacheToGet != null)
        {
              System.out.println("Get object from existing cache");
              for(String key:cacheToGet.keySet()){
              System.out.println("\tKey : "+key+", value : "+cacheToGet.get(key));
              }
        } else {
              System.out.println("Cache need to be initiated!! ");
        }
    }
}

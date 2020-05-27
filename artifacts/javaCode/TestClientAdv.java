package com.demo.coherence;

import com.tangosol.net.CacheFactory;
import java.util.Hashtable;

public class TestClientAdv {

    public TestClientAdv() {
        super();
    }
    
    public static void main(String[] args){
        String cacheName = "datacache";
        String cacheToPutKey = "CONFIG_CACHE<@Z>ESB_CACHE<@Z>SIKP_KUR";
        
        Hashtable<String, Object> cacheToPut = new Hashtable<String, Object>();
        cacheToPut.put("key1", "value1");
        cacheToPut.put("key2", "value2");
        
        System.out.println("Put initiate object to cache : "+cacheToPutKey);
        CacheFactory.getCache(cacheName).put(cacheToPutKey, cacheToPut);
        System.out.println("Put initiate object succeed");
        
        System.out.println("Get object from cache");
        Hashtable<String, Object> cacheToGet = (Hashtable<String, Object>) CacheFactory.getCache(cacheName).get(cacheToPutKey);
        for(String key:cacheToGet.keySet()){
            System.out.println("\tKey : "+key+", value : "+cacheToGet.get(key));
        }
        
        cacheToGet.put("key3", "value3");
        System.out.println("Put update object to cache : "+cacheToPutKey);
        CacheFactory.getCache(cacheName).put(cacheToPutKey, cacheToGet);
        System.out.println("Put update object succeed");
        
        System.out.println("Get update object from cache");
        cacheToGet = (Hashtable<String, Object>) CacheFactory.getCache(cacheName).get(cacheToPutKey);
        for(String key:cacheToGet.keySet()){
            System.out.println("\tKey : "+key+", value : "+cacheToGet.get(key));
        }        
    }
}

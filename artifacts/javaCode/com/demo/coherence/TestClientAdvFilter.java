package com.demo.coherence;

import com.tangosol.net.CacheFactory;
import com.tangosol.util.Filter;
import com.tangosol.util.QueryHelper;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class TestClientAdvFilter {
    public TestClientAdvFilter() {
        super();
    }
    
    public static void main(String[] args){
        String cacheName = "datacache";
        String cacheToPutKey = "CONFIG_CACHE<@Z>ESB_CACHE<@Z>SIKP_KUR";
        String separator = "<@Z>";
		String cacheToPutKeyOr = "CONFIG_CACHE<@Z>ESB_CACHE";
        
        Hashtable<String, Object> cacheToPut = new Hashtable<String, Object>();
        cacheToPut.put("key4", "value4");
        cacheToPut.put("key5", "value5");
        
        System.out.println("Put initiate object to cache : "+cacheToPutKey);
        CacheFactory.getCache(cacheName).put(cacheToPutKey, cacheToPut);
        System.out.println("Put initiate object succeed");
        
        System.out.println("Get object from cache");
        try{
            Filter filter = QueryHelper.createFilter("key() = '" + cacheToPutKeyOr + "' OR key() LIKE '" + cacheToPutKeyOr + separator + "%'");
//			    Map<Object,Object> myMap = new HashMap<Object,Object>();
//			    myMap = CacheFactory.getCache(cacheName).entrySet(filter);
//			    for (Map.Entry e : myMap.entrySet())
//            System.out.println("\tKey = "+e.getKey() + " Value = "+e.getValue());
            Set<Map.Entry<Object,Object>>  entrys = CacheFactory.getCache(cacheName).entrySet(filter);
            for (Iterator iter = entrys.iterator(); iter.hasNext();) {
                Map.Entry e = (Map.Entry)iter.next();
                String keyFiltered = e.getKey().toString();
                Object valueFiltered = e.getValue();
                System.out.println("\tKey : " + keyFiltered + ", value : " + valueFiltered);
            }
        }
        catch(Exception ex){
            System.out.println("Found error : "+ex.getMessage());
            System.out.println(ex,ex);
        }
    }
}

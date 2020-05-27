package com.demo.coherence;

import com.tangosol.net.AbstractInvocable;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.CacheService;
import com.tangosol.net.InvocationService;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Service;

import java.util.Map;

public class TestClient {
    public TestClient() {
        super();
    }
    
    public static void main(String [] agrs) {
                
        NamedCache configcache  = CacheFactory.getCache("datacache");        
        
        System.out.println("Putting config cache value 1");
        
        configcache.put("MyCache", "Hello!");
                
        System.out.println("Getting config cache");
        System.out.print("Get from cache value=" + configcache.get("mycache"));
        
    }
}

package com.demo.coherence;

import com.tangosol.net.AbstractInvocable;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.CacheService;
import com.tangosol.net.InvocationService;
import com.tangosol.net.NamedCache;
import com.tangosol.util.Service;

import java.util.Map;

public class TestClientInteractive {
    public TestClientInteractive() {
        super();
    }
    
    public static void main(String [] args) {		
		
      String cachename = args[0];

      //get put operation
      String getputoperation = args[1];								

      NamedCache mycache  = CacheFactory.getCache(cachename);

      if (getputoperation.equals("put")) {
        String key = args[2];
        String value = args[3];
        mycache.put(key, value);
        System.out.println("Putting key=" + key + " ,Value="+ value);
      }

      if (getputoperation.equals("get")) {
        String key = args[2];						
        System.out.println("Getting key=" + key + " ,Value=" + mycache.get(key));
      }
    }
}

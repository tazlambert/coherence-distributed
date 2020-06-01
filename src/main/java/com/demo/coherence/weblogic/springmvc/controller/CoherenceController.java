package com.demo.coherence.weblogic.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tangosol.net.CacheFactory;
import java.util.*;
import java.text.SimpleDateFormat;

@Controller
public class CoherenceController {

    @RequestMapping("/cohwlsdemo")
    public String cohwlsdemo(Model model) {

        //Please change these two values
        //cacheName is the name of Coherence Cache
        String cacheName = "datacache";
        //cacheToPutKey is the name one of the key inside cacheName, this key will have value in Hashmap
        String cacheToPutKey = "DateRandom";

        StringBuffer message = new StringBuffer();
        String identifier;
        String time;
        Date date;
        Random generator = new Random();
        Hashtable<String, Object> cacheToPut = new Hashtable<String, Object>();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

        Hashtable<String, Object> cacheToGet = (Hashtable<String, Object>) CacheFactory.getCache(cacheName).get(cacheToPutKey);
        if (cacheToGet != null)
        {
            System.out.println("Get object from existing cache");
            message.append("Get object from existing cache");
            message.append("<br>");
            for(String key:cacheToGet.keySet()){
                System.out.println("\tKey : "+key+", value : "+cacheToGet.get(key));
                message.append("\tKey : "+key+", value : "+cacheToGet.get(key));
                message.append("<br>");
            }
            date = new Date(System.currentTimeMillis());
            identifier = Integer.toString(generator.nextInt(9999999));
            time = formatter.format(date);
            cacheToGet.put(identifier,time);
            System.out.println("Put update object to cache : "+cacheToPutKey);
            message.append("Put update object to cache : "+cacheToPutKey);
            message.append("<br>");
            CacheFactory.getCache(cacheName).put(cacheToPutKey, cacheToGet);
            System.out.println("Put update object succeed");
            message.append("Put update object succeed");
            message.append("<br>");
        } else {
            date = new Date(System.currentTimeMillis());
            identifier = Integer.toString(generator.nextInt(9999999));
            time = formatter.format(date);
            cacheToPut.put(identifier,time);
            System.out.println("Put initiate object to cache : "+cacheToPutKey);
            message.append("Put initiate object to cache : "+cacheToPutKey);
            message.append("<br>");
            CacheFactory.getCache(cacheName).put(cacheToPutKey, cacheToPut);
            System.out.println("Put initiate object succeed");
            message.append("Put initiate object succeed");
            message.append("<br>");
        }

        System.out.println("Get final object from cache");
        message.append("Get final object from cache");
        message.append("<br>");
        cacheToGet = (Hashtable<String, Object>) CacheFactory.getCache(cacheName).get(cacheToPutKey);
        for(String key:cacheToGet.keySet()){
            System.out.println("\tKey : "+key+", value : "+cacheToGet.get(key));
            message.append("\tKey : "+key+", value : "+cacheToGet.get(key));
            message.append("<br>");
        }

        model.addAttribute("content", message);

        return "cohdemo";

    }
}

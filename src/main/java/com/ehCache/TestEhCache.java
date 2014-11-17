package com.ehCache;

import com.newslive.actions.cache.EChache.EHCacheManger;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mami01 on 11/03/14.
 */
public class TestEhCache {
    public static void main(String[] args) {
        CacheManager manager = new CacheManager("E:\\work\\workspace\\SpringMVC\\src\\main\\resources\\ehcache.xml");
        Cache newsCache = manager.getCache("newsCache");
        newsCache.put(new Element("2","Hello"));
        newsCache.put(new Element("3", "Bye"));
       displayElementInCache(newsCache);

        getElementFromCache(newsCache, "3");

        displayElementInCache(newsCache);
        getElementFromCache(newsCache, "4");
        displayElementInCache(newsCache);
        getElementFromCache(newsCache, "3");
        getElementFromCache(newsCache, "4");
        getElementFromCache(newsCache, "3");
    }

    private static void displayElementInCache(Cache newsCache) {
        System.out.println("Elements in the Cache");
        List<String> list = newsCache.getKeys();
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            Element ele = newsCache.get(key);
            System.out.println(ele.getObjectKey() + " " + ele.getObjectValue());
        }
    }

    private static void getElementFromCache(Cache newsCache, String key) {
        Element element = newsCache.get(key);
        if (null != element) { // Cache Hit
            System.out.println("Cache Hit - " + element.getObjectValue());
        } else { // Cache Miss
            // Retreive from DB and add this to cache
            System.out.println("Cache Miss - Fetching from DB ...");
            newsCache.put(new Element(key,"default"));
        }
    }
}

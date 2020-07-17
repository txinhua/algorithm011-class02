package example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by tangguifu on 2020/7/17.
 */
public class LRUCache {
    LinkedList<Integer> keys = new LinkedList<Integer>();
    Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
    int maxSize;
    public LRUCache(int capacity) {
        maxSize = capacity;
    }

    public int get(int key) {
        if(keys.size() >= maxSize){
            keys.pollFirst();
        }
        keys.addLast(key);
        if (cache.containsKey(key)){
            return cache.get(key);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.size() >= maxSize) {
            int removeKey = keys.peekFirst();
            cache.remove(removeKey);
            keys.pollFirst();
        }
        cache.put(key,value);
        keys.addLast(key);
    }
}

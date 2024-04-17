package concurrentHashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapThread extends Thread{
    public static Integer id = 0;
    public static Map<Integer,String> map = new ConcurrentHashMap<>();
    @Override
    public void run() {
        for(int i = 1; i<11;i++){
            id++;
            map.put(id%3,getName());
        }
        System.out.println("This is the concurrent map: " +map.toString());
    }

    public void nameFromOutside(String name){
        this.setName(name);
    }

}
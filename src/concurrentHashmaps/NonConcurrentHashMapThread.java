package concurrentHashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NonConcurrentHashMapThread extends Thread{
    public static Integer id = 0;
    public static Map<Integer,String> map = new HashMap<>();
    @Override
    public void run() {
        for(int i = 1; i<11;i++){
            id++;
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(id%3, getName());
        }
        System.out.println("This is the normal hash map: " +map.toString());
    }

    public void nameFromOutside(String name){
        this.setName(name);
    }


}

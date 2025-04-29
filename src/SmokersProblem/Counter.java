package SmokersProblem;

import java.util.HashMap;
import java.util.Map;

public class Counter {

    private Map<String, Integer> countMap = new HashMap<>();
    private int alives;

    public Counter(int totalFumantes) {
        this.alives = totalFumantes;
    }

    public synchronized void increment(String name) {
        int count = countMap.getOrDefault(name, 0) + 1;
        countMap.put(name, count);
    }

    public synchronized int getCount(String name) {
        return countMap.getOrDefault(name, 0);
    }

    public synchronized void smokerDie(String name) {
        System.out.println(name + " fumou pela última vez");
        alives--;
    }
    
    public synchronized boolean isAlive(String name) {
    	return this.getCount(name) < 3;
    }

    public synchronized boolean haveSmokersAlive() {
        return alives > 0;
    }
}

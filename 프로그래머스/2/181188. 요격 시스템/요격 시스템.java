import java.util.*;

class Target implements Comparable<Target> {
    int s;
    int e;
    
    public Target (int s, int e) {
        this.s = s;
        this.e = e;
    }
    
    @Override
    public int compareTo(Target o) {
        return this.e - o.e;
    }
    
    @Override
    public String toString() {
        return "[" + s + ", " + e + "]";
    }
}

class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<Target> pq = new PriorityQueue<>();
        
        for (int[] target : targets) {
            pq.offer(new Target(target[0], target[1]));
        }
        
        int current = pq.poll().e;
        int count = 1;
        
        while(!pq.isEmpty()) {
            Target t = pq.poll();
            if (t.s < current) continue;
            current = t.e;
            count++;
        }
        
        
        return count;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority: priorities) {
            pq.add(priority);
        }
        
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    pq.poll();
                    count++;
                    if (i == location) {
                        return count;
                    }
                }
            }
        }
        return count;
    }
}
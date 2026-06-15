import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int scoville : scovilles) {
            pq.offer(scoville);    
        }
        
        int count = 0;

        while (pq.size() > 1 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();

            pq.offer(first + second * 2);
            count++;
        }

        return pq.peek() < K ? -1 : count;
    }
}
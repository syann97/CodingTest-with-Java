import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && stones[q.peekLast()] <= stones[i]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        
        int min = stones[q.peekFirst()];
        
        for (int right = k; right < stones.length; right++) {
            if (!q.isEmpty() && q.peekFirst() <= right - k) {
                q.pollFirst();
            }
            
            while (!q.isEmpty() && stones[q.peekLast()] <= stones[right]) {
                q.pollLast();
            }
            q.offerLast(right);
            
            min = Math.min(min, stones[q.peekFirst()]);
        }

        return min;
    }
}
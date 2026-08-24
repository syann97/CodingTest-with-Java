class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long max = 0;
        for (int time : times) {
            max = Math.max(max, time);
        }
        
        long s = 1;
        long e = max * n;
        
        
        while (s < e) {
            long m = (s + e) / 2;
            
            if (isPossible(m, times, n)) {
                e = m;
            }
            else {
                s = m + 1;
            }
        }
        
        return e;
    }
    
    static boolean isPossible(long guess, int[] times, int target) {
        long count = 0;
        
        for (int time : times) {
            count += guess / time;
        }
        
        return count >= target;
    }
}
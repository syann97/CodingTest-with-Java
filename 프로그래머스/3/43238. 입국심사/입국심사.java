import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int min = Integer.MAX_VALUE;
        
        for (int time : times) {
            min = Math.min(min, time);
        }
        
        long s = 1;
        long e = (long)min * n;
        long answer = 0;
        
        
        while (s <= e) {
            long m = s + (e - s) / 2;
            
            if (isValidTime(m, times, n)) {
                answer = m;
                e = m - 1;
            }
            else {
                s = m + 1;                
            }
        }
        
        return answer;
    }
    
    static boolean isValidTime(long time, int[] times, int n) {
        long count = 0;
        
        for (int t : times) {
            count += time / t;
        }
        
        return count >= n;
    }
}
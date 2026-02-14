class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int s = 1;
        int e = 0;
        
        for (int diff : diffs) {
            e = Math.max(e, diff);
        }
        
        int m;
        int level;
        
        while (s < e) {
            m = (s + e) / 2;
            
            if (calculate(m, diffs, times, limit) <= limit) {
                e = m;
            }
            else {
                s = m + 1;
            }
        }
        
        return e;
    }
    
    static long calculate (int level, int[] diffs, int[] times, long limit) {
        long total = times[0];
        int time_prev = times[0];
        
        for (int i = 1; i < diffs.length; i++) {
            int time_cur = times[i];
            total += (time_prev + time_cur) * (Math.max(diffs[i] - level, 0)) + time_cur;
            time_prev = time_cur;
        }
        
        
        return total;
    }
}
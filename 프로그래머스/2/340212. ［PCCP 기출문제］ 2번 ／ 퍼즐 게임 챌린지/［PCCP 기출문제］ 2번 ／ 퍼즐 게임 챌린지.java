class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int end = 0;
        
        for (int diff : diffs) {
            end = Math.max(end, diff);
        }
        
        return div(1, end, diffs, times, limit);
    }
    
    static int div(int s, int e, int[] diffs, int[] times, long limit) {
        if (s >= e) return e;
        
        int m = (s + e) / 2;
        
        if (isPossible(diffs, times, limit, m)) return div(s, m, diffs, times, limit);
        else return div(m+1, e, diffs, times, limit);
    }
    
    static boolean isPossible (int[] diffs, int[] times, long limit, int level) {
        long total = 0;
        int time_prev = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            int time_cur = times[i];
            int plus = (time_cur + time_prev) * (Math.max(diffs[i] - level, 0)) + time_cur;
            total += plus;
            time_prev = time_cur;
        }
               
        return total <= limit;
    }
}
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
        
        // System.out.println("level : " + level);
        
        for (int i = 0; i < diffs.length; i++) {
            int time_cur = times[i];
            int plus = (time_cur + time_prev) * (Math.max(diffs[i] - level, 0)) + time_cur;
            // System.out.println((i+1) + "번째 퍼즐");
            // System.out.println("cur : " + time_cur + "  plus : " + plus);
            // System.out.println();
            total += plus;
            time_prev = time_cur;
        }
               
        return total <= limit;
    }
    
}


// diff [1, 99999, 100000, 99995]	times [9999, 9001, 9999, 9001]
// 공식 (times[i] + time_prev) * (diff[i] - 숙련도(level)) + 9001;

// diff - level = 틀린 횟수
// time_cur + time_prev = 이전 퍼즐 다시 풀고오는 시간
// 즉 prev에 이미 푼 건 누적해야됨

// 숙련도의 최솟값 구하기
// 이분 탐색 
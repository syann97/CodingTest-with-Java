import java.util.*;

class Solution {
    static Set<Integer> others;
    static int[][] dp;
    static final int MAX = 100000000;
    public int[] solution(int target) {
        init(target);
        
        for (int i = 1; i <= target; i++) { 
            boolean flag = false;
            for (int j = 1; j <= 20; j++) {
                if (i-j < 0) {
                    flag = true;
                    break;
                }
                updateCount(i-j, i, true);
            }
            
            if (i >= 50) updateCount(i-50, i, true);
            
            if (!flag) {
                for (int other : others) {
                    if (i - other < 0) continue;
                    updateCount(i-other, i, false);
                }
            }
        }
        
        return new int[]{dp[target][0] + dp[target][1], dp[target][0]};
    }
    
    static void init(int target) {
        dp = new int[target+1][2];
        others = new HashSet<>();
        
        for (int i = 1; i <= target; i++) {
            Arrays.fill(dp[i], MAX);
        }
        
        // 아직은 모름
        dp[0][0] = 0;
        dp[1][0] = 0;
    
        for (int i = 11; i <= 20; i++) {
            others.add(i*2);
        }
        for (int i = 7; i <= 20; i++) {
            others.add(i*3);
        }
    }
    
    static void updateCount(int i, int j, boolean isSingle) {
        int[] current = dp[i];
        int[] next = dp[j];
        
        // 비교 후 갱신 (현재의 다음과 비교)
        int cs = current[0] + (isSingle ? 1 : 0);
        int co = current[1] + (!isSingle ? 1 : 0);
        
        int ns = next[0];
        int no = next[1];
        
        if ((cs + co) < (ns + no)) {
            dp[j][0] = cs;
            dp[j][1] = co;
        }
        else if ((cs + co) == (ns + no) && cs > ns) {
            dp[j][0] = cs;
            dp[j][1] = co;           
        }
        
        return;
    }
}
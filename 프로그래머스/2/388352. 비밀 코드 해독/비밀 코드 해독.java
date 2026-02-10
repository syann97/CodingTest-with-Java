import java.util.*;

class Solution {
    
    static int N;
    static int result = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        
        N = n;
        
        boolean[][] countingQ = new boolean[q.length][n+1];
        
        for (int i = 0; i < q.length; i++) {
            for (int j : q[i]) {
                countingQ[i][j] = true;
            }
        }
        
        bf(0, 0, new int[ans.length], ans, countingQ);
        
        return result;
    }
    
    
    static void bf (int cnt, int cur, int[] tmp, int[] ans, boolean[][] countingQ) {
        if (cnt == 5) {
            if (Arrays.equals(tmp, ans)) result++;
            return;
        }
        
        boolean flag;
        for (int i = cur + 1; i <= N - 4 + cnt; i++) {
            
            flag = false;
            
            for (int j = 0; j < countingQ.length; j++) {
                if (countingQ[j][i]) {
                    tmp[j]++;
                    if (tmp[j] > ans[j]) flag = true;
                }
            }
            
            if (!flag) bf(cnt + 1, i, tmp, ans, countingQ);
            
            for (int j = 0; j < countingQ.length; j++) {
                if (countingQ[j][i]) {
                    tmp[j]--;
                }
            }
        }
    }
}
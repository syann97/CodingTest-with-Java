import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        
        boolean[][] countingQ = new boolean[q.length][n+1];
        
        for (int i = 0; i < q.length; i++) {
            for (int j : q[i]) {
                countingQ[i][j] = true;
            }
        }
        
        return bf(0, 0, new int[ans.length], ans, countingQ, n);
    }
    
    
    static int bf (int cnt, int cur, int[] tmp, int[] ans, boolean[][] countingQ, int N) {
        if (cnt == 5) {
            return Arrays.equals(tmp, ans) ? 1 : 0;
        }
        
        int total = 0;
        boolean flag;
        for (int i = cur + 1; i <= N - 4 + cnt; i++) {
            
            flag = false;
            
            for (int j = 0; j < countingQ.length; j++) {
                if (countingQ[j][i]) {
                    tmp[j]++;
                    if (tmp[j] > ans[j]) flag = true;
                }
            }
            
            if (!flag) {
                for (int j = 0; j < countingQ.length; j++) {
                    int need = ans[j] - tmp[j]; 
                    
                    if (need > 4 - cnt) {
                        flag = true;
                        break;
                    }
                }
            }
            
            if (!flag) total += bf(cnt + 1, i, tmp, ans, countingQ, N);
            
            for (int j = 0; j < countingQ.length; j++) {
                if (countingQ[j][i]) {
                    tmp[j]--;
                }
            }
        }
        
        return total;
    }
}
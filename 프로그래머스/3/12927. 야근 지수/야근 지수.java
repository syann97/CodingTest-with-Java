import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        int[] countWork = new int[50001];
        int count = 0;
        int min = 50000;
        int max = 0;
        
        for (int work : works) {
            min = Math.min(min, work);
            max = Math.max(max, work);
            countWork[work]++;
            count += work;
        }
        
        if (count <= n) return 0;
        
        int index = max;
        
        while (n > 0 && index > 0) {
            int size = countWork[index];

            if (size > 0) {
                int minus = Math.min(size, n);
                countWork[index] -= minus;
                countWork[index - 1] += minus;
                n -= minus;
            }
            
            if (countWork[index] == 0) index--;
            else if (n == 0) break;
        }
        
        long answer = 0;
        for (int i = 1; i <= max; i++) {
            if (countWork[i] > 0) {
                answer += (long) i * i * countWork[i];
            }
        }
        
        return answer;
    }
}
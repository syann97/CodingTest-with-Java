import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        boolean[] isValid = new boolean[1000001];
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int idx = (i+j) % n;
                sum += elements[idx];
                isValid[sum] = true;
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= 1000000; i++) {
            if (isValid[i]) answer++;
        }
        
        return answer;
    }
}
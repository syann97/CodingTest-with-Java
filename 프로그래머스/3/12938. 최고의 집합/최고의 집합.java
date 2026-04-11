class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        
        // 모두 -1;
        int value;
        int rest;
        if (n >= s) {
            return new int[]{-1};
        }
        else {
            value = s / n;
            rest = s % n;
        }
        
        for (int i = 0; i < n - rest; i++) {
            answer[i] = value;
        }
        for (int i = n - rest; i < n; i++) {
            answer[i] = value + 1;
        }
        
        return answer;
    }
}
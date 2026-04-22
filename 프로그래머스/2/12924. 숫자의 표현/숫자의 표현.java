class Solution {
    public int solution(int n) {
        // 개수의 숫자를 더한 후 그것을 개수만큼 모듈로 가능한지 여부
        
        int count = 1;
        int sum = 1;
        for (int i = 2; i < n; i++) {
            sum += i;
            if (sum > n) break;
            if ((n - sum) % i == 0) count++; 
        }
        
        return count;
    }
}
class Solution {
    int[] nums;
    int N;
    int T;
    
    public int dfs(int idx, int sum) {   
        if (idx == N) {
            if (sum == T && idx == N) return 1;
            return 0;
        }
        
        return dfs(idx+1, sum) + dfs(idx+1, sum-(nums[idx]*2));
    }
    
    public int solution(int[] numbers, int target) {
        int total = 0;
        nums = numbers.clone();
        T = target;
        N = numbers.length;
        
        for (int i = 0; i < N; i++) {
            total += numbers[i];
        }

        return dfs(0, total);
    }
}
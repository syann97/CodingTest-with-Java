class Solution {
    int[] nums;
    int N;
    int T;
    int count = 0;
    
    public void bf(int idx, int sum) {   
        if (idx == N) {
            if (sum == T && idx == N) count++;
            return;
        }
        
        bf(idx+1, sum);
        bf(idx+1, sum-(nums[idx]*2));
    }
    
    public int solution(int[] numbers, int target) {
        int total = 0;
        nums = numbers.clone();
        T = target;
        N = numbers.length;
        
        for (int i = 0; i < N; i++) {
            total += numbers[i];
        }

        bf(0, total);
        return count;
    }
}
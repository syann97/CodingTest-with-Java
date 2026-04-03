class Solution {
    public long solution(int[] sequence) {
        long sumA = 0;
        long sumB = 0;
        long max = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            int pulse = i % 2 == 0 ? -1 : 1;
            int currentA = sequence[i] * pulse;
            int currentB = sequence[i] * (-pulse);
            
            sumA = Math.max(sumA + currentA, 0);
            sumB = Math.max(sumB + currentB, 0);
            
            if (sumA + currentA >= 0) max = Math.max(max, sumA);
            if (sumB + currentB >= 0) max = Math.max(max, sumB);
        }
        
        return max;
    }
}
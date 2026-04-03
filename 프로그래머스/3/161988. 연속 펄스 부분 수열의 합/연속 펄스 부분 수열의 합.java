class Solution {
    public long solution(int[] sequence) {
        long evenMinus = 0;
        long oddMinus = 0;
        long max = 0;
        
        for (int i = 0; i < sequence.length; i++) {
            int evenCurrent = sequence[i] * (i % 2 == 0 ? -1 : 1);
            int oddCurrent = sequence[i] * (i % 2 == 1 ? -1 : 1);
            
            if (evenMinus + evenCurrent < 0) {
                evenMinus = 0;
            }
            else {
                evenMinus += evenCurrent;
                max = Math.max(max, evenMinus);
            }
            
            if (oddMinus + oddCurrent < 0) {
                oddMinus = 0;
            }
            else {
                oddMinus += oddCurrent;
                max = Math.max(max, oddMinus);
            }
        }
        
        return max;
    }
}
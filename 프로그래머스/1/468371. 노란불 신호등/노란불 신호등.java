import java.util.*;


class Solution {
    public int solution(int[][] signals) {
        int end = getEndTime(signals);
        boolean[] isYellow = new boolean[end+1];
        Arrays.fill(isYellow, true);

        for (int[] signal : signals) {
            int unit = getUnit(signal);
            int time = 1;
            while(time <= end) {
                for (int i = time; i < time+signal[0]; i++) {
                    if (i <= end) isYellow[i] = false;
                }
                
                int rs = time + signal[0] + signal[1];
                for (int i = rs; i < rs + signal[2]; i++) {
                    if (i <= end) isYellow[i] = false;
                }
                
                time = rs + signal[2];                
            }
        }
        
        for (int i = 1; i <= end; i++) {
            if (isYellow[i]) return i;
        }
        
        return -1;
    }
    
    
    static int getEndTime(int[][] signals) {
        Set<Integer> unit = new HashSet<>();
        
        for (int[] signal : signals) {
            int time = 0;
            for (int t : signal) time += t;
            unit.add(time);
        }
        
        int end = 1;
        for (int t : unit) end *= t;
        
        return end;
    }
    
    static int getUnit(int[] signal) {
        int time = 0;
        for (int t : signal) time += t;
        return time;
    }
}
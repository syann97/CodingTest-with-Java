import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int N = lines.length;
        
        // 1초 -> 1000, 1분 -> 60000, 1시간 -> 3600000, 1일 -> 86400000;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int[] start = new int[N];
        int[] end = new int[N];
        
        
        for (int i = 0; i < N; i++) {
            int[] time = getMs(lines[i].split(" "));
            start[i] = time[0];
            end[i] = time[1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        

        int max = 0;
        for (int i = 0; i < N; i++) {
            int sectionStart = end[i]; 
            int sectionEnd = end[i] + 999;
            int count = 0;

            for (int j = 0; j < N; j++) {
                if (start[j] <= sectionEnd && end[j] >= sectionStart) {
                    count++;
                }
                if (start[j] > sectionEnd) break;
            }
            max = Math.max(max, count);
        }

        return max;
    }

    static int[] getMs(String[] log) {
        int start = 0;
        String[] time = log[1].split(":");
        
        int h = Integer.parseInt(time[0]) * 3600000;
        int m = Integer.parseInt(time[1]) * 60000;
        String[] sec = time[2].split("\\.");        
        int s = Integer.parseInt(sec[0]) * 1000 + Integer.parseInt(sec[1]);
        
        start += h + m + s;
        double seconds = Double.parseDouble(log[2].replace("s", ""));
        
        int t = (int)(seconds * 1000) - 1;
        
        int[] ms = new int[]{start - t, start};
        
        
        return ms;
    }
}
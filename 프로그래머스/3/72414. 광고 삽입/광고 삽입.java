import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int n = timeToSec(play_time);
        long[] dp = new long[n + 1];
        
        for (String log : logs) {
            setTime(log, dp);
        }
        
        for (int i = 1; i <= n; i++) {
            dp[i] += dp[i-1]; 
        }
        
        for (int i = 1; i <= n; i++) {
            dp[i] += dp[i-1]; 
        }
        
        int adLength = timeToSec(adv_time);
        int adStartTime = 0;
        long max = dp[adLength - 1]; 
        
        for (int i = 1; i <= n - adLength; i++) {
            long tmpTime = dp[i+adLength-1] - dp[i-1];
            if (max < tmpTime) {
                max = tmpTime;
                adStartTime = i;
            }
        }

        
        return secToTime(adStartTime);
    }
    
    static void setTime(String log, long[] dp) {
        String[] startEnd = log.split("-");
        int start = timeToSec(startEnd[0]);
        int end = timeToSec(startEnd[1]);
        
        dp[start] += 1;
        if (end < dp.length) dp[end] -= 1;
    }
    
    
    static int timeToSec (String time) {
        String[] hms = time.split(":");
        return Integer.parseInt(hms[0]) * 3600 + Integer.parseInt(hms[1]) * 60 + Integer.parseInt(hms[2]);
    }
    
    static String secToTime (int s) {
        int h = s / 3600;
        s %= 3600;
        
        int m = s / 60;
        s %= 60;
        
        String time = String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s);
        return time;
    }
}
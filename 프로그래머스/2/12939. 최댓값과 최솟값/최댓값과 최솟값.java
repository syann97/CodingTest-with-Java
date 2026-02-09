import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) throws IOException {
        
        String[] numbers = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        
        for (String strNum : numbers) {
            int num = Integer.parseInt(strNum);
            
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
    
        return min + " " + max;
    }
}
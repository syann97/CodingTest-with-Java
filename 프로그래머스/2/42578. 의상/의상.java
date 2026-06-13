import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String parts = cloth[1];
            
            map.put(parts, map.getOrDefault(parts, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue() + 1);
        }
        
        return answer - 1;
    }
}
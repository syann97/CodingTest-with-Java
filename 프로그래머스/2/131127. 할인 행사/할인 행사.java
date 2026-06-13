import java.util.*;

class Solution {    
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }
        
        int answer = 0;
        int count = 0;
        int N = number.length;
        int[] counting = new int[N];
        
        for (int i = 0; i < 10; i++) {
            if (!map.containsKey(discount[i])) continue;
            int index = map.get(discount[i]);
            
            if(++counting[index] == number[index]) {
                count++;
            }
            
            if (count == N) answer++;
        }
        
        for (int i = 0; i < discount.length - 10; i++) {
            if (map.containsKey(discount[i])) {
                int index = map.get(discount[i]);
                
                if(--counting[index] == number[index] - 1) {
                    count--;
                }
            }
            
            int j = i+10;
            if (map.containsKey(discount[j])) {
                int index = map.get(discount[j]);
                
                if(++counting[index] == number[index]) {
                    count++;
                }
            }
            
            if (count == N) answer++;
        }
        
                
        return answer;
    }
}
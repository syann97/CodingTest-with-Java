import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int N = gems.length;
        Map<String, Integer> indexMap = new HashMap<>();
        
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (!indexMap.containsKey(gems[i])) {
                indexMap.put(gems[i], index++);
            }
        }
        
        int[] count = new int[index];
        int indexCount = 0;
        
        int s = 0;
        int e = 0;
        int[] answer = new int[2];
        int length = N+1;
        
        while (s < N && e < N) {
            if (count[indexMap.get(gems[e])]++ == 0) indexCount++;
            
            while (index == indexCount) {
                if (e - s < length) {
                    answer[0] = s + 1;
                    answer[1] = e + 1;
                    length = e - s;
                }
                
                if (--count[indexMap.get(gems[s])] == 0) indexCount--;
                s++;
            }
            
            e++;
        }
        return answer;
    }
}
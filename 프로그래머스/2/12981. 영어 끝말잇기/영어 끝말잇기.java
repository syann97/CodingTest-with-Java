import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int answer = 0;
        int L = words.length;
        boolean flag = false;
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        char prevLastWord = words[0].charAt(words[0].length() - 1);
        
        int idx = 1;
        while (idx < L) {            
            char currentFirstWord = words[idx].charAt(0);
            
            if (prevLastWord != currentFirstWord || set.contains(words[idx])) {
                return getResult(idx, n);
            }
            
            set.add(words[idx]);
            prevLastWord = words[idx].charAt(words[idx].length() - 1);
            idx++;
        }
        
        return new int[]{0, 0};
    }
    
    
    static int[] getResult(int idx, int n) {
        int order = idx + 1;
        int num = order % n == 0 ? n : order % n;
        int turn = (int)Math.ceil((double)order / n);
        
        return new int[]{num, turn};
    }
    
}
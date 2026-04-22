import java.util.*;

class Solution {
    static ArrayList<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(1, 3, 2, n);
        
        
            
        return list.toArray(new int[list.size()][]);
    }
    
    static void hanoi (int s, int e, int m, int n) {
        if (n == 1) {
            list.add(new int[]{s, e});
            return;
        }
        
        // 중간 과정을 m에 놓고 [1, 3] 수행 후 m -> e 
        
        hanoi(s, m, e, n-1);
        hanoi(s, e, m, 1);
        hanoi(m, e, s, n-1);
    }
}
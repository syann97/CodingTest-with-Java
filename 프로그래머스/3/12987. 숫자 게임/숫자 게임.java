import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int N = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = N-1;
        int bIdx = N-1;
        int count = 0;
        while (aIdx >= 0) {
            if (A[aIdx] < B[bIdx]) {
                count++;
                aIdx--;
                bIdx--;
            }
            else {
                aIdx--;
            }
        }
        
        return count;
    }
}
import java.util.*;

class Solution
{
    public int solution(int []A, int []B) {
        int N = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * B[N - i - 1];
        }

        return sum;
    }
}
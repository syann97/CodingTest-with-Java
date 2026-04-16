class Solution {
    static int N;
    static int count;
    static boolean[] col;
    static boolean[] left;
    static boolean[] right;
    public int solution(int n) {
        N = n;
        count = 0;
        
        int[][] board = new int[n][n];
        col = new boolean[n];
        left = new boolean[n*2+1];
        right = new boolean[n*2+1];
        
        nQueen(0);
        return count;
    }
    
    static void nQueen(int r) {
        if (r == N) {
            count++;
            return;
        }
        
        // 열 확인
        for (int c = 0; c < N; c++) {
            if (!col[c] && !left[r+c] && !right[r-c+N]) {
                col[c] = true;
                left[r+c] = true;
                right[r-c+N] = true;
                
                nQueen(r+1);
                
                col[c] = false;
                left[r+c] = false;
                right[r-c+N] = false;
            }
        }
        
    }
}
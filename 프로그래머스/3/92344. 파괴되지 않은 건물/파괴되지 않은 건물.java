import java.util.*;

class Solution {
    static int N;
    static int M;
    public int solution(int[][] board, int[][] skills) {
        N = board.length;
        M = board[0].length;
        int[][] prefix = new int[N][M];
        
        for (int[] skill : skills) {
            useSkill(prefix, skill[1], skill[2], skill[3], skill[4], skill[0] == 1 ? -skill[5] : skill[5]);
        }
        
        return getAnswer(board, prefix);
    }
    
    
    static void useSkill (int[][] prefix, int r1, int c1, int r2, int c2, int degree) {
        prefix[r2][c2] += degree;
        
        if (r1 > 0) {
            prefix[r1-1][c2] -= degree;
        }
        
        if (c1 > 0) {
            prefix[r2][c1-1] -= degree;
        }
        
        if (r1 > 0 && c1 > 0) {
            prefix[r1-1][c1-1] += degree;
        }
    }
    
    static int getAnswer (int[][] board, int[][] prefix) {
        int count = N * M;
        for (int i = N-1; i >= 0; i--) {
            for (int j = M-1; j >= 1; j--) {
                prefix[i][j-1] += prefix[i][j];
            }
        }
        
        for (int j = M-1; j >= 0; j--) {
            for (int i = N-1; i >= 0; i--) {
                if (i > 0) {
                    prefix[i-1][j] += prefix[i][j];
                }
                
                if (board[i][j] + prefix[i][j] <= 0) {
                    count--;
                }
            }
        }
        return count;
    }
}
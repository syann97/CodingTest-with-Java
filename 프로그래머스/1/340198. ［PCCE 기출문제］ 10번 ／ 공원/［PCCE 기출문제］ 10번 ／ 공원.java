import java.util.*;


class Solution {
    static int N;
    static int M;
    public int solution(int[] mats, String[][] park) {
        N = park.length;
        M = park[0].length;
        
        mats = Arrays.stream(mats)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(i -> i)
            .toArray();
            
        
        for (int mat : mats) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i + mat - 1 < N && j + mat - 1 < M && checkSetMat(i, j, mat, park)) return mat;
                }
            }
        }
        return -1;
    }
    
    static boolean checkSetMat(int row, int col, int size, String[][] park) {
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
    
    
}
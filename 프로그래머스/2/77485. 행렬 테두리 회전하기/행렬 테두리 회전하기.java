import java.util.*;

class Solution {
    static int N;
    static int M;
    public int[] solution(int rows, int columns, int[][] queries) {
        N = rows;
        M = columns;
        int[][] grid = new int[rows][columns];
        
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = value++;
            }
        }
        
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(grid, queries[i]);
        }
        
        return answer;
    }
    
    static int rotate(int[][] grid, int[] query) {
        int sy = query[0] - 1;
        int sx = query[1] - 1;
        int ey = query[2] - 1;
        int ex = query[3] - 1;
        
        int next = grid[sy][sx];
        int tmp = 0;
        int min = next;
        
        for (int nx = sx+1; nx <= ex; nx++) {
            tmp = grid[sy][nx];
            min = Math.min(min, tmp);
            
            grid[sy][nx] = next;
            next = tmp;
        }
        
        for (int ny = sy+1; ny <= ey; ny++) {
            tmp = grid[ny][ex];
            min = Math.min(min, tmp);
            
            grid[ny][ex] = next;
            next = tmp;
        }
        
        for (int nx = ex - 1; nx >= sx; nx--) {
            tmp = grid[ey][nx];
            min = Math.min(min, tmp);
            
            grid[ey][nx] = next;
            next = tmp;
        }
        
        for (int ny = ey-1; ny >= sy; ny--) {
            tmp = grid[ny][sx];
            min = Math.min(min, tmp);
            
            grid[ny][sx] = next;
            next = tmp;
        }
        
        return min;
    }
}
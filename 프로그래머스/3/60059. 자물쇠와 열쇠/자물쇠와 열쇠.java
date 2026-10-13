import java.util.*;

class Solution {
    static class Pos {
        int y;
        int x;
        
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    static int N;
    static int M;
    static ArrayList<Pos> pos;
    public boolean solution(int[][] key, int[][] lock) {
        pos = new ArrayList<>();
        
        N = key.length;
        M = lock.length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (key[i][j] == 1) {
                    pos.add(new Pos(i, j));            
                }
            }
        }
        
        return getAnswer(key, lock);
    }
    
    static boolean getAnswer(int[][] key, int[][] lock) {
        int empty = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (lock[i][j] == 0) empty++;
            }
        }
        
        
        for (int d = 0; d < 4; d++) {
            for (int dy = -N+1; dy < M; dy++) {
                for (int dx = -N+1; dx < M; dx++) {
                    int count = 0;
                    boolean isValid = true;
                    
                    for (Pos p : pos) {
                        int ny = p.y + dy;
                        int nx = p.x + dx;
                        
                        if (ny < 0 || ny >= M || nx < 0 || nx >= M) continue;
                        
                        if (lock[ny][nx] == 1) {
                            isValid = false;
                            break;
                        }
                        
                        count++;
                    }
                    
                    if (isValid && count == empty) return true;
                }
            }
            
            rotate();
        }
        
        return false;
    }
    
    static void rotate() {
        for (Pos p : pos) {
            int y = p.y;
            int x = p.x;
            
            p.y = N-1-x;
            p.x = y;
        }
    }
}
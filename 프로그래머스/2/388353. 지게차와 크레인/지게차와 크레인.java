import java.util.*;

class Pos {
    int y;
    int x;
    
    public Pos (int y, int x) {
        this.y = y;
        this.x = x;
    }
}


class Solution {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    public int solution(String[] storage, String[] requests) {
        int row = storage.length;
        int col = storage[0].length();
        
        char[][] tmp = new char[row + 2][col + 2];
        
        for (int i = 0; i < row + 2; i++) {
            Arrays.fill(tmp[i], ' ');
        }
        
        for (int i = 1; i <= row; i++) {
            String s = storage[i-1];
            for (int j = 1; j <= col; j++) {
                char c = s.charAt(j-1);
                tmp[i][j] = c;
            }
        }
        
        return processPhase(tmp, requests, row, col);
    }
    
    public int processPhase(char[][] storage, String[] requests, int row, int col) {
        int count = 0;
        
        for (String request : requests) {
            
            // print(storage, row);
            boolean isAllPickup = request.length() == 2;
            char order = request.charAt(0);
            
            if (isAllPickup) {
                for (int i = 1; i <= row; i++) {
                    for (int j = 1; j <= col; j++) {
                        if (storage[i][j] == order) {
                            storage[i][j] = '@';
                            count++;
                        }
                    }
                }
            }
            
            else {
                propagation(storage, row, col);
                
                char[][] copy = deepCopy(storage);
                ArrayDeque<Pos> q = new ArrayDeque<>();
                
                for (int i = 1; i <= row; i++) {
                    for (int j = 1; j <= col; j++) {
                        if (copy[i][j] == order && isValid(copy, i, j)) {
                            storage[i][j] = ' ';
                            count++;
                        }
                    }
                }
                
            }
        }
        
        // print(storage, row);
        
        return row * col - count;
    }
    
    static char[][] deepCopy(char[][] original) {
        if (original == null) return null;

        char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i].clone(); 
        }
        return result;
    }
    
    static void propagation(char[][] storage, int row, int col) {
        boolean[][] visited = new boolean[row + 2][col + 2];
        ArrayDeque<Pos> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offer(new Pos(0, 0));
        
        while (!q.isEmpty()) {
            Pos pos = q.poll();
            int y = pos.y;
            int x = pos.x;
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (0 <= ny && ny < row + 2 && 0 <= nx && nx < col + 2 && !visited[ny][nx] && (storage[ny][nx] == ' ' || storage[ny][nx] == '@')) {
                    storage[ny][nx] = ' ';
                    visited[ny][nx] = true;
                    q.offer(new Pos(ny, nx));  
                }
            }
        }
        // print(storage, row);
    }
    
    static boolean isValid(char[][] storage, int y, int x) {
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (storage[ny][nx] == ' ') return true;
        }
        
        return false;
    }
    
    static void print(char[][] storage, int row) {
        for (int i = 0; i < row + 2; i++) {
            System.out.println(Arrays.toString(storage[i]));
        }
        System.out.println();
    } 
}
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int result = 0;
        
        Map<Integer, Integer>[][] map = new HashMap[101][101];
    
        for (int i = 0; i < routes.length; i++) {
            int[] cur = points[routes[i][0] - 1];
            int y = cur[0];
            int x = cur[1];
            int turn = 0;
            
            if (map[y][x] == null) map[y][x] = new HashMap<>();
            
            int count = map[y][x].getOrDefault(turn, 0);
            
            if (count == 1) {
                result++;
            }
            
            map[y][x].put(turn, count + 1);

            

            
            for (int j = 1; j < routes[i].length; j++) {
                int[] next = points[routes[i][j] - 1];
                int ny = next[0];
                int nx = next[1];
                
                while (y != ny || x != nx) {
                    if (y != ny) {
                        int dy = (y < ny) ? 1 : -1;
                        y += dy;
                    } else {
                        int dx = (x < nx) ? 1 : -1;
                        x += dx;
                    }

                    turn++;

                    if (map[y][x] == null) map[y][x] = new HashMap<>();

                    count = map[y][x].getOrDefault(turn, 0);
                    if (count == 1) {
                        result++;
                    }
                    map[y][x].put(turn, count + 1);
                }
            }
        }
        
        return result;
    }
}
import java.util.*;

class Drone {
    int y;
    int x;
    int dir;
    int dist;
    
    public Drone(int y, int x, int dir, int dist) {
        this.y = y;
        this.x = x;
        this.dir = dir;
        this.dist = dist;
    }
}


class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] dyVtoH = {0, 0, 1, 1};
    static int[] dxVtoH = {-1, 1, -1, 1};
 
    
    public int solution(int[][] board) {
        return bfs(board);
    }
    
    static int bfs (int[][] board) {
        int N = board.length;
        int M = board[0].length;
        int ey = N - 1;
        int ex = M - 1;
        
        ArrayDeque<Drone> q = new ArrayDeque<>();
        q.offer(new Drone(0, 0, 0, 0));
        
        boolean[][][] visited = new boolean[2][N][M];
        visited[0][0][0] = true;
        
        
        while (!q.isEmpty()) {
            Drone drone = q.poll();
            
            int y = drone.y;
            int x = drone.x;
            int dir = drone.dir;
            int dist = drone.dist;
            
            if ((dir == 0 && y == ey && x + 1 == ex) || (dir == 1 && y + 1 == ey && x == ex)) {
                return dist;
            }
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (isInbound(ny, nx, dir, board) && !visited[dir][ny][nx]) {
                    visited[dir][ny][nx] = true;
                    q.offer(new Drone(ny, nx, dir, dist + 1));
                }
            }
            
            if (dir == 0) {
                for (int dx = 0; dx < 2; dx++) {
                    for (int dy = -1; dy <= 1; dy += 2) {
                        int checkY = y + dy;
                        int checkX = x + 1 - dx;
                        int ny = Math.min(y, checkY);
                        int nx = x + dx;

                        if (0 <= checkY && checkY < N && 0 <= checkX && checkX < M
                                && board[checkY][checkX] == 0
                                && isInbound(ny, nx, 1, board)
                                && !visited[1][ny][nx]) {
                            visited[1][ny][nx] = true;
                            q.offer(new Drone(ny, nx, 1, dist + 1));
                        }
                    }
                }
            }
            
            else {
                for (int dy = 0; dy < 2; dy++) {
                    for (int dx = -1; dx <= 1; dx += 2) {
                        int checkX = x + dx;
                        int checkY = y + 1 - dy;
                        int ny = y + dy;
                        int nx = Math.min(x, checkX);

                        if (0 <= checkY && checkY < N && 0 <= checkX && checkX < M
                                && board[checkY][checkX] == 0
                                && isInbound(ny, nx, 0, board)
                                && !visited[0][ny][nx]) {
                            visited[0][ny][nx] = true;
                            q.offer(new Drone(ny, nx, 0, dist + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    static boolean isInbound(int y, int x, int dir, int[][] board) {
        int N = board.length;
        int M = board[0].length;
        
        if (y < 0 || x < 0 || y >= N || x >= M || board[y][x] == 1) return false;
        if (dir == 0 && (x + 1 >= M || board[y][x+1] == 1)) return false;
        if (dir == 1 && (y + 1 >= N || board[y+1][x] == 1)) return false;
        return true;
    }
}
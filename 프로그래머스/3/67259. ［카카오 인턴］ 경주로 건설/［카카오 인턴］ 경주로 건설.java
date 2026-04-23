import java.util.*;

class Node {
    int y;
    int x;
    int d;
    
    public Node (int y, int x, int d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}

class Solution {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static final int MAX = 10000000;
    static int N;
    static int M;
    public int solution(int[][] board) {
        N = board.length;
        M = board[0].length;
        
        // 이동 방향 기록, 나머지 방향 5 진행방향 1
        // bfs + dijkstra
        return bfs(board);
    }
    
    static int bfs(int[][] board) {
        // init
        int[][][] visited = new int[4][N][M];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    visited[i][j][k] = MAX;
                }
            }
            visited[i][0][0] = 0;
        }
        
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 2));
        q.offer(new Node(0, 0, 3));
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            int cd = node.d;
            
            int current = visited[cd][y][x];
            for (int d = 0; d < 4; d++) {
                if (visited[d][y][x] < current + 500) continue;
            }
            
            
            for (int nd = 0; nd < 4; nd++) {
                int ny = y + dy[nd];
                int nx = x + dx[nd];
                int nc = visited[cd][y][x] + (nd == cd ? 100 : 600);
                
                if (0 <= ny && ny < N && 0 <= nx && nx < M && board[ny][nx] != 1 && nc < visited[nd][ny][nx]) {
                    visited[nd][ny][nx] = nc;
                    q.offer(new Node(ny, nx, nd));
                }
            }
        }
        
        int min = MAX;
        for (int d = 0; d < 4; d++) {
            min = Math.min(min, visited[d][N-1][M-1]);
        }
        
        return min;
        
    }
}
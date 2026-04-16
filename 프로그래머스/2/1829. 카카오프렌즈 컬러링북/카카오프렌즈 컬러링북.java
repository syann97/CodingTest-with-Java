class Solution {
    static int R;
    static int C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public int[] solution(int m, int n, int[][] picture) {
        R = m;
        C = n;
        boolean[][] visited = new boolean[R][C];
        // flood fill + bfs();
        
        int maxArea = 0;
        int areaCount = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    maxArea = Math.max(maxArea, dfs(i, j, picture[i][j], picture, visited));
                    areaCount++;
                }
            }
        }
            
        
        return new int[] {areaCount, maxArea};
    }
    
    
    static int dfs(int y, int x, int color, int[][] picture, boolean[][] visited) {
        if (visited[y][x]) return 0;
        visited[y][x] = true;
        
        int count = 1;
        
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (0 <= ny && ny < R && 0 <= nx && nx < C) {
                if (!visited[ny][nx] && picture[ny][nx] == color) {
                    count += dfs(ny, nx, color, picture, visited);
                }
            }
        }
        
        return count;
    }
}
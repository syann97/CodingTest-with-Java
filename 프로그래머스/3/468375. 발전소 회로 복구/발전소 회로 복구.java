import java.util.*;


class Node {
    int y;
    int x;
    
    public Node (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Edge {
    int v;
    Edge edge;
    
    public Edge(int v, Edge edge) {
        this.v = v;
        this.edge = edge;
    }
}

class Solution {
    static int[] dy = {-1, 0, 1 , 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] pannelDist;
    static int[][] pannels;
    static int[][] dist;
    static int[][] dp;
    static Edge[] graph;
    static String[] grid;
    static int answer;
    static int[] in;
    static int N;
    static int M;
    static int L;
    public int solution(int h, String[] g, int[][] p, int[][] seqs) {
        pannels = p;
        grid = g;
        answer = Integer.MAX_VALUE;
        
        N = grid.length;
        M = grid[0].length();
        
        dist = getElevatorDistance(grid);
        
        topologySort(seqs);
        memoizationPannelDist();
        
        boolean[] visited = new boolean[L];
        // [상태][현재]
        dp = new int[1<<L][L];
        for (int i = 0 ; i < (1<<L); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int v = 0; v < L; v++) {
            if(in[v] == 0) {
                visited[v] = true;
                // 1. 초기 출발지가 v == 1이 아니라면 이동
                int dist = 0;
                if (v != 0) {
                    dist += pannelDist[0][v];
                }
                
                dfs(1, v, dist, in, 1 << v);
                visited[v] = false;
            }
        }
        
        return answer;
    }
    
    static void memoizationPannelDist() {
        pannelDist = new int[L][L];
        
        for (int i = 0; i < L; i++) {
            for (int j = i+1; j < L; j++) {
                int distance = calDist(i, j);
                pannelDist[i][j] = distance;
                pannelDist[j][i] = distance;
            }
        }
    }
    
    static int calDist(int u, int v) {
        int[] from = pannels[u];
        int[] to = pannels[v];
        
        if (from[0] == to[0]) return bfs(from[1]-1, from[2]-1, to[1]-1, to[2]-1);
        return dist[from[1]-1][from[2]-1] + Math.abs(from[0] - to[0]) + dist[to[1]-1][to[2]-1]; 
    }
    
    
    // pannel 
    static void dfs(int count, int v, int totalDist, int[] in, int status) {
        if (count == L) {
            answer = Math.min(answer, totalDist);
            return;
        }
        
        if (dp[status][v] <= totalDist) return;
        dp[status][v] = totalDist;
        
        
        for (Edge edge = graph[v]; edge != null; edge = edge.edge) {
            int nv = edge.v;
            in[nv]--;
        }
        
        for (int nv = 0; nv < L; nv++) {
            if (in[nv] == 0 && (status & (1 << nv)) == 0) {
                int newStatus = status | (1 << nv);
                int newMove = pannelDist[v][nv];
                dfs(count + 1, nv, totalDist + newMove, in, newStatus);
            }
        }
        
        for (Edge edge = graph[v]; edge != null; edge = edge.edge) {
            int nv = edge.v;
            in[nv]++;
        }
    }
    
    static void topologySort(int[][] seqs) {
        L = pannels.length;
        in = new int[L];
        graph = new Edge[L];
        
        for (int[] seq : seqs) {
            
            int u = seq[0] - 1;
            int v = seq[1] - 1;
            in[v]++;
            graph[u] = new Edge(v, graph[u]);
        }
    }
    
    
    // logic 1. grid 기반의 엘리베이터로의 거리 계산 -> 시뮬레이션 최적화
    // logic 2. 위상정렬 순서 선정
        // logic 2-1. 탐색 우선순위 설정할 때 |x-y| 고려하기
        // logic 2-2. or 가능 순서 dfs 수행하기
    
    static int[][] getElevatorDistance(String[] grid) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        Node pos = findElevator(grid);
        dist = new int[N][M];
        dist[pos.y][pos.x] = 1;
        
        for (int d = 0; d < 4; d++) {
            int ny = pos.y + dy[d];
            int nx = pos.x + dx[d];
            
            if (ny < 0 || ny >= N || nx < 0 || nx >= M || grid[ny].charAt(nx) == '#') continue;
            q.offer(new Node(ny, nx));
            dist[ny][nx] = 1;
        }
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && grid[ny].charAt(nx) != '#' && dist[ny][nx] == 0) {
                    
                    dist[ny][nx] = dist[y][x] + 1;
                    q.offer(new Node(ny, nx));
                }
            }
        }
        dist[pos.y][pos.x] = 0;
        
        return dist;
    }
        

    
    static Node findElevator(String[] grid) {
        for (int i = 0; i < N; i++) {
            String s = grid[i];
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '@') {
                    return new Node(i, j);
                }
            }
        }
        
        return null;
    }
    
    static int bfs(int sy, int sx, int ey, int ex) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(sy, sx));
        
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[sy][sx] = 0;
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int y = node.y;
            int x = node.x;
            
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] >= 0 || grid[ny].charAt(nx) == '#') continue;
                
                if (ny == ey && nx == ex) return visited[y][x] + 1;
                visited[ny][nx] = visited[y][x] + 1;
                q.offer(new Node(ny, nx));
            }
        }
        
        return -1;
    }
}
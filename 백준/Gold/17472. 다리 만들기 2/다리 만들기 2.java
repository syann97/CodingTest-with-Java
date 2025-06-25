import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Edge implements Comparable<Edge> {
    int u;
    int v;
    int w;

    public Edge (int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}


public class Main {
    static StringTokenizer st;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int min;
    static PriorityQueue<Edge> edges;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        min = N * M;

        int[][] area = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int V = classifyLand(N, M, area);
        parent = new int[V+1];

        for (int i = 2; i <= V; i++) parent[i] = i;
        bf(N, M, area, new boolean[N][M]);

        int count = 0;
        int result = 0;

        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            if (union(edge.u, edge.v)) {
                count++;
                result += edge.w;
            }
            if (count == V - 3) break;
        }
        System.out.println(count == V - 3 ? result : -1);
    }

    static int classifyLand(int N, int M, int[][] area) {
        int index = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 1) {
                    dfs(i, j, index++, N, M, area);
                }
            }
        }
        return index;
    }

    static void dfs(int y, int x, int no, int N, int M, int[][] area) {
        area[y][x] = no;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (0 <= ny && ny < N && 0 <= nx && nx < M && area[ny][nx] == 1) {
                dfs(ny, nx, no, N, M, area);
            }
        }
    }

    static void bf(int N, int M, int[][] area, boolean[][] visited) {
        edges = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 로직 수행
                if (area[i][j] >= 2) {
                    int u = area[i][j];
                    // 상/하/좌/우
                    for (int d = 0; d < 4; d++) {
                        // 방향 정해짐
                        int w = 0;
                        int y = i;
                        int x = j;

                        while (true) {
                            y += dy[d];
                            x += dx[d];

                            // count 미반환 로직
                            if (y < 0 || y >= N || x < 0 || x >= M || u == area[y][x]) break;
                            // count 반환 로직 offer 로직
                            if (area[y][x] != 0) {
                                if (w >= 2) {
                                    edges.offer(new Edge(u, area[y][x], w));
                                }
                                break;
                            }
                            w++;
                        }
                    }
                }
            }
        }
    }

    static int find (int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union (int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        parent[b] = a;
        return true;
    }
}
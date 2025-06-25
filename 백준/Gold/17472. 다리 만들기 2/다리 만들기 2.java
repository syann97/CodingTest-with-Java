import java.io.IOException;
import java.util.PriorityQueue;

class Reader {
    private final int SIZE = 1 << 8;
    private byte[] buffer = new byte[SIZE];
    private int size, index;

    private byte read() throws IOException {
        if (size == index) {
            size = System.in.read(buffer, index = 0, SIZE);

            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }

    int nextInt() throws IOException {
        int n = 0;
        byte c;
        boolean isMinus = false;

        while ((c = read()) <= 32);


        if (c == 45) {
            isMinus = true;
            c = read();
        }

        do n = (n << 3) + (n << 1) + (c & 15);
        while (48 <= (c = read()) && c <= 57);

        return isMinus ? ~n+1 : n;
    }
}


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
}


public class Main {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int[] parent;
    public static void main(String[] args) throws Exception {
        Reader in = new Reader();

        int N = in.nextInt();
        int M = in.nextInt();

        int[][] area = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                area[i][j] = in.nextInt();
            }
        }

        int V = classifyLand(N, M, area);
        parent = new int[V+1];

        for (int i = 2; i <= V; i++) parent[i] = i;
        PriorityQueue<Edge> edges = bf(N, M, area);

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

    static PriorityQueue<Edge> bf(int N, int M, int[][] area) {
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] >= 2) {
                    int u = area[i][j];
                    for (int d = 0; d < 4; d++) {
                        int w = 0;
                        int y = i;
                        int x = j;

                        while (true) {
                            y += dy[d];
                            x += dx[d];

                            if (y < 0 || y >= N || x < 0 || x >= M || u == area[y][x]) break;
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
        return edges;
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
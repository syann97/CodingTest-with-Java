import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int y;
    int x;
    int t;

    public Node (int y, int x, int t) {
        this.y = y;
        this.x = x;
        this.t = t;
    }

    @Override
    public int compareTo(Node o) {
        return this.t - o.t;
    }
}


public class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t<= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] area = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            sb.append("#").append(t).append(" ").append(dijkstra(N, area, sy, sx, ey, ex)).append("\n");
        }
        System.out.print(sb);
    }

    static int dijkstra(int n, int[][] area, int sy, int sx, int ey, int ex) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(sy, sx, 0));

        int[][] time = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(time[i], MAX);
        }

        time[sy][sx] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int y = node.y;
            int x = node.x;
            int t = node.t;

            if (time[y][x] < t) continue;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                int nt = t + 1;

                if (ny < 0 || ny >= n || nx < 0 || nx >= n || area[ny][nx] == 1) continue;

                if (area[ny][nx] == 2 &&  nt % 3 != 0) {
                    nt += 3 - (nt % 3);
                }

                if (time[ny][nx] > nt) {
                    time[ny][nx] = nt;
                    pq.offer(new Node(ny, nx, nt));
                }
            }
        }

        return time[ey][ex] == MAX ? -1 : time[ey][ex];
    }
}
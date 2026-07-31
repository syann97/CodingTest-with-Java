import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge> {
    int v;
    int w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static final int INF = 1000000000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dp;
    static int[][] dist;
    static int totalNodes;
    static int fullMask;
    static int office;
    static int home;
    static int N;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            init();
            sb.append('#').append(t).append(' ').append(tsp(0, office)).append('\n');
        }

        System.out.print(sb);
    }

    static int tsp(int mask, int current) {
        if (mask == fullMask) return dist[current][home];
        if (dp[mask][current] != -1) return dp[mask][current];

        int result = INF;

        for (int next = 1; next <= N; next++) {
        	if (current == next) continue;

            int bit = 1 << (next - 1);
            if ((mask & bit) != 0) continue;

            result = Math.min(result, dist[current][next] + tsp(mask | bit, next));
        }

        return dp[mask][current] = result;
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        totalNodes = N + 2;
        office = 0;
        home = N + 1;
        fullMask = (1 << N) - 1;

        Node[] nodes = new Node[totalNodes];

        st = new StringTokenizer(br.readLine());
        nodes[office] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        nodes[home] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int customer = 1; customer <= N; customer++) {
            nodes[customer] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        dist = new int[totalNodes][totalNodes];
        setGraph(nodes);

        dp = new int[1 << N][N + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
    }

    static void setGraph(Node[] nodes) {
        for (int from = 0; from < totalNodes - 1; from++) {
            for (int to = from + 1; to < totalNodes; to++) {
                int distance = calDist(nodes[from], nodes[to]);

                dist[from][to] = distance;
                dist[to][from] = distance;
            }
        }
    }

    static int calDist(Node from, Node to) {
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y);
    }
}
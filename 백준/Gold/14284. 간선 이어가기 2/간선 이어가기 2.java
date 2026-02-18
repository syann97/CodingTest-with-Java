import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Edge implements Comparable<Edge> {
    int v;
    int w;

    public Edge (int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo (Edge o) {
        return this.w - o.w;
    }
}


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(graph, n, s, t));
    }

    private static int dijkstra(ArrayList<Edge>[] graph, int n, int s, int t) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s, 0));

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.v;
            int w = edge.w;

            if (w > dist[v]) continue;

            if (v == t) return dist[t];

            for (Edge next : graph[v]) {
                int nv = next.v;
                int nw = next.w;

                if (dist[nv] > w + nw) {
                    dist[nv] = w + nw;
                    pq.offer(new Edge(nv, dist[nv]));
                }
            }
        }

        return dist[t];
    }
}
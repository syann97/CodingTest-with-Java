import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v;
    int w;

    public Edge (int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }
        System.out.println(dijkstra(graph, N));
    }

    static int dijkstra (ArrayList<Edge>[] graph, int N) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.v;
            int w = edge.w;
            
            if (w > dist[v]) continue;

            for (Edge e : graph[v]) {
                if (dist[e.v] > w + e.w) {
                    dist[e.v] = w + e.w;
                    pq.offer(new Edge(e.v, dist[e.v]));
                }
            }
        }
        return dist[N];
    }
}

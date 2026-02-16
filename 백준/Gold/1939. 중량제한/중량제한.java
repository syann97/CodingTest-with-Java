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
        return Integer.compare(o.w, this.w);
    }
}


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(graph, N, s, e));
    }

    private static int dijkstra(ArrayList<Edge>[] graph, int n, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, Integer.MAX_VALUE));

        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[start] = Integer.MAX_VALUE;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.v;
            int w = edge.w;

            if (w < dist[v]) continue;

            if (v == end) break;

            for (Edge e : graph[v]) {
                int min = Math.min(w, e.w);
                if (dist[e.v] < min) {
                    dist[e.v] = min;
                    pq.offer(new Edge(e.v, dist[e.v]));
                }
            }
        }

        return dist[end];
    }
}
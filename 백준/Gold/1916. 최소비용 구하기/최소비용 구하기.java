import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Reader {
    private static final int SIZE = 1 << 13;
    private byte[] buffer = new byte[SIZE];
    private int index, size;

    public byte read() throws IOException {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) {
                buffer[0] = -1;
            }
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

        return isMinus ? ~n + 1 : n;
    }
}

class Edge implements Comparable<Edge> {
    int v;
    int w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        int N = in.nextInt();
        int M = in.nextInt();

        List<Edge>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            graph[u].add(new Edge(v, w));
        }

        int s = in.nextInt();
        int e = in.nextInt();

        System.out.println(dijkstra(s, e, N, graph));
    }


    static int dijkstra(int s, int e, int N, List<Edge>[] graph) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            int v = edge.v;
            int w = edge.w;

            if (dist[v] < w) continue;

            for (Edge next : graph[v]) {
                int nv = next.v;
                int nw = dist[v] + next.w;

                if (dist[nv] > nw) {
                    dist[nv] = nw;
                    pq.offer(new Edge(nv, nw));
                }
            }
        }
        return dist[e] == Integer.MAX_VALUE ? -1 : dist[e];
    }
}

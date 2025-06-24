import java.io.IOException;
import java.util.PriorityQueue;

class Reader {
    private final int SIZE = 1 << 13;
    private byte[] buffer = new byte[SIZE];
    private int size, index;

    private byte read() throws IOException {
        if (index == size) {
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

        return isMinus ? ~n + 1 : n;
    }
}


class Edge implements Comparable<Edge> {
    int u;
    int v;
    int w;

    public Edge(int u, int v, int w) {
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
    static PriorityQueue<Edge> edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        edges = new PriorityQueue<>();
        Reader in = new Reader();

        int V = in.nextInt();
        int E = in.nextInt();

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= E; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();

            edges.add(new Edge(u, v, w));
        }

        int count = V;
        int answer = 0;

        while (count > 1) {
            Edge edge = edges.poll();

            if (union(edge.u, edge.v)) {
                answer += edge.w;
                count--;
            }
        }

        System.out.println(answer);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


class Node {
    float x;
    float y;

    public Node (float x, float y) {
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    double w;

    public Edge (int u, int v, double w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo (Edge o) {
        if (this.w == o.w) {
            if (this.u == o.u) {
                return Integer.compare(this.v, o.v);
            }
            return Integer.compare(this.u, o.u);
        }
        return Double.compare(this.w, o.w);
    }

    @Override
    public String toString() {
        return this.u +  " " + this.v + " " + this.w + "\n";
    }
}

class Main {
    static StringTokenizer st;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[V];

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            float x = Float.parseFloat(st.nextToken());
            float y = Float.parseFloat(st.nextToken());

            nodes[i] = new Node(x, y);
        }

        TreeSet<Edge> set = new TreeSet<>();

        for (int i = 0; i < V - 1; i++) {
            for (int j = i + 1; j < V; j++) {
                Node n1 = nodes[i];
                Node n2 = nodes[j];

                set.add(new Edge(i, j, calculateDist(n1.x, n1.y, n2.x, n2.y)));
            }
        }

        parent = new int[V];

        for (int i = 0; i < V; i++) parent[i] = i;

        double answer = 0;
        int count = V - 1;

        while (count > 0) {
            Edge edge = set.pollFirst();
            if (!union(edge.u, edge.v)) continue;

            answer += edge.w;
            if (set.isEmpty()) break;

            count--;
        }

        System.out.printf("%.2f%n", answer);

    }


    static Double calculateDist (float x1, float y1, float x2, float y2) {
        float x = Math.abs(x1 - x2);
        float y = Math.abs(y1 - y2);
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }


    static int find (int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union (int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        parent[y] = x;
        return true;
    }
}
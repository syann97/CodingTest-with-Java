import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


class Reader {
    private final int SIZE = 1 << 13;
    private byte[] buffer = new byte[SIZE];
    private int size, index;

    private byte read() throws IOException {
        if (size == index) {
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

        return isMinus ? ~n+1 : n;
    }
}

class Node implements Comparable<Node> {
    int u;
    int v;
    public Node (int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public int compareTo(Node o) {
        return this.v - o.v;
    }
}


public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();

        int T = in.nextInt();
        while (T --> 0) {
            int V = in.nextInt();
            int E = in.nextInt();

            PriorityQueue<Node> nodes = new PriorityQueue<>();
            parent = new int [V+1];
            for (int i = 1; i <= V; i++) parent[i] = i;

            for (int i = 0; i < E; i++) {
                int u = in.nextInt();
                int v = in.nextInt();

                nodes.offer(new Node(u, v));
            }

            int count = V;
            int result = 0;

            while (count > 1) {
                Node node = nodes.poll();
                if (union(node.v, node.u)) {
                    count--;
                    result++;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }


    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return false;
        parent[b] = a;
        return true;
    }

}

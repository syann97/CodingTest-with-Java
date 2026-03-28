import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


class Node {
    int next;
    Node node;

    public Node (int next, Node node) {
        this.next = next;
        this.node = node;
    }
}

public class Main {
    static StringTokenizer st;
    static int N;
    static int K;
    static int X;
    static int Y;
    static int[] D;
    static int[] in;
    static Node[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T -- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            D = new int[N+1];
            in = new int[N+1];
            graph = new Node[N+1];


            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());

                in[Y]++;
                graph[X] = new Node(Y, graph[X]);
            }

            int W = Integer.parseInt(br.readLine());

            sb.append(topologySort(W)).append("\n");
        }
        System.out.println(sb);
    }

    static int topologySort(int w) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] result = new int[N+1];

        for (int i = 1; i <= N; i++) {
            result[i] = D[i];
            if (in[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();

            for (Node node = graph[v]; node != null; node = node.node) {
                int nv = node.next;

                result[nv] = Math.max(result[nv], result[v] + D[nv]);

                if (--in[nv] == 0) q.offer(nv);
            }
        }

        return result[w];
    }
}

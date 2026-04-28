import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int v;
    Node node;

    public Node (int v, Node node) {
        this.v = v;
        this.node = node;
    }
}

public class Main {
    static StringTokenizer st;
    static Node[] graph;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new Node[N];
        dp = new int[N];
        
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            graph[v] = new Node(i, graph[v]);
        }

        dfs(0);
        System.out.println(dp[0]);
    }

    static void dfs(int v) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> dp[o2] - dp[o1]);
        for (Node node = graph[v]; node != null; node = node.node) {
            int nv = node.v;
            dfs(nv);
            pq.offer(nv);
        }

        if (pq.isEmpty()) dp[v] = 0;
        else {
            int sequence = 0;

            while (!pq.isEmpty()) {
                int nv = pq.poll();
                sequence++;
                dp[v] = Math.max(dp[v], dp[nv] + sequence);
            }
        }
    }
}

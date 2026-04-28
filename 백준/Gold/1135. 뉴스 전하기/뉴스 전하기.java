import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new Node[N];

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            graph[v] = new Node(i, graph[v]);
        }

        System.out.println(dfs(0));
    }

    static int dfs(int v) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Node node = graph[v]; node != null; node = node.node) {
            int nv = node.v;
            list.add(dfs(nv));
        }

        int sequence = 0;
        int max = 0;

        list.sort(Collections.reverseOrder());

        for (int current : list) {
            sequence++;
            max = Math.max(max, current + sequence);
        }

        return max;
    }
}

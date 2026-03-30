import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
	static Node[] graph;
	static int[] in;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		in = new int[N+1];
		graph = new Node[N+1];

		int v = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k >= 0) {
				v = Integer.parseInt(st.nextToken());
				k--;
			}

			while (k-- > 0) {
				int nv = Integer.parseInt(st.nextToken());
				graph[v] = new Node(nv, graph[v]);
				in[nv]++;

				v = nv;
			}
		}

		System.out.print(topologySort());

	}

	static String topologySort() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		int count = 0;
		for (int v = 1; v <= N; v++) {
			if (in[v] == 0) {
				q.offer(v);
			}
		}

		while (!q.isEmpty()) {
			int v = q.poll();
			count++;
			sb.append(v).append("\n");

			for (Node node = graph[v]; node != null; node = node.node) {
				int nv = node.next;

				in[nv]--;
				if (in[nv] == 0) q.offer(nv);
			}
		}
		if (count != N) return "0";
		return sb.toString();
	}
}

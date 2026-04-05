import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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
	static int[] cost;
	static int[] in;
	static int N;


	public static void main(String[] args) throws IOException {
		init();
		System.out.println(topologicalSort());
	}

	private static int topologicalSort() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int[] total = new int[N+1];

		for (int v = 1; v <= N; v++) {
			total[v] = cost[v];
			if (in[v] == 0) {
				q.offer(v);
			}
		}
		
		int result = 0;
		while (!q.isEmpty()) {
			int v = q.poll();
			
			result = Math.max(result, total[v]);

			for (Node node = graph[v]; node != null; node = node.node) {
				int nv = node.v;

				total[nv] = Math.max(total[nv], total[v] + cost[nv]);

				if (--in[nv] == 0) q.offer(nv);
			}
		}
		return result;
	}



	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		in = new int[N+1];
		cost = new int[N+1];
		graph = new Node[N+1];

		for (int v = 1; v <= N; v++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());

			cost[v] = time;

			while (count-- > 0) {
				int nv = Integer.parseInt(st.nextToken());
				graph[nv] = new Node(v, graph[nv]);
				in[v]++;
			}
		}
	}
}

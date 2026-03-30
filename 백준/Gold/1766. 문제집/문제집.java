import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
		
			graph[A] = new Node(B, graph[A]);
			in[B]++;
		}

		System.out.println(topologySort());
	}

	private static String topologySort() {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int v = 1; v <= N; v++) {
			if (in[v] == 0) {
				pq.offer(v);
			}
		}

		while (!pq.isEmpty()) {
			int v = pq.poll();
			sb.append(v).append(" ");

			for (Node node = graph[v]; node != null; node = node.node) {
				int nv = node.next;
				if (--in[nv] == 0) pq.offer(nv);
			}
		}

		return sb.toString();
	}
}

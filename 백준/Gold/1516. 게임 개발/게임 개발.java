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
	static int[] time;
	static int[] base;
	static int[] in;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		in = new int[N+1];
		base = new int[N+1];
		time = new int[N+1];
		graph = new Node[N+1];

		for (int v = 1; v <= N; v++) {
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			base[v] = input;
			time[v] = input;

			while(true) {
				if ((input = Integer.parseInt(st.nextToken())) == -1) break;
				graph[input] = new Node(v, graph[input]);
				in[v]++;
			}
		}

		System.out.print(topologySort());
	}

	static String topologySort() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int v = 1; v <= N; v++) {
			if (in[v] == 0) {
				q.offer(v);
			}
		}

		while (!q.isEmpty()) {
			int v = q.poll();

			for (Node node = graph[v]; node != null; node = node.node) {
				int nv = node.v;

				time[nv] = Math.max(time[nv], time[v] + base[nv]);


				if (--in[nv] == 0) q.offer(nv);
			}
		}

		for (int v = 1; v <= N; v++) {
			sb.append(time[v]).append('\n');
		}

		return sb.toString();
	}
}

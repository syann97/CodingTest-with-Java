import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node {
	int v;
	int w;
	Node node;

	public Node(int v, int w, Node node) {
		this.v = v;
		this.w = w;
		this.node = node;
	}
}

class Edge implements Comparable<Edge> {
	int v;
	int w;

	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}


public class Main {
	static Node[] graph;
	static StringTokenizer st;
	static final int MAX = Integer.MAX_VALUE;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new Node[N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u] = new Node(v, w, graph[u]);
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		dijkstra(s, e);
	}


	static void dijkstra(int s, int e) {
		int[] dist = new int[N+1];
		int[] trace = new int[N+1];

		Arrays.fill(dist, MAX);
		dist[s] = 0;
		trace[s] = s;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(s, 0));

		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int v = edge.v;
			int w = edge.w;

			if (v == e) break;
			if (dist[v] < w) continue;

			for (Node next = graph[v]; next != null; next = next.node) {
				int nv = next.v;
				int nw = w + next.w;

				if (nw < dist[nv]) {
					dist[nv] = nw;
					trace[nv] = v;
					pq.offer(new Edge(nv, nw));
				}
			}
		}

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		int cv = e;

		while (true) {
			stack.push(cv);
			if (cv == s) break;
			cv = trace[cv];
		}

		StringBuilder sb = new StringBuilder();
		sb.append(dist[e]).append("\n").append(stack.size()).append("\n");

		while(!stack.isEmpty()) {
			sb.append(stack.poll()).append(" ");
		}

		System.out.println(sb);
	}
}
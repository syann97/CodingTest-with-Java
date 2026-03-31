import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
	static Map<String, Integer> indexMap;
	static ArrayList<Integer>[] directChild;
	static Node[] graph;
	static String[] s;
	static int[] in;
	static int N;

	public static void main(String[] args) throws IOException {
		init();
		topologySort();
	}

	static void topologySort() {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			if (in[i] == 0) {
				q.offer(i);
			}
		}

		sb.append(q.size()).append("\n");
		if (!q.isEmpty()) {
			for (int ancestor : q) {
				sb.append(s[ancestor]).append(" ");
			}
			sb.append("\n");
		}

		while (!q.isEmpty()) {
			int v = q.poll();

			for (Node node = graph[v]; node != null; node = node.node) {
				int nv = node.next;

				if (--in[nv] == 0) {
					directChild[v].add(nv);
					q.offer(nv);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(s[i]).append(" ").append(directChild[i].size());
			Collections.sort(directChild[i]);

			for (int index : directChild[i]) {
				sb.append(" ").append(s[index]);
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new String[N+1];
		indexMap = new HashMap<>();
		graph = new Node[N+1];
		in = new int[N+1];
		s[0] = "";

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			s[i] = st.nextToken();
		}

		Arrays.sort(s);

		for (int i = 1; i <= N; i++) {
			indexMap.put(s[i], i);
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int child = indexMap.get(st.nextToken());
			int parent = indexMap.get(st.nextToken());

			in[child]++;
			graph[parent] = new Node(child, graph[parent]);
		}

		directChild = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			directChild[i] = new ArrayList<>();
		}
	}
}

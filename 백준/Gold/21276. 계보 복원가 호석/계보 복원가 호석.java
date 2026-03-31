import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	static StringTokenizer st;
	static Map<String, Set<String>> ancestor;
	static Map<String, Set<String>> directChild;
	static Map<String, Integer> in;
	public static void main(String[] args) throws IOException {
		init();
		topologySort();
	}

	static void topologySort() {
		PriorityQueue<String> pq = new PriorityQueue<>();
		PriorityQueue<String> topAncestor = new PriorityQueue<>();
		for (Map.Entry<String, Integer> entry : in.entrySet()) {
			if (entry.getValue() == 0) {
				pq.offer(entry.getKey());
			}
		}

		while(!pq.isEmpty()) {
			String candidate = pq.poll();

			if(ancestor.get(candidate).isEmpty()) {
				topAncestor.offer(candidate);
			}

			for (String parent : ancestor.get(candidate)) {
				for (String child : directChild.get(candidate)) {
					directChild.get(parent).remove(child);
				}

				in.put(parent, in.get(parent)-1);
				if (in.get(parent) == 0) {
					pq.offer(parent);
				}
			}
		}


		StringBuilder sb = new StringBuilder();
		int size = topAncestor.size();

		sb.append(size).append("\n");

		if (size != 0) {
			while (!topAncestor.isEmpty()) {
				sb.append(topAncestor.poll()).append(" ");
			}
			sb.append("\n");
		}

		for (Map.Entry<String, Set<String>> entry : directChild.entrySet()) {
			sb.append(entry.getKey()).append(" ").append(entry.getValue().size());

			for (String child : entry.getValue()) {
				sb.append(" ").append(child);
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		ancestor = new TreeMap<>();
		directChild = new TreeMap<>();
		in = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			String key = st.nextToken();
			ancestor.put(key, new TreeSet<>());
			directChild.put(key, new TreeSet<>());
			in.put(key, 0);
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String child = st.nextToken();
			String parent = st.nextToken();

			ancestor.get(child).add(parent);
			directChild.get(parent).add(child);
			in.put(parent, in.get(parent) + 1);
		}
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		ArrayDeque<Integer> q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] A = new int[N+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= L; i++) {
			A[i] = Integer.parseInt(st.nextToken());

			while (!q.isEmpty() && A[i] <= A[q.peekLast()]) {
				q.pollLast();
			}

			q.offer(i);
			sb.append(A[q.peekFirst()]).append(" ");
		}

		for (int i = L + 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());

			if (!q.isEmpty() && q.peekFirst() <= i - L) {
				q.pollFirst();
			}

			while (!q.isEmpty() && A[i] <= A[q.peekLast()]) {
				q.pollLast();
			}

			q.offer(i);
			sb.append(A[q.peekFirst()]).append(" ");
		}

		System.out.println(sb);
	}
}

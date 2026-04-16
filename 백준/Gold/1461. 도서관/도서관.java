import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static StringTokenizer st;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> {
			return o2-o1;
		});
		PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> {
			return o2-o1;
		});

		int best = 0;
		boolean isLeft = false;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int pos = Integer.parseInt(st.nextToken());
			int abs = Math.abs(pos);

			if (abs > best) {
				isLeft = pos < 0;
				best = abs;
			}

			if (pos < 0) left.add(abs);
			else right.add(abs);
		}


		int answer = 0;
		if (isLeft) {
			answer += moveOneWay(left);
		}
		else {
			answer += moveOneWay(right);
		}

		answer += moveRound(left);
		answer += moveRound(right);

		System.out.println(answer);
	}

	private static int moveOneWay(PriorityQueue<Integer> q) {
		int dist = q.poll();

		int size = q.size();
		int count = Math.min(size, M-1);

		while(count-- > 0) {
			q.poll();
		}

		return dist;
	}

	private static int moveRound(PriorityQueue<Integer> q) {
		int dist = 0;
		while (!q.isEmpty()) {
			dist += (q.poll() * 2);
			int size = q.size();
			int count = Math.min(size, M-1);

			while(count-- > 0) {
				q.poll();
			}
		}

		return dist;
	}
}

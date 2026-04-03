import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Problem implements Comparable<Problem> {
	int deadline;
	int reward;

	public Problem (int deadline, int reward) {
		this.deadline = deadline;
		this.reward = reward;
	}

	@Override
	public int compareTo(Problem o) {
		return o.deadline - this.deadline;
	}
}

public class Main {
	static StringTokenizer st;
	static PriorityQueue<Problem> basePq;
	static int N;
	public static void main(String[] args) throws IOException {
		init();
		System.out.println(greedy());
	}

	static long greedy() {
		long total = 0;
		PriorityQueue<Integer> comparePq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int currentDeadLine = N; currentDeadLine >= 1; currentDeadLine--) {
			while (!basePq.isEmpty()) {
				if (basePq.peek().deadline < currentDeadLine) break;
				comparePq.offer(basePq.poll().reward);
			}

			if (!comparePq.isEmpty()) total += comparePq.poll();
		}

		return total;
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		basePq = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			basePq.offer(new Problem(d, r));
		}
	}
}

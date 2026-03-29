import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] count = new int[M];

		int N = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			count[i] = Integer.parseInt(st.nextToken());
			N += count[i];
		}

		int K = Integer.parseInt(br.readLine());

		double answer = 0;

		for (int i = 0; i < M; i++) {
			if (count[i] >= K) {
				answer += addPercentage(N, count[i], K);
			}
		}

		System.out.println(answer);
	}

	private static double addPercentage(int n, int count, int k) {
		double percentage = 1;
		while (k-- > 0) {
			percentage *= (double)count / n;
			count--;
			n--;
		}
		return percentage;
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();

		boolean[] case1 = new boolean[N];
		boolean[] case2 = new boolean[N];
		boolean[] result = new boolean[N];

		for (int i = 0; i < N; i++) {
			case1[i] = a[i] == '1';
			case2[i] = a[i] == '1';
			result[i] = b[i] == '1';
		}

		switchOn(0, case2);

		if (N == 2) {
			if (case1[0] == result[0] && case1[1] == result[1]) {
				System.out.println(0);
			}
			else if (case2[0] == result[0] && case2[1] == result[1]) {
				System.out.println(1);
			}
			else {
				System.out.println(-1);
			}
		}
		else {
			int count1 = 0;
			int count2 = 1;

			for (int i = 1; i < N-1; i++) {
				if (case1[i-1] != result[i-1]) {
					switchOn(i, case1);
					++count1;
				}

				if (case2[i-1] != result[i-1]) {
					switchOn(i, case2);
					++count2;
				}
			}

			if (case1[N-2] != result[N-2]) {
				switchOn(N-1, case1);
				++count1;
			}
			if (case2[N-2] != result[N-2]) {
				switchOn(N-1, case2);
				++count2;
			}
			if (case1[N-2] == result[N-2] && case1[N-1] == result[N-1]) {
				System.out.println(count1);
			}
			else if (case2[N-2] == result[N-2] && case2[N-1] == result[N-1]) {
				System.out.println(count2);
			}
			else {
				System.out.println(-1);
			}
		}
	}

	static void switchOn(int i, boolean[] current) {
		for (int j = i - 1; j <= i + 1; j++) {
			if (j >= 0 && j < N) {
				current[j] = !current[j];
			}
		}
	}
}

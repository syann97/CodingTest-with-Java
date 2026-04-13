import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	static String S;
	static String P;
	static int N;
	static int M;
	public static void main(String[] args) throws Exception {
		init();
		greedy();
	}

	static void greedy() {
		if (N == 1) System.out.println(M);
		else {
			int index = 0;
			int count = 0;
			
			while (index < M) {
				int max = 0;

				for (int i = 0; i < N; i++) {
					int stack = 0;
					while (i + stack < N && index + stack < M) {
						if (S.charAt(i + stack) == P.charAt(index + stack)) {
							stack++;
						}
						else {
							break;
						}
					}

					max = Math.max(max, stack);
				}

				index += max;
				count++;
			}
			System.out.println(count);
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		P = br.readLine();

		N = S.length();
		M = P.length();
	}
}

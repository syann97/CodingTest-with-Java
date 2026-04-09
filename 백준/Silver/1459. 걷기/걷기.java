import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int low = Math.min(X, Y);
		int high = Math.max(X, Y);
		
		long answer = (long)low * Math.min(W * 2, S);

		if ((high - low) % 2 == 1) {
			answer += (long)(high - low - 1) * Math.min(W, S) + W;
		}
		else {
			answer += (long)(high - low) * Math.min(W, S);
		}

		System.out.println(answer);
	}
}

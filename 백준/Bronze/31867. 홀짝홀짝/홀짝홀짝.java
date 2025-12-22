import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[] digits = br.readLine().toCharArray();

		int even = 0;

		for (int i = 0; i < N; i++) {
			if ((digits[i] - 48) % 2 == 0) even++;
		}

		int odd = N - even;

		System.out.println(even > odd ? "0" : even < odd ? "1" : "-1");
    }
}

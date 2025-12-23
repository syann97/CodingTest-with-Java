import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int STR = Integer.parseInt(st.nextToken());
		int DEX = Integer.parseInt(st.nextToken());
		int INT = Integer.parseInt(st.nextToken());
		int LUK = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken()) * 4;

		int total = STR + DEX + INT + LUK;

		System.out.println(N <= total ? 0 : N - total);

    }
}

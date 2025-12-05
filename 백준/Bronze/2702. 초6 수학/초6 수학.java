import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = gcd(a, b);
            sb.append(lcm(a * b, gcd)).append(" ").append(gcd).append("\n");
        }
        System.out.println(sb);

    }

    static int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int lcm (int a, int b) {
        return a / b;
    }
}

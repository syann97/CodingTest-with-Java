import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long S = Long.parseLong(st.nextToken());

        long c1 = S * (M + 1) * (100 - N) / 100;
        long c2 = S * M;

        System.out.println(Math.min(c1, c2));
    }
}

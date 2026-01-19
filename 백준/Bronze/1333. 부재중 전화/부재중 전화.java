import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] time = new boolean[N * (L + 5) + 1];


        int idx = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(time, idx, idx + L, true);
            idx += L + 5;
        }

        int t = 0;
        while (true) {
            if (t < time.length - 1) {
                if (!time[t]) break;
            }
            else break;

            t += D;
        }

        System.out.println(t);
    }
}

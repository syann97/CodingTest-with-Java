import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] W = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(W);

        System.out.println(greedy(W));
    }

    
    static long greedy (int[] W) {
        long S = 0;

        for (int w : W) {
            if (w > S + 1) break;
            S += w;
        }

        return S + 1;
    }
}

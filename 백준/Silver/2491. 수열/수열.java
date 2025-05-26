import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] lower = new int[N];
        int[] bigger = new int[N];

        Arrays.fill(lower, 1);
        Arrays.fill(bigger, 1);

        int max = 1;
        st = new StringTokenizer(br.readLine());
        A[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if (A[i] <= A[i-1]) lower[i] = lower[i-1] + 1;
            if (A[i] >= A[i-1]) bigger[i] = bigger[i-1] + 1;

            max = Math.max(max, lower[i]);
            max = Math.max(max, bigger[i]);
        }
        System.out.println(max);
    }
}


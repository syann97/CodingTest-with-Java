import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] A = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        int count = 0;

        for (int i = 0; i < N; i++) {
            long target = A[i];
            int s = 0;
            int e = N-1;

            while (s < e) {
                if (s == i || e == i) {
                    if (s == i) s++;
                    else e--;
                    continue;
                }
                
                long tmp = A[s] + A[e];
                if (tmp == target) {
                    count++;
                    break;
                }
                else if (tmp < target) s++;
                else e--;
            }
        }
        System.out.println(count);
    }
}
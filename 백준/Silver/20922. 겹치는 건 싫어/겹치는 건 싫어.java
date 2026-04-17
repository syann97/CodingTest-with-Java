import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int[] count = new int[100001];

        int answer = 0;
        while (s < N && e < N) {
            if (++count[a[e]] > K) {
                while (count[a[e]] > K) {
                    count[a[s++]]--;
                }
            }
            e++;
            answer = Math.max(answer, e-s);
        }

        System.out.println(answer);
    }
}
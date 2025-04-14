import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = N-1;
        int count = 0;
        Arrays.sort(arr);

        while (s < e) {
            int tmp = arr[s] + arr[e];
            if (tmp == M) {
                count++;
                s++;
                e--;
            }
            else {
                if (tmp < M) {
                    s++;
                }
                else {
                    e--;
                }
            }
        }
        System.out.println(count);
    }
}
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


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(0, N-1, num, A)).append("\n");
        }
        System.out.println(sb);
    }

    static int binarySearch(int s, int e, int target, int[] A) {
        while (s <= e) {
            int m = (s + e) >> 1;

            if (A[m] == target) return 1;
            if (A[m] > target) {
                e = m - 1;
            }
            else {
                s = m + 1;
            }
        }
        return 0;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] A = new int[5];
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                A[Integer.parseInt(st.nextToken())]++;
            }

            int[] B = new int[5];
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                B[Integer.parseInt(st.nextToken())]++;
            }

            boolean isDraw = true;
            for (int j = 4; j >= 1; j--) {
                if (A[j] == B[j]) continue;

                if (A[j] > B[j]) sb.append("A");
                else sb.append("B");
                isDraw = false;
                sb.append("\n");
                break;
            }
            if (isDraw) sb.append("D").append("\n");
        }
        System.out.print(sb);
    }
}
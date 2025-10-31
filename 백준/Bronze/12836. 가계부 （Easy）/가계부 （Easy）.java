import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[] amount = new long[N + 1];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int p = Integer.parseInt(st.nextToken());
                long x = Long.parseLong(st.nextToken());

                amount[p] += x;
            }

            if (op == 2) {
                int p = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                long tmp = 0;
                for (int j = p; j <= q; j++) {
                    tmp += amount[j];
                }
                sb.append(tmp).append("\n");
            }
        }
        System.out.print(sb);
    }
}
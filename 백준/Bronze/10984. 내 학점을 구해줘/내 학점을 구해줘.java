import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            int credit = 0;
            float grade = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                credit += n;
                grade += Float.parseFloat(st.nextToken()) * n;
            }
            sb.append(credit).append(" ").append(String.format("%.1f", (grade/credit))).append("\n");
        }
        System.out.print(sb);
    }
}
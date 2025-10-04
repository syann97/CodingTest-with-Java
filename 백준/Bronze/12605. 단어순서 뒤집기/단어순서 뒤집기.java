import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= N; test_case++) {
            String[] s = br.readLine().split(" ");
            sb.append("Case #").append(test_case).append(": ");

            for (int i = s.length - 1; i >= 0; i--) {
                sb.append(s[i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
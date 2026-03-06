import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        sb.append("int a;").append("\n").append("int *ptr = &a;").append("\n");

        for (int t = 2; t <= N; t++) {
            sb.append("int ");

            for (int j = 0; j < t; j++) {
                sb.append("*");
            }

            sb.append("ptr").append(t).append(" = ").append("&ptr").append(t == 2 ? "" : t - 1).append(";\n");
        }

        System.out.print(sb);
    }
}

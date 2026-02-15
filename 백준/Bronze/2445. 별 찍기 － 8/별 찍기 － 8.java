import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 2*N-1; i++) {
            for (int j = 0; j < 2*N; j++) {
                if (i < N) {
                    if (j <= i || j >= 2*N-1-i) {
                        sb.append("*");
                    }
                    else {
                        sb.append(" ");
                    }
                }
                else {
                    if (j <= 2*(N-1)-i || j >= i+1) {
                        sb.append("*");
                    }
                    else {
                        sb.append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

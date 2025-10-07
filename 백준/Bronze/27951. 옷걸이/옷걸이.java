import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] hanger = new int[N];
        int U = 0;
        int D = 0;


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hanger[i] = Integer.parseInt(st.nextToken());
            if (hanger[i] == 1) U++;
            else if (hanger[i] == 2) D++;
        }

        st = new StringTokenizer(br.readLine());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int up_rest = up - U;
        int down_rest = down - D;
        if (up_rest < 0 || down_rest < 0) {
            sb.append("NO");
        }
        else {
            sb.append("YES").append("\n");
            for (int i = 0; i < N; i++) {
                if (hanger[i] == 1) sb.append("U");
                else if (hanger[i] == 2) sb.append("D");
                else {
                    if (up_rest > 0) {
                        sb.append("U");
                        up_rest--;
                    }
                    else {
                        sb.append("D");
                        down_rest--;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            long S = Long.parseLong(st.nextToken());
            long P = Long.parseLong(st.nextToken());

            long s = 1;
            long e = S / 2;
            boolean flag = false;

            while (s <= e) {
                long m = (s + e) / 2;
                long n = S - m;

                if (m > 0 && n > P / m) { 
                    e = m - 1; // 너무 크므로 범위를 줄임
                }
                else {
                    if (m * n == P) {
                    flag = true;
                    break;
                }
                else if (m * n < P) {
                    s = m + 1;
                }
                else {
                    e = m - 1;
                }
                }    
            }

            sb.append(flag ? "Yes" : "No").append("\n");
        }

        System.out.print(sb);
    }
}

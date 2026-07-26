import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            int answer = 0;
            boolean[] visited = new boolean[10];

            do {
                answer += N;
                int tmp = answer;

                while (tmp > 0) {
                    int n = tmp % 10;

                    if (!visited[n]) {
                        visited[n] = true;
                        count++;
                    }
                    tmp /= 10;
                }
            } while (count < 10);

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
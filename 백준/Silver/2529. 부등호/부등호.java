import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int answer = 0;
    static boolean flag;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        sb = new StringBuilder();

        char[] operations = s.replace(" ", "").toCharArray();
        int[] answer = new int[N+1];

        flag = false;
        for (int i = 9; i >= 0; i--) {
            if (flag) break;
            answer[0] = i;
            boolean[] visited = new boolean[10];
            visited[i] = true;
            bt(0, N, true, operations, answer, visited);
        }
        sb.append("\n");

        flag = false;
        for (int i = 0; i <= 9; i++) {
            if (flag) break;
            answer[0] = i;
            boolean[] visited = new boolean[10];
            visited[i] = true;
            bt(0, N, false, operations, answer, visited);
        }

        System.out.println(sb);
    }


    static void bt(int idx, int N, boolean isReverse, char[] operations, int[] answer, boolean[] visited) {
        if (idx == N) {
            for (int i = 0; i <= N; i++) {
                sb.append(answer[i]);
            }
            flag = true;
            return;
        }

        int target = answer[idx];
        if (!isReverse) {
            for (int num = 0; num <= 9; num++) {
                if (!visited[num]) {
                    if ((operations[idx] == '<' && target < num) || (operations[idx] == '>' && target > num)) {
                        if (flag) return;
                        answer[idx+1] = num;
                        visited[num] = true;
                        bt(idx+1, N, isReverse, operations, answer, visited);
                        visited[num] = false;
                    }
                }
            }
        }
        else {
            for (int num = 9; num >= 0; num--) {
                if (!visited[num]) {
                    if ((operations[idx] == '<' && target < num) || (operations[idx] == '>' && target > num)) {
                        if (flag) return;
                        answer[idx+1] = num;
                        visited[num] = true;
                        bt(idx+1, N, isReverse, operations, answer, visited);
                        visited[num] = false;
                    }
                }
            }
        }
    }
}
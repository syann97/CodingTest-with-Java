import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        sb = new StringBuilder();

        char[] operations = s.replace(" ", "").toCharArray();
        int[] answer = new int[N+1];
        boolean[] visited;

        for (int i = 9; i >= 0; i--) {
            visited = new boolean[10];
            visited[i] = true;
            answer[0] = i;

            if(bt(0, N, true, operations, answer, visited)) break;
        }
        sb.append("\n");

        for (int i = 0; i <= 9; i++) {
            visited = new boolean[10];
            visited[i] = true;
            answer[0] = i;

            if (bt(0, N, false, operations, answer, visited)) break;
        }

        System.out.println(sb);
    }


    static boolean bt(int idx, int N, boolean isReverse, char[] operations, int[] answer, boolean[] visited) {
        if (idx == N) {
            for (int i = 0; i <= N; i++) {
                sb.append(answer[i]);
            }
            return true;
        }

        int target = answer[idx];
        if (!isReverse) {
            for (int num = 0; num <= 9; num++) {
                if (!visited[num]) {
                    if ((operations[idx] == '<' && target < num) || (operations[idx] == '>' && target > num)) {
                        answer[idx+1] = num;
                        visited[num] = true;
                        if (bt(idx+1, N, isReverse, operations, answer, visited)) return true;
                        visited[num] = false;
                    }
                }
            }
        }
        else {
            for (int num = 9; num >= 0; num--) {
                if (!visited[num]) {
                    if ((operations[idx] == '<' && target < num) || (operations[idx] == '>' && target > num)) {
                        answer[idx+1] = num;
                        visited[num] = true;
                        if (bt(idx+1, N, isReverse, operations, answer, visited)) return true;
                        visited[num] = false;
                    }
                }
            }
        }
        return false;
    }
}
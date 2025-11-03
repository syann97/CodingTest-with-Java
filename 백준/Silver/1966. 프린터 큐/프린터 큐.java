import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class IdxNumber {
    int idx;
    int num;

    public IdxNumber (int idx, int num) {
        this.idx = idx;
        this.num = num;
    }
}


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<IdxNumber> q = new ArrayDeque<>();
            int[] counting = new int[10];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                counting[num]++;
                q.offer(new IdxNumber(j, num));
            }

            int target = 9;
            int cnt = 0;
            boolean flag = false;
            while (!q.isEmpty()) {
                while (counting[target] == 0) target--;

                while (!q.isEmpty()) {
                    IdxNumber idxNumber = q.poll();
                    int idx = idxNumber.idx;
                    int num = idxNumber.num;

                    if (num == target) {
                        cnt++;
                        counting[target]--;
                        if (idx == M) flag = true;
                        break;
                    }
                    q.offer(new IdxNumber(idx, num));
                }

                if (flag) {
                    System.out.println(cnt);
                    break;
                }
            }
        }
    }
}
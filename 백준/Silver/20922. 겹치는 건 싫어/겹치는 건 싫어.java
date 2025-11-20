import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int max = 1;

        int[] counting = new int[100001];

        while (start <= end) {
            int num = arr[end];
            if (counting[num] == K) {
                while (true) {
                    int target = arr[start];
                    if (target == num) {
                        start++;
                        break;
                    }
                    counting[target]--;
                    start++;
                }
            }
            else {
                counting[num]++;
                max = Math.max(max, end - start + 1);
            }

            end++;

            if (end == N) break;
        }

        System.out.println(max);
    }
}
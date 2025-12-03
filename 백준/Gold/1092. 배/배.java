import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] cranes = new Integer[N];

        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] boxes = new Integer[M];
        boolean[] visited = new boolean[M];

        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cranes, Collections.reverseOrder());
        Arrays.sort(boxes, Collections.reverseOrder());

        int time = 0;
        int count = 0;
        int index = 0;
        while (true) {
            time++;

            boolean isMoved = false;
            for (int crane : cranes) {
                for (int i = index; i < M; i++) {
                    if (visited[i]) continue;
                    if (crane >= boxes[i]) {
                        if (!isMoved) {
                            isMoved = true;
                            index = i + 1;
                        }
                        visited[i] = true;
                        count++;
                        break;
                    }
                }
            }

            if (!isMoved || count == M) {
                break;
            }
        }

        System.out.println(count == M ? time : -1);
    }
}

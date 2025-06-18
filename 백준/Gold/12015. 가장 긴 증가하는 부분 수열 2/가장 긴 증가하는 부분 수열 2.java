import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> LIS = new ArrayList<>();
        LIS.add(0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num > LIS.get(LIS.size() - 1)) {
                LIS.add(num);
            } else {
                int idx = binarySearch(1, LIS.size() - 1, LIS, num);
                LIS.set(idx, num);
            }
        }

        System.out.println(LIS.size() - 1);
    }

    static int binarySearch(int s, int e, List<Integer> LIS, int target) {
        while (s <= e) {
            int m = (s + e) / 2;

            if (LIS.get(m) < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return s;
    }
}

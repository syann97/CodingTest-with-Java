import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int count = 0;
            int building = buildings[i];

            // 왼쪽
            for (int j = i-1; j >= 0; j--) {
                if (isVisible(buildings[j], building, j, i, buildings)) count++;
            }

            // 오른쪽
            for (int j = i+1; j < N; j++) {
                if (isVisible(building, buildings[j], i, j, buildings)) count++;
            }

            // 갱신
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    static boolean isVisible(int y1, int y2, int x1, int x2, int[] buildings) {
        double m = (double) (y2 - y1) / (x2 - x1);

        for (int i = x1 + 1; i < x2; i++) {
            double pos = y1 + m * (i - x1);
            if (buildings[i] >= pos) return false;
        }

        return true;
    }
}
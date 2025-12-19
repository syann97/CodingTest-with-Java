import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int one = 50;
        int[] cube = new int[6];
        for (int i = 0; i < 6; i++) {
            cube[i] = Integer.parseInt(st.nextToken());
            one = Math.min(one, cube[i]);
        }

        int five = getMinFiveSurface(cube);
        int three = getMinThreeSurface(cube);
        int two = getMinTwoSurface(cube);


        long answer = 0;
        if (N == 1) answer += five;
        else {
            answer += three * 4 + two * 4;
            if (N > 2) {
                long range = N - 2;
                answer += two * range * 8;
                answer += one * range * range * 5;
                answer += one * range * 4;
            }
        }

        System.out.println(answer);
    }

    static int getMinFiveSurface(int[] cube) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            max = Math.max(max, cube[i]);
            sum += cube[i];
        }

        return sum - max;
    }

    static int getMinThreeSurface(int[] cube) {
        int min = 150;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (j == 5 - i) continue;
                for (int k = j + 1; k < 6; k++) {
                    if (k == 5 - i || k == 5 - j) continue;
                    min = Math.min(min, cube[i] + cube[j] + cube[k]);
                }
            }
        }

        return min;
    }

    static int getMinTwoSurface(int[] cube) {
        int min = 100;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (j == 5 - i) continue;
                min = Math.min(min, cube[i] + cube[j]);
            }
        }

        return min;
    }
}

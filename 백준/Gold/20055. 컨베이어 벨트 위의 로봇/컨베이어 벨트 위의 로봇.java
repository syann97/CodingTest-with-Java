import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int K;
    static int L = 0;
    static int S = 0;
    static int length;
    static int[] belt;
    static boolean[] robot;


    public static void main(String[] args) throws IOException {
        // init
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        length = N * 2;
        belt = new int[length];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while (K > 0) {
            // 1. rotateBelt
            rotateBelt();

            // 2. move Robot
            moveRobot();

            // 3. setRobot
            setRobot();
            L++;
        }
        System.out.println(L);
    }

    static void rotateBelt() {
        S = S == 0 ? length - 1 : S - 1;
        if (robot[N-2]) robot[N-2] = false;
        for (int i = N-3; i >= 0; i--) {
            if (robot[i]) {
                robot[i] = false;
                robot[i + 1] = true;
            }
        }
    }

    static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            int next = (S + i + 1) % length;
            if (robot[i] && !robot[i+1] && belt[next] > 0) {
                robot[i] = false;
                if (i < N - 2) robot[i + 1] = true;
                belt[next]--;
                if (belt[next] == 0) K--;
            }
        }
    }

    static void setRobot() {
        if (belt[S] != 0) {
            belt[S]--;
            if (belt[S] == 0) K--;
            robot[0] = true;
        }
    }
}
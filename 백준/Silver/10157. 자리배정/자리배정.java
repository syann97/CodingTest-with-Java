import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Quest {
    int STR;
    int INT;
    int POINT;

    public Quest(int STR, int INT, int POINT) {
        this.STR = STR;
        this.INT = INT;
        this.POINT = POINT;
    }
}

public class Main {
    static StringTokenizer st;
    static int R;
    static int C;
    static int K;
    static int X;
    static int Y;
    static boolean flag = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        X = 0;
        Y = 0;

        if (K > R * C) System.out.println(0);
        else {
            bf(1, 0, C, R, K, 0);
            System.out.println(X + " " + Y);
        }
    }


    static void bf(int x, int y, int c, int r, int k, int d) {
        if (flag) {
            return;
        }

        if (d == 0) {
            if (k <= r) {
                X = x;
                Y = y + k;
                flag = true;
            } else {
                bf(x, y + r, c - 1, r, k - r, 1);
            }
        }

        else if (d == 1) {
            if (k <= c) {
                X = x + k;
                Y = y;
                flag = true;
            } else {
                bf(x + c, y, c, r - 1, k - c, 2);
            }
        }


        else if (d == 2) {
            if (k <= r) {
                X = x;
                Y = y - k;
                flag = true;
            } else {
                bf(x, y - r, c - 1, r, k - r, 3);
            }
        }

        else {
            if (k <= c) {
                X = x - k;
                Y = y;
                flag = true;
            } else {
                bf(x - c, y, c, r - 1, k - c, 0);
            }
        }
    }
}
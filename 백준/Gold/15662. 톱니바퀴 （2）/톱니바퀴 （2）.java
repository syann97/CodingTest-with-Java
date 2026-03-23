import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static int start = 0;
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int[] cogwheels = new int[T];

        for (int i = 0; i < T; i++) {
            cogwheels[i] = parseDecimal(br.readLine());
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            rotateCogwheels(cogwheels, findRotateCogwheels(cogwheels, number, dir));
        }

        System.out.println(getCount(cogwheels));
    }

    static int getCount(int[] cogwheels) {
        int count = 0;
        for (int i = 0; i < T; i++) {
            if ((cogwheels[i] & 1) != 0) {
                count++;
            }
        }
        return count;
    }

    static void rotateCogwheels(int[] cogwheels, int[] isRotate) {
        for (int i = start; i < T; i++) {
            if (isRotate[i] == 0) break;

            int tmp = cogwheels[i];

            if (isRotate[i] == 1) {
                tmp <<= 1;
                if (((tmp & 256) != 0)) {
                    tmp -= 255;
                }
            }
            else {
                if (((tmp & 1) != 0)) {
                    tmp += 256;
                }
                tmp >>= 1;
            }

            cogwheels[i] = tmp;
        }
    }

    static int[] findRotateCogwheels(int[] cogwheels, int number, int dir) {
        int base = number;

        int[] isRotate = new int[T];
        isRotate[base] = dir;

        start = 0;

        while (--base >= 0) {
            if ((((cogwheels[base] & 4) != 0) ^ ((cogwheels[base+1] & 64) != 0))) {
                isRotate[base] = isRotate[base+1] == 1 ? -1 : 1;
            } else {
                start = base + 1;
                break;
            }
        }

        if (start < 0) start = 0;
        base = number;

        while (++base < T) {
            if ((((cogwheels[base] & 64) != 0) ^ ((cogwheels[base-1] & 4) != 0))) {
                isRotate[base] = isRotate[base-1] == 1 ? -1 : 1;
            } else {
                break;
            }
        }

        return isRotate;
    }

    static int parseDecimal(String s) {
        int decimal = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                decimal += 1;
            }

            if (i != 0) decimal <<= 1;
        }

        return decimal;
    }
}

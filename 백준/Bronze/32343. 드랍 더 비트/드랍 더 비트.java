import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bf(N, a, b, new StringBuilder(), new StringBuilder());
        System.out.println(answer);
    }

    static void bf(int digit, int a, int b, StringBuilder strX, StringBuilder strY) {
        if (digit < a || digit < b) return;
        if (digit == 0) {
            int x = Integer.parseInt(strX.toString(), 2);
            int y = Integer.parseInt(strY.toString(), 2);

            answer = Math.max(answer, x ^ y);

            return;
        }

        if (a > 0 && b > 0) {
            strX.append(1);
            strY.append(1);
            bf(digit - 1, a - 1, b - 1, strX, strY);
            strX.setLength(strX.length() - 1);
            strY.setLength(strY.length() - 1);
        }
        if (a > 0) {
            strX.append(1);
            strY.append(0);
            bf(digit - 1, a - 1, b, strX, strY);
            strX.setLength(strX.length() - 1);
            strY.setLength(strY.length() - 1);
        }

        if (b > 0) {
            strX.append(0);
            strY.append(1);
            bf(digit - 1, a, b - 1, strX, strY);
            strX.setLength(strX.length() - 1);
            strY.setLength(strY.length() - 1);
        }

        strX.append(0);
        strY.append(0);
        bf(digit - 1, a, b, strX, strY);
        strX.setLength(strX.length() - 1);
        strY.setLength(strY.length() - 1);
    }
}
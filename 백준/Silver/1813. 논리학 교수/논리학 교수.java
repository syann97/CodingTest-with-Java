import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numberCount = new int[51];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numberCount[num]++;
        }

        int i = 50;
        boolean flag = false;
        while (i >= 0) {
            if (numberCount[i] == i) {
                flag = true;
                break;
            }
            i--;
        }

        System.out.println(flag ? i : -1);
    }
}
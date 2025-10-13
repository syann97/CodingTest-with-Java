import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int EXP = 25000;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        EXP -= Integer.parseInt(br.readLine()) * 100;

        int answer = 0;
        boolean isMaxLv = false;

        int max = C * 30;
        while (V > 0) {
            if (EXP <= max) {
                answer += EXP % C == 0 ? EXP / C : EXP / C + 1;
                isMaxLv = true;
                break;
            }
            EXP -= max;
            answer += 30;
            V--;
        }

        max = B * 30;
        if (!isMaxLv) {
            while (S > 0) {
                if (EXP <= max) {
                    answer += EXP % B == 0 ? EXP / B : EXP / B + 1;
                    isMaxLv = true;
                    break;
                }
                EXP -= max;
                answer += 30;
                S--;
            }

            if (!isMaxLv) {
                answer += EXP % A == 0 ? EXP / A : EXP / A + 1;
            }
        }
        System.out.print(answer);
    }
}

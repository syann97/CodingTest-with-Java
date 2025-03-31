import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] woods = new int[5];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = {1, 2, 3, 4, 5};

        for (int i = 0; i < 5; i++) woods[i] = Integer.parseInt(st.nextToken());
        while (!Arrays.equals(answer, woods)) logic();
        System.out.println(sb);
    }


    static void logic() {
        for (int i = 0; i < 4; i++) {
            if (woods[i] > woods[i+1]) {
                int tmp = woods[i];
                woods[i] = woods[i+1];
                woods[i+1] = tmp;
                print();
            }
        }
    }

    static void print() {
        for (int i = 0; i < 5; i++) {
            sb.append(woods[i]).append(" ");
        }
        sb.append('\n');
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        int tmpA = Integer.parseInt(st.nextToken());
        int tmpB = Integer.parseInt(st.nextToken());
        int a = 100 - tmpA;
        int b = 100 - tmpB;
        int c = 100 - (a + b);
        int d = a * b;
        int q = d / 100;
        int r = d % 100;

        int answer = tmpA * tmpB;
        int front = answer / 100;
        int back = answer % 100;

        sb.append(a + " " + b + " " + c + " " + d + " " + q + " " + r).append("\n").append(String.format("%d %d\n", front, back));
        System.out.println(sb);
    }
}

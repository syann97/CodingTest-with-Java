import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < X; i++) sb1.append("1");
        for (int i = 0; i < Y; i++) sb2.append("1");

        int num1 = Integer.parseInt(sb1.toString());
        int num2 = Integer.parseInt(sb2.toString());

        System.out.println(num1 + num2);
    }
}

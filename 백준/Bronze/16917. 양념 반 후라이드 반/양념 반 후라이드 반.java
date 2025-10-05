import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int common_count = Math.min(X, Y);
        
        int case1 = A * X + B * Y;
        int case2 = C * 2 * Math.max(X, Y);
        int case3 = (C * 2 * common_count) + (A * (X - common_count)) + (B * (Y - common_count));

        System.out.println(Math.min(case1, Math.min(case2, case3)));
    }
}
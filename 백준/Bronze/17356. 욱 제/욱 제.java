import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());

        double M = (B - A) / 400;
        
        System.out.println(1 / (1 + Math.pow(10, M)));
    }
}

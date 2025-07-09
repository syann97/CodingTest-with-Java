import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double a = Integer.parseInt(br.readLine());
        double b = 100 - a;
        
        System.out.println(String.format("%.10f", (100 / a)));
        System.out.println(String.format("%.10f", (100 / b)));
    }
}

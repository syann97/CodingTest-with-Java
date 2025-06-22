import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigDecimal bd = new BigDecimal(Math.pow(0.5, N));
        System.out.println(bd.setScale(N, RoundingMode.HALF_UP).toPlainString());
    }
}

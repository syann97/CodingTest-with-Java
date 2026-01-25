import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 3;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            BigInteger sum = BigInteger.ZERO;

            for (int i = 0; i < N; i++) {
                BigInteger temp = new BigInteger(br.readLine());
                sum = sum.add(temp);
            }

            int result = sum.compareTo(BigInteger.ZERO);

            if (result == 0) {
                System.out.println("0");
            }
            else if (result > 0) {
                System.out.println("+");
            }
            else {
                System.out.println("-");
            }
        }
    }
}
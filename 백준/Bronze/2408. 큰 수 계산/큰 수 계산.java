import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<BigInteger> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        for (int i = 0; i < 2 * N - 1; i++) {
            String input = br.readLine();
            if (i % 2 == 0) {
                numbers.add(new BigInteger(input));
            } else {
                operators.add(input.charAt(0));
            }
        }

        for (int i = 0; i < operators.size(); ) {
            char op = operators.get(i);
            if (op == '*' || op == '/') {
                BigInteger left = numbers.get(i);
                BigInteger right = numbers.get(i + 1);
                BigInteger result;

                if (op == '*') {
                    result = left.multiply(right);
                } else {
                    result = floorDivide(left, right);
                }

                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
            } else {
                i++;
            }
        }

        BigInteger finalResult = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            char op = operators.get(i);
            BigInteger nextNum = numbers.get(i + 1);
            if (op == '+') {
                finalResult = finalResult.add(nextNum);
            } else {
                finalResult = finalResult.subtract(nextNum);
            }
        }

        System.out.println(finalResult);
    }

    private static BigInteger floorDivide(BigInteger a, BigInteger b) {
        BigInteger[] dr = a.divideAndRemainder(b);
        BigInteger quotient = dr[0];
        BigInteger remainder = dr[1];

        if (remainder.signum() != 0 && (a.signum() != b.signum())) {
            return quotient.subtract(BigInteger.ONE);
        }
        return quotient;
    }
}
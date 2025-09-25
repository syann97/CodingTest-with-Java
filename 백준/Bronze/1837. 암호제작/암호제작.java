import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger P = new BigInteger(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(decode(P, K));
    }

    static boolean isPrime(BigInteger x) {
        return x.isProbablePrime(100);
    }

    static String decode(BigInteger P, int K) {
        BigInteger bigK = BigInteger.valueOf(K);

        for (BigInteger small = new BigInteger("2"); small.compareTo(bigK) < 0; small = small.add(BigInteger.ONE)) {
            if (P.mod(small).equals(BigInteger.ZERO)) {
                if (isPrime(small)) {
                    return "BAD " + small;
                }
            }
        }
        return "GOOD";
    }
}
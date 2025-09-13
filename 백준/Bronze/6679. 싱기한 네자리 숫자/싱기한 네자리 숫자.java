import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        int num;
        for (int i = 1000; i < 10000; i++) {
            num = i;
            int sumSixteenRadix = 0;
            while (num > 0) {
                sumSixteenRadix += num % 16;
                num /= 16;
            }

            num = i;
            int sumTwelveRadix = 0;
            while (num > 0) {
                sumTwelveRadix += num % 12;
                num /= 12;
            }

            num = i;
            int sumTenRadix = 0;
            while (num > 0) {
                sumTenRadix += num % 10;
                num /= 10;
            }

            if (sumTenRadix == sumTwelveRadix && sumTwelveRadix == sumSixteenRadix) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}

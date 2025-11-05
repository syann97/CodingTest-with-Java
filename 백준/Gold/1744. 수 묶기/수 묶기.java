import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2개씩 짝을 찾아간다
        // 1. 기본적으로 곱셈은 양수끼리 혹은 음수끼리 수행
        // 2. 정렬을 통해 양수는 가장 큰 두 수끼리 곱한다
        // 3. 정렬을 통해 음수는 가장 작은 두 수끼리 곱한다
        // 4. 만약 0이 존재한다면 음수가 존재할 때만 곱하고 나머지는 패싱


        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        boolean isExistZero = false;
        int positiveCount = 0;
        int negativeCount = 0;

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            if (numbers[i] > 0) positiveCount++;
            else if (numbers[i] < 0) negativeCount++;
            else isExistZero = true;
        }

        Arrays.sort(numbers);


        int start = 0;
        int end = N-1;
        int answer = 0;

        while (positiveCount >= 2) {
            int mul = numbers[end] * numbers[end-1];
            int sum = numbers[end] + numbers[end-1];
            answer += Math.max(mul, sum);
            positiveCount -= 2;
            end -= 2;
        }

        if (positiveCount == 1) answer += numbers[end];

        while (negativeCount >= 2) {
            answer += numbers[start] * numbers[start+1];
            negativeCount -= 2;
            start += 2;
        }

        if (negativeCount == 1) {
            if (!isExistZero) answer += numbers[start];
        }

        System.out.println(answer);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Change {
    int n;
    int k;

    public Change(int n, int k) {
        this.n = n;
        this.k = k;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(change(N, K));
    }

    private static String change(int number, int maxK) {
        String s = String.valueOf(number);
        int L = s.length();
        int[] numbers = new int[L];
        int maxNumber = (int) Math.pow(10, L);

        if (L == 1 || (L == 2 && s.charAt(1) == '0')) {
            return "-1";
        }

        if (L == 7) {
            return "1000000";
        }

        boolean[][] visited = new boolean[maxK +1][maxNumber];
        Queue<Change> q = new ArrayDeque<>();

        visited[maxK][number] = true;
        q.offer(new Change(number, maxK));

        int max = 0;

        while (!q.isEmpty()) {
            Change change = q.poll();
            int n = change.n;
            int k = change.k;

            if (k == 0) {
                max = Math.max(max, n);
                continue;
            }

            setNumbers(numbers, n, L);

            for (int i = 0; i < L - 1; i++) {
                for (int j = i + 1; j < L; j++) {
                    if (i == 0 && numbers[j] == 0) continue;
                    int next = changeNumber(numbers, i, j);
                    if (!visited[k-1][next]) {
                        visited[k-1][next] = true;
                        q.offer(new Change(next, k-1));
                    }
                }
            }
        }

        return String.valueOf(max);
    }

    private static void setNumbers(int[] numbers, int n, int L) {
        int i = L - 1;

        while (n > 0) {
            numbers[i] = n % 10;
            n /= 10;
            i--;
        }
    }

    private static int changeNumber(int[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;

        int returnNumber = convertInt(numbers);

        numbers[j] = numbers[i];
        numbers[i] = tmp;

        return returnNumber;
    }


    private static int convertInt(int[] numbers) {
        int L = numbers.length;
        int mul = 1;
        int number = 0;

        for (int i = L - 1; i >= 0; i--) {
            number += numbers[i] * mul;
            mul *= 10;
        }

        return number;
    }
}

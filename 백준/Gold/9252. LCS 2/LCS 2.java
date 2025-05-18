import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 히르쉬버그 알고리즘 사용 (학습용)
public class Main {
    static String a, b;  // 두 문자열
    static StringBuilder result = new StringBuilder();  // 최종 LCS 결과를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 문자열을 1-based 인덱스를 위해 앞에 공백 추가
        // 예: " ABCDEF" 처럼 a.charAt(1) 부터 실제 문자열 첫 문자임
        a = " " + br.readLine();
        b = " " + br.readLine();

        // 전체 구간에 대해 LCS 재귀 호출
        LCS(1, a.length() - 1, 1, b.length() - 1);

        // LCS 길이 출력
        System.out.println(result.length());
        // LCS 문자열 출력
        System.out.println(result);
    }

    // a[s1..e1], b[s2..e2] 구간의 LCS를 result에 추가하는 함수
    static void LCS(int s1, int e1, int s2, int e2) {
        // 구간이 잘못된 경우 종료
        if (s1 > e1 || s2 > e2) return;

        // a 구간이 한 글자인 경우 (기저 조건)
        if (s1 == e1) {
            // b 구간 전체를 순회하며 a[s1]와 같은 문자가 있으면 결과에 추가 후 종료
            for (int i = s2; i <= e2; i++) {
                if (a.charAt(s1) == b.charAt(i)) {
                    result.append(a.charAt(s1));
                    break;
                }
            }
            return;
        }

        // a 구간을 반으로 나눔
        int mid = (s1 + e1) / 2;
        int len = e2 - s2 + 1; // b 구간 길이

        // upper, lower: 각각 a의 앞쪽 절반과 뒤쪽 절반에 대해 b와의 LCS 길이 DP 결과 저장
        // save: DP 계산 중간 저장용 배열
        int[] upper = new int[len + 2];
        int[] lower = new int[len + 2];
        int[] save = new int[len + 2];

        // 1) a[s1..mid], b[s2..e2]에 대해 LCS 길이 DP 계산 (forward 방향)
        for (int i = s1; i <= mid; i++) {
            for (int j = s2; j <= e2; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    // 문자 같으면 왼쪽 위 대각선 + 1
                    upper[j - s2 + 1] = save[j - s2] + 1;
                } else {
                    // 문자가 다르면 왼쪽 or 위쪽 중 최대값 선택
                    upper[j - s2 + 1] = Math.max(save[j - s2 + 1], upper[j - s2]);
                }
            }
            // 현재 행 결과를 저장해 다음 행에서 사용
            System.arraycopy(upper, 0, save, 0, len + 2);
        }

        // save 배열 초기화 (0으로 채움)
        Arrays.fill(save, 0);

        // 2) a[mid+1..e1], b[s2..e2]에 대해 LCS 길이 DP 계산 (backward 방향)
        for (int i = e1; i >= mid + 1; i--) {
            for (int j = e2; j >= s2; j--) {
                if (a.charAt(i) == b.charAt(j)) {
                    // 대각선 아래 + 1
                    lower[j - s2 + 1] = save[j - s2 + 2] + 1;
                } else {
                    // 오른쪽 or 아래 중 최대값
                    lower[j - s2 + 1] = Math.max(save[j - s2 + 1], lower[j - s2 + 2]);
                }
            }
            // 현재 행 결과 저장
            System.arraycopy(lower, 0, save, 0, len + 2);
        }

        // 3) 두 DP 결과를 합쳐서 분할점(분할할 b의 인덱스)을 찾음
        int mxv = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = s2 - 1; i <= e2; i++) {
            // upper[i] + lower[i+1] 값이 최대인 위치를 찾음
            int temp = upper[i - s2 + 1] + lower[i - s2 + 2];
            if (temp >= mxv) {
                mxv = temp;
                idx = i;
            }
        }

        // 4) 찾은 분할점 기준으로 재귀 호출 분할
        LCS(s1, mid, s2, idx);
        LCS(mid + 1, e1, idx + 1, e2);
    }
}

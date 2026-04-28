import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int L = 100; // 보드 크기 100x100
    static final int T = 10;  // 테스트 케이스 개수 10개

    public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
        char[][] board = new char[L][L];

        for (int t = 1; t <= T; t++) {
            String line = br.readLine();
            if (line == null) break;
            
            // 1. 테스트 케이스 번호를 입력받음 (trim으로 공백 제거)
            String tcNum = line.trim();
            if (tcNum.isEmpty()) {
                t--; 
                continue;
            }

            // 2. 100줄의 보드 데이터 입력
            for (int i = 0; i < L; i++) {
                board[i] = br.readLine().trim().toCharArray();
            }

            // 3. 정답 계산 및 결과 누적 (#번호 정답)
            sb.append("#").append(tcNum).append(" ").append(getAnswer(board)).append("\n");
        }

        // 전체 결과 한 번에 출력
        System.out.print(sb);
    }

    static int getAnswer(char[][] board) {
        int maxLen = 0;

        for (int i = 0; i < L; i++) {
            // 가로 줄 검사 (i행 고정)
            maxLen = Math.max(maxLen, findMaxPalindrome(board, i, true));
            // 세로 줄 검사 (i열 고정)
            maxLen = Math.max(maxLen, findMaxPalindrome(board, i, false));
        }

        return maxLen;
    }

    static int findMaxPalindrome(char[][] board, int index, boolean isRow) {
        int size = 1;

        for (int i = 0; i < L; i++) {
            // 1. 홀수 길이 회문 (중앙 글자 하나)
            size = Math.max(size, expand(board, index, i - 1, i + 1, 1, isRow));

            // 2. 짝수 길이 회문 (중앙 글자 두 개가 같을 때)
            if (i + 1 < L) {
                if (isRow) {
                    if (board[index][i] == board[index][i + 1]) {
                        size = Math.max(size, expand(board, index, i - 1, i + 2, 2, isRow));
                    }
                } else {
                    if (board[i][index] == board[i + 1][index]) {
                        size = Math.max(size, expand(board, index, i - 1, i + 2, 2, isRow));
                    }
                }
            }
        }
        return size;
    }

    private static int expand(char[][] board, int fix, int left, int right, int currentSize, boolean isRow) {
        while (left >= 0 && right < L) {
            if (isRow) {
                if (board[fix][left] != board[fix][right]) break;
            } else {
                if (board[left][fix] != board[right][fix]) break;
            }
            left--;
            right++;
            currentSize += 2;
        }
        return currentSize;
    }
}
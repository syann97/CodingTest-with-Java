import java.util.*;

class Solution {
    static int N;
    static int[] info;
    static int max;
    static int[] answer;
    public int[] solution(int n, int[] apeach) {
        max = -1;
        N = n;
        info = apeach;
        answer = new int[11];
        
        // 어피치가 화살 n발 선으로 
        // 이후 라이언이 n발
        // 과녁판 -> 양궁판과 동일 바깥 = 0
        
        // 제약 조건
        // k점을 a발 , b발 맞춘 경우 더 많이 맞힌 선수 k점
        // a == b 일 경우 어피치 (선으로 쏜 친구)
        // 둘 다 0발 -> 무득점
        
        // 각 선 수 최종 점수 계산
        // 최종 점수 높으면 우승자 -> 이것도 같은 경우 (어피치 우승)
        
        
        // 라이언이 쏜 상황
        // 무조건 비기는 상황 없어야됨 최종적으로 하나라도 이겨야 함
        
        // 문제 정의 최종 승리
        // n 판 중 n/2+1판 이겨야 함
        dfs(0, n, 0, new int[11]);
        
        for (int i = 0; i <= 10; i++) {
            if (answer[i] != 0) {
                return answer;
            }
        }
        
        return new int[]{-1};
    }
    
    static void dfs(int index, int rest, int total, int[] record) {
        if (rest == 0) {
            int point = getPoint(record);
            if (point <= 0) return;
            if (point > max) {
                max = point;
                for (int i = 0; i <= 10; i++) {
                    answer[i] = record[i];
                }
            }
            else if (point == max) {
                if (compare(record)) {
                    for (int i = 0; i <= 10; i++) {
                        answer[i] = record[i];
                    }
                }
            }
            return;
        }
        
        if (index == 11) return;
        
        // 상관없이 넘긴다
        if (index == 10) {
            record[index] = rest;
            dfs(index+1, 0, total, record);
            record[index] = 0;
        }
        
        // 이길 가능성 있다 
        if (info[index] < rest) {
            record[index] = info[index] + 1;
            dfs(index+1, rest-(info[index]+1), total+(10-index), record);
            record[index] = 0;
        }
        
    
        dfs(index+1, rest, total, record);
    }
    
    static boolean compare(int[] record) {
        for (int i = 10; i >= 0; i--) {
            if (answer[i] == record[i]) continue;
            if (answer[i] < record[i]) return true;
            else return false;
        }
        return false;
    }
    
    static int getPoint(int[] record) {
        int apeach = 0;
        int ryan = 0;
        for (int i = 0; i <= 10; i++) {
            if (info[i] == 0 && record[i] == 0) continue;
            if (info[i] >= record[i]) apeach += (10 - i);
            else ryan += (10 - i);
        }

        return ryan - apeach;
    }
}


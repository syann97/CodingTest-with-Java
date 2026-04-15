import java.util.*;

class Solution {
    static int N;
    static int[] info;
    static int[] answer;
    static int max;
    public int[] solution(int n, int[] information) {
        N = n;
        max = 0;
        info = information;
        answer = new int[11];
        
        dfs(0, n, new int[11]);
        
        // 출력
        // 라이언이 어피치를 가장 큰 점수 차이로 이기기 위햏 n발의 화살을 어떤 과녁에 맞혀야 하는지
        // 화살의 개수는 n  (이 과녁의 점수의 개수를 차례대로 담은 정답을 출력)
        // 지거나 비기는 경우 [-1] 반환
        for (int i = 0; i <= 10; i++) {
            if (answer[i] != 0) return answer;
        }
        
        // 예외
        // 지거나 비기는 경우 [-1] 반환
        return new int[]{-1};
    }
    
    
    
    
    static void dfs(int index, int rest, int[] currentInfo) {
        // 기능
        // dfs
        
        if (rest == 0) {
            int diff = getDiff(currentInfo);
            if (diff > 0) {
                if (max < diff) {
                    max = diff;
                    copy(currentInfo);
                }
                else if (max == diff && isBetter(currentInfo)) {
                    copy(currentInfo);
                }
            }
            return;
        }
        
        if (index == 11) return;
        
        // 정의
        // 1. 어피치 화살 n발 -> 라이언 화살 n발
        // 2. 0점 ~ 10점까지의 과녁
        // 3. k점에 많은 화살을 맞춘 선수가 점수 k점 ()
            // 제약 -> 동일한 경우는 어피치 승
            // -> 둘다 0발인 경우 패스
        // 4. 각 선수의 최종 점수 계산
        // 5. 최종 점수 높은 사람 우승 
        if (index == 10) {
            currentInfo[index] = rest;
            dfs(index+1, 0, currentInfo);
            currentInfo[index] = 0;
        }
        
        if (info[index] < rest) {
            currentInfo[index] = info[index] + 1;
            dfs(index+1, rest - (info[index] + 1), currentInfo);
            currentInfo[index] = 0;
        }
            
        dfs(index+1, rest, currentInfo);
    }
    static boolean isBetter(int[] currentInfo) {
        for (int i = 10; i >= 0; i--) {
            if (answer[i] == currentInfo[i]) continue;
            if (answer[i] < currentInfo[i]) return true;
            return false;
        }
        return false;
    }
    
    // 이기는 경우인지
    // 가장 큰 점수 차인지 비교
    static int getDiff(int[] currentInfo) {
        int apeach = 0;
        int ryan = 0;
        
        for (int i = 0; i <= 10; i++) {
            if (info[i] == 0 && currentInfo[i] == 0) continue;
            if (info[i] >= currentInfo[i]) apeach += 10 - i;
            else ryan += 10 - i;
        }
        
        return ryan - apeach;
    }
    
    
    static void copy(int[] currentInfo) {
        for (int i = 0; i <= 10; i++) {
            answer[i] = currentInfo[i];
        }
    }
}
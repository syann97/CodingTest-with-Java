import java.util.*;

class Solution {
    // 병사 n명, 무적권 k번, 적 매 라운드 enemy[i] 만큼 (i는 라운드)
    // 남은 병사 수보다 현재 라운드의 적의 수가 더 많으면 게임 종료
    // 그리디 -> 최대한 많은 라운드 진행하기
    // 1. 상한 직전까지 일단 모두 집어넣는다
    // 2. k를 쓴다
    // 3. 넣는다
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        int L = enemy.length;
        int count = 0;
        
        for (int i = 0; i < L; i++) {
            count += enemy[i];
            pq.offer(enemy[i]);
            
            if (count > n) {
                while (k > 0 && count > n) {
                    k--;
                    count -= pq.poll();
                }
            }
            
            if (k == 0 && count > n) return i;
        }
        
        return L;
    }
}
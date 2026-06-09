import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int N = people.length;
        // 구명보트 한번에 최대 2명 + 무게 제한 존재
        // 구명보트 최소화
        
        Arrays.sort(people);
        
        int s = 0;
        int e = N-1;
        int count = 0;
        
        while (s < e) {
            int w = people[s] + people[e];
            if (w <= limit) {
                count++;
                s++;
                e--;
            }
            else {
                e--;
            }
        }
        
        return N - count;
    }
}
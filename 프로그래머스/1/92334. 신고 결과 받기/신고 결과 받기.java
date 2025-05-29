import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 우선 정답을 반환하기 위한 int[] answer 배열 선언
        int[] answer = new int[id_list.length];
        
        // report 중복 제거
        Set<String> distinct_report = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            distinct_report.add(report[i]);
        }
        
        
        
        // report 횟수를 세는 reported count 생성
        Map<String, Integer> reported_count = new HashMap<>();
        
        // id_list로 초기화
        for (int i = 0; i < id_list.length; i++) {
            reported_count.put(id_list[i], 0);
        }
        
        
        // report를 순회하면서 count를 증가       
        for (String rep : distinct_report) {
            String[] split_report = rep.split(" ");
            reported_count.put(split_report[1], reported_count.get(split_report[1]) + 1);
        }

        
        // report를 다시 순회하면서 count가 k 이상인 reported에 대해서 reporter의 값을 answer를 통해 증가시키기
        for (String rep : distinct_report) {
            String[] split_report = rep.split(" ");
            if (reported_count.get(split_report[1]) >= k) {
                answer[indexOf(id_list, split_report[0])]++;
            }
        }
        return answer;
    }
    
    static int indexOf(String[] id_list, String target) {
        for (int i = 0; i < id_list.length; i++) {
            if (id_list[i].equals(target)) return i;
        }
        return -1;
    }
}
class Solution {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int[] answer = new int[2];
        int sum = sequence[0];
        int start = 0;
        int end = 0;
        int diff = 1000001;
        
        // 투 포인터 알고리즘 구현
        while (start < len && end < len && start <= end) {
            if (sum == k) {
                if (end - start < diff) {
                    answer[0] = start;
                    answer[1] = end;
                    diff = end - start;
                }
                
                if (end - start == 0) return answer;
                
                sum -= sequence[start++];
            }
            
            
            // 합이 작은 경우 => end 증가
            else if (sum < k) {
                if (end + 1 < len) sum += sequence[++end];
                else return answer;
            }
            
            // 합이 큰 경우 start 증가
            else sum -= sequence[start++];
        }
        
        return answer;
    }
}
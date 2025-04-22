import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] deployDate = new int[101];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < progresses.length; i++) {
            int rest = 100 - progresses[i];
            int current =  rest / speeds[i] + (rest % speeds[i] == 0 ? 0 : 1);
            
            if (!queue.isEmpty()) {
                if (current <= queue.peekLast()) deployDate[queue.peekLast()]++;
                else {
                    queue.offer(current);
                    deployDate[current]++;
                }
            }
            else {
                queue.offer(current);
                deployDate[current]++;
            }
        }
        
        int i = queue.size();
        int[] answer = new int[queue.size()];
        
        System.out.println(queue);
        
        while (!queue.isEmpty()) {
            i--;
            answer[i] = deployDate[queue.pollLast()];
        }
        
        return answer;
    }
}
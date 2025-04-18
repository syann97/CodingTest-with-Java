import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        ArrayDeque<Integer> stack = new ArrayDeque();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && (prices[i] < prices[stack.peek()])) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int pop = stack.pop();
            ans[pop] = prices.length - 1 - pop;
        }
        return ans;
    }

}
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push('(');
            else {
                if (stack.isEmpty()) return false;
                stack.poll();
            }
        }

        return stack.isEmpty();
    }
}
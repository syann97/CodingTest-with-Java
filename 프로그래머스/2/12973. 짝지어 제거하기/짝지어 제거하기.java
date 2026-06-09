import java.util.*;

class Solution
{
    public int solution(String s)
    {
        if (s.length() % 2 == 1) return 0;
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.offerLast(c);
            }
            else {
                if (stack.peekLast() == c) {
                    stack.pollLast();
                }else {
                    stack.offerLast(c);
                }
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}
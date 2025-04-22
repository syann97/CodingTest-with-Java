class Solution {
    public int solution(String s) {

        int answer = s.length();
        int stack = 1;
        
        for(int i = 1; i <= s.length() / 2; i++){
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);
            
            for(int j = i; j <= s.length(); j += i){
                int end = Math.min(j + i, s.length());
                String compare = s.substring(j, end);
                
                if(base.equals(compare)){
                    stack++;
                } 
                else {
                    if(stack >= 2) sb.append(stack);
                    sb.append(base);
                    base = compare;
                    stack = 1;
                }
            }
            sb.append(base);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}
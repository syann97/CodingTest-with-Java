class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int len = parseSec(video_len);
        int ops = parseSec(op_start);
        int ope = parseSec(op_end);
        int cur = parseSec(pos);
        
        if (ops <= cur && cur <= ope) cur = ope;
        
        int tmp;
        for (String command : commands) {
            if (command.equals("next")) {
                cur = Math.min(cur + 10, len);
            }
            else {
                cur = Math.max(cur - 10, 0);
            }
            
            if (ops <= cur && cur <= ope) cur = ope;
        }

        return timeFormat(cur);
    }
    
    static int parseSec(String time) {
        String[] ms = time.split(":");
        return Integer.parseInt(ms[0]) * 60 + Integer.parseInt(ms[1]);
    }
    
    static String timeFormat(int time) {
        int m = time / 60;
        int s = time % 60;
        
        return String.format("%02d:%02d", m, s);
    }
}

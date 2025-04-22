class Solution {
    public String solution(String new_id) {
        // 1단계: 대문자 -> 소문자 치환
        new_id = new_id.toLowerCase();
        
        // 2단계: 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표 제외 제거
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");
        
        // 3단계: 마침표(.)가 2연속 이상인 것 하나로 치환
        new_id = new_id.replaceAll("\\.{2,}", ".");
        
        // 4단계: 마침표(.)가 시작이나 끝에 있다면 제거
        new_id = new_id.replaceAll("^\\.|\\.$", "");
        
        // 5단계: 빈 문자열 => a를 대입
        if (new_id.isEmpty()) new_id = "a";
        
        // 6단계: 길이 16 이상 => 첫 15개 문자만 포함 + 제거 후 마침표(.)가 끝일 경우 제거
        if (new_id.length() >= 16) {
            if (new_id.charAt(14) == '.') new_id = new_id.substring(0, 14);
            else new_id = new_id.substring(0, 15);
        }
        
        // 7단계: 길이가 2자 이하 => 마지막 문자를 길이 3이 될 때까지 반복 추가
        if (new_id.length() <= 2) {
            char lastChar = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) {
                new_id += lastChar;
            }
        }
        System.out.println(new_id);

        return new_id;
    }
}
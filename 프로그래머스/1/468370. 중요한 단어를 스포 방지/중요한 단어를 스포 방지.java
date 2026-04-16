import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        char[] messageArray = new char[message.length()+1];
        boolean[] isSpoiler = new boolean[message.length()+1];
        
        for (int i = 0; i < message.length(); i++) {
            messageArray[i] = message.charAt(i);
        }
        messageArray[message.length()] = ' ';
        
        for (int[] spoiler : spoiler_ranges) {
            int s = spoiler[0];
            int e = spoiler[1];
            
            for (int i = s; i <= e; i++) {
                isSpoiler[i] = true;
            }
        }
        
        
        ArrayList<String> spoilerWord = new ArrayList<>();
        Set<String> noSpoilerWord = new HashSet<>();
        
        boolean isMosaic = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < messageArray.length; i++) {
            if (messageArray[i] == ' ') {
                if (isMosaic) spoilerWord.add(sb.toString());
                else noSpoilerWord.add(sb.toString());
                sb.setLength(0);
                isMosaic = false;
            }
            else {
                sb.append(messageArray[i]);
                if (isSpoiler[i]) isMosaic = true;
            }
        }
        
        Set<String> importantWord = new HashSet<>();
        
        for (String candidate : spoilerWord) {
            if (!noSpoilerWord.contains(candidate)) {
                importantWord.add(candidate);
            }
        }
        
        System.out.println(noSpoilerWord);
        System.out.println(spoilerWord);
        
        return importantWord.size();
    }
}
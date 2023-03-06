import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> min = new HashMap<>();
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                if(min.get(keymap[i].charAt(j)) == null || min.get(keymap[i].charAt(j)) > j + 1) {
                    min.put(keymap[i].charAt(j), j + 1);
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            for(int j = 0; j < targets[i].length(); j++) {
                if(min.get(targets[i].charAt(j)) == null) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += min.get(targets[i].charAt(j));
            }
        }
        
        return answer;
    }
}
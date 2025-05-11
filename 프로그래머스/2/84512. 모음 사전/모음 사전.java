import java.util.*;

class Solution {
    String[] str = {"", "A", "E", "I", "O", "U"};
    Set<String> dictionary = new TreeSet<String>();
    
    public int solution(String word) {
        int answer = 0;
            
        permutaion(0, 1, "");
        
        for (String wordInDictionary : dictionary) {
            ++answer;
            
            if (word.equals(wordInDictionary)) {
                break;
            }
        }
        
        return answer;
    }
    
    private void permutaion(int count, int start, String wordInDictionary) {
        if (count == 5) {
            this.dictionary.add(wordInDictionary.toString());
            
            return;
        }
        
        for (int i = start; i < 6; i++) {
            permutaion(count + 1, 0, wordInDictionary + this.str[i]);
        }
    }
}
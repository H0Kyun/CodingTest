import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 변경될 수 있는 단어 저장 Set
        // 인덱스 별 바꿀 수 있는 단어 저장 Map<Integer, Set> or List<Set>
        // 인덱스 별 바꿀 수 있는 단어로 변경 변경한 단어는 기억했다 다시 수정하지 않게 해야 함
        // 변경 가능하면 다음 알파벳 변경
        // traget과 같으면 변경 횟수 반환
        // 그게 아니라 더 바꿀게 없으면 MAX_VALUE 반환
        // 최종 결과가 MAX_VALUE 면 0 아니면 결과 반환
        Set<String> dictionary = new HashSet<String>();
        
        List<Set<Character>> replaceableWords = new ArrayList<Set<Character>>();
        for(int i = 0; i < begin.length(); ++i) {
            replaceableWords.add(new HashSet<Character>());
        }
        
        StringBuilder start = new StringBuilder(begin);
        
        for (String word : words) {
            dictionary.add(word);
            
            for (int i = 0; i < begin.length(); ++i) {
                if (start.charAt(i) == word.charAt(i)) {
                    continue;
                }
                
                replaceableWords.get(i).add(word.charAt(i));
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < begin.length(); ++i) {
            min = Math.min(min, dfs(dictionary, replaceableWords, start, target, 0));
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    
    private int dfs(Set<String> dictionary, List<Set<Character>> replaceableWords, StringBuilder start, String target, int count) {
        if (start.toString().equals(target)) {
            return count;
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < start.length(); ++i) {
            Set<Character> alphabets = replaceableWords.get(i);
            
            char original = start.charAt(i);
            
            for(char alphabet : alphabets) {
                start.setCharAt(i, alphabet);
                
                if (dictionary.contains(start.toString())) {
                    Set<Character> remainAlphabets = new HashSet<Character>(alphabets);
                    remainAlphabets.remove(alphabet);
                    List<Set<Character>> copyReplaceableWords = new ArrayList<Set<Character>>(replaceableWords);
                    copyReplaceableWords.set(i, remainAlphabets);
                    
                    min = Math.min(min, dfs(dictionary, copyReplaceableWords, start, target, count + 1));
                }
                
                
                start.setCharAt(i, original);
            }
        }
        
        return min;
    }
}
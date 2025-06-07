import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 변할 수 있는 단어 저장
        Set<String> dictionary = new HashSet<String>();
        
        // 인덱스 별 바꿀 수 있는 알파벳 저장
        List<Set<Character>> replaceableAlphabetsByIndex = new ArrayList();
        for(int i = 0; i < begin.length(); ++i) {
            replaceableAlphabetsByIndex.add(new HashSet());
        }
        
        for (String word : words) {
            dictionary.add(word);
            
            for (int i = 0; i < begin.length(); ++i) {
                if (begin.charAt(i) == word.charAt(i)) {
                    continue;
                }
                
                replaceableAlphabetsByIndex.get(i).add(word.charAt(i));
            }
        }
        
        StringBuilder start = new StringBuilder(begin);
        
        int min = dfs(dictionary, replaceableAlphabetsByIndex, start, target, 0);
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    
    private int dfs(
        Set<String> dictionary,
        List<Set<Character>> replaceableAlphabetsByIndex,
        StringBuilder start,
        String target,
        int count
    ) {
        // traget과 같으면 변경 횟수 반환
        if (start.toString().equals(target)) {
            return count;
        }
        
        // 더 변경할 수 있는게 없으면 MAX_VALUE 반환하도록 설정
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < start.length(); ++i) {
            Set<Character> alphabets = replaceableAlphabetsByIndex.get(i);
            
            char original = start.charAt(i);
            // 인덱스 별 바꿀 수 있는 알파벳으로 변경
            for(char alphabet : alphabets) {
                start.setCharAt(i, alphabet);
                
                if (dictionary.contains(start.toString())) {
                    // 변경한 알파벳으로 다시 변경하지 않게 해야 함
                    Set<Character> remainAlphabets = new HashSet(alphabets);
                    remainAlphabets.remove(alphabet);
                    
                    List<Set<Character>> copyReplaceableAlphabetsByIndex 
                        = new ArrayList(replaceableAlphabetsByIndex);
                    copyReplaceableAlphabetsByIndex.set(i, remainAlphabets);
                    
                    min = Math.min(
                        min, 
                        dfs(dictionary, copyReplaceableAlphabetsByIndex, start, target, count + 1)
                    );
                }
            }
            
            start.setCharAt(i, original);
        }
        
        return min;
    }
}
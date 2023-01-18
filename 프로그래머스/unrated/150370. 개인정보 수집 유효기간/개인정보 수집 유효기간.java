import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int todayDays = getTotalDays(today);
        
        Map<String, Integer> periodOfTerms = new HashMap<>();
        for(String s : terms) {
            String[] termsAndPeriod = s.split(" ");
            periodOfTerms.put(termsAndPeriod[0], Integer.parseInt(termsAndPeriod[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] dateAndTerms = privacies[i].split(" ");
            if(getTotalDays(dateAndTerms[0]) + periodOfTerms.get(dateAndTerms[1]) * 28 <= todayDays)
                    answer.add(i + 1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private int getTotalDays(String dateFormat) {
        String[] date = dateFormat.split("\\.");
        return Integer.parseInt(date[0]) * 12 * 28 + Integer.parseInt(date[1]) * 28 + Integer.parseInt(date[2]);
    }
}
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String[] yearMonthDay = today.split("\\.");
        
        Map<String, Integer> termsMap = new HashMap<>();
        for(String s : terms) {
            String[] sArray = s.split(" ");
            termsMap.put(sArray[0], Integer.parseInt(sArray[1]));
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] sArray = privacies[i].split(" ");
            String[] date = sArray[0].split("\\.");
            int term = termsMap.get(sArray[1]);
            int year = Integer.parseInt(date[0]) + term / 12;
            int month = Integer.parseInt(date[1]) + term % 12;
            int day = Integer.parseInt(date[2]) - 1;
            if(month > 12) {
                year++;
                month -= 12;
            }
            
            if(day == 0) {
                day = 28;
                month--;
                if(month == 0) {
                    month = 12;
                    year--;
                }
            }
            
            System.out.println(year + " " + month + " " + day)
            ;
            if(year < Integer.parseInt(yearMonthDay[0]))
                answer.add(i + 1);
            else if(year <= Integer.parseInt(yearMonthDay[0]) && month < Integer.parseInt(yearMonthDay[1]))
                answer.add(i + 1);
            else if(year <= Integer.parseInt(yearMonthDay[0]) && month <= Integer.parseInt(yearMonthDay[1]) && day < Integer.parseInt(yearMonthDay[2]))
                answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
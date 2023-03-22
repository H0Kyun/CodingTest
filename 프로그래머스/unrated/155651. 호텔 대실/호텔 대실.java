import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 1;
        Arrays.sort(book_time, (String[] arr1, String[] arr2) -> this.timeToInteger(arr1[0]) - this.timeToInteger(arr2[0]));
        
        List<Integer> clearRoomTime = new ArrayList<>();
        clearRoomTime.add(timeToInteger(book_time[0][1]) + 10);
        
        for(int i = 1; i < book_time.length; i++) {
            boolean isNew = true;
            for(int j = 0; j < clearRoomTime.size(); j++) {
                if(timeToInteger(book_time[i][0]) >= clearRoomTime.get(j)) {
                    clearRoomTime.set(j, timeToInteger(book_time[i][1]) + 10);
                    isNew = false;
                    break;
                }
            }
            if(isNew) clearRoomTime.add(timeToInteger(book_time[i][1]) + 10);
        }
        
        return clearRoomTime.size();
    }
    
    private int timeToInteger(String time) {
        String[] hourAndMin = time.split(":");
        return Integer.parseInt(hourAndMin[0]) * 60 + Integer.parseInt(hourAndMin[1]);
    }
}
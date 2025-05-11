import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Set<Integer> reservedStudent = new HashSet<Integer>();
        
        for (int student : reserve) {
            reservedStudent.add(student);
        }
        
        for (int i = 0; i < lost.length; ++i) {
            if (reservedStudent.contains(lost[i])) {
                reservedStudent.remove(lost[i]);
                
                lost[i] = -1;
                
                ++answer;
            }
        }
        
        Arrays.sort(lost);
        
        for (int student : lost) {
            if (reservedStudent.contains(student - 1)) {
                reservedStudent.remove(student - 1);
                
                ++answer;
            } else if (reservedStudent.contains(student + 1)) {
                reservedStudent.remove(student + 1);
                
                ++answer;
            }
        }
        
        return answer;
    }
}
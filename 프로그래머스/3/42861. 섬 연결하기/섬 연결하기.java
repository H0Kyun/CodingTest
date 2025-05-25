import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
        
        List<Integer> parent = new ArrayList<Integer>(Collections.nCopies(n, null));
        Collections.fill(parent, -1);
        
        int answer = 0;
        
        for (int[] cost : costs) {
            Integer x = this.find(parent, cost[0]);
            Integer y = this.find(parent, cost[1]);

            if (x != y) {
                unionSet(parent, x, y);
                answer += cost[2];
            }
        }
        
        return answer;
    }
    
    private Integer find(List<Integer> parent, Integer i) {
        if (parent.get(i).compareTo(-1) == 0) {
            return i;
        }
        
        return this.find(parent, parent.get(i));
    }

    private void unionSet(List<Integer> parent, Integer x, Integer y) {
        Integer xroot = find(parent, x);
        Integer yroot = find(parent, y);
        
        parent.set(xroot, yroot);
    }
}
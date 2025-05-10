import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        List<Integer[]> dugeonsToExplore = new LinkedList<Integer[]>();
        
        for(int[] dungeon : dungeons) {
            Integer[] dugeonToExplore = { dungeon[0], dungeon[1] };
            dugeonsToExplore.add(dugeonToExplore);
        }
        
        int answer = dfs(dugeonsToExplore, k, 0);
        
        return answer;
        
    }
    
    private int dfs(List<Integer[]> dungeons, int remainingFatigue, int count) {
        int maxCount = count;
        
        for(int i = 0; i < dungeons.size(); ++i) {
            if (dungeons.get(i)[0] <= remainingFatigue) {
                List<Integer[]> remainingDungeons = new LinkedList(dungeons);
                remainingDungeons.remove(i);

                maxCount = Math.max(maxCount, dfs(remainingDungeons, remainingFatigue - dungeons.get(i)[1], count + 1));
            }
        }
        
        return maxCount;
    }
}
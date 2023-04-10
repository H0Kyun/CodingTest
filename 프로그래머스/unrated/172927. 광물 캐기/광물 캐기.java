class Solution {
    int answer;
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        // 다이아몬드로 캐기 // 다, 철, 돌 ....
        // 철로 캐기
        // 돌로 캐기
        
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) continue;
            dfs(i, picks, minerals, 0, 0);
            picks[i]++;
        }
        
        return answer;
    }
    
    private void dfs(int pickaxes, int[] picks, String[] minerals, int count, int tiredness) {
        
        picks[pickaxes]--;
        int dPoint = 0;
        int iPoint = 0;
        int sPoint = 0;

        switch(pickaxes) {
            case 0:
                dPoint = 1;
                iPoint = 1;
                sPoint = 1;
                break;
            case 1:
                dPoint = 5;
                iPoint = 1;
                sPoint = 1;
                break;
            default:
                dPoint = 25;
                iPoint = 5;
                sPoint = 1;
                break;
        }
        int length = count + 5;
        if(count + 5 > minerals.length) length = minerals.length;
        for(int i = count; i < length; i++) {
            if(minerals[i].equals("diamond")) {
                tiredness += dPoint;
            } else if(minerals[i].equals("iron")) {
                tiredness += iPoint;
            } else {
                tiredness += sPoint;
            }
        }
        
        if(tiredness >= answer) return;
        
        if((picks[0] == 0 && picks[1] == 0 && picks[2] == 0) || (count + 5 >= minerals.length)) {
            answer = Math.min(answer, tiredness);
            return;
        }
        
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) continue;
            dfs(i, picks, minerals, count + 5, tiredness);
            picks[i]++;
        }
        
    }
}
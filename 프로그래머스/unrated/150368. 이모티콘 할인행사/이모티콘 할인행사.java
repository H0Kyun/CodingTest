class Solution {
    int[] answer;
    int[][] e;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        e = new int[emoticons.length][2];
        for(int i = 0; i < emoticons.length; i++) {
            e[i][0] = emoticons[i];
        }
        sub(users, emoticons.length - 1);
        return answer;
    }
    
    public void sub(int[][] users, int n) {
        if(n == -1) {
            int a = 0;
            int b = 0;
            for(int i = 0; i < users.length; i++) {
                int price = 0;
                for(int j = 0; j < e.length; j++) {
                    if(users[i][0] <= e[j][1]) {
                        price += e[j][0] - (e[j][0] / 100 * e[j][1]);
                    }
                    
                    if(price >= users[i][1]) {
                        price = 0;
                        a++;
                        break;
                    }
                }
                b += price;
            }
            System.out.println();
            if(a > answer[0]) {
                answer[0] = a;
                answer[1] = b;
            } else if(a == answer[0] && answer[1] < b) {
                answer[0] = a;
                answer[1] = b;
            }
            return;
        }
        
        e[n][1] = 10;
        sub(users, n - 1);
        e[n][1] = 20;
        sub(users, n - 1);
        e[n][1] = 30;
        sub(users, n - 1);
        e[n][1] = 40;
        sub(users, n - 1);
    }
}
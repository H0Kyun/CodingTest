import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // 1. 각 팀의 인원을 저장한다. 팀이 6명인지 확인한다.
        // 2. 6명이 아닌 팀이 있으면 해당 팀 선수들에게는 점수를 주지 않는다.
        // 3. 점수를 계산한다. 계산하면서 5번째 선수의 점수는 따로 저장한다.
        // 4. 같은 점수의 팀이 존재하면 미리 저장한 5번째 선수의 점수를 비교한다.
        
        int T = sc.nextInt();
        
        
        for(int testCase = 1; testCase <= T; ++testCase) {
            sc.nextLine();
            int N = sc.nextInt();
            sc.nextLine();
            
            int[] numberOfTeamMember = new int[201];
            int[] scoreOfTeam = new int[201];
            int[] scoreOfFifthPlayer = new int[201];
            int[] raceResult = new int[N];
            
            for(int i = 0; i < N; ++i) {
                int teamNumber = sc.nextInt();
                
                ++numberOfTeamMember[teamNumber];
                raceResult[i] = teamNumber;
            }
            
            int score = 0;
            for(int i = 0; i < N; ++i) {
                if(numberOfTeamMember[raceResult[i]] < 6) {
                    continue;
                }
                
                ++score;
                //System.out.print(raceResult[i] + ": " + score + "/ ");
                ++numberOfTeamMember[raceResult[i]];
                
                if(numberOfTeamMember[raceResult[i]] == 11) {
                    scoreOfFifthPlayer[raceResult[i]] = score;
                }
                
                if(numberOfTeamMember[raceResult[i]] < 11) {
                    scoreOfTeam[raceResult[i]] += score;
                }
            }
            
            int minScore = Integer.MAX_VALUE;
            int winner = 0;
            for(int i = 1; i < 201; ++i) {
                if(scoreOfTeam[i] <= 0) {
                    continue;
                }
                
                if(scoreOfTeam[i] < minScore) {
                    
                    minScore = scoreOfTeam[i];
                    winner = i;
                } else if(scoreOfTeam[i] == minScore) {
            
                    if (scoreOfFifthPlayer[winner] > scoreOfFifthPlayer[i]) {
                        winner = i;
                    }
                }
            }
            
            sb
                .append(winner)
                .append("\n");
            
        }
        
        System.out.println(sb);
        
        sc.close();
    }
}
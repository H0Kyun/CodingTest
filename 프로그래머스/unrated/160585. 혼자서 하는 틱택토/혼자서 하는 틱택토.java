class Solution {
    public int solution(String[] board) {
        int oWinCount = 0;
        int xWinCount = 0;
            boolean xWin = false;
        int oCount = 0 , xCount = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length(); j++) {
                if(board[i].charAt(j) == 'O') {
                    oCount++;     
                } else if(board[i].charAt(j) == 'X') {
                    xCount++;
                }  
            }
        }
        
        for(int i = 0; i < board.length; i++) {   
            if(board[i].equals("OOO")) 
                oWinCount++;
            
            if(board[i].equals("XXX")) 
                xWinCount++;
        }
        
        for(int i = 0; i < board.length; i++) {
            int o = 0, x = 0;
            for(int j = 0; j < board[0].length(); j++) {
                if(board[j].charAt(i) == 'O') {
                    o++;
                } else if(board[j].charAt(i) == 'X') {
                    x++;
                }  
            }
            if(o == 3) oWinCount++;
            if(x == 3) xWinCount++;

        }

        
        if((board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O')
          || (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O'))
            oWinCount++;
        
        if((board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X')
          || (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X'))
            xWinCount++;
        
        
        if(oWinCount >= 1 && xWinCount == 0 && oCount - xCount == 1) return 1;
        else if(oWinCount == 0 && xWinCount >= 1 && oCount - xCount == 0) return 1;
        else if(oWinCount == 0 && xWinCount == 0 && (oCount - xCount == 1 || oCount - xCount == 0)) return 1;
        return 0;
    }
}
class Solution {
    public int solution(String[] board) {
        boolean oWin = false, xWin = false;
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
                oWin = true;
            
            if(board[i].equals("XXX")) 
                xWin = true;
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
            if(o == 3) oWin = true;
            if(x == 3) xWin = true;

        }

        
        if((board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O')
          || (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O'))
            oWin = true;
        
        if((board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X')
          || (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X'))
            xWin = true;
        
        
        if(oWin && !xWin && oCount - xCount == 1) return 1;
        else if(!oWin && xWin && oCount - xCount == 0) return 1;
        else if(!oWin && !xWin && (oCount - xCount == 1 || oCount - xCount == 0)) return 1;
        return 0;
    }
}
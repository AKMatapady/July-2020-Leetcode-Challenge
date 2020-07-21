class Solution {
    
    char[][] b;
    String w;
    int r, c;
    public boolean dfs(int index, Set<Integer> visited, int curr)
    {
        if(index == w.length())
            return true;
        int r1 = curr/c;
        int c1 = curr%c;
        int currL = ((r1-1)*c)+c1;
        if(r1 > 0 && b[r1-1][c1]==w.charAt(index) && (!visited.contains(currL)))
        {
            //System.out.println("index: "+ index + " at " + currL);
            visited.add(currL);
            if(dfs(index+1, visited, currL))
                return true;
            visited.remove(currL);
        }
        int currR = ((r1+1)*c)+c1;
        if(r1 < (r-1) && b[r1+1][c1]==w.charAt(index) && (!visited.contains(currR)))
        {
            //System.out.println("index: "+ index + " at " + currR);
            visited.add(currR);
            if(dfs(index+1, visited, currR))
                return true;
            visited.remove(currR);
        }
        
        int currT = (r1*c)+c1-1;
        if(c1 > 0 && b[r1][c1-1]==w.charAt(index) && (!visited.contains(currT)))
        {
            //System.out.println("index: "+ index + " at " + currT);
            visited.add(currT);
            if(dfs(index+1, visited, currT))
                return true;
            visited.remove(currT);
        }
        int currB = (r1*c)+c1+1;
        if(c1 < (c-1) && b[r1][c1+1]==w.charAt(index) && (!visited.contains(currB)))
        {
            //System.out.println("index: "+ index + " at " + currB);
            visited.add(currB);
            if(dfs(index+1, visited, currB))
                return true;
            visited.remove(currB);
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length < 1)
            return false;
        r = board.length;
        c = board[0].length;
        //System.out.println("r: "+ r + " c: " + c);
        if(word.length() > (r*c))
            return false;
        b = board;
        w = word;
        Set<Integer> st = new HashSet();
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(b[i][j] == w.charAt(0))
                    st.add((i*c)+j);
            }
        }
        
        for(int x: st)
        {
            //System.out.println("index: 0 at " + x);
            Set<Integer> temp = new HashSet();
            temp.add(x);
            if(dfs(1, temp, x))
                return true;
        }
        
        return false;
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length < 1)
            return 0;
        int r = grid.length;
        int c = grid[0].length;
        if(r==1 && c==1)
            return 4;
        boolean[][] visited = new boolean[r][c];
        Deque<Integer> q = new LinkedList<Integer>();//used as stack for DFS
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(grid[i][j] == 1)
                {
                    q.add((c*i)+j);
                    break;
                }
            }
            if(!q.isEmpty())
                break;
        }
        int ans = 0;
        while(!q.isEmpty())
        {
            int x = q.pop();
            int r1 = x/c;
            int c1 = x%c;
            if(!visited[r1][c1])
            {
                visited[r1][c1] = true;
                //up
                if(r1 > 0 && grid[r1-1][c1] == 1)
                {
                    q.add(((r1-1)*c)+c1);
                }
                else
                    ans++;
                //down
                if(r1 <(r-1) && grid[r1+1][c1] == 1)
                {
                    q.add(((r1+1)*c)+c1);
                }
                else
                    ans++;
                
                //left
                if(c1 > 0 && grid[r1][c1-1] == 1)
                {
                    q.add((r1*c)+c1-1);
                }
                else
                    ans++;
                //right
                if(c1 <(c-1) && grid[r1][c1+1] == 1)
                {
                    q.add((r1*c)+c1+1);
                }
                else
                    ans++;
                
            }
            
        }
        return ans;
    }
}
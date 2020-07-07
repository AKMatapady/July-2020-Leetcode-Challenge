class Solution {
    
    public String getString(int[] cells)
    {
        StringBuilder sb = new StringBuilder();
        for(int i : cells)
            sb.append(i+"");
        return sb.toString();
    }
    
    public int[] getCells(String str)
    {
        int[] cells = new int[str.length()];
        int i = 0;
        for(char z : str.toCharArray())
        {
            cells[i] = Integer.parseInt(z+"");
            i++;
        }
        return cells;
    }
    
    public int[] prisonAfterNDays(int[] cells, int N) {
        
        Set<String> s = new HashSet();
        HashMap<Integer, String> mp = new HashMap();
        
        int i = 0;
        String save = getString(cells);
        while(true)
        {
            int[] temp = new int[cells.length];
            temp[0] = 0;
            temp[cells.length - 1] = 0;
            for(int j = 1; j < (cells.length - 1); j++)
            {
                temp[j] = 0;
                if(cells[j-1] == cells[j+1])
                    temp[j] = 1;
            }
            cells = temp;
            if(i == N-1)
                return cells;
            save = getString(cells);            
            if(s.contains(save))
                break;
            s.add(save);
            mp.put(i, save);
            i++;
        }
        
        int z = N % i;
        z--;
        if(z < 0)
            z += i;
        
        save = mp.get(z);
        
        
        return getCells(save);
    }
}
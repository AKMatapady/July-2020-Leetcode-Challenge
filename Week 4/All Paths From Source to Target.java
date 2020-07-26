class Solution {
    HashMap<Integer, Set<Integer>> mp;
    List<List<Integer>> res;
    Set<Integer> visited;
    int n;
    
    public void dfs(int x, List<Integer> ans)
    {
        ans.add(x);
        if(x == n-1)
        {
            List<Integer> ans2 = ans.stream().collect(Collectors.toList());
            res.add(ans2);
            ans.remove((Integer)x);
            return;
        }
        Set<Integer> next = mp.getOrDefault(x, new HashSet());        
        for(int y: next)
        {
            if(!visited.contains(y))
            {
                visited.add(y);
                dfs(y, ans);
                visited.remove(y);
            }            
        }
        ans.remove((Integer)x);
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<List<Integer>>();
        if(graph == null || graph.length < 1)
            return res;
        if(graph.length == 1)
        {
            List<Integer> ans = new ArrayList();
            ans.add(0);
            res.add(ans);
            return res;
        }
        mp = new HashMap();
        visited = new HashSet();
        n = graph.length;
        int i = 0;
        
        for(int[] g: graph)
        {
            for(int j: g)
            {
                Set<Integer> st = mp.getOrDefault(i, new HashSet());
                st.add(j);
                mp.put(i, st);
            }
            i++;
        }
        
        Set<Integer> first = mp.getOrDefault(0, new HashSet());
        visited.add(0);
        for(int x: first)
        {
            List<Integer> ans = new ArrayList();
            ans.add(0);
            visited.add(x);
            dfs(x, ans);
            visited.remove(x);
            //res.add(ans);
        }
        return res;
    }
}
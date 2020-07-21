class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        if(numCourses == 0)
            return ans;
        if(numCourses == 1)
        {
            ans[0]=0;
            return ans;
        }
        if(prerequisites==null || prerequisites.length < 1)
        {
            for(int i = 0; i < numCourses; i++)
                ans[i]=i;
            return ans;
        }
        int z = 0;
        //course -> all prerequisites
        HashMap<Integer, Set<Integer>> mp = new HashMap();
        //prerequisite -> dependent courses
        HashMap<Integer, Set<Integer>> m2 = new HashMap();
        boolean[] visited = new boolean[numCourses];
        Arrays.fill(visited, false);
        Set<Integer> st = new HashSet();
        for(int i = 0; i < numCourses; i++)
            st.add(i);
        for(int[] x: prerequisites)
        {
            st.remove(x[0]);
            Set<Integer> s1 = mp.getOrDefault(x[0], new HashSet());
            s1.add(x[1]);
            mp.put(x[0], s1);
            
            Set<Integer> s2 = m2.getOrDefault(x[1], new HashSet());
            s2.add(x[0]);
            m2.put(x[1], s2);
        }
        
        for(int course: st)
        {
            visited[course] = true;
            ans[z] = course;
            z++;
            Set<Integer> s1 = m2.getOrDefault(course, new HashSet());
            for(int x : s1)
            {
                Set<Integer> s2 = mp.getOrDefault(x, new HashSet());
                s2.remove(course);
                mp.put(x, s2);
            }
        }
        
        int prevz = 0;
        
        while(z < numCourses && prevz < z)
        {
            prevz = z;
            Set<Integer> freed = new HashSet();
            for(int x : st)
            {
                Set<Integer> s2 = m2.getOrDefault(x, new HashSet());
                for(int x0: s2)
                {
                    if(!st.contains(x0))
                    {
                        Set<Integer> s1 = mp.getOrDefault(x0, new HashSet());
                        if(s1.isEmpty())
                        {
                            freed.add(x0);                            
                        }
                    }
                }
            }
            for(int x: freed)
            {
                st.add(x);
                ans[z] = x;
                z++;
                if(z == numCourses)
                    return ans;
                Set<Integer> s1 = m2.getOrDefault(x, new HashSet());
                for(int x0 : s1)
                {
                    Set<Integer> s2 = mp.getOrDefault(x0, new HashSet());
                    s2.remove(x);
                    mp.put(x, s2);
                }
            }
            
        }
        
        if(z<numCourses)
            return new int[0];
        return ans;
    }
}
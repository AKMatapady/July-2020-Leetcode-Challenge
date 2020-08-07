class Solution {
    private Tries root;
    private List<String> wordList;
    private char[] input;
    private Set<Character> lookup;
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordList = new LinkedList<>();
        if(s.length() == 0) 
            return this.wordList;
        this.lookup = new HashSet<>();
        this.root = new Tries();
        this.input = s.toCharArray();
        for(String word : wordDict) {
            addWord(word.toCharArray());
        }
        if(isValid()) 
            splitWord(new StringBuilder(), 0, root);
        return wordList;
    }
    
    private void splitWord(StringBuilder sb, int i, Tries cur) {
        if(i == input.length) {
            wordList.add(sb.toString());
            return;
        }
        // System.out.println("\n" + input[i]);
        if(sb.length() > 0) sb.append(" ");
        while(i < input.length && cur != null) {
            // System.out.print(input[i] + " > ");
            cur = cur.children.get(input[i]);
            sb.append(input[i]);
            if(cur != null && cur.end) {
                splitWord(new StringBuilder(sb), i + 1, root);
            }
            i++;
        }
    }
    
    class Tries {
        Map<Character, Tries> children;
        boolean end;
        Tries() {
            children = new HashMap<>();
        }
    }
    
    private void addWord(char[] s) {
        Tries cur = root;
        for(int i = 0; i < s.length; i++) {
            this.lookup.add(s[i]);
            if(cur.children.containsKey(s[i]) == false) {
                cur.children.put(s[i], new Tries());
            }
            cur = cur.children.get(s[i]);
        }
        cur.end = true;
    } 
    
    private boolean isValid() {
        for(int i = 0; i < input.length; i++) {
            if(lookup.contains(input[i])) continue;
            return false;
        }
        return true;
    }
}
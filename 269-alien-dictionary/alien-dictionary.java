class Solution {
    boolean isInvalid=false;
    HashMap<Character, HashSet<Character>> buildGraph(String[] words) {
        HashMap<Character, HashSet<Character>> adjList = new HashMap<>();
        int length = words.length;
        for (int i = 0; i < length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int j = 0, k = 0;
            boolean flag = false;
            while (j < word1.length() && k < word2.length()) {
                if (word1.charAt(j) != word2.charAt(k)) {
                    flag = true;
                    if (!adjList.containsKey(word1.charAt(j)))
                        adjList.put(word1.charAt(j), new HashSet<>());
                    adjList.get(word1.charAt(j)).add(word2.charAt(k));
                    break;
                }
                j++;
                k++;
            }
            if(!flag && word1.length()>word2.length()) isInvalid = true;
        }
        
        for (int i = 0; i < length ; i++) {
        
            String word = words[i];
            for(int j=0;j<word.length();j++)
            {
               if(!adjList.containsKey(word.charAt(j))) 
                adjList.put(word.charAt(j),new HashSet<>());
            }
        }
        

        return adjList;
    }

    String findTopologicalSorting(HashMap<Character, HashSet<Character>> adjList) {
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        StringBuilder topoSort = new StringBuilder();

          for (Map.Entry<Character, HashSet<Character>> i : adjList.entrySet()) {
              indegree.put(i.getKey(),0);
          }
        for (Map.Entry<Character, HashSet<Character>> i : adjList.entrySet()) {
            HashSet<Character> neighbors = i.getValue();
            if(neighbors!=null){
            for (Character neighbor : neighbors) {
                int curFreq = indegree.getOrDefault(neighbor, 0);
                indegree.put(neighbor, curFreq + 1);
            }
            }
        }
        
        for (Map.Entry<Character, Integer> i : indegree.entrySet()) {
            char node = i.getKey();
            int indg = i.getValue();
            if (indg == 0) {
                q.add(node);
            }
        }
  
        while (!q.isEmpty()) {
            char curNode = q.poll();
            topoSort.append(curNode);
            HashSet<Character> neighbors = adjList.get(curNode);
            if(neighbors!=null){
            for (Character neighbor : neighbors) {
                indegree.put(neighbor, indegree.get(neighbor)- 1);
                if (indegree.get(neighbor) == 0) {
                    q.add(neighbor);
                }
            }
            }
        }   

        return  topoSort.toString();
     
    }

    public String alienOrder(String[] words) {
        HashMap<Character, HashSet<Character>> adjList = buildGraph(words);
        String sequence = findTopologicalSorting(adjList);
        if(isInvalid) return "";
        if (sequence.length() == adjList.size()) {
            // no cycle case
            return sequence;
        } else
            return "";

    }
}
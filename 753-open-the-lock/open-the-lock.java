class Solution {
    public int openLock(String[] deadends, String target) {

        HashSet<String> visited = new HashSet<>();
        HashSet<String> invalidNodes = new HashSet<>();
        int deadendLength = deadends.length;

        for (int i = 0; i < deadendLength; i++)
            invalidNodes.add(deadends[i]);

        if(invalidNodes.contains("0000"))
            return -1;
            
        Queue<String> q = new LinkedList<>();
        String source = "0000";
        q.add(source);
        visited.add(source);

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-->0) {
                String curNode = q.poll();
                if (curNode.equals(target))
                    return time;

                for (int i = 0; i < 4; i++) {
                    char token = curNode.charAt(i);

                    StringBuilder nextPassword = new StringBuilder(curNode);
                    StringBuilder prevPassword = new StringBuilder(curNode);

                    char nextToken = (char) ((((int) token - 48) + 1) % 10 + 48);
                    char prevToken = (char) ((((int) token - 48) + 9) % 10 + 48);
        
                    nextPassword.setCharAt(i, nextToken);
                    prevPassword.setCharAt(i, prevToken);

                    if (!visited.contains(nextPassword.toString()) &&
                        !invalidNodes.contains(nextPassword.toString())) {
                        
                        q.add(nextPassword.toString());
                        visited.add(nextPassword.toString());
                    }

                    if (!visited.contains(prevPassword.toString()) &&
                        !invalidNodes.contains(prevPassword.toString())) {
                        
                        q.add(prevPassword.toString());
                        visited.add(prevPassword.toString());
                    }
                }
            }
            time++;
        }

        return -1;

    }
}